package com.gmail.widmo.bok.drop.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;

public class CommandManager {

    public static CommandMap commandMap;

    public static void registerCommand(Command command)
    {
        if(commandMap==null){
            try {
                Field field = SimplePluginManager.class.getDeclaredField("commandMap");
                field.setAccessible(true);
                commandMap = (CommandMap) field.get(Bukkit.getServer().getPluginManager());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        commandMap.register("drop",command);
    }

    public static void registerCommands(Command... commands){
        for(Command command : commands){
            registerCommand(command);
        }
    }


}
