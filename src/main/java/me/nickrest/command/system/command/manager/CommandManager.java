package me.nickrest.command.system.command.manager;

import lombok.Getter;
import me.nickrest.command.system.command.Command;
import me.nickrest.command.system.command.commands.TestCommand;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The manager of commands
 **/
@Getter
public class CommandManager {

    /** Every command */
    private final List<Command> commands = new ArrayList<>();

    /**
     * Registers every command in the plugin with the command manager
     * */
    public CommandManager(Plugin plugin) {
        register(new TestCommand());
        commands.forEach(command -> Objects.requireNonNull(plugin.getServer().getPluginCommand(command.getName())).setExecutor(command));
    }

    /**
     * Register a command
     *
     * @param command The command to register
     * */
    public void register(Command command) {
        commands.add(command);
    }
}
