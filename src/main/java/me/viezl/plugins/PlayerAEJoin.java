package me.viezl.plugins;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerAEJoin implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendTitle(ChatColor.RED + "MAIN TITLE", "SUBTIBLE", 1,20,1);
    }
}
