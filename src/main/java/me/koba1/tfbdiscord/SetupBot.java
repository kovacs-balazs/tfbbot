package me.koba1.tfbdiscord;

import me.koba1.tfbdiscord.Rules.DCRules;
import me.koba1.tfbdiscord.Statusz.StatuszEdit;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class SetupBot {

    public static JDA jda;
    public static Guild TFBGuild;
    private static Main m = Main.getPlugin(Main.class);

    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault("")
                    .addEventListeners(new sendembed(), new DCRules())
                    .setActivity(Activity.watching("TFB játékosait"))
                    .setStatus(OnlineStatus.ONLINE)
                    .setRequestTimeoutRetry(false)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS).build();
            jda.awaitReady();
            TFBGuild = jda.getGuildById("953751052400861254");

           new StatuszEdit().startserver(m.getConfig().getBoolean("server-status"), jda.getGuildById("953751052400861254").getTextChannelById("953751053298438157"));
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
