package com.gmail.widmo.bok.drop.command.commands;

import com.gmail.widmo.bok.drop.command.CommandExc;
import com.gmail.widmo.bok.drop.data.Drop;
import com.gmail.widmo.bok.drop.data.User;
import com.gmail.widmo.bok.drop.service.DropService;
import com.gmail.widmo.bok.drop.service.UserService;
import com.gmail.widmo.bok.drop.utils.Utils;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class DropCommand extends CommandExc {

    public DropCommand() {
        super("drop", "Komena na sprawdzenie dropu!", "/drop", Lists.newArrayList());
    }

    @Override
    public boolean execute(CommandSender commandSender, String arg, String[] args) {
        openGui((Player)commandSender);
        return false;
    }

    public static void openGui(Player player){
        User u = UserService.getUser(player);
        Inventory inventory = Bukkit.createInventory(null,27, Utils.c("&cDrop z kamienia"));
        for(Drop drop : DropService.drops){
            ItemStack itemStack = new ItemStack(drop.getDrop().getType(),1,drop.getDrop().getDurability());{
                ItemMeta meta = itemStack.getItemMeta();
                meta.setDisplayName(Utils.c("&c» &b"+drop.getName()+""));
                List<String> lore = Lists.newArrayList();

                lore.add(Utils.c("&bSzansa: &6"+ drop.getChance()+"%"));
                lore.add(Utils.c("&bPoniżej poziomu: &6"+drop.getY()));
                lore.add(Utils.c("&bDoświadczenie: &6"+drop.getExp()));
                lore.add(Utils.c("&bFortune: "+ (drop.isFortune() ? "&aTak" : "&cNie")));
                lore.add(Utils.c("&bDrop: "+ (u.getEnabled().get(drop) == 1 ? "&aWlaczony" : "&cWylaczony")));

                meta.setLore(lore);
                itemStack.setItemMeta(meta);
            }
            inventory.addItem(itemStack);
        }
        player.openInventory(inventory);
    }
}
