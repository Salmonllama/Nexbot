package org.crabcraft.nexbot.controlpanel;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import org.crabcraft.nexbot.controlpanel.subpanels.StatsPanel;
import org.javacord.api.DiscordApi;

public class BotPanel extends JFrame {
    public BotPanel(DiscordApi api) {
        super(api.getYourself().getDiscriminatedName() + " Control Panel");

        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        StatsPanel stats = new StatsPanel(api);
        add(stats);
        
        setVisible(true);
    }
}