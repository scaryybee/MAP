package io.github.asr.mafp.message

import io.github.asr.mafp.utils.RESET
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.entity.Player

fun Component.sendTo(player: Player) = player.sendMessage(this)

fun Component.sendTo(playerList: List<Player>) = playerList.forEach { this.sendTo(it) }

fun Component.setBaseColor(color: ChatColor): Component =
    Component.text(color.toString() + this.insertion()!!.replace(RESET.toString(), color.toString(), true))
