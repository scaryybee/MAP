package io.github.asr.mafp.block

import org.bukkit.Material

object Block {
    fun Material.isWall() : Boolean = Wall.valuesList().contains(this.toWall())

    fun Material.toWall() : Wall? {
        Wall.values().forEach {
            if (it.toMaterial() == this) {
                return it
            }
        }

        return null
    }

    enum class Wall(private val material: Material) {
        COBBLESTONE(Material.COBBLESTONE_WALL),
        MOSSY_COBBLESTONE(Material.MOSSY_COBBLESTONE_WALL),
        BRICK(Material.BRICK_WALL),
        PRISMARINE(Material.PRISMARINE_WALL),
        RED_SANDSTONE(Material.RED_SANDSTONE_WALL),
        MOSSY_STONE_BRICK(Material.MOSSY_STONE_BRICK_WALL),
        GRANITE(Material.GRANITE_WALL),
        STONE_BRICK(Material.STONE_BRICK_WALL),
        NETHER_BRICK(Material.NETHER_BRICK_WALL),
        ANDESITE(Material.ANDESITE_WALL),
        RED_NETHER_BRICK(Material.RED_NETHER_BRICK_WALL),
        SANDSTONE(Material.SANDSTONE_WALL),
        END_STONE_BRICK(Material.END_STONE_BRICK_WALL),
        DIORITE(Material.DIORITE_WALL),
        BLACKSTONE(Material.BLACKSTONE_WALL),
        POLISHED_BLACKSTONE(Material.POLISHED_BLACKSTONE_WALL),
        POLISHED_BLACKSTONE_BRICK(Material.POLISHED_BLACKSTONE_BRICK_WALL),
        COBBLED_DEEPSLATE(Material.COBBLED_DEEPSLATE_WALL),
        POLISHED_DEEPSLATE(Material.POLISHED_DEEPSLATE_WALL),
        DEEPSLATE_BRICK(Material.DEEPSLATE_BRICK_WALL),
        DEEPSLATE_TILE(Material.DEEPSLATE_TILE_WALL);

        fun toMaterial() : Material = material

        companion object {
            fun valuesList() : List<Wall> {
                val walls = mutableListOf<Wall>()
                values().forEach { walls.add(it) }

                return walls
            }
        }
    }

    fun Material.isCandle(): Boolean = Candle.valuesList().contains(this.toCandle())

    fun Material.toCandle(): Candle? {
        Candle.values().forEach {
            if (it.toMaterial() == this) return it
        }

        return null
    }

    enum class Candle(private val material: Material) {
        NORMAL(Material.CANDLE),
        WHITE(Material.WHITE_CANDLE),
        ORANGE(Material.ORANGE_CANDLE),
        MAGENTA(Material.MAGENTA_CANDLE),
        LIGHT_BLUE(Material.LIGHT_BLUE_CANDLE),
        YELLOW(Material.YELLOW_CANDLE),
        LIME(Material.LIME_CANDLE),
        PINK(Material.PINK_CANDLE),
        GRAY(Material.GRAY_CANDLE),
        LIGHT_GRAY(Material.LIGHT_GRAY_CANDLE),
        CYAN(Material.CYAN_CANDLE),
        PURPLE(Material.PURPLE_CANDLE),
        BLUE(Material.BLUE_CANDLE),
        BROWN(Material.BROWN_CANDLE),
        GREEN(Material.GREEN_CANDLE),
        RED(Material.RED_CANDLE),
        BLACK(Material.BLACK_CANDLE);

        fun toMaterial(): Material = material

        companion object {
            fun valuesList(): List<Candle> = listOf(NORMAL, WHITE, ORANGE, MAGENTA, LIGHT_BLUE, YELLOW, LIME, PINK, GRAY, LIGHT_GRAY,
                CYAN, PURPLE, BLUE, BROWN, GREEN, RED, BLACK)
        }
    }
}