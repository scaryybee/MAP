package io.github.asr.mafp.tool

import org.bukkit.Material

enum class Tool(private val material : Material) {
    SHEARS(Material.SHEARS);

    fun toMaterial(): Material = material

    companion object {
        fun materialList() : List<Material> {
            val list = mutableListOf<Material>()

            list.add(Material.SHEARS)

            Pickaxe.values().forEach { list.add(it.toMaterial()) }

            Axe.values().forEach { list.add(it.toMaterial()) }

            Shovel.values().forEach { list.add(it.toMaterial()) }

            Hoe.values().forEach { list.add(it.toMaterial()) }

            Others.values().forEach { list.add(it.toMaterial()) }

            return list
        }

        fun Material.isPickaxe() : Boolean = Pickaxe.valuesList().contains(this.toPickaxe())

        fun Material.toPickaxe() : Pickaxe? {
            Pickaxe.values().forEach {
                if (it.toMaterial() == this) return it
            }

            return null
        }

        enum class Pickaxe(private val material : Material) {
            WOOD(Material.WOODEN_PICKAXE),
            STONE(Material.STONE_PICKAXE),
            IRON(Material.IRON_PICKAXE),
            GOLD(Material.GOLDEN_PICKAXE),
            DIAMOND(Material.DIAMOND_PICKAXE),
            NETHERITE(Material.NETHERITE_PICKAXE);

            fun toMaterial() : Material = material

            companion object {
                fun valuesList() : List<Pickaxe> = listOf(WOOD, STONE, IRON, GOLD, DIAMOND, NETHERITE)
            }
        }

        fun Material.isAxe() : Boolean = Axe.valuesList().contains(this.toAxe())

        fun Material.toAxe() : Axe? {
            Axe.values().forEach {
                if (it.toMaterial() == this) return it
            }

            return null
        }

        enum class Axe(private val material : Material) {
            WOOD(Material.WOODEN_AXE),
            STONE(Material.STONE_AXE),
            IRON(Material.IRON_AXE),
            GOLD(Material.GOLDEN_AXE),
            DIAMOND(Material.DIAMOND_AXE),
            NETHERITE(Material.NETHERITE_AXE);

            fun toMaterial() : Material = material

            companion object {
                fun valuesList() : List<Axe> = listOf(WOOD, STONE, IRON, GOLD, DIAMOND, NETHERITE)
            }
        }

        fun Material.isShovel() : Boolean = Shovel.valuesList().contains(this.toShovel())

        fun Material.toShovel() : Shovel? {
            Shovel.values().forEach {
                if (it.toMaterial() == this) return it
            }

            return null
        }

        enum class Shovel(private val material : Material) {
            WOOD(Material.WOODEN_SHOVEL),
            STONE(Material.STONE_SHOVEL),
            IRON(Material.IRON_SHOVEL),
            GOLD(Material.GOLDEN_SHOVEL),
            DIAMOND(Material.DIAMOND_SHOVEL),
            NETHERITE(Material.NETHERITE_SHOVEL);

            fun toMaterial() : Material = material

            companion object {
                fun valuesList() : List<Shovel> = listOf(WOOD, STONE, IRON, GOLD, DIAMOND, NETHERITE)
            }
        }

        fun Material.isHoe() : Boolean = Shovel.valuesList().contains(this.toShovel())

        fun Material.toHoe() : Hoe? {
            Hoe.values().forEach {
                if (it.toMaterial() == this) return it
            }

            return null
        }

        enum class Hoe(private val material : Material) {
            WOOD(Material.WOODEN_HOE),
            STONE(Material.STONE_HOE),
            IRON(Material.IRON_HOE),
            GOLD(Material.GOLDEN_HOE),
            DIAMOND(Material.DIAMOND_HOE),
            NETHERITE(Material.NETHERITE_HOE);

            fun toMaterial() : Material = material

            companion object {
                fun valuesList() : List<Hoe> = listOf(WOOD, STONE, IRON, GOLD, DIAMOND, NETHERITE)
            }
        }

        enum class Others(private val material : Material) {
            FLINT_AND_STEAL(Material.FLINT_AND_STEEL),
            COMPASS(Material.COMPASS),
            SPYGLASS(Material.SPYGLASS),
            LEAD(Material.LEAD),
            NAME_TAG(Material.NAME_TAG);

            fun toMaterial() : Material = material
        }
    }
}