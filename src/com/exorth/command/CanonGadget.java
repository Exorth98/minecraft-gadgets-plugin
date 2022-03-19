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

    ANIMAL_CANON("animalcanon", "Animal Canon","Throws a random animal egg", Material.IRON_HORSE_ARMOR),
    MONSTER_CANON("monstercanon", "Monster Canon","Throws a random monster egg", Material.GOLDEN_HORSE_ARMOR),
    CAPTURE_CANON("capturecanon", "Capture Canon","Capture any mob in an egg", Material.DIAMOND_HORSE_ARMOR);

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

    // Build Itemstack for gadget
    public ItemStack buildItem(){
        ItemStack gadgetItem = new ItemStack(this.material, 1);
        ItemMeta gadgetMeta = gadgetItem.getItemMeta();

        gadgetMeta.addEnchant(Enchantment.DURABILITY,1,false);
        gadgetMeta.setDisplayName(this.name);
        gadgetMeta.setLore(Arrays.asList(this.description));
        gadgetItem.setItemMeta(gadgetMeta);

        return gadgetItem;
    }

    // Returuns all possible gadgets command args
    public static List<String> getGadgetCommands() {
        List<String> names = new ArrayList<>();
        for (CanonGadget gadget : values()) {
            names.add(gadget.commandArgName);
        }
        return names;
    }

    // Small util function to display available gadget command args
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

    // Check if an Itemstack is representative of a gadget
    public static CanonGadget getGadgetFromItem(ItemStack item) {
        CanonGadget result = null;
        for (CanonGadget gadget : values()) {
            if (gadget.buildItem().isSimilar(item)) {
                result = gadget;
            }
        }
        // Should never be null since commandArgs is from with getGadgetNames()
        return result;
    }


}
