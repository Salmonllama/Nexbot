package org.crabcraft.nexbot.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
            properties.setProperty("token", "YOUR-TOKEN-HERE");
            properties.setProperty("default-prefix", "?");

            try {
                properties.store(new FileWriter(new File("config.properties")), null);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
     }

     public static Properties loadConfigFile() {
        Properties properties = new Properties();
        String fileName = "config.properties";
        InputStream input = null;

        try {
            input = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("Couldn't find config file" + e);
        }

        try {
            properties.load(input);
        }
        catch (IOException e) {
            System.out.println("Couldn't read the config file" + e);
        }

        return properties;
     }

    public static String getToken() {
        return Config.loadConfigFile().getProperty("token");
     }

    public static String getDefaultPrefix() {
        return Config.loadConfigFile().getProperty("default-prefix");
     }
}