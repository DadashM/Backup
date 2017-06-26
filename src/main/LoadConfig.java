package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoadConfig {
	Connection c = null;
	Statement stmt = null;

	public void loadValuesFromConfig() {
		String url = "jdbc:sqlite:" + System.getProperty("user.home") + "\\AppData\\Local\\Backup\\config.db";

		String sql = "SELECT * FROM counts";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(url);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Starter.lastSavedCount = rs.getInt("lastSavedCount");
				Starter.howManyTimesDone = rs.getInt("howManyTimesDone");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
