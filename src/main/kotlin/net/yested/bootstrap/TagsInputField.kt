package net.yested.bootstrap

import net.yested.jquery.JQuery
import net.yested.jquery.JQueryEventObject
import net.yested.jquery.jQuery
import net.yested.jquery.on
import net.yested.whenAddedToDom

 enum class TagsInputFieldType(val className: String) {
    INFO("info"),
    PRIMARY("primary"),
    DANGER("danger"),
    SUCCESS("success"),
    DEFAULT("default"),
    WARNING("warning")
}

@Suppress("NOTHING_TO_INLINE")
inline
private fun JQuery.tagsinput(command: dynamic, data: dynamic): dynamic = asDynamic().tagsinput(command, data)
@Suppress("NOTHING_TO_INLINE")
inline
private fun JQuery.tagsinput(command: dynamic): dynamic = asDynamic().tagsinput(command)

private abstract class TagsInputBeforeEvent<T>(val item: T, var cancel: Boolean) : JQueryEventObject
private abstract class TagsInputAfterEvent<T>(val item: T) : JQueryEventObject

 enum class BeforeEventPermission {
    PREVENT,
    ALLOW
}

private fun <T> tagsInputBeforeEventHandler(event: TagsInputBeforeEvent<T>, func: ((T) -> BeforeEventPermission)?) {
    event.cancel = when (func?.invoke(event.item) ?: BeforeEventPermission.ALLOW) {
        BeforeEventPermission.PREVENT -> true
        BeforeEventPermission.ALLOW -> false
    }
}

 class TagsInputField<T>(val textFactory: (T) -> String = { it.toString() },
                               val typeFactory: (T) -> TagsInputFieldType = { TagsInputFieldType.DEFAULT },
                               val idFactory: ((T) -> Any)? = null,
                               inputSize: InputSize = InputSize.DEFAULT) : InputField<Array<T>>(inputSize, placeholder = null, type = "text") {

     var maxTagCount: Int? = null
     var onAddExistingTag: (T, JQuery) -> Unit = { item, jqTag -> jqTag.hide(400) { jqTag.fadeIn(400) } }
     var onBeforeItemAdd: ((T) -> BeforeEventPermission)? = null
     var onAfterItemAdded: ((T) -> Unit)? = null
     var onBeforeItemRemove: ((T) -> BeforeEventPermission)? = null
     var onAfterItemRemoved: ((T) -> Unit)? = null
     var maxLengthOfSingleTag: Int? = null
     var removeWhiteSpacesAroundTagsAutomatically: Boolean = false
     var allowDuplicates: Boolean = false

     var dontInitializeAutomatically: Boolean = false

    // TODO freeInput, typeahead
     var initialized: Boolean = false

    override var data: Array<T>
        get() = tags
        set(value) {
            tags = value
        }

    init {
        element.setAttribute("data-role", "tagsinput")
    }

     fun add(newElem: T) {
        if (!initialized) {
            return
        }
        jQuery(this.element).tagsinput("add", newElem)
    }

     fun remove(newElem: T) {
        if (!initialized) {
            return
        }
        jQuery(this.element).tagsinput("remove", newElem)
    }

     fun removeAll() {
        if (!initialized) {
            return
        }
        jQuery(this.element).tagsinput("removeAll")
    }

    override fun clear() {
        removeAll()
    }

     fun focus() {
        if (!initialized) {
            return
        }
        jQuery(this.element).tagsinput("focus")
    }

     fun input(): JQuery =
            if (!initialized) {
                jQuery(this.element)
            } else {
                jQuery(this.element).tagsinput("input")
            }

     fun refresh() {
        if (!initialized) {
            return
        }
        jQuery(this.element).tagsinput("refresh")
    }

     fun destroy() {
        if (!initialized) {
            return
        }
        val jqElement = jQuery(this.element);
        jqElement.tagsinput("destroy")
        jqElement.off("beforeItemAdd")
        jqElement.off("itemAdded")
        jqElement.off("beforeItemRemove")
        jqElement.off("itemRemoved")
        initialized = false
    }

     fun init(calledAutomatically: Boolean = false) {
        if (initialized || (calledAutomatically && dontInitializeAutomatically)) {
            return
        }
        val jqElement = jQuery(this.element)
        this.element.removeAttribute("placeholder")
        val options = object {
            val tagClass = { item: T -> "label label-${typeFactory(item).className}" }
            val itemValue = idFactory
            val itemText = textFactory
            val maxTags = maxTagCount
            val maxChars = maxLengthOfSingleTag
            val trimValue = removeWhiteSpacesAroundTagsAutomatically
            val allowDuplicates = this@TagsInputField.allowDuplicates
            val onTagExists = onAddExistingTag
        }
        // HACK: if itemValue is defined for non-object data, then it doesn't work
        if (idFactory == null) {
            js("delete options.itemValue")
            js("delete options.itemText")
        }
        jqElement.tagsinput(options)
        jqElement.on("beforeItemAdd", { event: TagsInputBeforeEvent<T> -> tagsInputBeforeEventHandler(event, onBeforeItemAdd) })
        jqElement.on("itemAdded", { event: TagsInputAfterEvent<T> -> onAfterItemAdded?.invoke(event.item) })
        jqElement.on("beforeItemRemove", { event: TagsInputBeforeEvent<T> -> tagsInputBeforeEventHandler(event, onBeforeItemRemove) })
        jqElement.on("itemRemoved", { event: TagsInputAfterEvent<T> -> onAfterItemRemoved?.invoke(event.item) })
        initialized = true
    }

     var tags: Array<T>
        get() {
            return if (initialized) {
                jQuery(this.element).tagsinput("items")
            } else {
                arrayOf<T>()
            }
        }
        set(value) {
            if (initialized) {
                removeAll()
                value.forEach { add(it) }
            } else {
                this.value = value.joinToString(",")
            }
        }

    init {
        element.whenAddedToDom {
            init(calledAutomatically = true)
        }

    }
}
