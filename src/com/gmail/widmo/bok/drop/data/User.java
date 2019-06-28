package com.gmail.widmo.bok.drop.data;

import com.gmail.widmo.bok.drop.service.DropService;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private Map<Drop,Integer> enabled;

    public User(Player player){
        this.name = player.getName();
        this.enabled = new HashMap<Drop,Integer>();
        for(Drop drop : DropService.drops){
            this.enabled.put(drop,1);
        }
    }

    public String getName() {
        return name;
    }

    public Map<Drop, Integer> getEnabled() {
        return enabled;
    }

    public void setEnabled(Map<Drop, Integer> enabled) {
        this.enabled = enabled;
    }

    public void setName(String name) {
        this.name = name;
    }
}
