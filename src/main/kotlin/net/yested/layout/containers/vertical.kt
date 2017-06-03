package net.yested.layout.containers

import net.yested.jquery.jQuery
import net.yested.*
import net.yested.utils.registerResizeHandler
import org.w3c.dom.HTMLElement

class VerticalContainer(val width: Dimension? = null, height: Dimension, val gap:Int = 0) : Component {

    private val items = arrayListOf<ContainerItem>()

    override val element = createElement("div") with {
        setAttribute("style", "position: relative; width: ${width?.toHtml() ?: ""}; height: ${height.toHtml()};")
    }

    init {
        element.whenAddedToDom {
            recalculatePositions()
            registerResizeHandler(element.parentNode as HTMLElement) { x, y ->
                recalculatePositions()
            }
        }
    }

    private fun needToCalculateWidth() = width == null

     fun row(width: Dimension? = null, height: Dimension, init: HTMLComponent.() -> Unit) {
        val child = Div() with {
            style = "position: absolute; width: ${width?.toHtml()};"
            init()
        }
        if (items.size > 0 && gap > 0) {
            val gap = createElement("div") with { setAttribute("style", "height: ${gap}px;")}
            element.appendChild(gap)
        }
        items.add(ContainerItem(child, height))
        element.appendChild(child.element)
        recalculatePositions()
        if (needToCalculateWidth()) {
            recalculateWidth()
            registerResizeHandler(child.element) { x, y ->
                recalculateWidth()
            }
        }
    }

    private fun recalculatePositions() {

        val gaps = (items.size - 1) * gap
        val totalWidth = jQuery(element).height()
        val totalFixed = items.filter { it.dimension is Pixels }.map { (it.dimension as Pixels).value }.sum()
        val totalPercents = items.filter { it.dimension is Percent }.map { (it.dimension as Percent).value }.sum()
        val dimensionAvailableToPct = totalWidth.toInt() - totalFixed - gaps

        var position = 0
        items.forEach { item ->
            val calculatedDimension: Int = if (item.dimension is Pixels) {
                item.dimension.value
            } else if (item.dimension is Percent) {
                (item.dimension.value / totalPercents * dimensionAvailableToPct).toInt()
            } else {
                throw Exception("Unsupported dimension type for horizontal column width: ${item.dimension}")
            }
            jQuery(item.div.element).css("top", "${position}px")
            jQuery(item.div.element).css("height", "${calculatedDimension}px")
            position += calculatedDimension + gap
        }
    }

    private fun recalculateWidth() {
        val maxHeightOfChildren = items.map { jQuery(it.div.element).height().toInt() }.max()
        jQuery(element).css("width", "$maxHeightOfChildren")
    }

}

 fun HTMLComponent.verticalContainer(width: Dimension? = null, height: Dimension, gap: Int = 0, init: VerticalContainer.() -> Unit) {
    +(VerticalContainer(width = width, height = height, gap = gap) with { init() })
}
