package com.gmail.widmo.bok.drop.utils;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ParseItemStackUtil {

    public static ItemStack parse(String string){
        ItemStack is = new ItemStack(Material.AIR);
        String[] strings = string.split(" ");
        String[] materialAndData = strings[0].split(";");
        is.setType(Material.getMaterial(Integer.parseInt(materialAndData[0])));
        is.setDurability(Short.parseShort(materialAndData[1]));
        int amount = 0;
        if(Utils.isInteger(strings[1])){
            amount = Integer.parseInt(strings[1]);
        }
        is.setAmount(amount);
        for(int i = 2; i < strings.length; i++)
        {
            String s = strings[i];
            String[] trims = s.split(";");
            if(trims.length>=1){
                if(trims[0].equalsIgnoreCase("nazwa")){
                    ItemMeta meta = is.getItemMeta();
                    meta.setDisplayName(Utils.c(trims[1].replace("_"," ")));
                    is.setItemMeta(meta);
                }
                if(trims[0].equalsIgnoreCase("opis")){
                    ItemMeta meta = is.getItemMeta();
                    List<String> lore = Lists.newArrayList();
                    String[] lores = trims[1].split("%NL%");
                    for(String s1 : lores){
                        lore.add(Utils.c(s1));
                    }
                    meta.setLore(lore);
                    is.setItemMeta(meta);
                }
            }
        }
        return is;
    }
}
