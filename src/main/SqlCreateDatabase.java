package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlCreateDatabase {

	public static void createDatabase() {
		String url = "jdbc:sqlite:" + System.getProperty("user.home") + "\\AppData\\Local\\Backup\\config.db";

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Driver name: " + meta.getDriverName());
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createCountsTable() {

		Connection c = null;
		Statement stmt = null;

		String url = "jdbc:sqlite:" + System.getProperty("user.home") + "\\AppData\\Local\\Backup\\config.db";

		String sql = "CREATE TABLE IF NOT EXISTS counts (\n" + "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
				+ "lastSavedCount INTEGER NOT NULL,\n" + "howManyTimesDone INTEGER NOT NULL);";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(url);

			stmt = c.createStatement();
			stmt.executeUpdate(sql);

			sql = "INSERT INTO counts (lastSavedCount, howManyTimesDone)\n" + "VALUES (0, 0);";
			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
