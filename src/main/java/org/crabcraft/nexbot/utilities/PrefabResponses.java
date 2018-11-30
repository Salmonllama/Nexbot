package org.crabcraft.nexbot.utilities;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class PrefabResponses {

    public static EmbedBuilder noPermissions(MessageCreateEvent event, String permission) {

        EmbedBuilder embed = new EmbedBuilder()
            .setColor(Color.RED)
            .setAuthor(event.getApi().getYourself())
            .addField("Missing Permissions:", permission);

        return embed;
    }
}
