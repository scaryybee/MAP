package io.github.asr.mafp.message

import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.entity.Player

infix fun Component.sendTo(player: Player) = player.sendMessage(this)

infix fun Component.sendTo(playerList: List<Player>) = playerList.forEach { this sendTo it }

infix fun Component.setBaseColor(color: ChatColor): Component =
    Component.text("${color}${this.insertion()!!}")
