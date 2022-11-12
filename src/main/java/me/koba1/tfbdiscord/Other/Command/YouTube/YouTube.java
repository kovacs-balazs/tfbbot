package me.koba1.tfbdiscord.Other.Command.YouTube;

import me.koba1.tfbdiscord.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class YouTube implements CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("stream")) {
            if(sender instanceof Player) {
                if(sender.hasPermission("youtube.use")) {
                    m.getServer().broadcastMessage(" ");
                    m.getServer().broadcastMessage(format(replace(m.getConfig().getString("youtube-stream"), ((Player) sender), args[0])));
                    m.getServer().broadcastMessage(" ");
                }
            }
        }
        else if(cmd.getName().equalsIgnoreCase("video")) {
            if(sender instanceof Player) {
                if(sender.hasPermission("youtube.use")) {
                    m.getServer().broadcastMessage(" ");
                    m.getServer().broadcastMessage(format(replace(m.getConfig().getString("youtube-video"), ((Player) sender), args[0])));
                    m.getServer().broadcastMessage(" ");
                }
            }
        }
        return false;
    }

    public static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String replace(String msg, Player p, String link) {
        return msg.replaceAll("%player_name%", p.getName()).replaceAll("%link%", link);
    }
}
