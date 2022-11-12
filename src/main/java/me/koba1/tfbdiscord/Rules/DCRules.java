package me.koba1.tfbdiscord.Rules;

import me.koba1.tfbdiscord.SetupBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.event.EventHandler;

import java.awt.*;

public class DCRules extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getMessage().getContentRaw().equals("!!sendrule")) {
            if(e.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                TextChannel channel = SetupBot.TFBGuild.getTextChannelById("953751053298438159");
                channel.sendMessageEmbeds(embed().build()).queue();
            }
        }
    }

    public EmbedBuilder embed() {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Szabályzat")
                .setColor(new Color(125, 60, 0))
                .setAuthor("The Forbidden Builders szabályzata", null, SetupBot.TFBGuild.getIconUrl())
                .setDescription("**Szabályzat nem ismerete nem mentesít azok betartása alól!**\n\n" +
                        "`1.0` Másik játékos szidása, bántása TILOS!\n\n" +
                        "`1.1` Mások személyes adatait, képeit TILOS megosztani!\n\n" +
                        "`1.2` Hang/Video felvételt engedély nélkül készíteni TILOS!\n\n" +
                        "`1.3` Pornográf, politikai, gyűlöletkeltő videók, képek megosztása TILOS!\n\n" +
                        "`1.4` TILOS csak nagy betűvel írni!\n\n" +
                        "`1.5` Indokoltatlan feszültségkeltés, kötekedés TILOS!\n\n" +
                        "`1.6` TILOS politikai, etnikai képek videók megosztása!\n\n" +
                        "`1.7` Más szerver hirdetése/reklámozása TILOS!\n\n" +
                        "`1.8` TILOS kereskedelmi célra használni a szervert!\n\n" +
                        "`1.9` TILOS a hangcsatorna ki- és belépegetéssel szórakozni!\n\n" +
                        "`1.10` Más építményét kiadni sajátodnak TILOS!\n\n" +
                        "`1.11` Spamelni/floodolni TILOS (ugyanazt az üzenetet küldjük el többször)\n\n" +
                        "`1.12` Minden botot rendeltetésszerűen használj!\n\n" +
                        "`1.13` TILOS a megkülönböztetés (negatív megjegyzések a bőr színével, nemével vagy más személyes tulajdonságokkal kapcsolatban)!\n\n" +
                        "*`A moderátorok büntethetnek a szabályzatban konkrétan nem szereplő, de józan ésszel büntethetőnek ítélhető cselekményekért is.`*")
                .setFooter("The Forbidden Builders • Szabályzat", SetupBot.TFBGuild.getIconUrl());
        return embed;

    }
}
