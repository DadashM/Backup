package main;

import java.io.File;

public class IsConfigFileExist {
	File configDir;
	File configFile;

	public IsConfigFileExist() {
		configDir = new File(System.getProperty("user.home") + "\\AppData\\Local\\Backup");
		configFile = new File(System.getProperty("user.home") + "\\AppData\\Local\\Backup\\config.db");
	}

	public void isConfigExist() {
		if (!configDir.exists()) {
			configDir.mkdir();
			SqlCreateDatabase.createDatabase();
			SqlCreateDatabase.createCountsTable();
		}
	}
	
}
