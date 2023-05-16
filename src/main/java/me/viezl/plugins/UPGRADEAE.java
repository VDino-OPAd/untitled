package me.viezl.plugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;


public final class UPGRADEAE extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Config.setup();
        getConfig().options().copyDefaults();
        Config.save();
        getLogger().info(" ");
        getLogger().info(ChatColor.RED+"AEUPGRADE ENABLE");
        getLogger().info(ChatColor.YELLOW+"Author : ViezL");
        getLogger().info(" ");
        getCommand("aeupgrade").setExecutor(new AEGuiCommand(this));
        getServer().getPluginManager().registerEvents(new AEClickGui(),this);
        getServer().getPluginManager().registerEvents(new PlayerAEJoin(),this);
    }

    public void openGui(Player player){
        Inventory gui = Bukkit.createInventory(player, 54, ChatColor.AQUA + "NÂNG CẤP PHÙ PHÉP");
        ItemStack glass1 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemStack glass2 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemStack slot = new ItemStack(Material.BOOK);
        ItemStack slot2 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemStack confirm = new ItemStack(Material.ANVIL);

        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.GREEN+"Xác nhận nâng cấp");
        ArrayList<String> createlore3 = new ArrayList<>();
        createlore3.add(ChatColor.WHITE+"Nhấp vào để tiến hành nâng cấp");
        confirm_meta.setLore(createlore3);
        confirm.setItemMeta(confirm_meta);

        ItemMeta slot_meta = slot.getItemMeta();
        slot_meta.setDisplayName(ChatColor.YELLOW+"Ô phù phép");
        ArrayList<String> createlore = new ArrayList<>();
        createlore.add(ChatColor.GOLD+"Bỏ phù phép vào ô này để cường hóa");
        slot_meta.setLore(createlore);
        slot.setItemMeta(slot_meta);

        ItemMeta close_meta = close.getItemMeta();
        close_meta.setDisplayName(ChatColor.RED+"Đóng giao diện nâng cấp");
        ArrayList<String> createlore4 = new ArrayList<>();
        createlore4.add(ChatColor.LIGHT_PURPLE+"Nhấp vào để đóng");
        close_meta.setLore(createlore4);
        close.setItemMeta(close_meta);

        ItemMeta slot2_meta = slot2.getItemMeta();
        slot2_meta.setDisplayName(ChatColor.AQUA+"Ô đá cường hóa phù phép");
        ArrayList<String> createlore2 = new ArrayList<>();
        createlore2.add(ChatColor.DARK_AQUA+"Bỏ đá cường hóa vào đây");
        slot2_meta.setLore(createlore);
        slot2.setItemMeta(slot2_meta);
        for (int i = 0;i<54;i++){
            if(i<9 || i>44) {
                gui.setItem(i,glass2);
            }
            gui.setItem(i,glass1);
        }
        gui.setItem(9,glass2);
        gui.setItem(18,glass2);
        gui.setItem(17,glass2);
        gui.setItem(27,glass2);
        gui.setItem(26,glass2);
        gui.setItem(35,glass2);
        gui.setItem(36,glass2);
        gui.setItem(44,glass2);
        gui.setItem(20,slot2);
        gui.setItem(24,slot);
        gui.setItem(31,confirm);
        gui.setItem(49,close);
        player.openInventory(gui);
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.AQUA+"Há lô em =)) tắt mọe plugin chi v");
        getLogger().info(ChatColor.DARK_AQUA+"Dùng thì dùng không dùng thì cút =))");
        getLogger().info(ChatColor.BLUE+"Tắt mọe plugins đi");
    }
}
