package me.koba1.tfbdiscord.Other.Command;

import me.koba1.tfbdiscord.Main;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlotsRoom implements CommandExecutor, TabCompleter {
    public static ArrayList rooms = new ArrayList() {{
        add("red");
        add("green");
        add("brown");
    }};

    private Main m = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("room")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(sender.hasPermission("plot.room.use")) {
                    if(args.length == 3) {
                        if (Bukkit.getPlayer(args[2]) != null) {
                            Player target = (Player) Bukkit.getPlayer(args[2]);
                            if (rooms.contains(args[1].toLowerCase())) {
                                if (args[0].equalsIgnoreCase("add")) {
                                    if(!Main.api.getUserManager().getUser(target.getUniqueId()).getCachedData().getPermissionData().getPermissionMap().containsKey("group." + args[1] + "_room")) {
                                        Main.api.getUserManager().modifyUser(target.getUniqueId(), user -> {
                                            if(!user.data().add(Node.builder("group." + args[1] + "_room").build()).wasSuccessful())
                                                p.sendMessage("§cValami nem sikerült!");
                                                return;
                                        });
                                        p.sendMessage("§aJátékos sikeresen hozzáadva!");
                                        p.performCommand("plots add " + target.getName());
                                    } else {
                                        sender.sendMessage("§cA játékos már hozzá van adva");
                                    }
                                }
                                //
                                else if (args[0].equalsIgnoreCase("remove")) {
                                    if(Main.api.getUserManager().getUser(target.getUniqueId()).getCachedData().getPermissionData().getPermissionMap().containsKey("group." + args[1] + "_room")) {
                                        Main.api.getUserManager().modifyUser(target.getUniqueId(), user -> {
                                            if(!user.data().remove(Node.builder("group." + args[1] + "_room").build()).wasSuccessful())
                                                p.sendMessage("§cValami nem sikerült!");
                                                return;
                                        });
                                        p.performCommand("plots remove " + target.getName());
                                        p.sendMessage("§aJátékos sikeresen eltávolítva!");
                                    } else {
                                        sender.sendMessage("§cA játékos nincs hozzáadva");
                                    }
                                }
                            }
                        } else {
                            sender.sendMessage("§cEz a játékos nem elérhető!");
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String alias, @NotNull String[] args) {
        if(args.length == 1) {
            if(sender.hasPermission("plot.room.use")) {
                return Arrays.asList("add", "remove");
            }
        }
        if(args.length == 2) {
            if(sender.hasPermission("plot.room.use")) {
                return Arrays.asList("red", "green", "brown");
            }
        }
        return null;
    }
}
