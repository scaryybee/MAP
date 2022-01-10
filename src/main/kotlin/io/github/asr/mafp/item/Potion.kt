package io.github.asr.mafp.item

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffectType

fun Material.isPotion() = this == Material.POTION || this == Material.SPLASH_POTION || this == Material.LINGERING_POTION

val ItemStack.potionTypes: List<PotionEffectType>
    get() {
        if (this.type.isPotion()) {
            val potionTypeList = mutableListOf<PotionEffectType>()
            (this.itemMeta as PotionMeta).customEffects.forEach {
                potionTypeList.add(it.type)
            }

            return potionTypeList
        }

        throw RuntimeException()
    }