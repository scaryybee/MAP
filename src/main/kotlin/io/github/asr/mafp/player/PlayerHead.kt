package io.github.asr.mafp.player

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.plugin.Plugin
import java.util.*

fun Plugin.playerHead(player: Player): ItemStack =
    ItemStack(Material.PLAYER_HEAD).apply {
        val meta = this.itemMeta as SkullMeta
        meta.owningPlayer = server.getOfflinePlayer(player.uniqueId)
    }

fun Plugin.playerHead(uuid: UUID): ItemStack =
    ItemStack(Material.PLAYER_HEAD).apply {
        val meta = this.itemMeta as SkullMeta
        meta.owningPlayer = server.getOfflinePlayer(uuid)
    }
