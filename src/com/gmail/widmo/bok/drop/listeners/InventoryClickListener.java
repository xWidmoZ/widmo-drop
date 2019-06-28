package com.gmail.widmo.bok.drop.listeners;

import com.gmail.widmo.bok.drop.command.commands.DropCommand;
import com.gmail.widmo.bok.drop.data.Drop;
import com.gmail.widmo.bok.drop.data.User;
import com.gmail.widmo.bok.drop.service.DropService;
import com.gmail.widmo.bok.drop.service.UserService;
import com.gmail.widmo.bok.drop.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        if(event.getInventory()==null) return;
        if(!event.getInventory().getName().equalsIgnoreCase(Utils.c("&cDrop z kamienia"))) return;
        Player player = (Player) event.getWhoClicked();
        User user = UserService.getUser(player);
        if(event.getCurrentItem()==null) return;
        event.setCancelled(true);
        if(event.getCurrentItem().getItemMeta()==null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName()==null) return;
        Drop d = DropService.getDropByInvItem(event.getCurrentItem().getItemMeta().getDisplayName());
        if(d!=null){
            if(user.getEnabled().get(d)==1) {
                user.getEnabled().put(d, 0);
            }else{
                user.getEnabled().put(d,1);
            }
            DropCommand.openGui(player);
        }
    }
}
