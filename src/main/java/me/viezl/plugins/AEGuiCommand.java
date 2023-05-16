package me.viezl.plugins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AEGuiCommand implements CommandExecutor {
    UPGRADEAE plugin;
    public AEGuiCommand(UPGRADEAE plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            plugin.openGui(player);
        }
        return true;
    }
}
