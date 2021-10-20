package io.github.asr.mafp.listener

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEvent
import org.bukkit.plugin.Plugin

fun Plugin.eventCall(event: Event) = server.pluginManager.callEvent(event)

fun <T : PlayerEvent> Player.elseEvent(plugin: Plugin, listener: T.() -> Unit): Listener {
    val listenerData = object : Listener {
        @EventHandler
        fun onEvent(event: T) {
            if (event.player == this@elseEvent) {
                listener(event)
            }
        }
    }

    server.pluginManager.registerEvents(listenerData, plugin)
    return listenerData
}

fun <T : PlayerEvent> Plugin.elsePlayerEvent(player: Player, listener: T.() -> Unit): Listener
    = player.elseEvent<T>(this, listener)

fun <T : Event> Plugin.elseEvent(listener: T.() -> Unit): Listener {
    val listenerData = object : Listener {
        @EventHandler
        fun onEvent(event : T) {
            listener(event)
        }
    }

    server.pluginManager.registerEvents(listenerData, this)
    return listenerData
}