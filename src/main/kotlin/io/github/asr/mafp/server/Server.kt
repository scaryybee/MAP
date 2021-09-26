package io.github.asr.mafp.server

import org.bukkit.Sound
import org.bukkit.plugin.Plugin

fun Plugin.broadcastSound(sound: Sound, volume: Float, pitch: Float) = server
    .onlinePlayers.forEach {it.playSound(it.location, sound, volume, pitch) }

fun Plugin.reload() = server.reload()

