package me.viezl.plugins;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AEClickGui implements Listener {
    @EventHandler
    public void onGuiClick(InventoryClickEvent click){
        Player player = (Player) click.getWhoClicked();
        // Tên gui upgrade
        final String MAIN_MENU = ChatColor.AQUA + "NÂNG CẤP PHÙ PHÉP";

        //Mở menu
        if (click.getView().getTitle().equalsIgnoreCase(MAIN_MENU)){
            switch (click.getCurrentItem().getType()){
                case BOOK:

                    player.sendTitle(ChatColor.AQUA+"Đang được update",ChatColor.DARK_AQUA+"Mọe mi đang update lì thế nhở");
                    player.closeInventory();
                    break;
                case ENCHANTED_BOOK:
                    player.closeInventory();
                    break;
                case ANVIL:
                    if (click.getClick().isLeftClick() == true) {
                        player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 20);
                    }
                    break;
                case BARRIER:
                    player.closeInventory();
                    player.sendTitle(ChatColor.LIGHT_PURPLE+"Đã thoát",ChatColor.DARK_PURPLE+"Đã thoát khỏi giao diện");
                    break;
                default:
                    click.setCancelled(true);
                    break;
            }
        }
    }
}
