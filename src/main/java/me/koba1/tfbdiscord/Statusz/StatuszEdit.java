package me.koba1.tfbdiscord.Statusz;

import me.koba1.tfbdiscord.Main;
import me.koba1.tfbdiscord.SetupBot;
import me.koba1.tfbmaintenance.TFBMaintenanceAPI;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StatuszEdit {

    private Main m = Main.getPlugin(Main.class);

    public void startserver(boolean statusz, TextChannel channel) {
        new BukkitRunnable() {
            @Override
            public void run() {
                embed(statusz, channel);
            }
        }.runTaskTimer(m, 0, 300L);
    }

    public EmbedBuilder embed(boolean statusz, TextChannel channel) {
        TextChannel rules = SetupBot.TFBGuild.getTextChannelById("953751053298438159");
        EmbedBuilder embed = new EmbedBuilder()
                .setColor((statusz ? new Color(0, 255, 0) : new Color(255, 0, 0)))
                .setAuthor("The Forbidden Builders státusza", null, SetupBot.TFBGuild.getIconUrl())
                .setDescription("**" + "Szerver információk:" + "**"
                        + "\n*Mielőtt játszanál olvasd el a szabályzatot: " + rules.getAsMention() + "!*\nA szerverünk lényege, hogy építészeti tanácsokat, tippeket, trükköket " +
                        "rendszerezünk és osztunk meg a játékosainkkal.\nStaffjaink segítenek építeni, elindulni az úton.")
                .addField("Szerver státusz:", (statusz ? ":white_check_mark: Elérhető" : ":x: Nem elérhető"), true)
                .addField("Szerver ip", "forbiddenbuilders.ouimc.eu", true)
                .addField("Verzió:", "1.18.X", true)
                .addField((TFBMaintenanceAPI.isEnable() ? "Karbantartás" : ""), (TFBMaintenanceAPI.isEnable() ? "Bekapcsolva" : ""), true)
                .addField("Weboldal", "forbiddenbuilders.tebex.io", true)
                .addField("Eléhető játékosok:", Bukkit.getOnlinePlayers().size() + "/150", true);
        generatePlayerList();
        embed.addField("Játékosok:", playerListA, true)
                .addField("", playerListB, true)
                .addField("", playerListC, true)
                .addBlankField(true)
                .setThumbnail(SetupBot.TFBGuild.getIconUrl())
                .setFooter(timeanddateformat(), SetupBot.TFBGuild.getIconUrl());
        channel.editMessageEmbedsById("953759071159320637", embed.build()).submit();
        return embed;
    }

    public String timeanddateformat() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.GERMAN);
        Date date = new Date();
        return "The Forbidden Builders" + " • " + formatter.format(date);
    }

    public static String playerListA = " ";
    public static String playerListB = " ";
    public static String playerListC = " ";

    public void generatePlayerList() {
        playerListA = "";
        playerListB = "";
        playerListC = "";
        int counterA = 1;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if(counterA == 1) {
                playerListA += (p.getName() + "\n");
            }
            else if(counterA == 2) {
                playerListB += p.getName() + "\n";
            }
            if(counterA % 3 == 0) {
                playerListC += p.getName() + "\n";
                counterA = 0;
            }
            counterA++;
        }
    }
}
