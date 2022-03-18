package com.exorth;

import com.exorth.command.GadgetCommand;
import com.exorth.event.RightClickEvent;
import com.exorth.event.SnowballEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Gadgets extends JavaPlugin {

    public static Gadgets instance;

    @Override
    public void onEnable() {

        super.onEnable();
        instance = this;

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
