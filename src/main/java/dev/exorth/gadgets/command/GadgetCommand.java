package dev.exorth.gadgets.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GadgetCommand implements CommandExecutor {


    // Command cancel util
    public static boolean denyCommand(CommandSender sender, String denyMessage) {
        sender.sendMessage(denyMessage);
        return false;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        // Handling non-player command senders
        if (!(commandSender instanceof Player))
            return denyCommand(commandSender, "You must be a player to use this command");

        Player p = (Player) commandSender;

        // Handling bad args number
        if (args.length != 1)
            return denyCommand(p, "Usage: /gadgets [gadget name]");

        String gadgetCommand = args[0];

        // Handling bad gadget name
        if (!CanonGadget.getGadgetCommands().contains(gadgetCommand.toLowerCase()))
            return denyCommand(p, String.format("Usage: /gadgets [%s]", CanonGadget.getAvailableGadgetsUsage()));

        // Handling full inventory
        if (p.getInventory().firstEmpty() == -1)
            return denyCommand(p, "Your inventory is full!");

        // Giving gadget
        CanonGadget gadget = CanonGadget.getGadgetFromCommand(gadgetCommand);
        ItemStack gadgetItem = gadget.buildItem();
        p.getInventory().setItem(p.getInventory().firstEmpty(), gadgetItem);

        return true;
    }
}
