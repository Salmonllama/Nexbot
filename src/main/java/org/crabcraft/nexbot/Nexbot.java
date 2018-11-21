package org.crabcraft.nexbot;

import org.crabcraft.nexbot.utilities.Config;
import org.crabcraft.nexbot.utilities.Database;

public class Nexbot {
    
    public static void main(String[] args) {
        
        // Do first time bot setup.
        Config.firstTimeSetup();
        Database.firstTimeSetup();
    }
}