package io.github.asr.mafp.listener

import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent

class MAPPlayerDeathEvent(
    private val event: EntityDamageEvent,
    private val deathPlayer: Player,
    private var cancelled: Boolean = false
) {

    val player: Player
        get() = deathPlayer

    var isCancelled: Boolean = false
        get() = cancelled
        set(value) {
            event.isCancelled = value
            field = value
        }

    val entityDamageEvent: EntityDamageEvent
        get() = event
}