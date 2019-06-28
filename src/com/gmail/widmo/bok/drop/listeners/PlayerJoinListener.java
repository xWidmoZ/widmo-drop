package com.gmail.widmo.bok.drop.listeners;

import com.gmail.widmo.bok.drop.service.UserService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        UserService.createUser(event.getPlayer());
    }

}
