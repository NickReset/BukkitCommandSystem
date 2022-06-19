package me.nickrest.command.system;

import lombok.Getter;
import me.nickrest.command.system.command.manager.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main class of the plugin.
 * */
@Getter
public final class CommandSystem extends JavaPlugin {

    /** manager */
    private CommandManager manager;

    public void onEnable() {
        manager = new CommandManager(this);
    }

}
