package com.gmail.widmo.bok.drop.service;

import com.gmail.widmo.bok.drop.data.Drop;
import com.gmail.widmo.bok.drop.files.DropFile;
import com.gmail.widmo.bok.drop.utils.ParseItemStackUtil;
import com.gmail.widmo.bok.drop.utils.Utils;
import com.google.common.collect.Lists;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class DropService {

    public static List<Drop> drops = Lists.newArrayList();

    public static void createDrop(String ID, String name, ItemStack drop, boolean fortune, int y, int exp, double chance)
    {
        drops.add(new Drop(ID,name,drop,fortune,y,exp,chance));
    }

    public static void load()
    {
        for(String ID : DropFile.getData().getConfigurationSection("drops").getKeys(false))
        {
            String name = DropFile.getData().getString("drops."+ID+".name");
            double chance = DropFile.getData().getDouble("drops."+ID+".chance");
            ItemStack drop = ParseItemStackUtil.parse(DropFile.getData().getString("drops."+ID+".drop"));
            boolean fortune = DropFile.getData().getBoolean("drops."+ID+".fortune");
            int y = DropFile.getData().getInt("drops."+ID+".y");
            int exp = DropFile.getData().getInt("drops."+ID+".exp");
            createDrop(ID,name,drop,fortune,y,exp,chance);
        }
    }

    public static Drop getDropByID(String ID)
    {
        return drops.stream().filter(d -> d.getID().equalsIgnoreCase(ID)).findAny().orElse(null);
    }

    public static Drop getDropByInvItem(String displayName)
    {
        return drops.stream().filter(d -> Utils.c("&c» &b"+d.getName()).equalsIgnoreCase(displayName)).findAny().orElse(null);
    }


}
