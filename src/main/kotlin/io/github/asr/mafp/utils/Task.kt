package io.github.asr.mafp.utils

fun runs(vararg task: Task) = task.forEach { it.run() }

class Task(private val task: () -> Unit) {
    fun run() = task.invoke()
}