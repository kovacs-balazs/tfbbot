package me.koba1.tfbdiscord.Other;

import me.koba1.tfbdiscord.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Webshop implements CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("webshop")) {
            m.reloadConfig();
            sender.sendMessage(" ");
            sender.sendMessage(rgb(m.getConfig().getString("webshop")));
            sender.sendMessage(" ");
        }
        return false;
    }

    private final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    private String rgb(String msg) {
        Matcher match = pattern.matcher(msg);
        while (match.find()) {
            String color = msg.substring(match.start(), match.end());
            msg = msg.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            match = pattern.matcher(msg);
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
