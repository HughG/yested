package net.yested.bootstrap.smartgrid

import net.yested.*
import net.yested.bootstrap.Glyphicon
import net.yested.bootstrap.glyphicon
import net.yested.jquery.jQuery
import kotlin.browser.window

/**
 * Internal class of SmartGrid
 */
class GridColumnHeader<T>(
        val column:GridColumn<T>,
        sortingSupported:Boolean,
        val filterHandler: Function1<Filter<T>?, Unit>,
        filterConfig:String? = null,
        sortFunction: Function1<GridColumn<T>, Unit>,
        groupFunction: Function1<GridColumn<T>, Unit>,
        openAggregatedGroups: Function0<Unit>,
        closeAggregatedGroups: Function0<Unit>,
        cancelAggregation: Function0<Unit>) : HTMLComponent("div") {

    private val arrowPlaceholder = Span()
    private var filterContainer:Div?
    private var filterDisplayed = false

    private fun displayFilter() {
        positionFilter()
        Show().apply(filterContainer!!) {
            filterDisplayed = true
        }
    }

    private fun positionFilter() {

        val headerCellOffset = jQuery(this.element).offset()
        val posY = headerCellOffset.top.toDouble() - jQuery(window).scrollTop() as Int + jQuery(this.element).height() as Int
        val posX = headerCellOffset.left.toDouble() - jQuery(window).scrollLeft() as Int

        jQuery(filterContainer!!.element).css("top", "${posY}px")
        jQuery(filterContainer!!.element).css("left", "${posX}px")

    }

    init {

        if (column.filterFactory != null) {
            filterContainer = (Div() with {
                "style".."position: fixed; z-index: 1; display: none;"
            })
            createFilter(filterConfig)
            jQuery(window).click( { event ->
                if (filterDisplayed) {
                    if (jQuery(event.target).closest(filterContainer!!.element).length == 0) {
                        filterDisplayed = false
                        Hide().apply(filterContainer!!)
                    }
                }
            })
        } else {
            filterContainer = null
        }

        if (sortingSupported) {
            div { "style".."position: relative"
                div {
                    a(href = null, onclick = { sortFunction(column) }) {
                        "style".."cursor: pointer;"
                        +column.label
                    }
                    +arrowPlaceholder
                    if (filterContainer != null) {
                        +filterContainer!!
                        a(href = null, onclick = { displayFilter() }) {
                            "style".."cursor: pointer;"
                            glyphicon(icon = "filter")
                        }
                    }
                    if (column.groupBy != null) {
                        a(href = null, onclick = { groupFunction(column) }) {
                            "style".."cursor: pointer;"
                            glyphicon(icon = "folder-open")
                        }
                    }
                }
            }
        } else {
            if (column.id == "root") { //render aggregated column header
                a(onclick = { openAggregatedGroups() }) { "style".."cursor: pointer;"
                    glyphicon("plus")
                }
                nbsp()
                a(onclick = { closeAggregatedGroups() }) { "style".."cursor: pointer;"
                    glyphicon("minus")
                }
                nbsp()
                a(onclick = { cancelAggregation() }) { "style".."cursor: pointer;"
                    glyphicon("remove")
                }
            } else {
                +column.label
            }
        }
    }

    private fun createFilter(filterConfig: String?) {
        filterContainer!!.removeAllChildren()
        filterContainer!! with {
            +column.filterFactory!!.createFilterElement(filterHandler, filterConfig)
        }
    }

    fun updateSorting(sortByColumn:GridColumn<T>?, sortAscending:Boolean) {
        if (sortByColumn != column) {
            arrowPlaceholder.setContent("")
        } else {
            arrowPlaceholder.setChild(Glyphicon("arrow-${if (sortAscending) "up" else "down"}"))
        }
    }

    fun repositionFilter() {
        if (filterDisplayed) {
            positionFilter()
        }
    }

}

