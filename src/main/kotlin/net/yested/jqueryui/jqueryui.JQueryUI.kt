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
@file:kotlin.js.JsQualifier("JQueryUI")

package net.yested.jqueryui

external interface AccordionOptions : net.yested.jqueryui.AccordionEvents {
    var active: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var animate: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var collapsible: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var event: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var header: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var heightStyle: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var icons: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface AccordionUIParams {
    var newHeader: net.yested.jquery.JQuery
    var oldHeader: net.yested.jquery.JQuery
    var newPanel: net.yested.jquery.JQuery
    var oldPanel: net.yested.jquery.JQuery
}
external interface AccordionEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.AccordionUIParams)
}
external interface AccordionEvents {
    var activate: net.yested.jqueryui.AccordionEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var beforeActivate: net.yested.jqueryui.AccordionEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.AccordionEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Accordion : net.yested.jqueryui.Widget, net.yested.jqueryui.AccordionOptions
external interface AutocompleteOptions : net.yested.jqueryui.AutocompleteEvents {
    var appendTo: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var autoFocus: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var minLength: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var position: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var source: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface AutocompleteUIParams {
    var item: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface AutocompleteEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.AutocompleteUIParams)
}
external interface AutocompleteEvents {
    var change: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var close: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var focus: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var open: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var response: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var search: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var select: net.yested.jqueryui.AutocompleteEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Autocomplete : net.yested.jqueryui.Widget, net.yested.jqueryui.AutocompleteOptions {
    var escapeRegex: (value: String) -> String
    var filter: (array: Any, term: String) -> Any
}
external interface ButtonOptions {
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var icons: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var label: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var text: dynamic /* String | Boolean */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var click: ((event: org.w3c.dom.events.Event? /*= null*/) -> Unit)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Button : net.yested.jqueryui.Widget, net.yested.jqueryui.ButtonOptions
external interface DatepickerOptions {
    var altField: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var altFormat: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var appendText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var autoSize: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var beforeShow: ((input: org.w3c.dom.Element, inst: Any) -> net.yested.jqueryui.DatepickerOptions)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var beforeShowDay: ((date: kotlin.js.Date) -> Array<Any>)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var buttonImage: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var buttonImageOnly: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var buttonText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var calculateWeek: ((date: kotlin.js.Date) -> String)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var changeMonth: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var changeYear: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var closeText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var constrainInput: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var currentText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dateFormat: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dayNames: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dayNamesMin: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dayNamesShort: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var defaultDate: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var duration: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var firstDay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var gotoCurrent: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var hideIfNoPrevNext: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var isRTL: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var maxDate: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var minDate: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var monthNames: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var monthNamesShort: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var navigationAsDateFormat: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var nextText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var numberOfMonths: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var onChangeMonthYear: ((year: Number, month: Number, inst: Any) -> Unit)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var onClose: ((dateText: String, inst: Any) -> Unit)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var onSelect: ((dateText: String, inst: Any) -> Unit)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var prevText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var selectOtherMonths: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var shortYearCutoff: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showAnim: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showButtonPanel: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showCurrentAtPos: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showMonthAfterYear: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showOn: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showOptions: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showOtherMonths: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showWeek: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stepMonths: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var weekHeader: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var yearRange: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var yearSuffix: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface DatepickerFormatDateOptions {
    var dayNamesShort: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dayNames: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var monthNamesShort: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var monthNames: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Datepicker : net.yested.jqueryui.Widget, net.yested.jqueryui.DatepickerOptions {
    var regional: kotlin.js.Json
    fun setDefaults(defaults: net.yested.jqueryui.DatepickerOptions)
    fun formatDate(format: String, date: kotlin.js.Date, settings: net.yested.jqueryui.DatepickerFormatDateOptions? = kotlin.js.definedExternally /* null */): String
    fun parseDate(format: String, date: String, settings: net.yested.jqueryui.DatepickerFormatDateOptions? = kotlin.js.definedExternally /* null */): kotlin.js.Date
    fun iso8601Week(date: kotlin.js.Date): Number
    fun noWeekends(date: kotlin.js.Date): Array<Any>
}
external interface `T$0` {
    @kotlin.js.nativeGetter
    operator fun get(buttonText: String): ((event: org.w3c.dom.events.Event? /*= null*/) -> Unit)?
    @kotlin.js.nativeSetter
    operator fun set(buttonText: String, value: (event: org.w3c.dom.events.Event? /*= null*/) -> Unit)
}
external interface DialogOptions : net.yested.jqueryui.DialogEvents {
    var autoOpen: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var buttons: dynamic /* `T$0` | Array<DialogButtonOptions> */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var closeOnEscape: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var closeText: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var appendTo: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dialogClass: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var draggable: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var height: dynamic /* Number | String */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var hide: dynamic /* Boolean | Number | String | DialogShowHideOptions */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var maxHeight: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var maxWidth: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var minHeight: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var minWidth: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var modal: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var position: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var resizable: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var show: dynamic /* Boolean | Number | String | DialogShowHideOptions */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stack: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var title: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var width: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var zIndex: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    override var open: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    override var close: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface DialogButtonOptions {
    var icons: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var showText: dynamic /* String | Boolean */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var text: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var click: ((eventObject: net.yested.jquery.JQueryEventObject) -> Any)? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    @kotlin.js.nativeGetter
    operator fun get(attr: String): Any?
    @kotlin.js.nativeSetter
    operator fun set(attr: String, value: Any)
}
external interface DialogShowHideOptions {
    var effect: String
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var duration: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var easing: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface DialogUIParams
external interface DialogEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.DialogUIParams)
}
external interface DialogEvents {
    var beforeClose: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var close: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var drag: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dragStart: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dragStop: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var focus: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var open: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var resize: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var resizeStart: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var resizeStop: net.yested.jqueryui.DialogEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Dialog : net.yested.jqueryui.Widget, net.yested.jqueryui.DialogOptions
external interface `T$1` {
    var top: Number
    var left: Number
}
external interface DraggableEventUIParams {
    var helper: net.yested.jquery.JQuery
    var position: net.yested.jquery.`T$1`
    var offset: net.yested.jquery.`T$1`
}
external interface DraggableEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.DraggableEventUIParams)
}
external interface DraggableOptions : net.yested.jqueryui.DraggableEvents {
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var addClasses: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var appendTo: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var axis: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cancel: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var connectToSortable: dynamic /* Element | Array<Element> | JQuery | String */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var containment: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cursor: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cursorAt: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var grid: Array<Number>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var handle: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var helper: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var iframeFix: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var opacity: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var refreshPositions: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var revert: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var revertDuration: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scope: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scroll: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scrollSensitivity: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scrollSpeed: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var snap: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var snapMode: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var snapTolerance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stack: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var zIndex: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface DraggableEvents {
    var create: net.yested.jqueryui.DraggableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var start: net.yested.jqueryui.DraggableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var drag: net.yested.jqueryui.DraggableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stop: net.yested.jqueryui.DraggableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Draggable : net.yested.jqueryui.Widget, net.yested.jqueryui.DraggableOptions, net.yested.jqueryui.DraggableEvent
external interface DroppableEventUIParam {
    var draggable: net.yested.jquery.JQuery
    var helper: net.yested.jquery.JQuery
    var position: net.yested.jquery.`T$1`
    var offset: net.yested.jquery.`T$1`
}
external interface DroppableEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.DroppableEventUIParam)
}
external interface DroppableOptions : net.yested.jqueryui.DroppableEvents {
    var accept: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var activeClass: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var addClasses: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var greedy: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var hoverClass: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scope: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var tolerance: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface DroppableEvents {
    var create: net.yested.jqueryui.DroppableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var activate: net.yested.jqueryui.DroppableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var deactivate: net.yested.jqueryui.DroppableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var over: net.yested.jqueryui.DroppableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var out: net.yested.jqueryui.DroppableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var drop: net.yested.jqueryui.DroppableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Droppable : net.yested.jqueryui.Widget, net.yested.jqueryui.DroppableOptions
external interface MenuOptions : net.yested.jqueryui.MenuEvents {
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var icons: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var menus: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var position: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var role: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface MenuUIParams {
    var item: net.yested.jquery.JQuery? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface MenuEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.MenuUIParams)
}
external interface MenuEvents {
    var blur: net.yested.jqueryui.MenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.MenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var focus: net.yested.jqueryui.MenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var select: net.yested.jqueryui.MenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Menu : net.yested.jqueryui.Widget, net.yested.jqueryui.MenuOptions
external interface ProgressbarOptions : net.yested.jqueryui.ProgressbarEvents {
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var value: dynamic /* Number | Boolean */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var max: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface ProgressbarUIParams
external interface ProgressbarEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.ProgressbarUIParams)
}
external interface ProgressbarEvents {
    var change: net.yested.jqueryui.ProgressbarEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var complete: net.yested.jqueryui.ProgressbarEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.ProgressbarEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Progressbar : net.yested.jqueryui.Widget, net.yested.jqueryui.ProgressbarOptions
external interface ResizableOptions : net.yested.jqueryui.ResizableEvents {
    var alsoResize: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var animate: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var animateDuration: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var animateEasing: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var aspectRatio: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var autoHide: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cancel: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var containment: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var ghost: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var grid: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var handles: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var helper: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var maxHeight: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var maxWidth: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var minHeight: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var minWidth: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface ResizableUIParams {
    var element: net.yested.jquery.JQuery
    var helper: net.yested.jquery.JQuery
    var originalElement: net.yested.jquery.JQuery
    var originalPosition: Any
    var originalSize: Any
    var position: Any
    var size: Any
}
external interface ResizableEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.ResizableUIParams)
}
external interface ResizableEvents {
    var resize: net.yested.jqueryui.ResizableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var start: net.yested.jqueryui.ResizableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stop: net.yested.jqueryui.ResizableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.ResizableEvents? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Resizable : net.yested.jqueryui.Widget, net.yested.jqueryui.ResizableOptions
external interface SelectableOptions : net.yested.jqueryui.SelectableEvents {
    var autoRefresh: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cancel: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var filter: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var tolerance: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface `T$2` {
    var selected: org.w3c.dom.Element? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface `T$3` {
    var selecting: org.w3c.dom.Element? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface `T$4` {
    var unselected: org.w3c.dom.Element
}
external interface `T$5` {
    var unselecting: org.w3c.dom.Element
}
external interface SelectableEvents {
    val selected: ((event: org.w3c.dom.events.Event, ui: `T$2`) -> Unit)? get() = definedExternally
    val selecting: ((event: org.w3c.dom.events.Event, ui: `T$3`) -> Unit)? get() = definedExternally
    val start: ((event: org.w3c.dom.events.Event, ui: Any) -> Unit)? get() = kotlin.js.definedExternally
    val stop: ((event: org.w3c.dom.events.Event, ui: Any) -> Unit)? get() = kotlin.js.definedExternally
    val unselected: ((event: org.w3c.dom.events.Event, ui: `T$4`) -> Unit)? get() = definedExternally
    val unselecting: ((event: org.w3c.dom.events.Event, ui: `T$5`) -> Unit)? get() = definedExternally
}
external interface Selectable : net.yested.jqueryui.Widget, net.yested.jqueryui.SelectableOptions
external interface SelectMenuOptions : net.yested.jqueryui.SelectMenuEvents {
    var appendTo: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var icons: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var position: net.yested.jqueryui.JQueryPositionOptions? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var width: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SelectMenuUIParams {
    var item: net.yested.jquery.JQuery? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SelectMenuEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.SelectMenuUIParams)
}
external interface SelectMenuEvents {
    var change: net.yested.jqueryui.SelectMenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var close: net.yested.jqueryui.SelectMenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.SelectMenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var focus: net.yested.jqueryui.SelectMenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var open: net.yested.jqueryui.SelectMenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var select: net.yested.jqueryui.SelectMenuEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SelectMenu : net.yested.jqueryui.Widget, net.yested.jqueryui.SelectMenuOptions
external interface SliderOptions : net.yested.jqueryui.SliderEvents {
    var animate: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var max: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var min: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var orientation: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var range: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var step: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var value: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var values: Array<Number>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var highlight: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SliderUIParams {
    var handle: net.yested.jquery.JQuery? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var value: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var values: Array<Number>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SliderEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.SliderUIParams)
}
external interface SliderEvents {
    var change: net.yested.jqueryui.SliderEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.SliderEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var slide: net.yested.jqueryui.SliderEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var start: net.yested.jqueryui.SliderEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stop: net.yested.jqueryui.SliderEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Slider : net.yested.jqueryui.Widget, net.yested.jqueryui.SliderOptions
external interface SortableOptions : net.yested.jqueryui.SortableEvents {
    var appendTo: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var axis: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cancel: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var connectWith: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var containment: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cursor: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var cursorAt: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var dropOnEmpty: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var forceHelperSize: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var forcePlaceholderSize: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var grid: Array<Number>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var helper: dynamic /* String | (event: Event, element: Sortable) -> Element */ get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var handle: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var items: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var opacity: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var placeholder: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var revert: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scroll: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scrollSensitivity: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scrollSpeed: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var tolerance: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var zIndex: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SortableUIParams {
    var helper: net.yested.jquery.JQuery
    var item: net.yested.jquery.JQuery
    var offset: Any
    var position: Any
    var originalPosition: Any
    var sender: net.yested.jquery.JQuery
    var placeholder: net.yested.jquery.JQuery
}
external interface SortableEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: net.yested.jquery.JQueryEventObject, ui: net.yested.jqueryui.SortableUIParams)
}
external interface SortableEvents {
    var activate: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var beforeStop: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var change: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var deactivate: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var out: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var over: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var receive: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var remove: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var sort: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var start: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stop: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var update: net.yested.jqueryui.SortableEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Sortable : net.yested.jqueryui.Widget, net.yested.jqueryui.SortableOptions, net.yested.jqueryui.SortableEvents
external interface SpinnerOptions : net.yested.jqueryui.SpinnerEvents {
    var culture: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var icons: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var incremental: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var max: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var min: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var numberFormat: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var page: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var step: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SpinnerUIParam {
    var value: Number
}
external interface SpinnerEvent<T> {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: T)
}
external interface SpinnerEvents {
    var change: net.yested.jqueryui.SpinnerEvent<Any>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.SpinnerEvent<Any>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var spin: net.yested.jqueryui.SpinnerEvent<SpinnerUIParam>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var start: net.yested.jqueryui.SpinnerEvent<Any>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var stop: net.yested.jqueryui.SpinnerEvent<Any>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Spinner : net.yested.jqueryui.Widget, net.yested.jqueryui.SpinnerOptions
external interface TabsOptions : net.yested.jqueryui.TabsEvents {
    var active: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var collapsible: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var event: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var heightStyle: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var hide: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var show: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface TabsActivationUIParams {
    var newTab: net.yested.jquery.JQuery
    var oldTab: net.yested.jquery.JQuery
    var newPanel: net.yested.jquery.JQuery
    var oldPanel: net.yested.jquery.JQuery
}
external interface TabsBeforeLoadUIParams {
    var tab: net.yested.jquery.JQuery
    var panel: net.yested.jquery.JQuery
    var jqXHR: net.yested.jquery.JQueryXHR
    var ajaxSettings: Any
}
external interface TabsCreateOrLoadUIParams {
    var tab: net.yested.jquery.JQuery
    var panel: net.yested.jquery.JQuery
}
external interface TabsEvent<UI> {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: UI)
}
external interface TabsEvents {
    var activate: net.yested.jqueryui.TabsEvent<TabsActivationUIParams>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var beforeActivate: net.yested.jqueryui.TabsEvent<TabsActivationUIParams>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var beforeLoad: net.yested.jqueryui.TabsEvent<TabsBeforeLoadUIParams>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var load: net.yested.jqueryui.TabsEvent<TabsCreateOrLoadUIParams>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var create: net.yested.jqueryui.TabsEvent<TabsCreateOrLoadUIParams>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Tabs : net.yested.jqueryui.Widget, net.yested.jqueryui.TabsOptions
external interface TooltipOptions : net.yested.jqueryui.TooltipEvents {
    var content: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var hide: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var items: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var position: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var show: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var tooltipClass: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var track: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface TooltipUIParams
external interface TooltipEvent {
    @kotlin.js.nativeInvoke
    operator fun invoke(event: org.w3c.dom.events.Event, ui: net.yested.jqueryui.TooltipUIParams)
}
external interface TooltipEvents {
    var close: net.yested.jqueryui.TooltipEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var open: net.yested.jqueryui.TooltipEvent? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Tooltip : net.yested.jqueryui.Widget, net.yested.jqueryui.TooltipOptions
external interface EffectOptions {
    var effect: String
    var easing: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var duration: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var complete: Function<*>
}
external interface BlindEffect {
    var direction: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface BounceEffect {
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var times: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface ClipEffect {
    var direction: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface DropEffect {
    var direction: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface ExplodeEffect {
    var pieces: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface FadeEffect
external interface FoldEffect {
    var size: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var horizFirst: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface HighlightEffect {
    var color: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface PuffEffect {
    var percent: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface PulsateEffect {
    var times: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface ScaleEffect {
    var direction: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var origin: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var percent: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scale: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface ShakeEffect {
    var direction: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var times: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SizeEffect {
    var to: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var origin: Array<String>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var scale: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface SlideEffect {
    var direction: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface TransferEffect {
    var className: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var to: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface JQueryPositionOptions {
    var my: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var at: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var of: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var collision: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var using: Function<*>? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var within: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface MouseOptions {
    var cancel: String? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var delay: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var distance: Number? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface KeyCode {
    var BACKSPACE: Number
    var COMMA: Number
    var DELETE: Number
    var DOWN: Number
    var END: Number
    var ENTER: Number
    var ESCAPE: Number
    var HOME: Number
    var LEFT: Number
    var NUMPAD_ADD: Number
    var NUMPAD_DECIMAL: Number
    var NUMPAD_DIVIDE: Number
    var NUMPAD_ENTER: Number
    var NUMPAD_MULTIPLY: Number
    var NUMPAD_SUBTRACT: Number
    var PAGE_DOWN: Number
    var PAGE_UP: Number
    var PERIOD: Number
    var RIGHT: Number
    var SPACE: Number
    var TAB: Number
    var UP: Number
}
external interface UI {
    fun mouse(method: String): net.yested.jquery.JQuery
    fun mouse(options: net.yested.jqueryui.MouseOptions): net.yested.jquery.JQuery
    fun mouse(optionLiteral: String, optionName: String, optionValue: Any): net.yested.jquery.JQuery
    fun mouse(optionLiteral: String, optionValue: Any): Any
    var accordion: net.yested.jqueryui.Accordion
    var autocomplete: net.yested.jqueryui.Autocomplete
    var button: net.yested.jqueryui.Button
    var buttonset: net.yested.jqueryui.Button
    var datepicker: net.yested.jqueryui.Datepicker
    var dialog: net.yested.jqueryui.Dialog
    var keyCode: net.yested.jqueryui.KeyCode
    var menu: net.yested.jqueryui.Menu
    var progressbar: net.yested.jqueryui.Progressbar
    var slider: net.yested.jqueryui.Slider
    var spinner: net.yested.jqueryui.Spinner
    var tabs: net.yested.jqueryui.Tabs
    var tooltip: net.yested.jqueryui.Tooltip
    var version: String
}
external interface WidgetOptions {
    var disabled: Boolean? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var hide: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
    var show: Any? get() = kotlin.js.definedExternally; set(value) = kotlin.js.definedExternally
}
external interface Widget {
    @kotlin.js.nativeInvoke
    operator fun invoke(methodName: String): net.yested.jquery.JQuery
    @kotlin.js.nativeInvoke
    operator fun invoke(options: net.yested.jqueryui.WidgetOptions): net.yested.jquery.JQuery
    @kotlin.js.nativeInvoke
    operator fun invoke(options: net.yested.jqueryui.AccordionOptions): net.yested.jquery.JQuery
    @kotlin.js.nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String): Any
    @kotlin.js.nativeInvoke
    operator fun invoke(optionLiteral: String, options: net.yested.jqueryui.WidgetOptions): Any
    @kotlin.js.nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String, optionValue: Any): net.yested.jquery.JQuery
    @kotlin.js.nativeInvoke
    operator fun invoke(name: String, prototype: Any): net.yested.jquery.JQuery
    @kotlin.js.nativeInvoke
    operator fun invoke(name: String, base: Function<*>, prototype: Any): net.yested.jquery.JQuery
}
