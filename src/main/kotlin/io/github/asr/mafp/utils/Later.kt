package io.github.asr.mafp.utils

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

fun Plugin.runLater(task: Task, tick: Long) {
    Bukkit.getScheduler().runTaskLater(this, Runnable {
        task.run()
    }, tick)
}

fun Plugin.runLater(task: Task, second: Double) {
    this.runLater(task, (second * 20).toLong())
}

fun Plugin.wait(tick: Long, next: () -> Unit) = Bukkit.getScheduler().runTaskLater(this, Runnable(next), tick)

fun Plugin.wait(second: Double, next: () -> Unit) = this.wait((20 * second).toLong(), next)
