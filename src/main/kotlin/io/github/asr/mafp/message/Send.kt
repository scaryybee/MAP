package io.github.asr.mafp.message

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

fun Component.sendTo(player: Player) = player.sendMessage(this)

fun Component.sendTo(playerList: List<Player>) = playerList.forEach { this.sendTo(it) }