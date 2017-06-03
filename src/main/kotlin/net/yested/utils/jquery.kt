package net.yested.utils

import net.yested.jquery.JQueryStatic

inline fun <T> options(init: T.() -> Unit): T = js("{}").unsafeCast<T>().apply(init)

@Suppress("NOTHING_TO_INLINE")
inline fun <Event, Lambda> eventHandler(handler: Lambda) = handler.unsafeCast<Event>()

//throttle: https://github.com/cowboy/jquery-throttle-debounce
@Suppress("NOTHING_TO_INLINE")
inline fun <EVENT> JQueryStatic.throttle(duration:Int, noinline handler:(event:EVENT) -> Unit): Function1<EVENT, Unit> =
        asDynamic().throttle(duration, handler)
