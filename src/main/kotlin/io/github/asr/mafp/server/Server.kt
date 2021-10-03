package io.github.asr.mafp.server

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.plugin.Plugin

fun Sound.broadcast(volume: Float, pitch: Float) = Bukkit
    .getOnlinePlayers().forEach {it.playSound(it.location, this, volume, pitch) }

fun Component.broadcast() = Bukkit.broadcast(this)

fun Plugin.reload() = server.reload()

fun Plugin.unload() = server.pluginManager.disablePlugin(this)