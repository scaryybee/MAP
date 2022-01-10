package io.github.asr.mafp.message

import io.github.asr.mafp.utils.text
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import org.bukkit.ChatColor
import org.bukkit.entity.Player

infix fun Component.sendTo(player: Player) = player.sendMessage(this)

infix fun Component.sendTo(playerList: List<Player>) = playerList.forEach { this sendTo it }

fun TextComponent.setColor(color: ChatColor): TextComponent =
    text("$color" + this.content())


