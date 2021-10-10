package io.github.asr.mafp.entity

import io.github.asr.mafp.utils.forward
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

var Entity.isGravity: Boolean
    get() = this.hasGravity()
    set(value: Boolean) = this.setGravity(value)

class Entities {
    companion object {
        @JvmStatic
        fun create(type: EntityType, location: Location): Entity = location.world.spawnEntity(location, type)
    }
}

fun EntityType.create(location: Location): Entity = Entities.create(this, location)

infix fun Entity.to(location: Location) = this.teleport(location)

infix fun Entity.to(entity: Entity) = this.teleport(entity)

infix fun Entity.watch(loc: Location) {
    loc.direction = loc.toVector().subtract(this.location.toVector())
    this to loc
}

infix fun Entity.watch(entity: Entity) = this watch entity.location

fun Entity.forward(distance: Double) = location.forward(distance)