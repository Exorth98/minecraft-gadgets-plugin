package com.exorth.event;

import com.exorth.command.CanonGadget;
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

        // Check event conformity
        if (a == Action.PHYSICAL || event.getItem() == null)
            return;

        // Check if item is a gadget
        ItemStack item = event.getItem();
        CanonGadget gadget = CanonGadget.getGadgetFromItem(item);

        if (gadget != null){
            // Launch a snaball from the player, with a special name (name of gadget)
            Snowball snowball = p.launchProjectile(Snowball.class);
            snowball.setCustomName(gadget.name());
        }
    }
}
