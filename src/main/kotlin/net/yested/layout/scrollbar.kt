package net.yested.layout

import net.yested.*
import net.yested.jquery.jQuery
import net.yested.jquery.on
import net.yested.jqueryui.DraggableEvent
import net.yested.jqueryui.draggable
import net.yested.utils.eventHandler
import net.yested.utils.options
import net.yested.utils.registerResizeHandler
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.WheelEvent
import kotlin.js.Math

enum class ScrollBarOrientation(val directionProperty:String, val nonDirectionProperty:String, val axis:String, val cssPosProperty:String) {
    VERTICAL(directionProperty = "height", nonDirectionProperty = "width", axis = "y", cssPosProperty = "top"),
    HORIZONTAL(directionProperty = "width", nonDirectionProperty = "height", axis = "x", cssPosProperty = "left")
}

/**
 * https://github.com/cowboy/jquery-throttle-debounce
 */
 class ScrollBar(
        val orientation: ScrollBarOrientation,
        val size: Dimension,
        var numberOfItems: Int,
        var visibleItems: Int,
        val className:String? = null,
        val positionHandler:(Int) -> Unit) : Component {

    override val element = createElement("div")

    private val handle = Div()

    private var currentPosition:Int = 0

    private var trackerDimension:Int = 0

    private var handleDimension:Int = 0

     fun setTrackerVisible(visibleTracker:Boolean) {
        if (visibleTracker) {
            jQuery(handle.element).css("visibility", "visible")
        } else {
            jQuery(handle.element).css("visibility", "hidden")
        }
    }

    init {

        element.appendChild(handle.element)
        element.setAttribute("style", "${orientation.directionProperty}: ${size.toHtml()};")
        element.setAttribute("position", "absolute")

        if (className != null) {
            handle.clazz = className
        } else {
            handle.style = "${orientation.nonDirectionProperty}: 15px; background-color: #5c92e7; cursor: move; position: relative; ${orientation.cssPosProperty}: 0"
        }

        jQuery(handle.element).draggable(
                options {
                    axis = orientation.axis
                    containment = "parent"
                    val dragHandler = eventHandler {
                        val top = jQuery(this@ScrollBar.handle.element).css(orientation.cssPosProperty).toInt()
                        updatePosition(top)
                    }
                    drag = dragHandler.unsafeCast<DraggableEvent>()
                })

        jQuery(element).on("wheel") { event ->
            val e = event.originalEvent.unsafeCast<WheelEvent>()
            val delta = Math.max(-1, Math.min(1, e.deltaX.toInt()))
            event.preventDefault()
            if (delta < 0) {
                if (currentPosition < numberOfItems) {
                    currentPosition += delta*-1
                    changePositionOfHandler()
                    positionHandler(currentPosition)
                }
            } else {
                if (currentPosition > 0) {
                    currentPosition += delta*-1
                    changePositionOfHandler()
                    positionHandler(currentPosition)
                }
            }
        }

        var touchStartMouse:Int = 0
        var touchStartTop:Int = 0

        jQuery(handle.element).on("touchstart", { event->
            touchStartTop = jQuery(handle.element).css(orientation.cssPosProperty).toInt()
            touchStartMouse = getMouseTouchPosition(event)
            event.preventDefault()
        })

        jQuery(handle.element).on("touchmove", { event ->
            event.preventDefault()
            val newMousePos = getMouseTouchPosition(event)
            val diff: Int = newMousePos - touchStartMouse
            val newPosition = Math.max(0, Math.min(touchStartTop + diff, trackerDimension - handleDimension))
            jQuery(handle.element).css(orientation.cssPosProperty, "${newPosition}px")
            updatePosition(newPosition)
        })

        handle.element.whenAddedToDom {
            recalculate()
            registerResizeHandler(element.parentNode as HTMLElement) { x, y ->
                recalculate()
            }
        }

    }

    private fun getMouseTouchPosition(event: dynamic) = if (orientation == ScrollBarOrientation.VERTICAL) {
            event.originalEvent.touches[0].clientY
        } else {
            event.originalEvent.touches[0].clientX
        }

    private fun updatePosition(top: Int) {
        currentPosition = (numberOfItems.toDouble() * top / (trackerDimension - handleDimension)).toInt()
        positionHandler(currentPosition)
    }

     var position:Int
        get() = currentPosition
        set(value) {
            currentPosition = value
            changePositionOfHandler()
        }

    private fun changePositionOfHandler() {
        val position = (currentPosition.toDouble() * (trackerDimension - handleDimension) / numberOfItems).toInt()
        jQuery(handle.element).css(orientation.cssPosProperty, "${position}px")
    }

     fun setup(numberOfItems: Int, visibleItems: Int, newPosition: Int) {
        this.numberOfItems = numberOfItems
        this.visibleItems = visibleItems
        element.whenAddedToDom {
            recalculate()
            position = newPosition
        }
    }

    private fun recalculate() {
        trackerDimension = trackerDimension()
        handleDimension = handleDimension().toInt()
        jQuery(handle.element).css(orientation.directionProperty, "${handleDimension}")
    }

    private fun trackerDimension() =
            if (orientation == ScrollBarOrientation.VERTICAL) {
                jQuery(element).height().toInt()
            } else {
                jQuery(element).width().toInt()
            }

    private fun handleDimension() = Math.max(30, (trackerDimension * visibleItems/numberOfItems).toInt())

}