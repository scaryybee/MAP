package io.github.asr.mafp.listener

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

fun Plugin.events(init: EasyEvents.() -> Unit) {
    EasyEvents().apply(init).addEvent(this)
}

private fun Action.isRight() = this == Action.RIGHT_CLICK_AIR || this == Action.RIGHT_CLICK_BLOCK
private fun Action.isLeft() = this == Action.LEFT_CLICK_AIR || this == Action.LEFT_CLICK_BLOCK

class EasyEvents : Listener {
    private val itemMap = mutableMapOf<ItemStack, (event: PlayerInteractEvent) -> Unit>()
    private val materialMap = mutableMapOf<Material, (event: PlayerInteractEvent) -> Unit>()

    private var rightClick: (event: PlayerInteractEvent) -> Unit = {}
    private var leftClick: (event: PlayerInteractEvent) -> Unit = {}
    private var playerDeath: (event: PlayerDeathEvent) -> Unit = {}

    private var rightClickHandType = mutableListOf<EquipmentSlot>()
    private var leftClickHandType = mutableListOf<EquipmentSlot>()

    private var playerJoin: (event: PlayerJoinEvent) -> Unit = {}
    private var playerQuit: (event: PlayerQuitEvent) -> Unit = {}

    private var playerSendMessage: (event: AsyncChatEvent) -> Unit = {}

    private var playerMove: (event: PlayerMoveEvent) -> Unit = {}

    private var playerClearAdvancement: (event: PlayerAdvancementDoneEvent) -> Unit = {}

    private var playerConsume: (event: PlayerItemConsumeEvent) -> Unit = {}

    private var playerEnderPearl: (event: MAPEnderPearlEvent) -> Unit = {}

    private var shootBow: (event: EntityShootBowEvent) -> Unit = {}

    fun addEvent(plugin: Plugin) {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    fun onRightClick(vararg handType: EquipmentSlot = emptyArray(), action: (event: PlayerInteractEvent) -> Unit) {
        handType.forEach { rightClickHandType.add(it) }
        rightClick = action
    }

    fun onLeftClick(vararg handType: EquipmentSlot = emptyArray(), action: (event: PlayerInteractEvent) -> Unit) {
        handType.forEach { leftClickHandType.add(it) }
        leftClick = action
    }

    infix fun ItemStack.withInteract(action: (event: PlayerInteractEvent) -> Unit) { itemMap[this] = action }

    infix fun Material.withInteract(action: (event: PlayerInteractEvent) -> Unit) { materialMap[this] = action }

    fun onPlayerDeath(action: (event: PlayerDeathEvent) -> Unit) { playerDeath = action }

    fun onPlayerJoin(action: (event: PlayerJoinEvent) -> Unit) { playerJoin = action }

    fun onPlayerQuit(action: (event: PlayerQuitEvent) -> Unit) { playerQuit = action }

    fun onChat(action: (event: AsyncChatEvent) -> Unit) { playerSendMessage = action }

    fun onPlayerMove(action: (event: PlayerMoveEvent) -> Unit) { playerMove = action }

    fun onClearAdvancement(action: (event: PlayerAdvancementDoneEvent) -> Unit) { playerClearAdvancement = action }

    fun onConsume(action: (event: PlayerItemConsumeEvent) -> Unit) { playerConsume = action }

    fun onEnderPearl(action: (event: MAPEnderPearlEvent) -> Unit) { playerEnderPearl = action }

    fun onShootBow(action: (event: EntityShootBowEvent) -> Unit) { shootBow = action }

    private fun checkHandType(typeList: List<EquipmentSlot>, event: PlayerInteractEvent): Boolean {
        if (typeList.isEmpty()) return true
        return typeList.contains(event.hand)
    }

    @EventHandler
    private fun onPlayerInteractEvent(event: PlayerInteractEvent) {
        if (event.action.isRight() && checkHandType(rightClickHandType, event)) rightClick.invoke(event)
        if (event.action.isLeft() && checkHandType(leftClickHandType, event)) leftClick.invoke(event)

        val mainHandItem = event.player.inventory.itemInMainHand
        val offHandItem = event.player.inventory.itemInOffHand
        if (itemMap.containsKey(mainHandItem)) itemMap[mainHandItem]!!.invoke(event)
        if (itemMap.containsKey(offHandItem)) itemMap[offHandItem]!!.invoke(event)

        if (materialMap.containsKey(mainHandItem.type)) materialMap[mainHandItem.type]!!.invoke(event)
        if (materialMap.containsKey(offHandItem.type)) materialMap[offHandItem.type]!!.invoke(event)
    }

    @EventHandler
    private fun onPlayerDeath(event: PlayerDeathEvent) = playerDeath.invoke(event)

    @EventHandler
    private fun onPlayerJoinEvent(event: PlayerJoinEvent) = playerJoin.invoke(event)

    @EventHandler
    private fun onPlayerQuitEvent(event: PlayerQuitEvent) = playerQuit.invoke(event)

    @EventHandler
    private fun onAsyncChatEvent(event: AsyncChatEvent) = playerSendMessage.invoke(event)

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

    @EventHandler
    private fun onEntityShootBowEvent(event: EntityShootBowEvent) = shootBow.invoke(event)
}