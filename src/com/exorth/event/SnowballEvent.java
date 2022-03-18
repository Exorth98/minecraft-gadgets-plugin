package com.exorth.event;

import com.exorth.Gadgets;
import com.exorth.util.GadgetsHelpers;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class SnowballEvent implements Listener {

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball){

            Projectile snowball = (Projectile) event.getEntity();
            ProjectileSource snowball_source = (ProjectileSource)  snowball.getShooter();

            if (snowball_source instanceof Player){

                Player thrower = (Player) snowball_source;

                thrower.sendMessage(snowball.getCustomName());

                Location hitLoc = event.getEntity().getLocation();
                String worldName = hitLoc.getWorld().getName();
                World hitWorld = Gadgets.getInstance().getServer().getWorld(worldName);

                Location safeSurrounding = GadgetsHelpers.findSafeSurrounding(hitLoc, hitWorld);
                hitWorld.spawnEntity(safeSurrounding, EntityType.RABBIT);
            }
        }
    }
}
