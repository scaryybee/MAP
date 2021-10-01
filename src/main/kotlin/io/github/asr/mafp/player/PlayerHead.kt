package io.github.asr.mafp.player

import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.plugin.Plugin
import java.util.*

fun Plugin.playerHead(name: String): ItemStack =
    ItemStack(Material.PLAYER_HEAD).apply {
        val meta = this.itemMeta as SkullMeta
        meta.owningPlayer = server.getPlayer(name)
    }

fun Plugin.playerHead(uuid: UUID): ItemStack =
    ItemStack(Material.PLAYER_HEAD).apply {
        val meta = this.itemMeta as SkullMeta
        meta.owningPlayer = server.getPlayer(uuid)
    }

fun playerHead(player: OfflinePlayer): ItemStack =
    ItemStack(Material.PLAYER_HEAD).apply {
        val meta = this.itemMeta as SkullMeta
        meta.owningPlayer = player
    }
