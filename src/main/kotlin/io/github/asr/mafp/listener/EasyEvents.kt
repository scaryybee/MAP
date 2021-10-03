package io.github.asr.mafp.listener

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.Plugin

fun Plugin.events(init: EasyEvents.() -> Unit) {
    EasyEvents().apply(init).addEvent(this)
}

class EasyEvents : Listener {
    private lateinit var rightClick: PlayerInteractEvent.() -> Unit
    private lateinit var leftClick: PlayerInteractEvent.() -> Unit
    private lateinit var playerDeath: MAPPlayerDeathEvent.() -> Unit

    fun addEvent(plugin: Plugin) {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    fun onRightClick(init: PlayerInteractEvent.() -> Unit) { rightClick = init }

    fun onLeftClick(init: PlayerInteractEvent.() -> Unit) { leftClick = init }

    fun onPlayerDeath(init: MAPPlayerDeathEvent.() -> Unit) { playerDeath = init }

    @EventHandler
    private fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action.isRightClick) rightClick.invoke(event)
        else if (event.action.isLeftClick) leftClick.invoke(event)
    }

    @EventHandler
    private fun onEntityDamage(event: EntityDamageEvent) {
        if (event.entity !is Player) return
        val player = event.entity as Player

        if (player.health < event.damage) playerDeath.invoke(MAPPlayerDeathEvent(event, player))
    }
}