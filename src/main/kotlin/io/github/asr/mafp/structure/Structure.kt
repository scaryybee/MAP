package io.github.asr.mafp.structure

import org.bukkit.Material
import org.bukkit.block.Block

class Structure(private vararg val blocks: Block) {
    fun blockAmount(type: Material) : Int {
        var amount = 0
        blocks.forEach {
            if (it.type == type) {
                amount++
            }
        }

        return amount
    }

    fun containsBlock(type: Material) : Boolean {
        blocks.forEach {
            if (it.type == type) return true
        }

        return false
    }
}