package com.gmail.widmo.bok.drop.service;

import com.gmail.widmo.bok.drop.data.User;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static Map<String, User> users = new HashMap<String,User>();

    public static void createUser(Player player)
    {
        if(getUser(player)==null){
            users.put(player.getName(),new User(player));
        }
    }

    public static User getUser(Player player){
        return users.get(player.getName());
    }

    public static User getUser(String name){
        return users.get(name);
    }

}
