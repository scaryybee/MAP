package io.github.asr.mafp.listener

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.plugin.Plugin

fun Plugin.events(init: EasyEvents.() -> Unit) {
    EasyEvents().apply(init).addEvent(this)
}

class EasyEvents : Listener {
    private var rightClick: PlayerInteractEvent.() -> Unit = {}
    private var leftClick: PlayerInteractEvent.() -> Unit = {}
    private var playerDeath: MAPPlayerDeathEvent.() -> Unit = {}

    private var rightClickHandType = mutableListOf<EquipmentSlot>()
    private var leftClickHandType = mutableListOf<EquipmentSlot>()

    fun addEvent(plugin: Plugin) {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    fun onRightClick(vararg handType: EquipmentSlot = emptyArray(), init: PlayerInteractEvent.() -> Unit) {
        handType.forEach { rightClickHandType.add(it) }
        rightClick = init
    }

    fun onLeftClick(vararg handType: EquipmentSlot = emptyArray(), init: PlayerInteractEvent.() -> Unit) {
        handType.forEach { leftClickHandType.add(it) }
        leftClick = init
    }

    fun onPlayerDeath(init: MAPPlayerDeathEvent.() -> Unit) { playerDeath = init }

    private fun checkHandType(typeList: List<EquipmentSlot>, event: PlayerInteractEvent): Boolean {
        if (typeList.isEmpty()) return true
        return typeList.contains(event.hand)
    }

    @EventHandler
    private fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action.isRightClick && checkHandType(rightClickHandType, event)) rightClick.invoke(event)
        else if (event.action.isLeftClick && checkHandType(leftClickHandType, event)) leftClick.invoke(event)
    }

    @EventHandler
    private fun onEntityDamage(event: EntityDamageEvent) {
        if (event.entity !is Player) return
        val player = event.entity as Player

        if (player.health < event.damage) playerDeath.invoke(MAPPlayerDeathEvent(event, player))
    }
}