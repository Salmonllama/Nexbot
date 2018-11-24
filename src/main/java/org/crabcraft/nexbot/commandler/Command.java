package org.crabcraft.nexbot.commandler;

import java.util.Arrays;
import java.util.List;

import org.crabcraft.nexbot.utilities.Config;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public abstract class Command implements MessageCreateListener {

    public abstract void onCommand(MessageCreateEvent event, String[] args);
    public abstract List<String> Aliases();
    public abstract String Description();
    public abstract String Name();
    public abstract String Usage();
    public abstract List<String> Permissions();

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageAuthor().asUser().get().isBot()) {
            // Ignore bot users
            return;
        }
        // TODO: Add server-specific prefixes
        // Check for prefix validation
        // TODO: make sure it tracks the prefix *length* too, in cutPrefix() as well.
        if (!event.getMessageContent().split("")[0].equals(Config.getDefaultPrefix())) {
            // Ignore prefixes that aren't in the config
            return;
        }
        if (!isCommand(event.getMessageContent())) {
            // Ignore any message that doesn't start with a registered command or its alias
            return;
        }

        onCommand(event, getCommandArgs(event.getMessageContent()));
    }

    // TODO hasPermissions() inhibitor

    protected static String[] cutPrefix(String message) {
        // Remove the prefix from the command
        return message.substring(1).split(" ");
    }

    protected boolean isCommand(String string) {
        // Check if the string is a command or a command alias
        return Aliases().contains(Command.cutPrefix(string)[0]);
    }

    protected String[] getCommandArgs(String message) {
        // Get the arguments; remove the command itself
        return Arrays.copyOfRange(cutPrefix(message), 1, cutPrefix(message).length);
    }

    // TODO: send embeds and other types of message responses
    protected Message sendResponse(MessageCreateEvent event, String message) {
        return event.getChannel().sendMessage(message).join();
    }
}