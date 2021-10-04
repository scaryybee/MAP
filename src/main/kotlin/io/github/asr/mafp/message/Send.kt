package io.github.asr.mafp.message

import io.github.asr.mafp.utils.RESET
import io.github.asr.mafp.utils.Text
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.entity.Player

infix fun Component.sendTo(player: Player) = player.sendMessage(this)

infix fun Component.sendTo(playerList: List<Player>) = playerList.forEach { this sendTo it }

fun Component.setBaseColor(color: ChatColor): Component =
    Component.text(color.toString() + this.insertion()!!.replace(RESET.toString(), color.toString(), true))

fun Text.setBaseColor(color: ChatColor): Text =
    this.replace(RESET.toString(), color.toString(), true).addTextFront(Text(color.toString()))

