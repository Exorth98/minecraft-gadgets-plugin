package com.exorth.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class GadgetsHelpers {

    public static Location findSafeSurrounding(Location loc, World world){

        // Retrieving rounded coordinates
        int hitX = loc.getBlockX();
        int hitY = loc.getBlockY();
        int hitZ = loc.getBlockZ();

        // If passed location isn't an air/safe block, we check surroundings
        if (world.getBlockAt(hitX,hitY,hitZ).getType() != Material.AIR){
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
