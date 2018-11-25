package org.crabcraft.nexbot.commands;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import org.crabcraft.nexbot.commandler.Command;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
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

        Server server = event.getServer().get();
        User author = event.getMessageAuthor().asUser().get();

        Permissions perms = server.getPermissions(author);

        StringBuilder builder = new StringBuilder();
        builder.append("```md\n");

        for (PermissionType perm : perms.getAllowedPermission()) {
            builder.append(perm + "\n");
        }

        builder.append("```");

        EmbedBuilder embed = new EmbedBuilder()
            .setColor(Color.GREEN)
            .setTitle("User Permissions")
            .setAuthor(event.getApi().getYourself())
            .setDescription(builder.toString());

        sendResponse(event, embed);
    }
}