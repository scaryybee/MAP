package io.github.asr.mafp.entity

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
