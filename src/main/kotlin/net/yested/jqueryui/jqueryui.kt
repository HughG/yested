/**
 * From https://www.nuget.org/packages/jqueryui.TypeScript.DefinitelyTyped/1.5.1, converted with ts2kt 0.0.12
 */
@file:Suppress(
        "INTERFACE_WITH_SUPERCLASS",
        "OVERRIDING_FINAL_MEMBER",
        "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
        "CONFLICTING_OVERLOADS",
        "unused",
        "DEPRECATION"
)

package net.yested.jqueryui

import net.yested.jquery.JQuery
import net.yested.jquery.JQueryEventObject
import kotlin.js.RegExp

external interface `T$6` {
    @nativeInvoke
    operator fun invoke(): JQuery
    @nativeInvoke
    operator fun invoke(methodName: Any /* "blur" */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "collapse" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "collapseAll" */, event: JQueryEventObject? = definedExternally /* null */, all: Boolean? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "destroy" */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "disable" */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "enable" */)
    @nativeInvoke
    operator fun invoke(methodName: String, event: JQueryEventObject, item: JQuery)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "focus" */, event: JQueryEventObject, item: JQuery)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "isFirstItem" */): Boolean
    @nativeInvoke
    operator fun invoke(methodName: Any /* "isLastItem" */): Boolean
    @nativeInvoke
    operator fun invoke(methodName: Any /* "next" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "nextPage" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "previous" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "previousPage" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "refresh" */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "select" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: Any /* "widget" */): JQuery
    @nativeInvoke
    operator fun invoke(methodName: String): JQuery
    @nativeInvoke
    operator fun invoke(options: MenuOptions): JQuery
    @nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String): Any
    @nativeInvoke
    operator fun invoke(optionLiteral: String, options: MenuOptions): Any
    @nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    var active: Boolean
}
external interface `T$7` {
    var key: String? get() = definedExternally; set(value) = definedExternally
    var attribute: String? get() = definedExternally; set(value) = definedExternally
    var expression: RegExp? get() = definedExternally; set(value) = definedExternally
}
//external fun JQuery.accordion(): JQuery = definedExternally
//external fun JQuery.accordion(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.accordion(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.accordion(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.accordion(methodName: Any /* "refresh" */): Unit = definedExternally
//external fun JQuery.accordion(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.accordion(methodName: String): JQuery = definedExternally
//external fun JQuery.accordion(options: AccordionOptions): JQuery = definedExternally
//external fun JQuery.accordion(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.accordion(optionLiteral: String, options: AccordionOptions): Any = definedExternally
//external fun JQuery.accordion(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.autocomplete(): JQuery = definedExternally
//external fun JQuery.autocomplete(methodName: Any /* "close" */): Unit = definedExternally
//external fun JQuery.autocomplete(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.autocomplete(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.autocomplete(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.autocomplete(methodName: Any /* "search" */, value: String? = definedExternally /* null */): Unit = definedExternally
//external fun JQuery.autocomplete(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.autocomplete(methodName: String): JQuery = definedExternally
//external fun JQuery.autocomplete(options: AutocompleteOptions): JQuery = definedExternally
//external fun JQuery.autocomplete(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.autocomplete(optionLiteral: String, options: AutocompleteOptions): Any = definedExternally
//external fun JQuery.autocomplete(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.button(): JQuery = definedExternally
//external fun JQuery.button(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.button(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.button(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.button(methodName: Any /* "refresh" */): Unit = definedExternally
//external fun JQuery.button(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.button(methodName: String): JQuery = definedExternally
//external fun JQuery.button(options: ButtonOptions): JQuery = definedExternally
//external fun JQuery.button(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.button(optionLiteral: String, options: ButtonOptions): Any = definedExternally
//external fun JQuery.button(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.buttonset(): JQuery = definedExternally
//external fun JQuery.buttonset(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.buttonset(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.buttonset(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.buttonset(methodName: Any /* "refresh" */): Unit = definedExternally
//external fun JQuery.buttonset(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.buttonset(methodName: String): JQuery = definedExternally
//external fun JQuery.buttonset(options: ButtonOptions): JQuery = definedExternally
//external fun JQuery.buttonset(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.buttonset(optionLiteral: String, options: ButtonOptions): Any = definedExternally
//external fun JQuery.buttonset(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.datepicker(): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "destroy" */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "dialog" */, date: Date, onSelect: (() -> Unit)? = definedExternally /* null */, settings: DatepickerOptions? = definedExternally /* null */, pos: Array<Number>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "dialog" */, date: Date, onSelect: (() -> Unit)? = definedExternally /* null */, settings: DatepickerOptions? = definedExternally /* null */, pos: MouseEvent? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "dialog" */, date: String, onSelect: (() -> Unit)? = definedExternally /* null */, settings: DatepickerOptions? = definedExternally /* null */, pos: Array<Number>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "dialog" */, date: String, onSelect: (() -> Unit)? = definedExternally /* null */, settings: DatepickerOptions? = definedExternally /* null */, pos: MouseEvent? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "getDate" */): Date = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "hide" */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "isDisabled" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "refresh" */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "setDate" */, date: Date): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "setDate" */, date: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "show" */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "altField" */): Any = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "altField" */, altFieldValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "altField" */, altFieldValue: JQuery): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "altField" */, altFieldValue: Element): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "altFormat" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "altFormat" */, altFormatValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "appendText" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "appendText" */, appendTextValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "autoSize" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "autoSize" */, autoSizeValue: Boolean): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "beforeShow" */): (input: Element, inst: Any) -> DatepickerOptions = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "beforeShow" */, beforeShowValue: (input: Element, inst: Any) -> DatepickerOptions): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "beforeShowDay" */): (date: Date) -> Array<Any> = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "beforeShowDay" */, beforeShowDayValue: (date: Date) -> Array<Any>): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "buttonImage" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "buttonImage" */, buttonImageValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "buttonImageOnly" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "buttonImageOnly" */, buttonImageOnlyValue: Boolean): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "buttonText" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "buttonText" */, buttonTextValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "calculateWeek" */): (date: Date) -> String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "calculateWeek" */, calculateWeekValue: (date: Date) -> String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "changeMonth" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "changeMonth" */, changeMonthValue: Boolean): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "changeYear" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "changeYear" */, changeYearValue: Boolean): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "closeText" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "closeText" */, closeTextValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "constrainInput" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "constrainInput" */, constrainInputValue: Boolean): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "currentText" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "currentText" */, currentTextValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dateFormat" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dateFormat" */, dateFormatValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dayNames" */): Array<String> = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dayNames" */, dayNamesValue: Array<String>): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dayNamesMin" */): Array<String> = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dayNamesMin" */, dayNamesMinValue: Array<String>): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dayNamesShort" */): Array<String> = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "dayNamesShort" */, dayNamesShortValue: Array<String>): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "defaultDate" */): Any = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "defaultDate" */, defaultDateValue: Date): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "defaultDate" */, defaultDateValue: Number): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "defaultDate" */, defaultDateValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "duration" */): String = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "duration" */, durationValue: String): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "firstDay" */): Number = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "firstDay" */, firstDayValue: Number): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "gotoCurrent" */): Boolean = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: Any /* "gotoCurrent" */, gotoCurrentValue: Boolean): JQuery = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: String): Any = definedExternally
//external fun JQuery.datepicker(methodName: Any /* "option" */, optionName: String, vararg otherParams: Any): Any = definedExternally
//external fun JQuery.datepicker(methodName: String, vararg otherParams: Any): Any = definedExternally
//external fun JQuery.datepicker(options: DatepickerOptions): JQuery = definedExternally
//external fun JQuery.dialog(): JQuery = definedExternally
//external fun JQuery.dialog(methodName: Any /* "close" */): JQuery = definedExternally
//external fun JQuery.dialog(methodName: Any /* "destroy" */): JQuery = definedExternally
//external fun JQuery.dialog(methodName: Any /* "isOpen" */): Boolean = definedExternally
//external fun JQuery.dialog(methodName: Any /* "moveToTop" */): JQuery = definedExternally
//external fun JQuery.dialog(methodName: Any /* "open" */): JQuery = definedExternally
//external fun JQuery.dialog(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.dialog(methodName: String): JQuery = definedExternally
//external fun JQuery.dialog(options: DialogOptions): JQuery = definedExternally
//external fun JQuery.dialog(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.dialog(optionLiteral: String, options: DialogOptions): Any = definedExternally
//external fun JQuery.dialog(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.draggable(): JQuery = definedExternally
//external fun JQuery.draggable(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.draggable(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.draggable(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.draggable(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.draggable(methodName: String): JQuery = definedExternally
@Suppress("NOTHING_TO_INLINE")
inline fun JQuery.draggable(options: DraggableOptions): JQuery = asDynamic().draggable(options)
//external fun JQuery.draggable(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.draggable(optionLiteral: String, options: DraggableOptions): Any = definedExternally
//external fun JQuery.draggable(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.droppable(): JQuery = definedExternally
//external fun JQuery.droppable(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.droppable(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.droppable(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.droppable(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.droppable(methodName: String): JQuery = definedExternally
//external fun JQuery.droppable(options: DroppableOptions): JQuery = definedExternally
//external fun JQuery.droppable(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.droppable(optionLiteral: String, options: DraggableOptions): Any = definedExternally
//external fun JQuery.droppable(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external var JQuery.menu: `T$6` get() = definedExternally; set(value) = definedExternally
//external fun JQuery.progressbar(): JQuery = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "refresh" */): Unit = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "value" */): Any = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "value" */, value: Number): Unit = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "value" */, value: Boolean): Unit = definedExternally
//external fun JQuery.progressbar(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.progressbar(methodName: String): JQuery = definedExternally
//external fun JQuery.progressbar(options: ProgressbarOptions): JQuery = definedExternally
//external fun JQuery.progressbar(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.progressbar(optionLiteral: String, options: ProgressbarOptions): Any = definedExternally
//external fun JQuery.progressbar(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.resizable(): JQuery = definedExternally
//external fun JQuery.resizable(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.resizable(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.resizable(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.resizable(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.resizable(methodName: String): JQuery = definedExternally
//external fun JQuery.resizable(options: ResizableOptions): JQuery = definedExternally
//external fun JQuery.resizable(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.resizable(optionLiteral: String, options: ResizableOptions): Any = definedExternally
//external fun JQuery.resizable(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.selectable(): JQuery = definedExternally
//external fun JQuery.selectable(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.selectable(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.selectable(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.selectable(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.selectable(methodName: String): JQuery = definedExternally
//external fun JQuery.selectable(options: SelectableOptions): JQuery = definedExternally
//external fun JQuery.selectable(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.selectable(optionLiteral: String, options: SelectableOptions): Any = definedExternally
//external fun JQuery.selectable(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.selectmenu(): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "close" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "destroy" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "disable" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "enable" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "instance" */): Any = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "menuWidget" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "open" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "refresh" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.selectmenu(methodName: String): JQuery = definedExternally
//external fun JQuery.selectmenu(options: SelectMenuOptions): JQuery = definedExternally
//external fun JQuery.selectmenu(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.selectmenu(optionLiteral: String, options: SelectMenuOptions): Any = definedExternally
//external fun JQuery.selectmenu(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.slider(): JQuery = definedExternally
//external fun JQuery.slider(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "refresh" */): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "value" */): Number = definedExternally
//external fun JQuery.slider(methodName: Any /* "value" */, value: Number): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "values" */): Array<Number> = definedExternally
//external fun JQuery.slider(methodName: Any /* "values" */, index: Number): Number = definedExternally
//external fun JQuery.slider(methodName: String, index: Number, value: Number): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "values" */, index: Number, value: Number): Unit = definedExternally
//external fun JQuery.slider(methodName: String, values: Array<Number>): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "values" */, values: Array<Number>): Unit = definedExternally
//external fun JQuery.slider(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.slider(methodName: String): JQuery = definedExternally
//external fun JQuery.slider(options: SliderOptions): JQuery = definedExternally
//external fun JQuery.slider(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.slider(optionLiteral: String, options: SliderOptions): Any = definedExternally
//external fun JQuery.slider(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.sortable(): JQuery = definedExternally
//external fun JQuery.sortable(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.sortable(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.sortable(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.sortable(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.sortable(methodName: Any /* "toArray" */): Array<String> = definedExternally
//external fun JQuery.sortable(methodName: String): JQuery = definedExternally
@Suppress("NOTHING_TO_INLINE")
inline fun JQuery.sortable(options: SortableOptions): JQuery = asDynamic().sortable(options)
//external fun JQuery.sortable(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.sortable(methodName: Any /* "serialize" */, options: `T$7`? = definedExternally /* null */): String = definedExternally
//external fun JQuery.sortable(optionLiteral: String, options: SortableOptions): Any = definedExternally
//external fun JQuery.sortable(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.spinner(): JQuery = definedExternally
//external fun JQuery.spinner(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "pageDown" */, pages: Number? = definedExternally /* null */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "pageUp" */, pages: Number? = definedExternally /* null */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "stepDown" */, steps: Number? = definedExternally /* null */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "stepUp" */, steps: Number? = definedExternally /* null */): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "value" */): Number = definedExternally
//external fun JQuery.spinner(methodName: Any /* "value" */, value: Number): Unit = definedExternally
//external fun JQuery.spinner(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.spinner(methodName: String): JQuery = definedExternally
//external fun JQuery.spinner(options: SpinnerOptions): JQuery = definedExternally
//external fun JQuery.spinner(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.spinner(optionLiteral: String, options: SpinnerOptions): Any = definedExternally
//external fun JQuery.spinner(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.tabs(): JQuery = definedExternally
//external fun JQuery.tabs(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.tabs(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.tabs(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.tabs(methodName: Any /* "load" */, index: Number): Unit = definedExternally
//external fun JQuery.tabs(methodName: Any /* "refresh" */): Unit = definedExternally
//external fun JQuery.tabs(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.tabs(methodName: String): JQuery = definedExternally
//external fun JQuery.tabs(options: TabsOptions): JQuery = definedExternally
//external fun JQuery.tabs(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.tabs(optionLiteral: String, options: TabsOptions): Any = definedExternally
//external fun JQuery.tabs(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.tooltip(): JQuery = definedExternally
//external fun JQuery.tooltip(methodName: Any /* "destroy" */): Unit = definedExternally
//external fun JQuery.tooltip(methodName: Any /* "disable" */): Unit = definedExternally
//external fun JQuery.tooltip(methodName: Any /* "enable" */): Unit = definedExternally
//external fun JQuery.tooltip(methodName: Any /* "open" */): Unit = definedExternally
//external fun JQuery.tooltip(methodName: Any /* "close" */): Unit = definedExternally
//external fun JQuery.tooltip(methodName: Any /* "widget" */): JQuery = definedExternally
//external fun JQuery.tooltip(methodName: String): JQuery = definedExternally
//external fun JQuery.tooltip(options: TooltipOptions): JQuery = definedExternally
//external fun JQuery.tooltip(optionLiteral: String, optionName: String): Any = definedExternally
//external fun JQuery.tooltip(optionLiteral: String, options: TooltipOptions): Any = definedExternally
//external fun JQuery.tooltip(optionLiteral: String, optionName: String, optionValue: Any): JQuery = definedExternally
//external fun JQuery.addClass(classNames: String, speed: Number? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.addClass(classNames: String, speed: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.addClass(classNames: String, speed: Number? = definedExternally /* null */, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.addClass(classNames: String, speed: String? = definedExternally /* null */, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.removeClass(classNames: String, speed: Number? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.removeClass(classNames: String, speed: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.removeClass(classNames: String, speed: Number? = definedExternally /* null */, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.removeClass(classNames: String, speed: String? = definedExternally /* null */, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.switchClass(removeClassName: String, addClassName: String, duration: Number? = definedExternally /* null */, easing: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.switchClass(removeClassName: String, addClassName: String, duration: String? = definedExternally /* null */, easing: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.toggleClass(className: String, duration: Number? = definedExternally /* null */, easing: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.toggleClass(className: String, duration: String? = definedExternally /* null */, easing: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.toggleClass(className: String, aswitch: Boolean? = definedExternally /* null */, duration: Number? = definedExternally /* null */, easing: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.toggleClass(className: String, aswitch: Boolean? = definedExternally /* null */, duration: String? = definedExternally /* null */, easing: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.effect(options: Any): JQuery = definedExternally
//external fun JQuery.effect(effect: String, options: Any? = definedExternally /* null */, duration: Number? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.effect(effect: String, options: Any? = definedExternally /* null */, duration: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.hide(options: Any): JQuery = definedExternally
//external fun JQuery.hide(effect: String, options: Any? = definedExternally /* null */, duration: Number? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.hide(effect: String, options: Any? = definedExternally /* null */, duration: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.show(options: Any): JQuery = definedExternally
//external fun JQuery.show(effect: String, options: Any? = definedExternally /* null */, duration: Number? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.show(effect: String, options: Any? = definedExternally /* null */, duration: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.toggle(options: Any): JQuery = definedExternally
//external fun JQuery.toggle(effect: String, options: Any? = definedExternally /* null */, duration: Number? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.toggle(effect: String, options: Any? = definedExternally /* null */, duration: String? = definedExternally /* null */, complete: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.position(options: JQueryPositionOptions): JQuery = definedExternally
//external fun JQuery.enableSelection(): JQuery = definedExternally
//external fun JQuery.disableSelection(): JQuery = definedExternally
//external fun JQuery.focus(delay: Number, callback: Function<*>? = definedExternally /* null */): JQuery = definedExternally
//external fun JQuery.uniqueId(): JQuery = definedExternally
//external fun JQuery.removeUniqueId(): JQuery = definedExternally
//external fun JQuery.scrollParent(): JQuery = definedExternally
//external fun JQuery.zIndex(): Number = definedExternally
//external fun JQuery.zIndex(zIndex: Number): JQuery = definedExternally
//external var JQuery.widget: Widget get() = definedExternally; set(value) = definedExternally
//external var JQuery.jQuery: JQueryStatic get() = definedExternally; set(value) = definedExternally
//external var JQueryStatic.ui: UI get() = definedExternally; set(value) = definedExternally
//external var JQueryStatic.datepicker: Datepicker get() = definedExternally; set(value) = definedExternally
//external var JQueryStatic.widget: Widget get() = definedExternally; set(value) = definedExternally
//external var JQueryStatic.Widget: Widget get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInQuad: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutQuad: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutQuad: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInCubic: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutCubic: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutCubic: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInQuart: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutQuart: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutQuart: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInQuint: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutQuint: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutQuint: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInExpo: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutExpo: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutExpo: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInSine: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutSine: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutSine: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInCirc: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutCirc: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutCirc: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInElastic: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutElastic: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutElastic: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInBack: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutBack: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutBack: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInBounce: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeOutBounce: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
//external var JQueryEasingFunctions.easeInOutBounce: JQueryEasingFunction get() = definedExternally; set(value) = definedExternally
