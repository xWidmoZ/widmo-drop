package com.gmail.widmo.bok.drop;

import com.gmail.widmo.bok.drop.command.CommandManager;
import com.gmail.widmo.bok.drop.command.commands.DropCommand;
import com.gmail.widmo.bok.drop.files.Config;
import com.gmail.widmo.bok.drop.files.DropFile;
import com.gmail.widmo.bok.drop.listeners.BlockBreakListener;
import com.gmail.widmo.bok.drop.listeners.InventoryClickListener;
import com.gmail.widmo.bok.drop.listeners.PlayerJoinListener;
import com.gmail.widmo.bok.drop.service.DropService;
import com.gmail.widmo.bok.drop.service.UserService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable()
    {
        plugin = this;
        Config.setup(this);
        DropFile.setup(this);
        DropService.load();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(),this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(),this);
        CommandManager.registerCommands(new DropCommand());
        if(Bukkit.getOnlinePlayers().size()>0){
            for(Player player : Bukkit.getOnlinePlayers()){
                UserService.createUser(player);
            }
        }
    }

    public static Plugin getPlugin()
    {
        return plugin;
    }


}
