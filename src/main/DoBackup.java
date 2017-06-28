package main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoBackup {

	public void makeBackup(String from, String to) {
		System.out.println(from);
		System.out.println(to);
		String command = "xcopy " + from + " " + to + " " + "/O /X /E /H /K";

		try {
			Runtime r = Runtime.getRuntime();
			Process pr = r.exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeOldFolder() {

	}

	public void isPathsCorrect(String from, String to) {
		File fromPath = new File(from);
		File toPath = new File(to);
		File createBackupFolder;
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-YY_HH-mm-ss");
		Date date = new Date();

		if (fromPath.exists() && toPath.exists()) {

			if (!toPath.isDirectory()) {
				System.err.println("\"" + toPath + "\"" + " is invalid. Destination must be a directory !");
			} else {
				if (fromPath.isDirectory()) {
					if (fromPath.getName().equals("")) {
						createBackupFolder = new File(
								toPath + "\\" + fromPath.getAbsolutePath().substring(0, 1) + "_" + format.format(date));
						createBackupFolder.mkdir();
					} else {
						createBackupFolder = new File(toPath + "\\" + fromPath.getName() + "_" + format.format(date));
						createBackupFolder.mkdir();
					}
				} else {
					createBackupFolder = new File(toPath + "\\" + fromPath.getName() + "_" + format.format(date));
					createBackupFolder.mkdir();
				}

				 makeBackup(from, to);
			}

		} else {
			System.err.println("Specified path doesn't exist !");
		}

	}

}
