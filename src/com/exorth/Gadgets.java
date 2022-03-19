package com.exorth;

import com.exorth.command.GadgetCommand;
import com.exorth.event.RightClickEvent;
import com.exorth.event.SnowballEvent;
import com.exorth.util.GadgetsHelpers;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Gadgets extends JavaPlugin {

    // Plugin useful variables
    public static Gadgets instance;
    public static List<EntityType> animalProbs;
    public static List<EntityType> monsterProbs;

    @Override
    public void onEnable() {

        // Basic startup
        super.onEnable();
        instance = this;

        // Loading configs
        this.saveDefaultConfig();
        animalProbs = GadgetsHelpers.loadMobs("animals_prob");
        monsterProbs = GadgetsHelpers.loadMobs("monsters_prob");

        // Registration of Events and Commands
        Bukkit.getPluginManager().registerEvents(new SnowballEvent(), this);
        Bukkit.getPluginManager().registerEvents(new RightClickEvent(), this);
        getCommand("gadgets").setExecutor(new GadgetCommand());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Gadgets getInstance(){
        return instance;
    }
}
