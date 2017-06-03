package net.yested.utils

import net.yested.jquery.jQuery
import org.w3c.dom.HTMLElement
import kotlin.browser.window

private class ResizeHandler(
        val element:HTMLElement,
        val handler:(width:Number, height:Number) -> Unit) {

    private var latestWidth = jQuery(element).width()
    private var latestHeight = jQuery(element).height()

     fun check() {
        val newWidth = jQuery(element).width()
        val newHeight = jQuery(element).height()
        if (newWidth != latestWidth || newHeight != latestHeight) {
            latestWidth = newWidth
            latestHeight = newHeight
            handler(latestWidth, latestHeight)
        }
    }

}

private var timerId:Int = -1

private var resizeHandlers = arrayListOf<ResizeHandler>()

private fun checkAllHandlers() {
    resizeHandlers.forEach { it.check() }
}

 fun registerResizeHandler(element: HTMLElement, handler:(width:Number, height:Number) -> Unit) {

    resizeHandlers.add(ResizeHandler(element, handler))

    if (resizeHandlers.size == 1) {
        timerId = window.setInterval( { checkAllHandlers() }, 200)
    }

}