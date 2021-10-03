package io.github.asr.mafp.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.Plugin

private lateinit var rightClick: PlayerInteractEvent.() -> Unit
private lateinit var leftClick: PlayerInteractEvent.() -> Unit

fun Plugin.events(init: EasyEvents.() -> Unit) {
    EasyEvents().apply(init).addEvent(this)
}

class EasyEvents : Listener {
    fun addEvent(plugin: Plugin) {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    fun onRightClick(init: PlayerInteractEvent.() -> Unit) { rightClick = init }

    fun onLeftClick(init: PlayerInteractEvent.() -> Unit) { leftClick = init }

    @EventHandler
    private fun onClick(event: PlayerInteractEvent) {
        if (event.action.isRightClick) rightClick.invoke(event)
        else if (event.action.isLeftClick) leftClick.invoke(event)
    }
}