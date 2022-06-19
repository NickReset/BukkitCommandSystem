package me.nickrest.command.system.command;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.command.system.command.data.CommandInfo;
import me.nickrest.command.system.command.manager.CommandManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * The base of every command
 *
 * you will have to register the command in {@link CommandManager}
 * and then register the command how you would in plugin.yml
 * */
@Getter @Setter
public abstract class Command implements CommandExecutor {

    /** CommandInfo */
    public CommandInfo info = getClass().getAnnotation(CommandInfo.class);

    /** The data of the command */
    private String name, permission;
    private boolean console;

    public Command() {
        if(info == null) throw new IllegalArgumentException("CommandInfo is null");

        name = info.name();
        permission = info.permission();
        console = info.console();
    }

    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player) && !console) {
            sender.sendMessage("You must be a player to use this command");
            return true;
        }
        if (!sender.hasPermission(permission) && !permission.equalsIgnoreCase("")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission to use this command!"));
            return true;
        }
        return handle(sender, label, args);
    }

    public abstract boolean handle(CommandSender sender, String commandName, String[] args);

}
