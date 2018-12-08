package org.crabcraft.nexbot;

import org.crabcraft.nexbot.commandler.CommandRegistry;
import org.crabcraft.nexbot.commands.TestCommand;
import org.crabcraft.nexbot.controlpanel.BotPanel;
import org.crabcraft.nexbot.commandler.FrameworkConfig;
import org.crabcraft.nexbot.commandler.FrameworkDB;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.DiscordApi;

public class Nexbot {
    
    public static void main(String[] args) {
        // Entire bot needs a fundamental reorganise/rework now that Commandler has been fully released. Stay Tuned.
        
        // Bot initialisation:
        FrameworkConfig.firstTimeSetup(); // Needs changing. Was moved to become a component of the framework.
        FrameworkDB.firstTimeSetup(); // This needs changing. FrameworkDB was moved to become a component of the framework.

        DiscordApi api = new DiscordApiBuilder().setToken(FrameworkConfig.getToken()).login().join();
        System.out.println("Bot invite link: " + api.createBotInvite());

        CommandRegistry registry = new CommandRegistry(api);

        api.addMessageCreateListener(registry.registerCommand(new TestCommand()));

        BotPanel panel = new BotPanel(api);
    }
}