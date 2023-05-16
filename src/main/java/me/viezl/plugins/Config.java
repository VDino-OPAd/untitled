package me.viezl.plugins;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static File file;
    private static FileConfiguration cf;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("UPGRADEAE").getDataFolder(),"UPGRADEAE");
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
            }
        }
        cf = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return cf;
    }

    public static void save(){
        try{
            cf.save(file);
        }catch (IOException e){
            System.out.println("Không lưu file được rồi");
        }
    }

    public static void reload(){
        cf = YamlConfiguration.loadConfiguration(file);
    }
}
