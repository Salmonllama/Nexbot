package org.crabcraft.nexbot;

import org.crabcraft.nexbot.commandler.CommandRegistry;
import org.crabcraft.nexbot.utilities.Config;
import org.crabcraft.nexbot.utilities.Database;
import org.javacord.api.DiscordApiBuilder;

public class Nexbot {
    
    public static void main(String[] args) {
        
        // Do first time bot setup.
        Config.firstTimeSetup();
        Database.firstTimeSetup();

        new DiscordApiBuilder().setToken(Config.getToken()).login().thenAccept(api -> {

            // Add the command framework as a listener
            // api.addMessageCreateListener(CommandRegistry.registerCommand());
        });
    }
}