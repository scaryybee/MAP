package io.github.asr.mafp.utils

import net.kyori.adventure.text.Component
import java.lang.RuntimeException

fun String.toText() = Text(this)

fun emptyText() = Text()

fun Component.toText() = Text(this)

class Text(private val text: String) {
    constructor() : this("")
    constructor(component: Component) : this(component.insertion()!!)

    override fun toString(): String = text

    fun text(): String = text

    fun length(): Int = text.length

    fun toComponent(): Component = Component.text(text)

    infix fun addTextBack(text: Text): Text = Text(text() + text.text())

    infix fun addTextFront(text: Text): Text = Text(text.text() + text())

    fun replace(oldValue: String, newValue: String, ignoreCase: Boolean = false): Text {
        run {
            var occurrenceIndex: Int = text.indexOf(oldValue, 0, ignoreCase)
            // FAST PATH: no match
            if (occurrenceIndex < 0) return this

            val oldValueLength = oldValue.length
            val searchStep = oldValueLength.coerceAtLeast(1)
            val newLengthHint = length() - oldValueLength + newValue.length
            if (newLengthHint < 0) throw OutOfMemoryError()
            val stringBuilder = StringBuilder(newLengthHint)

            var i = 0
            do {
                stringBuilder.append(this, i, occurrenceIndex).append(newValue)
                i = occurrenceIndex + oldValueLength
                if (occurrenceIndex >= length()) break
                occurrenceIndex = text().indexOf(oldValue, occurrenceIndex + searchStep, ignoreCase)
            } while (occurrenceIndex > 0)
            return Text(stringBuilder.append(this.text(), i, length()).toString())
        }
    }
}