package me.koba1.tfbdiscord.Other.Command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Barrier implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("barrier")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.getInventory().addItem(new ItemStack(Material.BARRIER));
                } else if (args.length == 1) {
                    if (args[0].matches("^[0-9]+$")) {
                        p.getInventory().addItem(new ItemStack(Material.BARRIER, Integer.parseInt(args[0])));
                    }
                }
            }
        }
        return false;
    }
}
