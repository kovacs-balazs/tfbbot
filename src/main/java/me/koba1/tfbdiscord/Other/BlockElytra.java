package me.koba1.tfbdiscord.Other;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BlockElytra implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if(e.getCurrentItem() != null) {
            if(e.getCurrentItem().getType() != null) {
                if(e.getCurrentItem().getType() == Material.ELYTRA) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
