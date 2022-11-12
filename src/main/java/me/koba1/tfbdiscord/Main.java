package me.koba1.tfbdiscord;

import me.koba1.tfbdiscord.Events.PluginDisable;
import me.koba1.tfbdiscord.Other.*;
import me.koba1.tfbdiscord.Other.Command.Barrier;
import me.koba1.tfbdiscord.Other.Command.DebugStick;
import me.koba1.tfbdiscord.Other.Command.ItemFrame;
import me.koba1.tfbdiscord.Other.Command.PlotsRoom;
import me.koba1.tfbdiscord.Other.Command.YouTube.YouTube;
import me.koba1.tfbdiscord.Other.FAWESelection.RightClickEvent;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static HashMap<UUID, Boolean> hubCoold = new HashMap();
    public static LuckPerms api;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().set("server-status", true);
        getConfig().addDefault("discordmsg", "#1889ffC#1a89fes#1b89fda#1d8afct#1f8afbl#208afaa#228af8k#248bf7o#268bf6z#278bf5z #298bf4d#2b8cf3i#2c8cf2s#2e8cf1c#308cf0o#318cefr#338dedd#358decu#368debn#388deak#3a8ee9h#3c8ee8o#3d8ee7z#3f8ee6: #9C9AB7https://discord.gg/WRCty78RdV");
        getConfig().addDefault("discordmsg", "#1889ffC#1a89fes#1b89fda#1d8afct#1f8afbl#208afaa#228af8k#248bf7o#268bf6z#278bf5z #298bf4d#2b8cf3i#2c8cf2s#2e8cf1c#308cf0o#318cefr#338dedd#358decu#368debn#388deak#3a8ee9h#3c8ee8o#3d8ee7z#3f8ee6: #9C9AB7https://discord.gg/WRCty78RdV");
        getConfig().addDefault("youtube-video", "§8[§4You§fTube§8] §c%player_name% §7egy új videót töltött fel, nézzétek meg: §c%link%");
        getConfig().addDefault("youtube-stream", "§8[§eStream§8] §c%player_name% §7épp streamel! Gyertek és csekkoljátok: §c%link%");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        saveConfig();
        SetupBot.main(null);

        getServer().getPluginManager().registerEvents(new PluginDisable(), this);
        getServer().getPluginManager().registerEvents(new BlockPlugins(), this);
        getServer().getPluginManager().registerEvents(new BlockElytra(), this);

        //getServer().getPluginManager().registerEvents(new RightClickEvent(), this);


        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }

        getCommand("discord").setExecutor(new Discord());
        getCommand("hub").setExecutor(new LobbyCMD());
        getCommand("webshop").setExecutor(new Webshop());

        getCommand("barrier").setExecutor(new Barrier());
        getCommand("debugstick").setExecutor(new DebugStick());
        getCommand("itemframe").setExecutor(new ItemFrame());

        getCommand("video").setExecutor(new YouTube());
        getCommand("stream").setExecutor(new YouTube());

        getCommand("room").setExecutor(new PlotsRoom());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
