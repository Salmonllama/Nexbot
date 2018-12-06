package org.crabcraft.nexbot.utilities.database;

import org.crabcraft.nexbot.utilities.Config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void serverFirstTimeSetup(String serverName, String serverId) {
        // When a server is joined, this is called to add it to the database table.
        Connection conn = connectionSetup();

        try {
            // Create the table if it doesn't exist
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS serverconf"
                            + "(serverId TEXT NOT NULL PRIMARY KEY, serverName TEXT NOT NULL,"
                            + " prefix TEXT NOT NULL, logChannel TEXT)");
            System.out.println("serverConf initialised");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            // Add the server data into the table
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO serverconf"
                            + "(serverId, serverName, prefix, logChannel)"
                            + "VALUES"
                            + "(" + serverId + "," + serverName + "," + Config.getDefaultPrefix() + "," + null + ")"
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}