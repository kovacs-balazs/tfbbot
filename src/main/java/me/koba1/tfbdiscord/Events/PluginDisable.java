package me.koba1.tfbdiscord.Events;

import me.koba1.tfbdiscord.Main;
import me.koba1.tfbdiscord.SetupBot;
import me.koba1.tfbdiscord.Statusz.ShutdownEdit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

public class PluginDisable implements Listener {

    private Main m = Main.getPlugin(Main.class);

    @EventHandler
    public void onPluginDisable(PluginDisableEvent e) {
        if(e.getPlugin().getName().equalsIgnoreCase("TFBDiscord")) {
            m.getConfig().set("server-status", false);
            m.saveConfig();
            new ShutdownEdit().shutdown(SetupBot.TFBGuild.getTextChannelById("953751053298438157"));
        }
    }
}
