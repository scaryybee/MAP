package io.github.asr.mafp.entity

import org.bukkit.entity.Entity

var Entity.isGravity: Boolean
    get() = this.hasGravity()
    set(value: Boolean) = this.setGravity(value)