package org.crabcraft.nexbot.utilities;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection connectionSetup() {
        // Establish the database connection and return the connection variable
        try {
            Class.forName("org.sqlite.JDBC");
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:nexbot.db");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void firstTimeSetup() {
        // Check if nexbot.db exists, if not, create it.
        if (new File("nexbot.db").exists()) {
            System.out.println("Database exists, no need for further action.");
        }
        else {
            Connection conn = connectionSetup();
            try{ conn.close(); } catch(SQLException e) { e.printStackTrace(); }
            System.out.println("Database did not exist and was created");
        }
    }

    public static void serverFirstTimeSetup() {
        // When a server is joined, this is called to add it to the database table.
        // TODO: serverConf table with PREFIX, LOGCHANNEL.
    }
}