package io.github.asr.mafp.random

import org.bukkit.Location
import org.bukkit.entity.Entity
import kotlin.random.Random

private fun <T> randomInArray(array: Array<T>): T = array[Random.nextInt(array.size)]

private inline fun <reified T> randomInList(list: List<T>): T = randomInArray(list.toTypedArray())

fun randomEntity(list: List<Entity>): Entity = randomInList(list)

fun Location.nearbyRandomEntity(radius: Double): Entity = randomEntity(getNearbyLivingEntities(radius).toList())