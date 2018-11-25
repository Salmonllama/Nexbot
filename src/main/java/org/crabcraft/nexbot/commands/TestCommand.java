package org.crabcraft.nexbot.commands;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import org.crabcraft.nexbot.commandler.Command;
import org.javacord.api.entity.message.embed.EmbedBuilder;
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

        EmbedBuilder embed = new EmbedBuilder()
            .setAuthor(event.getMessageAuthor())
            .setColor(Color.GREEN)
            .setTitle(this.Name());

        if (args.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (String arg : args) {
                builder.append(arg + " ");
            }

            embed.setDescription(builder.toString());
        }

        sendResponse(event, embed);
    }
}