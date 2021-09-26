package io.github.asr.mafp.utils

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

fun Task.runLater(plugin: Plugin, tick: Long) {
    Bukkit.getScheduler().runTaskLater(plugin, Runnable {
        this.run()
    }, tick)
}

fun Task.runLater(plugin: Plugin, second: Double) {
    this.runLater(plugin, second * 20)
}

fun Plugin.wait(tick: Long, next: () -> Unit) = Bukkit.getScheduler().runTaskLater(this, Runnable(next), tick)

fun Plugin.wait(second: Double, next: () -> Unit) = this.wait((20 * second).toLong(), next)