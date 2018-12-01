package org.crabcraft.nexbot.controlpanel.subpanels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.javacord.api.DiscordApi;

public class StatsPanel extends JPanel {

    JLabel serversLabel = new JLabel("Loading server count...");
    JLabel usersLabel = new JLabel("Loading user count...");

    public StatsPanel(DiscordApi api) {
        super();

        add(serversLabel);
        add(usersLabel);

        // TODO: Move these to a discordAPI event so they get updated on the fly
        serversLabel.setText("Servers: " + Integer.toString(api.getServers().toArray().length));
        usersLabel.setText("Users: " + Integer.toString(api.getCachedUsers().toArray().length));

        setVisible(true);
    }
}