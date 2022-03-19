package com.exorth.util;

import com.exorth.Gadgets;
import org.bukkit.*;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.*;

public class GadgetsHelpers {

    // Detonate a firework at given location
    public static void spawnFirework(Location loc, Color color){

        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);

        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.setPower(2);
        fwm.addEffect(FireworkEffect.builder().withColor(color).flicker(true).build());
        fw.setFireworkMeta(fwm);

        fw.detonate();
    }

    // Load mobs spawning rates from given config section/type
    public static List<EntityType> loadMobs(String type) {
        List<EntityType> mobsList = new ArrayList<>();
        MemorySection configSection = (MemorySection) Gadgets.getInstance().getConfig().get(type);
        Map<String,Object> mobs = configSection.getValues(false);
        for(Map.Entry<String, Object> entry:mobs.entrySet())
            for(int i = 0; i < (Integer) entry.getValue(); i++)
                mobsList.add(EntityType.valueOf(entry.getKey().toUpperCase()));
        return mobsList;
    }

    // Given a list of mobs, returns a random one from the list
    public static EntityType getRandomMob(List<EntityType> entities){
        Random rand = new Random();
        return entities.get(rand.nextInt(entities.size()));
    }

    // Used to get random animal from animals list
    public static EntityType getRandomAnimal() {
        return getRandomMob(Gadgets.getInstance().animalProbs);
    }

    // Used to get random monster from monsters list
    public static EntityType getRandomMonster() {
        return getRandomMob(Gadgets.getInstance().monsterProbs);
    }

    // Given a location, it will find an air block around to safely spawn a mob
    public static Location findSafeSurrounding(Location loc, World world){

        // Retrieving rounded coordinates
        int hitX = loc.getBlockX();
        int hitY = loc.getBlockY();
        int hitZ = loc.getBlockZ();

        // If passed location isn't an air/safe block, we check surroundings
        if (world.getBlockAt(hitX,hitY,hitZ).getType() == Material.AIR){
            // Storing adjacent blocks coordinates
            int[] xSurroundings = {hitX+1, hitX-1};
            int[] ySurroundings = {hitY+1, hitY-1};
            int[] zSurroundings = {hitZ+1, hitZ-1};

            Boolean surroundingFound = false;
            // For each adjacent block
            for (int i = 0; i < xSurroundings.length && !surroundingFound; i++){
                int x = xSurroundings[i];
                for (int j = 0; j < ySurroundings.length && !surroundingFound; j++){
                    int y = ySurroundings[j];
                    for (int k = 0; k < zSurroundings.length && !surroundingFound; k++){
                        int z = zSurroundings[k];
                        // If it's an air block, we consider it safe
                        if(world.getBlockAt(x,y,z).getType() == Material.AIR){
                            loc = new Location(world, x+0.5, y+0.5, z+0.5);
                            surroundingFound = true;
                        }
                    }
                }
            }
        }
        // If passed location is an air/safe block, we use it
        else {
            loc = new Location(world, hitX+0.5, hitY+0.5, hitZ+0.5);
        }
        return loc;
    }

}
