package me.koba1.tfbdiscord.Other;

import me.koba1.tfbdiscord.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;;

public class LobbyCMD implements CommandExecutor, Listener {
    private Main m = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("hub")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                Location loc = new Location(Bukkit.getWorld("lobby_map"), 1.5, 77.09380, 12.5, (float) 128.3, (float) -10.7);
                if(args.length == 0) {
                    if(!Main.hubCoold.containsKey(p.getUniqueId())) {
                        p.teleport(loc);
                        p.sendMessage("§aTeleportálás az elosztóba!");
                        Main.hubCoold.put(p.getUniqueId(), true);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Main.hubCoold.remove(p.getUniqueId());
                            }
                        }.runTaskLater(m, 60L);
                    } else {
                        p.sendMessage("§cVárj mielőtt újra használnád!");
                    }
                }
                //
                else if(args.length == 1) {
                    if(p.hasPermission("hub.teleport.other")) {
                        try {
                            Player target = Bukkit.getPlayer(args[0]);
                            target.teleport(loc);
                            target.sendMessage("§aTeleportálás az elosztóba!");
                            p.sendMessage("§aTeleportálás az elosztóba: " + target.getName() + "!");
                        } catch (NullPointerException e) {
                            p.sendMessage("§cEz a játékos nem elérhető!");
                        }
                    }
                }
            }
        }
        return false;
    }
}
