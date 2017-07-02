package main;

public class CheckConfig {

	DoBackup doBackup;

	public void checkCounts() {
		doBackup = new DoBackup();

		if (Starter.countSpecified == Starter.lastSavedCount && Starter.fromPath.equals(Starter.lastFromPath) && Starter.toPath.equals(Starter.lastToPath)) {
			checkForHowManyTimesDone(doBackup);
		} else {
			Starter.lastSavedCount = Starter.countSpecified;
			Starter.lastFromPath = Starter.fromPath;
			Starter.lastToPath = Starter.toPath;
			Starter.howManyTimesDone = 0;
			doBackup.isPathsCorrect(Starter.fromPath, Starter.toPath);
			System.out.println(Starter.howManyTimesDone);
			if (Starter.countSpecified == 0) {
				Starter.howManyTimesDone = 0;
			}else {
				Starter.howManyTimesDone++;
			}
			System.out.println(Starter.howManyTimesDone);
		}
	}

	public void checkForHowManyTimesDone(DoBackup doBackup) {
		if (Starter.countSpecified != 0) {
			if (Starter.lastSavedCount == Starter.howManyTimesDone) {
				doBackup.removeOldFolder();
				doBackup.isPathsCorrect(Starter.fromPath, Starter.toPath);
				Starter.skipTableUpdate = true;
			} else {
				doBackup.isPathsCorrect(Starter.fromPath, Starter.toPath);
				Starter.howManyTimesDone++;
			}
		} else {
			Starter.skipTableUpdate = true;
			doBackup.isPathsCorrect(Starter.fromPath, Starter.toPath);
		}
	}
}
