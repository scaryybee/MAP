package io.github.asr.mafp.utils

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.util.Consumer

fun Location.spawnEntity(type: EntityType) {
    world.spawnEntity(this, type)
}

fun Location.spawnEntity(type: EntityType, randomizeData: Boolean) {
    world.spawnEntity(this, type, randomizeData)
}

fun Location.spawnEntity(type: EntityType, reason: CreatureSpawnEvent.SpawnReason) {
    world.spawnEntity(this, type, reason)
}

fun Location.spawnEntity(type: EntityType, reason: CreatureSpawnEvent.SpawnReason, function: Consumer<Entity>?) {
    world.spawnEntity(this, type, reason, function)
}

fun Location.spawnEntity(type: EntityType, reason: CreatureSpawnEvent.SpawnReason, function: (Entity) -> Unit) {
    world.spawnEntity(this, type, reason, function)
}


fun Location.spawnParticle(particle: Particle, number: Int) {
    world.spawnParticle(particle, this, number)
}
// TODO Add More .spawnParticle()

fun Location.playSound(sound: Sound, volume: Float) {
    world.playSound(this, sound, volume, pitch)
}