package net.yested.bootstrap

import net.yested.*
import net.yested.jquery.jQuery
import net.yested.jqueryui.sortable
import net.yested.utils.options

 enum class SelectionMode() {
    NONE(),
    SINGLE(),
    MULTI()
}

 class ListGroup<TYPE>(val selectionMode: SelectionMode = SelectionMode.MULTI, val sortable:Boolean = false, val renderer: Anchor.(item:TYPE)->Unit) : InputComponent<List<TYPE>> {

    private val onChangeListeners: ArrayList<Function0<Unit>> = ArrayList();

    override val element = createElement("div") with {
        setAttribute("class", "list-group")
        if (sortable) {
            jQuery(this).sortable(options {})
        }
    }

    private val selectedItems = arrayListOf<TYPE>()

    private val itemToAnchorMap = hashMapOf<TYPE, Anchor>()

    override var data: List<TYPE>
        get() = ArrayList(selectedItems)
        set(newSelection) {
            selectedItems.clear()
            selectedItems.addAll(newSelection)
            itemToAnchorMap.forEach {
                if (newSelection.contains(it.key)) {
                    jQuery(it.value.element).addClass("active")
                } else {
                    jQuery(it.value.element).removeClass("active")
                }
            }
            notifyListeners()
        }

    override fun addOnChangeListener(invoke: () -> Unit) {
        onChangeListeners.add(invoke)
    }

    override fun addOnChangeLiveListener(invoke: () -> Unit) {
        onChangeListeners.add(invoke)
    }

    override fun decorate(valid: Boolean) { }

    override fun clear() {
        deselectAll()
        notifyListeners()
    }

    private fun deselectAll() {
        selectedItems.clear()
        itemToAnchorMap.values.forEach {
            jQuery(it.element).removeClass("active")
        }
    }

    private fun clickedOnItem(item:TYPE) {

        val anchor:Anchor = itemToAnchorMap[item]!!

        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
            jQuery(anchor.element).removeClass("active")
        } else {
            if (selectionMode == SelectionMode.SINGLE) {
                deselectAll()
            }
            selectedItems.add(item)
            jQuery(anchor.element).addClass("active")
        }

        notifyListeners()

    }

    private fun notifyListeners() {
        onChangeListeners.forEach { it() }
    }

     var dataProvider:Collection<TYPE>
        get() = itemToAnchorMap
                .entries
                .sortedBy(selector = { element.getIndexOfChildNode(it.value.element)})
                .map { it.key }
        set(newDataProvider) {
            selectedItems.clear()
            itemToAnchorMap.clear()

            element.removeAllContent()
            newDataProvider.forEach { addItem(it) }
        }

     fun addItem(item:TYPE) {
        val anchor = Anchor() with {
            "class".."list-group-item"
            "style".."cursor:pointer"
            if (selectionMode != SelectionMode.NONE) {
                onclick = { clickedOnItem(item) }
            }
            renderer(item)
        }
        element.appendChild(anchor.element)
        itemToAnchorMap.put(item, anchor)
    }

     fun removeItem(item:TYPE) {
        val anchor = itemToAnchorMap.remove(item)!!
        element.removeChild(anchor.element)
        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
            notifyListeners()
        }
    }

}