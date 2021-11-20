package io.github.asr.mafp.loop

import io.github.asr.mafp.utils.wait
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import java.util.*

private val loopActionMap = mutableMapOf<UUID, Loop.() -> Unit>()

fun Plugin.loop(tickGab: Long, endLoop: Int, timeStart: Int = 0, action: Loop.() -> Unit) {
    val loop = Loop(timeStart)
    loopActionMap[loop.uuid()] = action
    val task = server.scheduler.scheduleSyncRepeatingTask(
        this, {
            action.invoke(loop)
            loop.looping()
        }, 0L, tickGab)

    wait(endLoop * tickGab) { server.scheduler.cancelTask(task) }
}

fun Plugin.infLoop(tickGab: Long, timeStart: Int = 0, action: Loop.() -> Unit) {
    val loop = Loop(timeStart)
    loopActionMap[loop.uuid()] = action
    server.scheduler.scheduleSyncRepeatingTask(
        this, {
            action.invoke(loop)
            loop.looping()
        }, 0L, tickGab
    )
}

class Loop(private var time: Int = 1) {
    private var uuid = UUID.randomUUID()!!

    init {
        uuid = UUID.randomUUID()!!
        loopActionMap[uuid] = {}
    }

    fun time(): Int = time

    fun looping() { time++ }

    fun stopLoop() {
        loopActionMap[uuid] = {}
    }

    fun uuid() = uuid
}
