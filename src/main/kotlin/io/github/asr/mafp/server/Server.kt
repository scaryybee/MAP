package io.github.asr.mafp.server

import net.kyori.adventure.text.Component
import org.bukkit.Sound
import org.bukkit.plugin.Plugin

fun Plugin.broadcastSound(sound: Sound, volume: Float, pitch: Float) = server
    .onlinePlayers.forEach {it.playSound(it.location, sound, volume, pitch) }

fun Plugin.reload() = server.reload()

fun Plugin.broadcastMessage(message: Component) = server.broadcast(message)

fun Plugin.unload() = server.pluginManager.disablePlugin(this)