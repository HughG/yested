package net.yested.jquery

inline fun JQuery.on(events: String, crossinline handler: () -> Any?) {
    on(events) { _: JQueryEventObject, _: Any -> handler() ?: Unit }
}
inline fun JQuery.on(events: String, crossinline handler: () -> Unit) {
    on(events) { _: JQueryEventObject, _: Any -> handler() }
}

inline fun JQuery.on(events: String, crossinline handler: (JQueryEventObject) -> Any?) {
    on(events) { event: JQueryEventObject, _: Any -> handler(event) ?: Unit }
}
inline fun JQuery.on(events: String, crossinline handler: (JQueryEventObject) -> Unit) {
    on(events) { event: JQueryEventObject, _: Any -> handler(event) }
}

inline fun <reified E : JQueryEventObject> JQuery.on(events: String, crossinline handler: (E) -> Any?) {
    on(events) { event: JQueryEventObject, _: Any -> handler(event as E) ?: Unit }
}
inline fun <reified E : JQueryEventObject> JQuery.on(events: String, crossinline handler: (E) -> Unit) {
    on(events) { event: JQueryEventObject, _: Any -> handler(event as E) }
}
