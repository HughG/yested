package net.yested

import net.yested.jquery.jQuery

private val DURATION = 200
private val SLIDE_DURATION = DURATION * 2
private val SHOW_HIDE_DURATION = DURATION * 2

 interface Effect {
    fun apply(component:Component, callback:Function0<Unit>? = null)
}

 interface BiDirectionEffect {
    fun applyIn(component:Component, callback:Function0<Unit>? = null)
    fun applyOut(component:Component, callback:Function0<Unit>? = null)
}

private fun call(function:Function0<Unit>?) {
    function?.let { function() }
}

 class Show() : Effect {
    override fun apply(component: Component, callback: (() -> Unit)?) {
        jQuery(component.element).show(SHOW_HIDE_DURATION) { call(callback) }
    }
}

 class Hide() : Effect {
    override fun apply(component: Component, callback: (() -> Unit)?) {
        jQuery(component.element).hide(SHOW_HIDE_DURATION) { call(callback) }
    }
}

 class SlideUp() : Effect {
    override fun apply(component: Component, callback:Function0<Unit>?) {
        jQuery(component.element).slideUp(SLIDE_DURATION) { call(callback) }
    }
}

 class SlideDown : Effect {
    override fun apply(component: Component, callback: (() -> Unit)?) {
        jQuery(component.element).slideDown(SLIDE_DURATION) { call(callback) }
    }
}

 class FadeOut : Effect {
    override fun apply(component: Component, callback: (() -> Unit)?) {
        jQuery(component.element).fadeOut(DURATION) { call(callback) }
    }
}

 class FadeIn : Effect {
    override fun apply(component: Component, callback: (() -> Unit)?) {
        jQuery(component.element).fadeIn(DURATION) { call(callback) }
    }
}

 class Fade : BiDirectionEffect {
    override fun applyIn(component: Component, callback: (() -> Unit)?) {
        FadeIn().apply(component, callback)
    }

    override fun applyOut(component: Component, callback: (() -> Unit)?) {
        FadeOut().apply(component, callback)
    }
}

 class Slide : BiDirectionEffect {
    override fun applyIn(component: Component, callback: (() -> Unit)?) {
        SlideDown().apply(component, callback)
    }

    override fun applyOut(component: Component, callback: (() -> Unit)?) {
        SlideUp().apply(component, callback)
    }
}