package me.koba1.tfbdiscord.Other;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockPlugins implements Listener {

    @EventHandler
    public void onPlayerCMD(PlayerCommandPreprocessEvent e) {
        String[] args = e.getMessage().split(" ");
        if (args[0].equalsIgnoreCase("/pl") || args[0].equalsIgnoreCase("/plugins")
                || args[0].equalsIgnoreCase("/ver") || args[0].equalsIgnoreCase("/version")
                || args[0].equalsIgnoreCase("/about") || args[0].equalsIgnoreCase("/icanhasbukkit")
                || args[0].equalsIgnoreCase("/minecraft:help") || args[0].equalsIgnoreCase("/bukkit:pl")
                || args[0].equalsIgnoreCase("/bukkit:plugins") || args[0].equalsIgnoreCase("/bukkit:about")
                || args[0].equalsIgnoreCase("/bukkit:ver") || args[0].equalsIgnoreCase("/bukkit:version")
                || args[0].equalsIgnoreCase("/minecraft:me") || args[0].equalsIgnoreCase("/bukkit")
                || args[0].equalsIgnoreCase("icanhasbukkit") || args[0].equalsIgnoreCase("/?")
                || args[0].equalsIgnoreCase("/bukkit:?") || args[0].equalsIgnoreCase("/bukkit:help")
                || args[0].equalsIgnoreCase("/help")) {
            if (!e.getPlayer().isOp() && !(e.getPlayer().hasPermission("blockedpl.bypass"))) {
                e.setCancelled(true);
                e.getPlayer().sendMessage("§fPlugins (9): §aTFBDiscord§f, §aTFBTimeStats§f, §aTFBScoreboard§f, §aTFBMenu" +
                        "§f, §aTFBMaintenance§f, §aTFBChatReaction§f, §aTFBParkour§f, §aTFBJoin§f, §aTFBEffect§f");
            }
        }
        //
        else if (args[0].equalsIgnoreCase("plotme") || args[0].equalsIgnoreCase("plot")
                || args[0].equalsIgnoreCase("plotsquared") || args[0].equalsIgnoreCase("plots")
                || args[0].equalsIgnoreCase("p") || args[0].equalsIgnoreCase("2")
                || args[0].equalsIgnoreCase("ps") || args[0].equalsIgnoreCase("p2")) {
            if (!(e.getPlayer().isOp()) && !(e.getPlayer().hasPermission("plotscmd.use.bypass"))) {
                if (!e.getPlayer().getWorld().getName().equalsIgnoreCase("plots")) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage("§cEzt ebben a világban nem használhatod!");
                }
            }
        }
    }
}
