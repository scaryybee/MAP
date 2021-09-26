package io.github.asr.mafp.utils

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.plugin.Plugin

val Plugin.overWorld: World
    get() = server.getWorld("world")!!

val Plugin.netherWorld: World
    get() = server.getWorld("world_nether")!!

val Plugin.enderWorld: World
    get() = server.getWorld("world_the_ender")!!

fun addWorld(namespacedKey: NamespacedKey): World {
    return Bukkit.createWorld(WorldCreator(namespacedKey))!!
}