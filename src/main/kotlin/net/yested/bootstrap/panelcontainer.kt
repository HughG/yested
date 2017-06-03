package net.yested.bootstrap

import net.yested.*
import net.yested.jquery.jQuery
import net.yested.jqueryui.sortable
import net.yested.utils.eventHandler
import net.yested.utils.options
import org.w3c.dom.HTMLElement

 abstract class PanelContainer(layoutChangeHandler:Function0<Unit>? = null) : Component {

    override val element: HTMLElement = createElement("ul");

    private val panels = arrayListOf<Panel>()

    init {

        element.setAttribute("class", "list-unstyled")
        jQuery(element).sortable(
                options {
                    handle = ".panel-heading"
                    update = eventHandler {
                        if (layoutChangeHandler != null) {
                            layoutChangeHandler()
                        }
                    }
                })

    }

     fun getPanels(): Array<Panel> = panels.toTypedArray()

    protected fun insertPanel(containerItem: Div, panel: Panel) {

        element.appendChild(containerItem.element)

        panel.dismissibleHandler = {
            element.removeChild(it.element.parentNode!!)
            panels.remove(it)
        }

        panels.add(panel)

    }

}

 class RowPanelContainer(layoutChangeHandler:Function0<Unit>? = null) : PanelContainer(layoutChangeHandler = layoutChangeHandler) {

     fun panel(size: DeviceSize, style:PanelStyle = PanelStyle.DEFAULT, dismissible: Boolean = false, init:Panel.() -> Unit) {
        add(panel = Panel(style = style, dismissible = dismissible) with { init() }, size = size)
    }

     fun add(panel:Panel, size: DeviceSize) {

        val containerItem = (Div() with {
            "class"..size.toString()
            +panel
        })

        insertPanel(containerItem, panel)

    }

}

 class FloatingPanelContainer(layoutChangeHandler:Function0<Unit>? = null, val margin: String = "10px") : PanelContainer(layoutChangeHandler = layoutChangeHandler) {

     fun panel(size: String, style:PanelStyle = PanelStyle.DEFAULT, dismissible: Boolean = false, init:Panel.() -> Unit) {
        add(panel = Panel(style = style, dismissible = dismissible) with { init() }, size = size)
    }

     fun add(panel:Panel, size: String) {

        val containerItem = (Div() with {
            "style".."width: ${size}; float: left; margin: ${margin};"
            +panel
        })

        insertPanel(containerItem, panel)

    }

}


 fun HTMLComponent.rowPanelContainer(init:RowPanelContainer.()->Unit) {
    +(RowPanelContainer() with { init() })
}

 fun HTMLComponent.floatingPanelContainer(margin: String = "10px", init:FloatingPanelContainer.()->Unit) {
    +(FloatingPanelContainer(margin = margin) with { init() })
}