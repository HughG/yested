package net.yested.bootstrap

import net.yested.*
import net.yested.jquery.jQuery
import net.yested.jqueryui.sortable
import net.yested.utils.options

/**
 * <div role="tabpanel">
 *
 *  <ul class="nav nav-tabs" role="tablist" id="myTab">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane fade in active" id="home">ggg</div>
        <div role="tabpanel" class="tab-pane fade" id="profile">bla</div>
    </div>
</div>
 */
private data class TabDefinition(
        val tabId:Int,
        val init: HTMLComponent.()->Unit,
        val onSelect:Function0<Unit>?)

 class Tabs(canChangeOrder:Boolean = false) : Component {

     override val element = createElement("div")

    private val bar = UL() with { role = "tablist"; clazz = "nav nav-tabs"}

    private val content = Div() with { clazz = "tab-content"}

    private val tabDefinitions = arrayListOf<TabDefinition>()

    private val headersRendered = hashMapOf<Int, Li>()
    private val tabsRendered = hashMapOf<Int, Div>()

    private var index = 0;

    private var tabIndexDisplayed = 0

    private var currentContent:Div? = null

    init {
        element.setAttribute("role", "tabpanel")

        element.appendComponent(bar)
        element.appendComponent(content)

        if (canChangeOrder) {
            jQuery(bar.element).sortable(options {})
        }

    }

    private fun renderContent(tabId:Int, init: HTMLComponent.()->Unit):Div =
        if (tabsRendered.containsKey(tabId)) {
            tabsRendered.get(tabId)!!
        } else {
            val div = Div() with {
                init()
            }
            tabsRendered.put(tabId, div)
            div
        }

    private fun getTabDefinition(tabId:Int) = tabDefinitions.filter { it.tabId == tabId }.firstOrNull()

     fun activateTab(tabId:Int) {

        val tabDefinition:TabDefinition? = getTabDefinition(tabId)
        if (tabDefinition == null) {
            throw Exception("Tab does not exists.")
        } else {
            tabIndexDisplayed = tabId

            val link: Li = headersRendered.get(tabId)!!
            link.clazz = "active"

            headersRendered.values.filter { it != link }.forEach { it.clazz = "" }

            val previousContent = currentContent

            val alreadyAdded = tabsRendered.containsKey(tabId)

            currentContent = null
            if (alreadyAdded) {
                currentContent = tabsRendered.get(tabId)!!
            } else {
                currentContent = renderContent(tabId, tabDefinition.init)
                tabsRendered.put(tabId, currentContent!!)
            }

            if (previousContent != null) {
                FadeOut().apply(previousContent) {
                    if (!alreadyAdded) {
                        currentContent!!.style = "display: none;"
                        content.appendChild(currentContent!!)
                    }
                    FadeIn().apply(currentContent!!)
                }
            } else {
                if (!alreadyAdded) {
                    content.appendChild(currentContent!!)
                }
            }
            tabDefinition.onSelect?.invoke()
        }
    }

     fun removeTab(tabId:Int) {

        val tabDefinition = getTabDefinition(tabId)

        if (tabDefinition == null) {
            throw Exception("Tab does not exists.")
        } else {

            val link: Li = headersRendered[tabId]!!
            bar.element.removeChild(link.element)

            headersRendered.remove(tabId)
            tabsRendered.remove(tabId)

            if (tabIndexDisplayed == tabId) {

                if (tabDefinitions.indexOf(tabDefinition) == 0) {
                    //if it is leftmost tab
                    if (tabDefinitions.size == 1) {
                        //this was the last tab available
                        content.removeAllChildren()
                    } else {
                        //otherwise display second tab
                        activateTab(tabDefinitions.get(1).tabId)
                    }
                } else {
                    //else display now a tab on the left
                    val leftTab = tabDefinitions.get(tabDefinitions.indexOf(tabDefinition) - 1)
                    activateTab(leftTab.tabId)
                }
            }

            tabDefinitions.remove(tabDefinition)

        }

    }

    private fun createTabLink(dismissible: Boolean, tabId:Int, header: HTMLComponent.()->Unit):Li {

        var removingTab = false

        val a = Anchor() with {
            "role" .. "tab"
            "style" .. "cursor: pointer; display: inline-block"
            header()
            if (dismissible) {
                nbsp()
                tag("button") {
                    clazz = "close"; "type".."button";
                    onclick = { removingTab = true; removeTab(tabId) }
                    +"&times;"
                }
            }
            onclick = {
                if (!removingTab) {
                    activateTab(tabId)
                }
            }
        }

        return Li() with {
            +a;
            role = "presentation"
        }

    }

    /**
     * @returns tabId
     */
     fun tab(dismissible: Boolean = false, header: HTMLComponent.()->Unit, onSelect:Function0<Unit>? = null, init: HTMLComponent.()->Unit):Int {

        val tabId = index++;
        val tabDefinition = TabDefinition(tabId, init, onSelect)

        tabDefinitions.add(tabDefinition)

        val link = createTabLink(dismissible, tabId, header)

        bar.appendChild(link)

        headersRendered.put(tabId, link)

        if (index == 1) {
            activateTab(tabId)
        }

        return tabId

    }

}

 fun HTMLComponent.tabs(canChangeOrder:Boolean = false, init:Tabs.() -> Unit): Unit {
    +(Tabs(canChangeOrder = canChangeOrder) with  { init() })
}
