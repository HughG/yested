package net.yested.bootstrap

import net.yested.*
import net.yested.jquery.JQuery
import net.yested.jquery.jQuery
import net.yested.jquery.on
import net.yested.utils.FormatString
import net.yested.utils.FormatStringBuilder
import net.yested.utils.Moment
import net.yested.utils.options
import org.w3c.dom.HTMLInputElement

//TODO: support Locales: http://momentjs.com/docs/#/i18n/
/**
 *
 * uses library: https://github.com/Eonasdan/bootstrap-datetimepicker/blob/master/build/js/bootstrap-datetimepicker.min.js
 */
 class DateField(formatter: FormatStringBuilder.()->FormatString) : ObservableInput<Moment?>() {

    val formatString = FormatStringBuilder().formatter().toString()

    private val inputElement = (createElement("input") with {
        setAttribute("type", "text")
        className = "form-control"
    }) as HTMLInputElement

    override val element =
            (Div() with {
                clazz = "input-group date"
                appendChild(inputElement)
                appendChild((Span() with {
                    clazz = "input-group-addon"
                    appendChild((Span() with { clazz = "glyphicon glyphicon-calendar"; style = "cursor: pointer;" }))
                }))
            }).element

    override fun clear() {
        data = null
    }

    protected var value: String
        get():String = inputElement.value
        set(value: String) {
            inputElement.value = value
        }

    override var data: Moment?
        get() = if (value.isEmpty()) null else Moment.parse(value, formatString)
        set(value) {
            this.value = if (value == null) "" else value.format(formatString)
        }

    fun init() {
// TODO 2017-06-03 HughG: Is this hack still needed in Kotlin 1.1.2?
        // Hack: datetimepicker cannot handle unknown parameters, and Kotlin add a $metadata$ property to every object
//        js("delete param.\$metadata$")
        jQuery(element).datetimepicker(options {
            format = formatString
        })

        jQuery(element).on("dp.change", { ->
            onChangeListeners.forEach { it() }
            onChangeLiveListeners.forEach { it() }
        })

    }

    init {
        this.element.whenAddedToDom {
            init()
        }
    }
}

external interface DateTimePickerOptions {
    var format: String
}

@Suppress("NOTHING_TO_INLINE")
inline private fun JQuery.datetimepicker(param: DateTimePickerOptions): Unit = asDynamic().datetimepicker(param)