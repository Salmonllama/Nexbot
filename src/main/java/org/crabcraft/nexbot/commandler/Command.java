package org.crabcraft.nexbot.commandler;

import java.util.List;

import org.crabcraft.nexbot.utilities.Config;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public abstract class Command implements MessageCreateListener {

    public abstract void onCommand(MessageCreateEvent event, String[] args);
    public abstract List<String> Aliases();
    public abstract String Description();
    public abstract String Name();
    public abstract String Usage();
    public abstract String Permissions();

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageAuthor().asUser().get().isBot()) {
            return;
        }
        // Add server-specific prefixes
        // Check for prefix validation
        if (!event.getMessageContent().split("")[0].equals(Config.getDefaultPrefix())) {
            return;
        }
    }
}