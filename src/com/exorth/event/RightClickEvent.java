package com.exorth.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RightClickEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {

        Player p = event.getPlayer();
        Action a = event.getAction();
        if ( a == Action.PHYSICAL || event.getItem() == null)
            return;

        ItemStack item = event.getItem();
        Snowball snowball = p.launchProjectile(Snowball.class);
        snowball.setCustomName("yoyo");

    }
}
