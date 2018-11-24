package org.crabcraft.nexbot.commands;

import java.util.Arrays;
import java.util.List;

import org.crabcraft.nexbot.commandler.Command;
import org.javacord.api.event.message.MessageCreateEvent;

public class TestCommand extends Command {

    @Override
    public String Name() { return "Test Command"; }
    @Override
    public List<String> Aliases() { return Arrays.asList("test"); }
    @Override
    public String Description() { return "Just a test command, look the other way"; }
    @Override
    public String Usage() { return "test"; }
    @Override
    public List<String> Permissions() { return Arrays.asList("none"); }

    @Override
    public void onCommand(MessageCreateEvent event, String[] args) {
        sendResponse(event, "test");
        if (args.length > 0) {
            sendResponse(event, args[0]);
        }
    }
}