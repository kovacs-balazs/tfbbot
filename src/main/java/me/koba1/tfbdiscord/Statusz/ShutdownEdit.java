package me.koba1.tfbdiscord.Statusz;

import me.koba1.tfbdiscord.Main;
import me.koba1.tfbdiscord.SetupBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.w3c.dom.Text;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ShutdownEdit {

    private Main m = Main.getPlugin(Main.class);

    public void shutdown(TextChannel channel) {
        TextChannel rules = SetupBot.TFBGuild.getTextChannelById("953751053298438159");
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(new Color(255, 0, 0))
                .setAuthor("The Forbidden Builders státusza", null, SetupBot.TFBGuild.getIconUrl())
                .setDescription("**" + "Szerver információk:" + "**"
                        + "\n*Mielőtt játszanál olvasd el a szabályzatot: " + rules.getAsMention() + "!*\nA szerverünk lényege, hogy építészeti tanácsokat, tippeket, trükköket " +
                        "rendszerezünk és osztunk meg a játékosainkkal.\nStaffjaink segítenek építeni, elindulni az úton.")
                .addField("Szerver státusz:", (m.getConfig().getBoolean("server-status") ? ":white_check_mark: Elérhető" : ":x: Nem elérhető"), true)
                .addField("Szerver ip", "forbiddenbuilders.ouimc.eu", true)
                .addField("Verzió:", "1.18.X", true)
                .addField("", "", true)
                .addField("", "", true)
                .addField("Weboldal", "forbiddenbuilders.tebex.io", true)
                .addBlankField(true)
                .setThumbnail(SetupBot.TFBGuild.getIconUrl())
                .setFooter("The Forbidden Builders" + " • Offline", SetupBot.TFBGuild.getIconUrl());
        channel.editMessageEmbedsById("953759071159320637", embed.build()).submit();

    }
}
