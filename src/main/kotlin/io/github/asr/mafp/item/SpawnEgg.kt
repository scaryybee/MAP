package io.github.asr.mafp.item

import org.bukkit.Material
import org.bukkit.entity.EntityType

fun Material.toSpawnEgg(): SpawnEgg? {
    SpawnEgg.valuesList().forEach {
        if (it.material == this) return it
    }

    return null
}

fun Material.isSpawnEgg(): Boolean = SpawnEgg.valuesList().contains(this.toSpawnEgg())

enum class SpawnEgg(val material: Material, val entityType: EntityType) {
    AXOLOTL(Material.AXOLOTL_SPAWN_EGG, EntityType.AXOLOTL),
    BAT(Material.BAT_SPAWN_EGG, EntityType.BAT),
    BEE(Material.BEE_SPAWN_EGG, EntityType.BEE),
    BLAZE(Material.BLAZE_SPAWN_EGG, EntityType.BLAZE),
    CAT(Material.CAT_SPAWN_EGG, EntityType.CAT),
    CAVE_SPIDER(Material.CAVE_SPIDER_SPAWN_EGG, EntityType.CAVE_SPIDER),
    CHICKEN(Material.CHICKEN_SPAWN_EGG, EntityType.CHICKEN),
    COD(Material.COD_SPAWN_EGG, EntityType.COD),
    COW(Material.COW_SPAWN_EGG, EntityType.COW),
    CREEPER(Material.CREEPER_SPAWN_EGG, EntityType.CREEPER),
    DOLPHIN(Material.DOLPHIN_SPAWN_EGG, EntityType.DOLPHIN),
    DONKEY(Material.DONKEY_SPAWN_EGG, EntityType.DONKEY),
    DROWNED(Material.DROWNED_SPAWN_EGG, EntityType.DROWNED),
    ELDER_GUARDIAN(Material.ELDER_GUARDIAN_SPAWN_EGG, EntityType.ELDER_GUARDIAN),
    ENDERMAN(Material.ENDERMAN_SPAWN_EGG, EntityType.ENDERMAN),
    ENDERMITE(Material.ENDERMITE_SPAWN_EGG, EntityType.ENDERMITE),
    EVOKER(Material.EVOKER_SPAWN_EGG, EntityType.EVOKER),
    FOX(Material.FOX_SPAWN_EGG, EntityType.FOX),
    GHAST(Material.GHAST_SPAWN_EGG, EntityType.GHAST),
    GLOW_SQUID(Material.GLOW_SQUID_SPAWN_EGG, EntityType.GLOW_SQUID),
    GOAT(Material.GOAT_SPAWN_EGG, EntityType.GOAT),
    GUARDIAN(Material.GUARDIAN_SPAWN_EGG, EntityType.GUARDIAN),
    HOGLIN(Material.HOGLIN_SPAWN_EGG, EntityType.HOGLIN),
    HORSE(Material.HORSE_SPAWN_EGG, EntityType.HORSE),
    HUSK(Material.HUSK_SPAWN_EGG, EntityType.HUSK),
    LLAMA(Material.LLAMA_SPAWN_EGG, EntityType.LLAMA),
    MAGMA_CUBE(Material.MAGMA_CUBE_SPAWN_EGG, EntityType.MAGMA_CUBE),
    MOOSHROOM(Material.MOOSHROOM_SPAWN_EGG, EntityType.MUSHROOM_COW),
    MULE(Material.MULE_SPAWN_EGG, EntityType.MULE),
    OCELOT(Material.OCELOT_SPAWN_EGG, EntityType.OCELOT),
    PANDA(Material.PANDA_SPAWN_EGG, EntityType.PANDA),
    PARROT(Material.PARROT_SPAWN_EGG, EntityType.PARROT),
    PHANTOM(Material.PHANTOM_SPAWN_EGG, EntityType.PHANTOM),
    PIG(Material.PIG_SPAWN_EGG, EntityType.PIG),
    PIGLIN(Material.PIGLIN_SPAWN_EGG, EntityType.PIGLIN),
    PIGLIN_BRUTE(Material.PIGLIN_BRUTE_SPAWN_EGG, EntityType.PIGLIN_BRUTE),
    PILLAGER(Material.PILLAGER_SPAWN_EGG, EntityType.PILLAGER),
    POLAR_BEAR(Material.POLAR_BEAR_SPAWN_EGG, EntityType.POLAR_BEAR),
    PUFFERFISH(Material.PUFFERFISH_SPAWN_EGG, EntityType.PUFFERFISH),
    RABBIT(Material.RABBIT_SPAWN_EGG, EntityType.RABBIT),
    RAVAGER(Material.RAVAGER_SPAWN_EGG, EntityType.RAVAGER),
    SALMON(Material.SALMON_SPAWN_EGG, EntityType.SALMON),
    SHEEP(Material.SHEEP_SPAWN_EGG, EntityType.SHEEP),
    SHULKER(Material.SHULKER_SPAWN_EGG, EntityType.SHULKER),
    SILVERFISH(Material.SILVERFISH_SPAWN_EGG, EntityType.SILVERFISH),
    SKELETON(Material.SKELETON_SPAWN_EGG, EntityType.SKELETON),
    SKELETON_HORSE(Material.SKELETON_HORSE_SPAWN_EGG, EntityType.SKELETON_HORSE),
    SLIME(Material.SLIME_SPAWN_EGG, EntityType.SLIME),
    SPIDER(Material.SPIDER_SPAWN_EGG, EntityType.SPIDER),
    SQUID(Material.SQUID_SPAWN_EGG, EntityType.SQUID),
    STRAY(Material.STRAY_SPAWN_EGG, EntityType.STRAY),
    STRIDER(Material.STRIDER_SPAWN_EGG, EntityType.STRIDER),
    TRADER_LLAMA(Material.TRADER_LLAMA_SPAWN_EGG, EntityType.TRADER_LLAMA),
    TROPICAL_FISH(Material.TROPICAL_FISH_SPAWN_EGG, EntityType.TROPICAL_FISH),
    TURTLE(Material.TURTLE_SPAWN_EGG, EntityType.TURTLE),
    VEX(Material.VEX_SPAWN_EGG, EntityType.VEX),
    VILLAGER(Material.VILLAGER_SPAWN_EGG, EntityType.VILLAGER),
    VINDICATOR(Material.VINDICATOR_SPAWN_EGG, EntityType.VINDICATOR),
    WANDERING_TRADER(Material.WANDERING_TRADER_SPAWN_EGG, EntityType.WANDERING_TRADER),
    WITCH(Material.WITCH_SPAWN_EGG, EntityType.WITCH),
    WITHER_SKELETON(Material.WITHER_SKELETON_SPAWN_EGG, EntityType.WITHER_SKELETON),
    WOLF(Material.WOLF_SPAWN_EGG, EntityType.WOLF),
    ZOGLIN(Material.ZOGLIN_SPAWN_EGG, EntityType.ZOGLIN),
    ZOMBIE(Material.ZOMBIE_SPAWN_EGG, EntityType.ZOMBIE),
    ZOMBIE_HORSE(Material.ZOMBIE_HORSE_SPAWN_EGG, EntityType.ZOMBIE_HORSE),
    ZOMBIE_VILLAGER(Material.ZOMBIE_VILLAGER_SPAWN_EGG, EntityType.ZOMBIE_VILLAGER),
    ZOMBIFIED_PIGLIN(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, EntityType.ZOMBIFIED_PIGLIN);

    companion object {
        fun valuesList(): List<SpawnEgg> {
            val list = mutableListOf<SpawnEgg>()

            values().forEach { list.add(it) }

            return list
        }
    }
}