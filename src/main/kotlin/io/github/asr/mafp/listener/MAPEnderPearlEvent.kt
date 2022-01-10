package io.github.asr.mafp.listener

import org.bukkit.event.player.PlayerTeleportEvent

class MAPEnderPearlEvent(
    private val event: PlayerTeleportEvent
) {
    val playerTeleportEvent
        get() = event

    var isCancelled
        get() = event.isCancelled
        set(value) {
            event.isCancelled = value
        }

    fun player() = event.player

    fun location() = event.to
}