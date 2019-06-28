package com.gmail.widmo.bok.drop.listeners;

import com.gmail.widmo.bok.drop.data.Drop;
import com.gmail.widmo.bok.drop.data.User;
import com.gmail.widmo.bok.drop.service.DropService;
import com.gmail.widmo.bok.drop.service.UserService;
import com.gmail.widmo.bok.drop.utils.RandomUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        User user = UserService.getUser(player);
        if(event.getBlock().getType().equals(Material.STONE)){
            for(Drop drop : DropService.drops){
                if(event.getBlock().getY()>drop.getY()) continue;
                if(RandomUtil.getChance(drop.getChance())){
                    if(user.getEnabled().get(drop)==1){
                        int amount = 1;
                        if(drop.isFortune()){
                            int lvl = event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                            if(lvl>0){
                                amount = RandomUtil.getRandomInteger(1,(lvl+1));
                            }
                        }
                        ItemStack itemStack = new ItemStack(drop.getDrop());
                        itemStack.setAmount(amount);
                        player.getInventory().addItem(itemStack);
                        player.giveExp(drop.getExp());
                    }
                }
            }
            return;
        }
    }
}
