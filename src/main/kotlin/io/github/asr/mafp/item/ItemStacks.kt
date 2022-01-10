package io.github.asr.mafp.item

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ItemStacks {
    companion object {
        @JvmStatic
        fun newStack(type: Material, displayName: Component, lore: List<Component>): ItemStack =
            ItemStack(type).apply { editMeta { it.displayName(displayName); it.lore(lore) } }
    }
}