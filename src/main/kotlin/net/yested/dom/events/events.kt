package net.yested.dom.events

import org.w3c.dom.Element
import org.w3c.dom.events.UIEvent
import org.w3c.dom.events.UIEventInit

external abstract class Touch : org.w3c.dom.Touch {
    val identifier: Int
    val screenX: Int
    val screenY: Int
    val clientX: Int
    val clientY: Int
    val pageX: Int
    val pageY: Int
    val target: Element
}

external class TouchList {
    val length: Int
    fun item(index: Int): Touch
    @JsName("item")
    operator fun get(index: Int): Touch
}

public external open class TouchEvent
    public constructor(type: kotlin.String, eventInitDict: TouchEventInit)
    : UIEvent
{
    val touches: TouchList
    val changedTouches: TouchList
    val targetTouches: TouchList
}

public external interface TouchEventInit : UIEventInit {
    val identifier: Int
    val screenX: Int
    val screenY: Int
    val clientX: Int
    val clientY: Int
    val pageX: Int
    val pageY: Int
    val target: Element
}
