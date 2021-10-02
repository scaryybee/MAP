package io.github.asr.mafp.inventory

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.PlayerInventory

fun Inventory.clearItem(inventoryRange: List<Int>,material: Material, amount: Int): Boolean {
    var number = 0
    val materialList = mutableListOf<Int>()
    for (slot in inventoryRange) {
        val slotItem = this.getItem(slot)
        if (slotItem?.type == material) {
            number += slotItem.amount
            if (amount <= number) {
                slotItem.amount -= amount - (number - slotItem.amount)
                materialList.forEach { this.setItem(it, null) }
                this.setItem(slot, slotItem)
                return true
            }
            materialList.add(slot)
        }
    }
    return false
}

fun PlayerInventory.getOwner(): Player = this.holder as Player