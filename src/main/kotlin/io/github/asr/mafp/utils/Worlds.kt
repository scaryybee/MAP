package io.github.asr.mafp.utils

import org.bukkit.GameRule
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

fun Plugin.addWorld(namespacedKey: NamespacedKey): World {
    return server.createWorld(WorldCreator(namespacedKey))!!
}

fun World.isOverWorld(): Boolean = this.name == "world"

fun World.isNetherWorld(): Boolean = this.name == "world_nether"

fun World.isEnderWorld(): Boolean = this.name == "world_the_ender"

fun World.isTrue(rule: GameRule<Boolean>): Boolean = this.isGameRule(rule.name)

fun World.set(rule: GameRule<Boolean>, boolean: Boolean) = this.setGameRule(rule, boolean)