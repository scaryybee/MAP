package io.github.asr.mafp.player

import io.papermc.paper.chat.ChatRenderer
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import java.util.*

fun Player.sleep() = this.sleep(this.location, true)

fun Player.wakeUp() = this.wakeup(false)

fun Player.say(to: Set<Audience>,message: Component) {
    AsyncChatEvent(true, this, to, ChatRenderer.defaultRenderer(), message, message)
}

fun Player.kill() { this.health = 0.0 }

fun Plugin.hidePlayerInGame(player: Player) = Bukkit.getOnlinePlayers().forEach { it.hidePlayer(this, player) }

fun offlinePlayer(name: String): OfflinePlayer? {
    Bukkit.getServer().offlinePlayers.forEach { if (it.name == name) return it }
    return null
}

fun offlinePlayer(uuid: UUID): OfflinePlayer = Bukkit.getServer().getOfflinePlayer(uuid)

fun Plugin.player(name: String): Player? {
    server.onlinePlayers.forEach { if (it.name == name) return it }
    return null
}

fun Plugin.player(uuid: UUID): Player? {
    server.onlinePlayers.forEach { if (it.uniqueId == uuid) return it }
    return null
}
