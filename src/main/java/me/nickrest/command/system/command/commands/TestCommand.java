package me.nickrest.command.system.command.commands;

import me.nickrest.command.system.command.Command;
import me.nickrest.command.system.command.data.CommandInfo;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "test", permission = "test.test")
public class TestCommand extends Command {

    public boolean handle(CommandSender sender, String commandName, String[] args) {
        sender.sendMessage(args.length + " arguments");
        return true;
    }
}
