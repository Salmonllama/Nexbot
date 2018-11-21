package org.crabcraft.nexbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.crabcraft.nexbot.utilities.config;

public class Nexbot {
    
    public static void main(String[] args) {
        
        // config.firstTimeSetup();

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            conn.close();
            System.out.println("database created");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}