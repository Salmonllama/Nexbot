package org.crabcraft.nexbot.utilities;

import java.io.File;
import java.util.Properties;

public class Config {

    public static void firstTimeSetup() {
        if (new File("config.properties").exists()) {
            System.out.println("Config file exists, skipping first time setup");
        }
        else if (new File("config.example.properties").exists()) {
            System.out.println(
                "It seems you haven't configured your properties file!\n" +
                "rename 'config.example.properties' to 'config.properties'\n" +
                "and fill in your token and desired default prefix."
            );
        }
        else {
            System.out.println("Config file does not exist, we need to create it!");
            // Create and set the first time config file.
            Properties properties = new Properties();
            properties.setProperty("token", "YOUR-TOKEN-HERE!");
            properties.setProperty("default-prefix", "?");
        }
     }

    public static void getToken() { }
    public static void getDefaultPrefix() { }
}