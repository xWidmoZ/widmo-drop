package com.gmail.widmo.bok.drop.utils;

import org.bukkit.ChatColor;

public class Utils {

    public static String c(String s){ return ChatColor.translateAlternateColorCodes('&',s); }

    public static boolean isInteger(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch(NumberFormatException e){

        }
        return false;
    }
}
