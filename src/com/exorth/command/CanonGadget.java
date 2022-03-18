package com.exorth.command;

import com.exorth.Gadgets;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CanonGadget {

    ANIMALCANON("animalcanon", "Animal Canon","Throws a random animal egg", Material.IRON_HORSE_ARMOR),
    MONSTERCANON("monstercanon", "Monster Canon","Throws a random monster egg", Material.GOLDEN_HORSE_ARMOR),
    CAPTURECANON("capturecanon", "Capture Canon","Capture any mob in an egg", Material.DIAMOND_HORSE_ARMOR);

    private final String commandArgName;
    private final String name;
    private final String description;
    private final Material material;

    CanonGadget(String commandArgName, String name, String description, Material material){
        this.commandArgName = commandArgName;
        this.name = name;
        this.description = description;
        this.material = material;
    }

    public ItemStack buildItem(){
        ItemStack gadgetItem = new ItemStack(this.material, 1);
        ItemMeta gadgetMeta = gadgetItem.getItemMeta();

        gadgetMeta.addEnchant(Enchantment.DURABILITY,1,false);
        gadgetMeta.setDisplayName(this.name);
        gadgetMeta.setLore(Arrays.asList(this.description));
        gadgetItem.setItemMeta(gadgetMeta);

        return gadgetItem;
    }

    public static List<String> getGadgetCommands() {
        List<String> names = new ArrayList<>();
        for (CanonGadget gadget : values()) {
            names.add(gadget.commandArgName);
        }
        return names;
    }

    public static String getAvailableGadgetsUsage() {
        return String.join("/", getGadgetCommands());
    }

    public static CanonGadget getGadgetFromCommand(String commandArg) {
        CanonGadget result = null;
        for (CanonGadget gadget : values()) {
            if (commandArg.equalsIgnoreCase(gadget.commandArgName)) {
                result = gadget;
            }
        }
        // Should never be null since commandArgs is from with getGadgetNames()
        return result;
    }


}
