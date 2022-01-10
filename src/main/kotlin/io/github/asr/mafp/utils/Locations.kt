package io.github.asr.mafp.utils

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.util.Consumer
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

fun Location.spawnEntity(type: EntityType) = world.spawnEntity(this, type)

fun Location.spawnEntity(type: EntityType, randomizeData: Boolean) = world.spawnEntity(this, type, randomizeData)

fun Location.spawnEntity(type: EntityType, reason: CreatureSpawnEvent.SpawnReason) = world.spawnEntity(this, type, reason)

fun Location.spawnEntity(type: EntityType, reason: CreatureSpawnEvent.SpawnReason, function: Consumer<Entity>?) =
    world.spawnEntity(this, type, reason, function)

fun Location.spawnEntity(type: EntityType, reason: CreatureSpawnEvent.SpawnReason, function: (Entity) -> Unit) =
    world.spawnEntity(this, type, reason, function)


fun Location.spawnParticle(particle: Particle, number: Int) {
    world.spawnParticle(particle, this, number)
}
// TODO Add More .spawnParticle()

fun Location.playSound(sound: Sound, volume: Float) {
    world.playSound(this, sound, volume, pitch)
}

fun Location.NSS(radius: Double, n: Int): List<Location> {
    val locationList = mutableListOf<Location>()
    val angle: Double = 360.0 / n
    for (i in 0 until n) {
        val t = angle * i
        val x = cos(t) * radius
        val z = sin(t) * radius

        locationList.add(clone().add(x, 0.0, z))
    }

    return locationList
}

private infix fun Int.to(to: Int) = this..to

fun Location.circle(radius: Double, gab: Double): List<Location> {
    val locationList = mutableListOf<Location>()

    for (i in -(radius * 100).toInt() to (radius * 100).toInt() step (gab * 100).toInt()) {
        val xLoc = i.toDouble() / 100
        val zLoc = sqrt(radius * radius - xLoc * xLoc)

        locationList.add(clone().add(xLoc, 0.0, zLoc))
        locationList.add(clone().add(xLoc, 0.0, -zLoc))
    }

    for (i in -(radius * 100).toInt() to (radius * 100).toInt() step (gab * 100).toInt()) {
        val zLoc = i.toDouble() / 100
        val xLoc = sqrt(radius * radius - zLoc * zLoc)

        locationList.add(clone().add(xLoc, 0.0, zLoc))
        locationList.add(clone().add(xLoc, 0.0, -zLoc))
    }

    return locationList
}

fun Location.forward(distance: Double) = this.clone().add(this.direction.multiply(distance))

fun Location.plus(vector: Vector) = clone().add(vector)

fun Location.plus(location: Location) = clone().add(location)

fun Location.plus(x: Double, y: Double, z: Double) = clone().add(x, y, z)
