package main;

import java.io.File;

import java.sql.*;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WriteToConfig {
	
	public static void updateRecords() {

		Connection c = null;
		Statement stmt = null;

		String url = "jdbc:sqlite:" + System.getProperty("user.home") + "\\AppData\\Local\\Backup\\config.db";

		String sql = "";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(url);

			stmt = c.createStatement();
			stmt.executeUpdate(sql);

			sql = "INSERT INTO counts (lastSavedCount, howManyTimesDone, fromPath, toPath)\n" + "VALUES (" + Starter.lastSavedCount + ", " + Starter.howManyTimesDone + ", " + "'" + Starter.lastFromPath + "'" + ", " + "'" + Starter.lastToPath + "'" + ");";
			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
