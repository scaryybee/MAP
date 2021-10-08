package io.github.asr.mafp.listener

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.entity.Player

class MAPPlayerChatEvent(
    private val event: AsyncChatEvent,
    private val sender: Player
) {
    var targets: MutableList<Player> = mutableListOf()

    var isCancelled: Boolean = false
        get() = event.isCancelled
        set(value) {
            field = value
            event.isCancelled = value
        }

    init {
        event.viewers().forEach {
            targets.add(it as Player)
        }
    }

    fun asyncChatEvent() = event

    fun sender() = sender

    fun message() = event.message()

    fun sendMessageToTargets() = targets.forEach {
        it.sendMessage("<${sender.name}> ${event.message()}")
    }
}