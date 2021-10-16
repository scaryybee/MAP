package io.github.asr.mafp.listener

import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

fun <T : Event> Plugin.elseEvent(listener: T.() -> Unit): Listener {
    val listenerData = object : Listener {
        @EventHandler
        fun on(event : T) {
            listener(event)
        }
    }
    server.pluginManager.registerEvents(listenerData, this)
    return listenerData
}