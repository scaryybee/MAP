package io.github.asr.mafp.command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

fun commands(init: EasyCommand.() -> Unit) {}

class EasyCommand : CommandExecutor {
    private val commandActionMap = mutableMapOf<String, MAPCommandSendEvent.() -> Unit>()

    fun addCommand(commandName: String, action: MAPCommandSendEvent.() -> Unit) {
        Bukkit.getServer().getPluginCommand(commandName)
        commandActionMap[commandName] = action
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (commandActionMap.containsKey(command.name)) {
            commandActionMap[command.name]!!.invoke(MAPCommandSendEvent(sender, command, args))
        }

        return false
    }
}