package com.exorth.event;

import com.exorth.Gadgets;
import com.exorth.command.CanonGadget;
import com.exorth.util.GadgetsHelpers;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SnowballEvent implements Listener {

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event) {

        if (event.getEntity() instanceof Snowball){

            Projectile snowball = (Projectile) event.getEntity();
            ProjectileSource snowball_source = (ProjectileSource)  snowball.getShooter();

            if (snowball_source instanceof Player){

                // Player thrower = (Player) snowball_source;

                // Checking if snowball has a custom name corresponding to a gadget
                String snowballName = snowball.getCustomName();
                List<String> gadgets = Stream.of(CanonGadget.values()).map(CanonGadget::name).toList();

                if (gadgets.contains(snowballName)) {

                    // Getting information about event location
                    Location hitLoc = event.getEntity().getLocation();
                    String worldName = hitLoc.getWorld().getName();
                    World hitWorld = Gadgets.getInstance().getServer().getWorld(worldName);

                    // Usefull for spawning a mob: getting safe surroundings
                    Location safeSurrounding = GadgetsHelpers.findSafeSurrounding(hitLoc, hitWorld);

                    // Spawning animal
                    if (snowballName.equals("ANIMAL_CANON")){
                        hitWorld.spawnEntity(safeSurrounding, GadgetsHelpers.getRandomAnimal());
                        GadgetsHelpers.spawnFirework(safeSurrounding, Color.LIME);
                    }
                    // Spawning monser
                    else if (snowballName.equals("MONSTER_CANON")){
                        hitWorld.spawnEntity(safeSurrounding, GadgetsHelpers.getRandomMonster());
                        GadgetsHelpers.spawnFirework(safeSurrounding, Color.RED);
                    }
                    // Capturing mob
                    else {
                        Entity shotEntity = event.getHitEntity();
                        if(shotEntity != null){
                            // Get EntityType enum name (ex: ZOMBIE, PIG, etc)
                            String entityTypeName = shotEntity.getType().name();
                            try {
                                // Dropping corresponding mob egg
                                Material entity_egg = Material.valueOf(String.format("%s_SPAWN_EGG", entityTypeName));
                                hitWorld.dropItem(shotEntity.getLocation(),new ItemStack(entity_egg));
                                GadgetsHelpers.spawnFirework(shotEntity.getLocation(), Color.AQUA);
                                shotEntity.remove();
                            }
                            catch(Exception e){}
                        }
                    }
                }
            }
        }
    }
}
