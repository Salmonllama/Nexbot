package org.crabcraft.nexbot;

import org.crabcraft.nexbot.commandler.CommandRegistry;
import org.crabcraft.nexbot.commands.TestCommand;
import org.crabcraft.nexbot.controlpanel.BotPanel;
import org.crabcraft.nexbot.utilities.Config;
import org.crabcraft.nexbot.utilities.database.Database;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.DiscordApi;

public class Nexbot {
    
    public static void main(String[] args) {
        
        // Bot initialisation:
        Config.firstTimeSetup();
        Database.firstTimeSetup();

        DiscordApi api = new DiscordApiBuilder().setToken(Config.getToken()).login().join();
        System.out.println("Bot invite link: " + api.createBotInvite());

        CommandRegistry registry = new CommandRegistry();

        api.addMessageCreateListener(registry.registerCommand(new TestCommand()));

        BotPanel panel = new BotPanel(api);
    }
}