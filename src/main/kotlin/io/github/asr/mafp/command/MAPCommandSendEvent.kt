package io.github.asr.mafp.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MAPCommandSendEvent(
    private val sender: CommandSender,
    private val command: Command,
    private val args: Array<out String>
) {
    fun player() = if (sender is Player) sender else null

    fun isConsoleSend() = sender !is Player

    fun commandName() = command.name

    fun command() = command

    fun argument(number: Int) = if (number >= args.size) null else args[number]

    fun arguments(vararg numbers: Int): List<String?> {
        val strings = mutableListOf<String?>()
        numbers.forEach { strings.add(argument(it)) }

        return strings
    }

    fun server() = sender.server
}