package net.yested.bootstrap.smartgrid

import net.yested.*
import net.yested.bootstrap.Align
import net.yested.bootstrap.glyphicon
import net.yested.dom.events.TouchEvent
import net.yested.jquery.JQueryEventObject
import net.yested.jquery.jQuery
import net.yested.jquery.on
import net.yested.jqueryui.sortable
import net.yested.layout.*
import net.yested.layout.containers.VerticalContainer
import net.yested.layout.containers.horizontalContainer
import net.yested.utils.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.Node
import org.w3c.dom.events.WheelEvent
import kotlin.browser.window
import kotlin.js.Math

interface CellEditorFactory<TYPE> {
    fun createEditor(width:String, item:TYPE, closeHandler: ()->Unit):HTMLElement
}

class Filter<T>(
        val filteringFunction: Function1<T, Boolean>,
        val filterConfig: String
)

interface FilterFactory<T> {
    fun createFilterElement(newFilterHandler : Function1<Filter<T>?, Unit>, filterConfig : String? = null): Component
}

data class GridColumn<T>(
        val id: String,
        val width: String,
        val label: String,
        val render: HTMLComponent.(T) -> Unit,
        val editor: CellEditorFactory<T>? = null,
        val align:Align = Align.LEFT,
        val filterFactory: FilterFactory<T>? = null,
        val sortFunction:((T, T) -> Int)? = null,
        val groupBy: ((T) -> String)? = null,
        val getNumber: ((T) -> Double?)? = null)

private class Group<T>(
        val groupName:String,
        var subgroups:List<Group<T>>? = null,
        var items:List<T>? = null,
        var open:Boolean = true,
        var aggregated:MutableMap<String, Double>? = null
)

private open class VisibleItem<T>

private class VisibleItemGroup<T>(
        val groupName:Comparable<*>,
        val group:Group<T>,
        val level:Int
) : VisibleItem<T>()

private class VisibleOneItem<T>(
        val item:T
) : VisibleItem<T>()

private fun <T> group(items: Collection<T>, aggregatingColumns: List<GridColumn<T>>, aggregateByColumn:Int): List<Group<T>> {
    val aggregatingColumn = aggregatingColumns.get(aggregateByColumn)
    return items
            .groupBy { aggregatingColumn.groupBy!!(it) }
            .entries
            .map { entry ->
                if (aggregateByColumn < aggregatingColumns.size - 1) {
                    //do additional grouping
                    Group(groupName = entry.key, subgroups = group(entry.value, aggregatingColumns, aggregateByColumn+1))
                } else {
                    Group(groupName = entry.key, items = entry.value)
                }
            }
}

private fun <T> renderGroupInto(group: Group<T>, visibleItems:MutableCollection<VisibleItem<T>>, level: Int) {
    if (group.groupName != "root") {
        visibleItems.add(VisibleItemGroup(groupName = group.groupName, group = group, level = level)) //add summary row
    }
    if (group.open) {
        if (group.subgroups != null) {
            group.subgroups!!.forEach { renderGroupInto(it, visibleItems, level + 1) }
        } else {
            group.items!!.map { VisibleOneItem(item = it) }.forEach { visibleItems.add(it) }
        }
    }
}

private fun <T> onEachSubGroup(group: Group<T>, action:(Group<T>)->Unit) {
    if (group.subgroups != null) {
        group.subgroups!!.forEach { subGroup ->
            onEachSubGroup(subGroup, action)
            action(subGroup)
        }
    }
}

fun calculateAggregatedNumber(numbers:Collection<Double?>):Double =
    numbers.filter { it != null }.fold(0.0, { fold,n -> fold+n!! } )

