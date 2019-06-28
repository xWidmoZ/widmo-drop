package com.gmail.widmo.bok.drop.files;

import com.gmail.widmo.bok.drop.Plugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static File file;
    public static FileConfiguration data;

    public static void setup(Plugin plugin){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

        file = new File(plugin.getDataFolder(), "config.yml");

        if(!file.exists()){
            plugin.saveResource("config.yml", true);
        }

        data = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getData()
    {
        return data;
    }

    public static void saveData()
    {
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadData()
    {
        data = YamlConfiguration.loadConfiguration(file);
    }


}
