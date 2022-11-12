package me.koba1.tfbdiscord.Other.FAWESelection;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.function.pattern.RandomPattern;
import com.sk89q.worldedit.internal.annotation.Selection;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RightClickEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getPlayer().getItemInHand() != null) {
                if (e.getPlayer().getItemInHand().getType() != null) {
                    if (e.getPlayer().getItemInHand().getType() != Material.AIR) {
                        if (e.getPlayer().getItemInHand().getType() == Material.SPECTRAL_ARROW) {
                            if (e.getPlayer().getItemInHand().hasItemMeta()) {
                                if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6WEBot")) {
                                    Player p = (Player) e.getPlayer();

                                    WorldEditPlugin we = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("FastAsyncWorldEdit");
                                    if (we == null)
                                        return;

                                    try {

                                        LocalSession session = WorldEditPlugin.getInstance().getSession(p);
                                        World world = session.getSelectionWorld();
                                    /*try {
                                        CuboidRegion selection = new CuboidRegion(world, BlockVector3.at(0, 80, 0), BlockVector3.at(10, 80, 10));
                                        try (EditSession editSession = WorldEditPlugin.getInstance().createEditSession(p)) {
                                            world.regenerate(selection, editSession);
                                            editSession.flushQueue();
                                        }
                                    } catch (Exception exception) {

                                    }*/
                                    } catch (Exception e1) {

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void asd() {

    }
}
