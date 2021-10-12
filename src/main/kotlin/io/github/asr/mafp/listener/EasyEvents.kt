package io.github.asr.mafp.listener

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

fun Plugin.events(init: EasyEvents.() -> Unit) {
    EasyEvents().apply(init).addEvent(this)
}

class EasyEvents : Listener {
    private val itemMap = mutableMapOf<ItemStack, PlayerInteractEvent.() -> Unit>()
    private val materialMap = mutableMapOf<Material, PlayerInteractEvent.() -> Unit>()

    private var rightClick: PlayerInteractEvent.() -> Unit = {}
    private var leftClick: PlayerInteractEvent.() -> Unit = {}
    private var playerDeath: MAPPlayerDeathEvent.() -> Unit = {}

    private var rightClickHandType = mutableListOf<EquipmentSlot>()
    private var leftClickHandType = mutableListOf<EquipmentSlot>()

    private var playerJoin: PlayerJoinEvent.() -> Unit = {}
    private var playerQuit: PlayerQuitEvent.() -> Unit = {}

    private var playerSendMessage: MAPPlayerChatEvent.() -> Unit = {}

    private var playerMove: PlayerMoveEvent.() -> Unit = {}

    private var playerClearAdvancement: PlayerAdvancementDoneEvent.() -> Unit = {}

    private var playerConsume: PlayerItemConsumeEvent.() -> Unit = {}

    private var playerEnderPearl: MAPEnderPearlEvent.() -> Unit = {}

    fun addEvent(plugin: Plugin) {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    fun onRightClick(vararg handType: EquipmentSlot = emptyArray(), action: PlayerInteractEvent.() -> Unit) {
        handType.forEach { rightClickHandType.add(it) }
        rightClick = action
    }

    fun onLeftClick(vararg handType: EquipmentSlot = emptyArray(), action: PlayerInteractEvent.() -> Unit) {
        handType.forEach { leftClickHandType.add(it) }
        leftClick = action
    }

    infix fun ItemStack.withInteract(action: PlayerInteractEvent.() -> Unit) { itemMap[this] = action }

    infix fun Material.withInteract(action: PlayerInteractEvent.() -> Unit) { materialMap[this] = action }

    fun onPlayerDeath(action: MAPPlayerDeathEvent.() -> Unit) { playerDeath = action }

    fun onPlayerJoin(action: PlayerJoinEvent.() -> Unit) { playerJoin = action }

    fun onPlayerQuit(action: PlayerQuitEvent.() -> Unit) { playerQuit = action }

    fun onChat(action: MAPPlayerChatEvent.() -> Unit) { playerSendMessage = action }

    fun onPlayerMove(action: PlayerMoveEvent.() -> Unit) { playerMove = action }

    fun onClearAdvancement(action: PlayerAdvancementDoneEvent.() -> Unit) { playerClearAdvancement = action }

    fun onConsume(action: PlayerItemConsumeEvent.() -> Unit) { playerConsume = action }

    fun onEnderPearl(action: MAPEnderPearlEvent.() -> Unit) { playerEnderPearl = action }

    private fun checkHandType(typeList: List<EquipmentSlot>, event: PlayerInteractEvent): Boolean {
        if (typeList.isEmpty()) return true
        return typeList.contains(event.hand)
    }

    @EventHandler
    private fun onPlayerInteractEvent(event: PlayerInteractEvent) {
        if (event.action.isRightClick && checkHandType(rightClickHandType, event)) rightClick.invoke(event)
        if (event.action.isLeftClick && checkHandType(leftClickHandType, event)) leftClick.invoke(event)

        val mainHandItem = event.player.inventory.itemInMainHand
        val offHandItem = event.player.inventory.itemInOffHand
        if (itemMap.containsKey(mainHandItem)) itemMap[mainHandItem]!!.invoke(event)
        if (itemMap.containsKey(offHandItem)) itemMap[offHandItem]!!.invoke(event)

        if (materialMap.containsKey(mainHandItem.type)) materialMap[mainHandItem.type]!!.invoke(event)
        if (materialMap.containsKey(offHandItem.type)) materialMap[offHandItem.type]!!.invoke(event)
    }

    @EventHandler
    private fun onEntityDamageEvent(event: EntityDamageEvent) {
        if (event.entity !is Player) return
        val player = event.entity as Player

        val checkList = listOf(player.inventory.itemInMainHand.type, player.inventory.itemInOffHand.type)

        if (checkList.contains(Material.TOTEM_OF_UNDYING)) return
        if (player.health < event.damage) playerDeath.invoke(MAPPlayerDeathEvent(event, player))
    }

    @EventHandler
    private fun onPlayerJoinEvent(event: PlayerJoinEvent) = playerJoin.invoke(event)

    @EventHandler
    private fun onPlayerQuitEvent(event: PlayerQuitEvent) = playerQuit.invoke(event)

    @EventHandler
    private fun onAsyncChatEvent(event: AsyncChatEvent) {
        val targets = mutableListOf<Player>()
        event.viewers().forEach {
            targets.add(it as Player)
        }

        playerSendMessage.invoke(MAPPlayerChatEvent(event, event.player))
    }

    @EventHandler
    private fun onPlayerMoveEvent(event: PlayerMoveEvent) = playerMove.invoke(event)

    @EventHandler
    private fun onPlayerClearAdvancementEvent(event: PlayerAdvancementDoneEvent) = playerClearAdvancement.invoke(event)

    @EventHandler
    private fun onPlayerItemConsumeEvent(event: PlayerItemConsumeEvent) = playerConsume.invoke(event)

    @EventHandler
    private fun onPlayerTeleportEvent(event: PlayerTeleportEvent) {
        if (event.cause == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) playerEnderPearl.invoke(MAPEnderPearlEvent(event))
    }
}