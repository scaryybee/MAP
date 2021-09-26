package io.github.asr.mafp.item

import org.bukkit.Material

fun Material.toSpawnEgg(): SpawnEgg? {
    SpawnEgg.valuesList().forEach {
        if (it.toMaterial() == this) return it
    }

    return null
}

fun Material.isSpawnEgg(): Boolean = SpawnEgg.valuesList().contains(this.toSpawnEgg())

enum class SpawnEgg(private val material: Material) {
    AXOLOTL(Material.AXOLOTL_SPAWN_EGG),
    BAT(Material.BAT_SPAWN_EGG),
    BEE(Material.BEE_SPAWN_EGG),
    BLAZE(Material.BLAZE_SPAWN_EGG),
    CAT(Material.CAT_SPAWN_EGG),
    CAVE_SPIDER(Material.CAVE_SPIDER_SPAWN_EGG),
    CHICKEN(Material.CHICKEN_SPAWN_EGG),
    COD(Material.COD_SPAWN_EGG),
    COW(Material.COW_SPAWN_EGG),
    CREEPER(Material.CREEPER_SPAWN_EGG),
    DOLPHIN(Material.DOLPHIN_SPAWN_EGG),
    DONKEY(Material.DONKEY_SPAWN_EGG),
    DROWNED(Material.DROWNED_SPAWN_EGG),
    ELDER_GUARDIAN(Material.ELDER_GUARDIAN_SPAWN_EGG),
    ENDERMAN(Material.ENDERMAN_SPAWN_EGG),
    ENDERMITE(Material.ENDERMITE_SPAWN_EGG),
    EVOKER(Material.EVOKER_SPAWN_EGG),
    FOX(Material.FOX_SPAWN_EGG),
    GHAST(Material.GHAST_SPAWN_EGG),
    GLOW_SQUID(Material.GLOW_SQUID_SPAWN_EGG),
    GOAT(Material.GOAT_SPAWN_EGG),
    GUARDIAN(Material.GUARDIAN_SPAWN_EGG),
    HOGLIN(Material.HOGLIN_SPAWN_EGG),
    HORSE(Material.HORSE_SPAWN_EGG),
    HUSK(Material.HUSK_SPAWN_EGG),
    LLAMA(Material.LLAMA_SPAWN_EGG),
    MAGMA_CUBE(Material.MAGMA_CUBE_SPAWN_EGG),
    MOOSHROOM(Material.MOOSHROOM_SPAWN_EGG),
    MULE(Material.MULE_SPAWN_EGG),
    OCELOT(Material.OCELOT_SPAWN_EGG),
    PANDA(Material.PANDA_SPAWN_EGG),
    PARROT(Material.PARROT_SPAWN_EGG),
    PHANTOM(Material.PHANTOM_SPAWN_EGG),
    PIG(Material.PIG_SPAWN_EGG),
    PIGLIN(Material.PIGLIN_SPAWN_EGG),
    PIGLIN_BRUTE(Material.PIGLIN_BRUTE_SPAWN_EGG),
    PILLAGER(Material.PILLAGER_SPAWN_EGG),
    POLAR_BEAR(Material.POLAR_BEAR_SPAWN_EGG),
    PUFFERFISH(Material.PUFFERFISH_SPAWN_EGG),
    RABBIT(Material.RABBIT_SPAWN_EGG),
    RAVAGER(Material.RAVAGER_SPAWN_EGG),
    SALMON(Material.SALMON_SPAWN_EGG),
    SHEEP(Material.SHEEP_SPAWN_EGG),
    SHULKER(Material.SHULKER_SPAWN_EGG),
    SILVERFISH(Material.SILVERFISH_SPAWN_EGG),
    SKELETON(Material.SKELETON_SPAWN_EGG),
    SKELETON_HORSE(Material.SKELETON_HORSE_SPAWN_EGG),
    SLIME(Material.SLIME_SPAWN_EGG),
    SPIDER(Material.SPIDER_SPAWN_EGG),
    SQUID(Material.SQUID_SPAWN_EGG),
    STRAY(Material.STRAY_SPAWN_EGG),
    STRIDER(Material.STRIDER_SPAWN_EGG),
    TRADER_LLAMA(Material.TRADER_LLAMA_SPAWN_EGG),
    TROPICAL_FISH(Material.TROPICAL_FISH_SPAWN_EGG),
    TURTLE(Material.TURTLE_SPAWN_EGG),
    VEX(Material.VEX_SPAWN_EGG),
    VILLAGER(Material.VILLAGER_SPAWN_EGG),
    VINDICATOR(Material.VINDICATOR_SPAWN_EGG),
    WANDERING_TRADER(Material.WANDERING_TRADER_SPAWN_EGG),
    WITCH(Material.WITCH_SPAWN_EGG),
    WITHER_SKELETON(Material.WITHER_SKELETON_SPAWN_EGG),
    WOLF(Material.WOLF_SPAWN_EGG),
    ZOGLIN(Material.ZOGLIN_SPAWN_EGG),
    ZOMBIE(Material.ZOMBIE_SPAWN_EGG),
    ZOMBIE_HORSE(Material.ZOMBIE_HORSE_SPAWN_EGG),
    ZOMBIE_VILLAGER(Material.ZOMBIE_VILLAGER_SPAWN_EGG),
    ZOMBIFIED_PIGLIN(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG);

    fun toMaterial(): Material = material

    companion object {
        fun valuesList(): List<SpawnEgg> {
            val list = mutableListOf<SpawnEgg>()

            values().forEach { list.add(it) }

            return list
        }
    }
}