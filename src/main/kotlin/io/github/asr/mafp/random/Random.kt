package io.github.asr.mafp.random

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

private fun <T> randomInArray(array: Array<T>): T = array[Random.nextInt(array.size)]

private inline fun <reified T> randomInList(list: List<T>): T = randomInArray(list.toTypedArray())

fun randomEntity(list: List<Entity>): Entity = randomInList(list)

fun Location.nearbyRandomEntity(radius: Double): Entity = randomEntity(getNearbyLivingEntities(radius).toList())

private fun randomMaterial() = Material.values().random()

private fun randomItemStack(): ItemStack {
    val material = randomMaterial()
    return ItemStack(material, Random.nextInt(material.maxStackSize) + 1)
}

class Random {
    companion object {
        @JvmStatic
        fun material() = randomMaterial()

        @JvmStatic
        fun itemStack() = randomItemStack()
    }
}