private fun <T> calculateAggregations(columnsWithGroupFunctions:List<GridColumn<T>>, group:Group<T>) {
    group.aggregated = hashMapOf()
    if (group.items != null) {
        columnsWithGroupFunctions.forEach { column ->
            val numbers = group.items!!.map { column.getNumber!!(it) }.filter { it != null }
            group.aggregated!!.put(column.id, calculateAggregatedNumber(numbers))
        }
    } else if (group.subgroups != null) {
        columnsWithGroupFunctions.forEach { column ->
            group.aggregated!!.put(column.id, calculateAggregatedNumber(group.subgroups!!.map { it.aggregated!!.get(column.id) }))
        }
    }
}

private fun <T> clearAggregationsOfAll(group:Group<T>) {
    onEachSubGroup(group) {
        it.aggregated = null
    }
}

/**
 * .on('mousemove', $.throttle(interval, function(e)
 */
 class SmartGrid<TYPE, KEY>(
        val rowHeight:Int = 30,
        val getKey:(TYPE)->KEY,
        columns:Array<GridColumn<TYPE>>) : Component {

    private val dataTable = createElement("table") with {
        setAttribute("class", "table-striped table-hover table-condensed")
        setAttribute("style", "table-layout: fixed; height: 100%;")
    }

    private val header = createElement("tr") with { }

    private val scrollBarVertical = ScrollBar(
                                            orientation = ScrollBarOrientation.VERTICAL,
                                            size = 100.pct(),
                                            numberOfItems = 1,
                                            visibleItems = 1,
                                            positionHandler = jQuery.throttle(35, { verticalScrollBarMoved(it) }))

    private val scrollBarHorizontal = ScrollBar(
                                            orientation = ScrollBarOrientation.HORIZONTAL,
                                            size = 100.pct(),
                                            numberOfItems = 1,
                                            visibleItems = 1,
                                            positionHandler = jQuery.throttle(35, { horizontalScrollBarMoved(it) }))

    private val columnHeaderContainer = Div() with {  "style".."overflow: scroll; overflow-x:hidden; overflow-y:hidden;"
        table {
            element.setAttribute("class", "table-striped table-hover table-condensed")
            element.setAttribute("style", "margin-bottom: 0px;")
            thead {
                element.appendChild(header)
            }
        }
    }

    private val cont = ScrollPane(horizontal = Overflow.HIDDEN, height = 100.pct()) {
        element.appendChild(dataTable)
    }

    override val element =
            (VerticalContainer(width = 100.pct(), height = 100.pct()) with {
                row(width = 100.pct(), height = (rowHeight).px()) {
                    horizontalContainer(width = 100.pct()) {
                        column(width = 100.pct()) {
                            scrollPane(horizontal = Overflow.HIDDEN) {
                                +columnHeaderContainer
                            }
                        }
                        column(width = 15.px()) {
                            a(onclick = { showDialogCustom() }) {
                                "style".."cursor: pointer;"
                                glyphicon("cog")
                            }
                        }
                    }
                }
                row(width = 100.pct(), height = 100.pct()) {
                    horizontalContainer(width = 100.pct(), height = 100.pct()) {
                        column(width = 100.pct(), height = 100.pct()) {
                            +cont
                        }
                        column(width = 15.px(), height = 100.pct()) {
                            +scrollBarVertical
                        }
                    }
                }
                row(width = 100.pct(), height = 15.px()) {
                    horizontalContainer(width = 100.pct()) {
                        column(width = 100.pct()) {
                            +scrollBarHorizontal
                        }
                        column(width = 15.px()) {
                            div { "style".."width:15px;" }
                        }
                    }
                }
            }).element


    private var sortColumn:GridColumn<TYPE>? = null
    private var asc:Boolean = true;
    private var columnHeaders:List<GridColumnHeader<TYPE>>? = null

    private var visibleColumns:List<String> = listOf()

    private val columns = columns
                            .plus(GridColumn<TYPE>(
                                id="root",
                                width = 200.px().toHtml(),
                                label = "",
                                render = { }))
                            .associateBy { it.id };

    private var rowsReferences = hashMapOf<KEY, HTMLElement>();

    private var visibleRows:Int = 1

    private var currentRow:Int = 0

    private var gridIsCreated:Boolean = false

    private val filters = hashMapOf<String, Filter<TYPE>>()

    private var fullDataList: MutableList<TYPE> = arrayListOf()
    private var filteredDataList: MutableList<TYPE> = arrayListOf()
    private var group:Group<TYPE> = Group<TYPE>(groupName = "root", open = true, items = arrayListOf())
    private var visibleDataList: MutableList<VisibleItem<TYPE>> = arrayListOf()

    private var dataListAsKeyMap: MutableMap<KEY, TYPE> = hashMapOf()

    private val groupingColumns: MutableList<GridColumn<TYPE>> = arrayListOf()

     var list: MutableList<TYPE>?
        get() = fullDataList
        set(value) {
            fullDataList = value ?: arrayListOf()
            dataListAsKeyMap = fullDataList.associateBy { getKey(it) } as MutableMap
            currentRow = 0
            refilterData()
            regroupData()
            renderGroupedData()
            repeatWithDelayUntil( { gridIsCreated }, 100) {
                createRowsWithColumns()
                displayNewData()
            }
        }

    private fun showDialogCustom() {
        val columnsWithoutAggregatingColumn = visibleColumns.filter { it != "root" }
        openConfigurationDialog(columns.values.filter { it.id != "root" }, columnsWithoutAggregatingColumn, { newVisibleColumns ->
            val newList = newVisibleColumns.toMutableList()
            if (groupingColumns.size > 0) {
                newList.add(0, "root")
            }
            visibleColumns = newList;
            createRowsWithColumns()
            renderHeaderInto(header)
            filtersChanged()
            redisplayTheReorderedDataSet()
            updateHorizontalScrollbar()
        })
    }

    init {

        visibleColumns = columns.map { it.id }

        //register scrolling
        cont.onscroll = {
            val a = columnHeaderContainer.element
            val b = cont.element
            js("a.scrollLeft = b.scrollLeft")
            //TODO: columnHeaderContainer.element.scrollLeft = cont.element.scrollLeft
        }

        //http://stackoverflow.com/questions/2264072/detect-a-finger-swipe-through-javascript-on-the-iphone-and-android
        var touchStartY:Int = 0
        var touchStartX:Int = 0
        var touchStartRow:Int = 0
        var horizontalScrollStart:Int = 0

        jQuery(dataTable).on("touchstart", { event ->
            val touchEvent = event.originalEvent as TouchEvent
            touchStartY = touchEvent.touches[0].clientY
            touchStartX = touchEvent.touches[0].clientX
            event.preventDefault()
            touchStartRow = currentRow
            horizontalScrollStart = scrollBarHorizontal.position
        })

        jQuery(dataTable).on("touchmove", { event ->
            event.preventDefault()
            val touchEvent = event.originalEvent as TouchEvent
            val yUp = touchEvent.touches[0].clientY
            val xUp = touchEvent.touches[0].clientX
            val diffY:Int = yUp - touchStartY
            val diffX:Int = xUp - touchStartX

            val newRow = touchStartRow - (diffY.toDouble()/rowHeight).toInt()
            val limitedNewRow = Math.max(0, Math.min(newRow, visibleDataList.size - visibleRows))
            val newHorizontalScrollPosition = Math.max(0, Math.min(horizontalScrollStart - diffX, scrollBarHorizontal.numberOfItems))

            if (gridIsCreated) {
                if (limitedNewRow != currentRow) {
                    val previousRow = currentRow
                    currentRow = limitedNewRow
                    redisplayTheReorderedDataSet(previousRow)
                }
                scrollBarVertical.position = currentRow
                scrollBarHorizontal.position = newHorizontalScrollPosition
                cont.element.scrollLeft = newHorizontalScrollPosition.toDouble()
            }

        })

        cont.element.whenAddedToDom {
            renderHeaderInto(header)
            makeHeaderSortable(header)
            recalculateVisibleRows()
            registerMouseWheelScroll()
            registerResizeHandler(cont.element) { x,y->
                recalculateVisibleRows()
                createRowsWithColumns()
                if (visibleDataList.size > 0) {
                    displayNewData()
                }
                updateHorizontalScrollbar()
            }
        }

        jQuery(window).scroll {
            columnHeaders?.forEach { it.repositionFilter() } ?: Unit
        }
        jQuery(cont.element).scroll {
            columnHeaders?.forEach { it.repositionFilter() } ?: Unit
        }
        jQuery(window).resize {
            columnHeaders?.forEach { it.repositionFilter() } ?: Unit
        }

    }

    private fun recalculateVisibleRows() {
        val viewPortHeight = jQuery(cont.element).height().toInt()
        visibleRows = Math.floor(viewPortHeight / rowHeight)
    }

    private fun displayNewData() {
        currentRow = Math.min(currentRow, Math.max(0, visibleDataList.size - visibleRows))
        redisplayTheReorderedDataSet()
        updateVerticalScrollbarToReflectChangeNumberOfItems()
    }

    private fun updateVerticalScrollbarToReflectChangeNumberOfItems() {
        val adjustedVisibleRows = calculateAdjustedVisibleRowsForVerticalScrollbar()
        scrollBarVertical.setup(numberOfItems = visibleDataList.size - visibleRows, visibleItems = adjustedVisibleRows, newPosition = currentRow)
        if (visibleDataList.size <= visibleRows) {
            scrollBarVertical.setTrackerVisible(false)
        } else {
            scrollBarVertical.setTrackerVisible(true)
        }
    }

    private fun calculateAdjustedVisibleRowsForVerticalScrollbar() =
            Math.max(1, (visibleRows * ((visibleDataList.size - visibleRows).toDouble() / visibleDataList.size.toDouble())).toInt())

    private fun verticalScrollBarMoved(newPosition:Int) {
        currentRow = newPosition
        redisplayTheReorderedDataSet()
    }

    private fun horizontalScrollBarMoved(newPosition:Int) {
        cont.element.scrollLeft = newPosition.toDouble()
    }

    private fun getVisibleColumns():List<GridColumn<TYPE>> =
            visibleColumns.map { columns.get(it)!! }


    private fun setSortingArrow() {
        columnHeaders!!.forEach { it.updateSorting(sortColumn, asc) }
    }

    private fun sortByColumn(column:GridColumn<TYPE>):Unit {
        if (column == sortColumn) {
            asc = !asc;
        } else {
            asc = true;
            sortColumn = column
        }
        sortData()
        renderGroupedData()
        redisplayTheReorderedDataSet()
        setSortingArrow()
    }

    private fun groupByColumn(column:GridColumn<TYPE>):Unit {
        if (groupingColumns.size == 0) {
            val newList = visibleColumns.toMutableList()
            newList.add(0, "root")
            visibleColumns = newList
        }
        visibleColumns = visibleColumns.filter { it != column.id } //remove column from visible columns
        groupingColumns.add(column)

        renderGridCompletely()

    }

    private fun renderGridCompletely() {
        createRowsWithColumns()
        renderHeaderInto(headerDiv = header)
        updateHorizontalScrollbar()
        regroupData()
        sortData()
        renderGroupedData()
        displayNewData()
    }

    private fun cancelAggregation() {

        val newVisibleColumnsList = visibleColumns.toMutableList()
        newVisibleColumnsList.removeAt(0)//remove old root column
        groupingColumns.reversed().forEach { //show again columns which where used for aggregation
            if (!newVisibleColumnsList.contains(it.id)) {
                newVisibleColumnsList.add(0, it.id)
            }
        }
        visibleColumns = newVisibleColumnsList
        groupingColumns.clear()

        renderGridCompletely()
    }

    private fun openCloseGroup(group:Group<TYPE>) {
        group.open = !group.open
        renderGroupedData()
        displayNewData()
    }

    private fun openAggregatedGroups() {
        onEachSubGroup(group) {
            it.open = true
        }
        renderGroupedData()
        displayNewData()
    }

    private fun closeAggregatedGroups() {
        onEachSubGroup(group) {
            it.open = false
        }
        renderGroupedData()
        displayNewData()
    }

    private fun renderHeaderInto(headerDiv: HTMLElement) {

        columnHeaders =
                getVisibleColumns()
                .map {
                    GridColumnHeader(
                            column = it,
                            sortingSupported = it.sortFunction != null,
                            filterHandler = { filter -> updateFilter(it.id, filter)},
                            filterConfig = filters.get(it.id)?.filterConfig ?: null,
                            sortFunction = { sortByColumn(it) },
                            groupFunction = { groupByColumn(it) },
                            openAggregatedGroups = { openAggregatedGroups() },
                            closeAggregatedGroups = { closeAggregatedGroups() },
                            cancelAggregation = { cancelAggregation() })
                }

        headerDiv.removeAllContent()

        columnHeaders!!
                .map { createColumnHeader(it) }
                .forEach { headerDiv.appendChild(it.element) }

        val filtersOfHiddenColumns = filters.keys.filter { !visibleColumns.contains(it) }
        filtersOfHiddenColumns.forEach {
            filters.remove(it)
        }

    }

    private fun updateFilter(columnId:String, filter: Filter<TYPE>?) {
        if (filter != null) {
            filters.put(columnId, filter)
        } else {
            filters.remove(columnId)
        }
        filtersChanged()
    }

    private fun filtersChanged() {
        refilterData()
        regroupData()
        renderGroupedData()
        displayNewData()
    }

    private fun renderGroupedData() {
        visibleDataList.clear()
        renderGroupInto(group, visibleDataList, 0)
        calculateAggregationsOfGroups()
    }

    private fun calculateAggregationsOfGroups(forColumns: Collection<String>? = null) {
        val columnsWithGetFunction = getVisibleColumns().filter { it.getNumber != null }.filter { forColumns == null || forColumns.contains(it.id) }
        if (columnsWithGetFunction.size > 0) {
            onEachSubGroup(group) {
                calculateAggregations(columnsWithGetFunction, it)
            }
        } else {
            clearAggregationsOfAll(group)
        }
    }

    private fun sortData() {
        if (sortColumn?.sortFunction != null) {
            sortItemsInGroup(group)
        }
    }

    private fun sortItemsInGroup(group: Group<TYPE>) {
        if (group.items != null) {
            group.items = group.items!!.sortedWith(comparator = Comparator {
                obj1: TYPE, obj2: TYPE ->
                (sortColumn!!.sortFunction!!(obj1, obj2)) * (if (asc) 1 else -1)
            }).toMutableList()
           /* group.items = group.items!!.sortedBy(object : java.util.Comparator<TYPE> {
                override fun compare(obj1: TYPE, obj2: TYPE): Int {
                    return (sortColumn!!.sortFunction!!(obj1, obj2)) * (if (asc) 1 else -1)
                }
            }).toMutableList()*/
        } else {
            group.subgroups = group.subgroups!!.sortedBy { it.groupName }
            group.subgroups!!.forEach { sortItemsInGroup(it) }
        }
    }

    private fun refilterData() {
        if (filters.size == 0) {
            filteredDataList = fullDataList
        } else {
            filteredDataList = fullDataList
                    .filter {
                        isItemMatchingFilters(it)
                    }
                    .toMutableList()
        }
    }

    private fun regroupData() {
        if (groupingColumns.size > 0) {
            group = Group(groupName = "root", subgroups = group(filteredDataList, groupingColumns, 0));
        } else {
            group = Group(groupName = "root", items = filteredDataList)
        }
    }

    private fun isItemMatchingFilters(item: TYPE): Boolean {
        var matching = true
        for (filter in filters.values) {
            if (!filter.filteringFunction(item)) {
                matching = false
                break
            }
        }
        return matching
    }

    private fun updateHorizontalScrollbar() {
        val range = jQuery(dataTable).width().toInt() - jQuery(cont.element).width().toInt()
        if (range > 0) {
            val handlerSize = range * (jQuery(cont.element).width().toDouble() / jQuery(header).width().toDouble())
            val newHorizontalPosition = Math.min(scrollBarHorizontal.position, range.toInt())
            scrollBarHorizontal.setup(numberOfItems = range.toInt(), visibleItems = handlerSize.toInt(), newPosition = newHorizontalPosition)
            scrollBarHorizontal.setTrackerVisible(true)
        } else {
            scrollBarHorizontal.setTrackerVisible(false)
        }
    }

    private fun createColumnHeader(columnHeader: GridColumnHeader<TYPE>) =
        HTMLComponent("th") with {
            "columnid"..columnHeader.column.id
            "style".."min-width: ${columnHeader.column.width}; max-width: ${columnHeader.column.width};"
            "class" .. "text-${columnHeader.column.align.code}";
            +columnHeader
        }

    private fun readCurrentColumnLayout() =
        (0..(header.childNodes.length-1)).map {
            (header.childNodes.item(it) as HTMLElement).getAttribute("columnid")!!
        }.toList()

    private fun makeHeaderSortable(headerDiv:HTMLElement) {
        jQuery(headerDiv).sortable(
                options {
                    update = eventHandler { event: dynamic, ui: dynamic ->
                        visibleColumns = readCurrentColumnLayout()
                        createRowsWithColumns()
                        redisplayTheReorderedDataSet()
                    }
                    delay = 150
                })
    }

    private fun setOnClick(td:HTMLElement, column:GridColumn<TYPE>) {
        if (column.editor != null) {
            td.onclick = {
                if (td.getAttribute("editing") != "true") {
                    td.setAttribute("editing", "true")
                    val rowIndex = getTBody().getIndexOfChildNode(td.parentNode!!)
                    val item = visibleDataList.get(currentRow + rowIndex)
                    if (item is VisibleOneItem<TYPE>) {
                        val editor = column.editor.createEditor(
                                column.width,
                                item.item,
                                {
                                    td.removeAttribute("editing")
                                    td.removeAllContent()
                                    HTMLComponent("", td) with {
                                        (column.render)(item.item)
                                    }
                                })
                        td.removeAllContent()
                        td.appendChild(editor)
                    }
                }
            }
        } else {
            td.onclick = {}
        }
    }

    private fun registerMouseWheelScroll() {

        jQuery(dataTable).on("wheel") { event: JQueryEventObject ->
            val previousRow = currentRow
            val e = event.originalEvent as WheelEvent
            event.preventDefault()
            val mouseDeltaY = toZero(e.deltaY) + toZero(e.detail.toDouble())*(-1.0)
            if (Math.abs(mouseDeltaY) > Math.abs(toZero(e.deltaX))) {
                val deltaY = Math.max(-1.0, Math.min(1.0, (mouseDeltaY )));
                if (deltaY < 0) {
                    currentRow = Math.min(currentRow + 1, visibleDataList.size - visibleRows)
                } else if (deltaY > 0) {
                    currentRow = Math.max(0, currentRow - 1)
                }
                if (previousRow != currentRow) {
                    redisplayTheReorderedDataSet(previousRow)
                    scrollBarVertical.position = currentRow
                }
            }
            if (Math.abs(e.deltaX) > Math.abs(mouseDeltaY)) {
                val deltaX = Math.max(-1.0, Math.min(1.0, (e.deltaX)));
                if (deltaX != 0.0) {
                    val newHorizontalScrollPosition =
                            Math.max(0, Math.min(scrollBarHorizontal.position - (deltaX * 10).toInt(), scrollBarHorizontal.numberOfItems))
                    scrollBarHorizontal.position = newHorizontalScrollPosition
                    cont.element.scrollLeft = newHorizontalScrollPosition.toDouble()
                }
            }
        }

        gridIsCreated = true

    }

    private fun createRowsWithColumns() {

        val visibleColumns = getVisibleColumns()

        var tbody = createElement("tbody")

        (1..visibleRows).forEach { rowIndex ->
            val tr = createElement("tr") with { setAttribute("style", "height: ${rowHeight}px;")}
            visibleColumns.forEach { column ->

                val td = createElement("td")
                if (column.align != Align.LEFT) {
                    td.setAttribute("class", "text-${column.align.code}")
                }
                if (rowIndex == 1) {
                    td.setAttribute("style", "min-width: ${column.width};  max-width: ${column.width};")
                }
                setOnClick(td, column)
                tr.appendChild(td)
            }
            tbody.appendChild(tr)
        }

        dataTable.removeChildByName("tbody")
        dataTable.appendChild(tbody)

        updateHorizontalScrollbar()

    }

    private fun redisplayTheReorderedDataSet(previousRow:Int? = null) {

        val columns = getVisibleColumns()
        val tbody = getTBody()
        val rows = tbody.childNodes

        val maxOptimizedMove:Int = Math.min(1, visibleRows / 2);

        if (previousRow != null && previousRow in (currentRow - maxOptimizedMove) .. (currentRow - 1)) { //scrolling down
            val movedRowsCount:Int = currentRow - previousRow

            (1..movedRowsCount).forEach { index ->

                //remove previous records from rowsReferences
                val removedItem = visibleDataList.get(previousRow + index - 1)
                if (removedItem is VisibleOneItem) {
                    rowsReferences.remove(getKey(removedItem.item))
                }

                val movedRow = rows.item(0)!!
                tbody.appendChild(movedRow)
                val itemForLastRow = visibleDataList.get(visibleRows + currentRow - (movedRowsCount - index + 1))
                updateRow(columns, itemForLastRow, movedRow)
                if (itemForLastRow is VisibleOneItem) {
                    rowsReferences.put(getKey(itemForLastRow.item), movedRow as HTMLElement)
                }
            }

        } else if (previousRow != null && previousRow in ((currentRow + 1) .. (currentRow + maxOptimizedMove))) { //scrolling up
            val movedRowsCount:Int = previousRow -currentRow
            (1..movedRowsCount).forEach { index ->

                //remove previous records from rowsReferences
                val removedItem = visibleDataList.get(previousRow + visibleRows - index)
                if (removedItem is VisibleOneItem) {
                    rowsReferences.remove(getKey(removedItem.item))
                }

                val movedRow = rows.item(visibleRows-1)!!
                val firstRow = rows.item(0)
                tbody.insertBefore(movedRow, firstRow)
                val itemForLastRow = visibleDataList.get(currentRow - index + 1)
                updateRow(columns, itemForLastRow, movedRow)
                if (itemForLastRow is VisibleOneItem) {
                    rowsReferences.put(getKey(itemForLastRow.item), movedRow as HTMLElement)
                }
            }
        } else {
            rowsReferences.clear()
            val rowsToRender = Math.min(visibleRows, visibleDataList.size)
            (1..rowsToRender)
                    .forEach {
                        val tr = rows.item(it - 1) as HTMLElement
                        val item = visibleDataList.get(it + currentRow - 1)
                        updateRow(columns, item, tr)
                        if (item is VisibleOneItem) {
                            rowsReferences.put(getKey(item.item), tr)
                        }
                    }
            ((rowsToRender+1)..visibleRows)
                .forEach {
                    val tr = rows.item(it - 1) as HTMLElement
                    clearRow(columns, tr)
                }
        }

    }

    private fun getTBody() = dataTable.getElementsByTagName("tbody").item(0)!!

    private fun updateRow(columns: List<GridColumn<TYPE>>, visibleItem: VisibleItem<TYPE>, tr: Node, columnsToUpdate: Collection<String>? = null) {
        columns.forEachIndexed { columnIndex, column ->
            if (columnsToUpdate == null || columnsToUpdate.contains(column.id)) {
                val td = tr.childNodes.item(columnIndex) as HTMLElement
                HTMLComponent("", td) with {
                    removeAllChildren()
                    if (visibleItem is VisibleOneItem) {
                        (column.render)(visibleItem.item)
                    } else if (visibleItem is VisibleItemGroup){
                        //it is aggregated row, only render if column is aggregating one
                        if (column.id == "root") {
                            nbsp(times = (visibleItem.level-1)*2)
                            a(onclick = { openCloseGroup(visibleItem.group) }) { "style".."cursor: pointer;"
                                if (visibleItem.group.open) {
                                    glyphicon("chevron-down")
                                } else {
                                    glyphicon("chevron-right")
                                }
                            }
                            +(visibleItem.groupName.toString())

                        } else {
                            val aggregatedValue:Double? = visibleItem.group.aggregated?.get(column.id) ?: null
                            if (aggregatedValue != null) {
                                +aggregatedValue.toFixed(2)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun clearRow(columns: List<GridColumn<TYPE>>, tr: Node, columnsToUpdate: Collection<String>? = null) {
        columns.forEachIndexed { columnIndex, column ->
            if (columnsToUpdate == null || columnsToUpdate.contains(column.id)) {
                val td = tr.childNodes.item(columnIndex) as HTMLElement
                HTMLComponent("", td) with {
                    removeAllChildren()
                }
            }
        }
    }

    private fun findByKey(collection:Collection<TYPE>, key: KEY): Int {
        var index = 0
        for (item in collection) {
            if (getKey(item) == key) {
                return index
            }
            index++
        }
        return -1
    }

    private fun isOneOfAffectedColumnsAGroupingOne(affectedColumns: Collection<String>) =
        groupingColumns.filter { affectedColumns.contains(it.id) }.size > 0

     fun updateItem(item: TYPE, affectedColumns: Collection<String>? = null) {

        val originalItem = dataListAsKeyMap.get(getKey(item))
        if (originalItem == null) {
            throw Exception("Item ${item}} not found in the list")
        }

        val index = fullDataList.indexOf(originalItem)

        fullDataList.removeAt(index)
        fullDataList.add(index, item)
        dataListAsKeyMap.put(getKey(item), item)

        val indexInFilteredList = findByKey(filteredDataList, getKey(item))
        val wasInList = indexInFilteredList >= 0
        if (wasInList) {
            filteredDataList.removeAt(indexInFilteredList)
        }
        val isMatchingFilter = isItemMatchingFilters(item)
        if (isMatchingFilter) {
            if (wasInList) {
                filteredDataList.add(indexInFilteredList, item)
            } else {
                filteredDataList.add(item)
            }
        }

        //disable sorting for performance reason
        sortColumn = null
        setSortingArrow()

        if (groupingColumns.size > 0) {
            //only do the regroupping if affected column is one of the groupping one
            if (affectedColumns == null || isOneOfAffectedColumnsAGroupingOne(affectedColumns) || wasInList != isMatchingFilter) {
                regroupData()
                renderGroupedData()
                displayNewData()
            } else {
                if (visibleColumns.filter { affectedColumns.contains(it) }.map { columns.get(it) }.filter { it!!.getNumber != null }.size > 0) {
                    calculateAggregationsOfGroups(affectedColumns)
                }
                //val affectedGridColumns = getVisibleColumns().filter { affectedColumns.contains(it.id) }
                val rowsToRender = Math.min(visibleRows, visibleDataList.size)
                val rows = getTBody().childNodes
                (1..rowsToRender)
                        .forEach {
                            val tr = rows.item(it - 1) as HTMLElement
                            val visibleItem = visibleDataList.get(it + currentRow - 1)
                            updateRow(getVisibleColumns(), visibleItem, tr, affectedColumns)
                        }
            }
        } else {
            group.items = filteredDataList
            if (wasInList == isMatchingFilter) {
                val tr = rowsReferences.get(getKey(item))
                if (tr != null) {
                    updateRow(getVisibleColumns(), VisibleOneItem(item), tr, affectedColumns)
                }
            } else {
                displayNewData()
            }
        }


    }

}