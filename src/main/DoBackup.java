package main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

public class DoBackup {

	public void makeBackup(String from, String to) {
		String command = "xcopy " + from + " " + to + " " + "/O /X /E /H /K";

		try {
			Runtime r = Runtime.getRuntime();
			Process pr = r.exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeOldFolder() {
		File backupPath = new File(Starter.lastToPath);
		List<Long> foldersInBackupDir = new ArrayList<>();
		List<File> foldersInBackupDirFile = new ArrayList<>();

		for (File file : backupPath.listFiles()) {
			foldersInBackupDir.add(file.lastModified());
			foldersInBackupDirFile.add(file);
		}

		Collections.sort(foldersInBackupDir);

		for (int s = 0; s < foldersInBackupDirFile.size(); s++) {
			if (foldersInBackupDir.get(0) == foldersInBackupDirFile.get(s).lastModified()) {
				try {
					FileUtils.deleteDirectory(foldersInBackupDirFile.get(s));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void isPathsCorrect(String from, String to) {
		File fromPath = new File(from);
		File toPath = new File(to);
		File createBackupFolder;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YY_HH-mm-ss");
		Date date = new Date();

		if (fromPath.exists() && toPath.exists()) {

			if (!toPath.isDirectory()) {
				System.err.println("\"" + toPath + "\"" + " is invalid. Destination must be a directory !");
				System.exit(1);
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

				makeBackup(fromPath.getAbsolutePath(), createBackupFolder.getAbsolutePath());
			}

		} else {
			System.err.println("Specified path doesn't exist !");
			System.exit(1);
		}

	}

}
