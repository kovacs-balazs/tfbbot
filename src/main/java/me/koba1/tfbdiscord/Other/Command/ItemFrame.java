package me.koba1.tfbdiscord.Other.Command;

import me.koba1.tfbdiscord.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class ItemFrame implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("itemframe")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    Main.getPlugin(Main.class).getServer().dispatchCommand(Main.getPlugin(Main.class).getServer().getConsoleSender(),
                            "minecraft:give " + p.getName() + " item_frame{EntityTag:{Invisible:1}} 1");
                }
            }
        }
        return false;
    }
}
