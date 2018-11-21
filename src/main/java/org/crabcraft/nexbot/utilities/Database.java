package org.crabcraft.nexbot.utilities;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static void firstTimeSetup() {
        try {
            Class.forName("org.sqlite.JDBC");
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    
        // Check if nexbot.db exists, if not, create it.
        if (new File("nexbot.db").exists()) {
            System.out.println("Database exists, no need for further action.");
        }
        else {
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:nexbot.db");
                conn.close();
                System.out.println("database created");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}