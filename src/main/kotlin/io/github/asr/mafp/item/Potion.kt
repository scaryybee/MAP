package io.github.asr.mafp.item

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect

fun Material.isPotion() = this == Material.POTION || this == Material.SPLASH_POTION || this == Material.LINGERING_POTION

val ItemStack.potionTypes: List<PotionEffect>
    get() {
        if (this.type.isPotion()) return (this.itemMeta as PotionMeta).customEffects

        throw RuntimeException()
    }