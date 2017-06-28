package main;

public class CheckConfig {

	DoBackup doBackup;

	public void checkCounts() {
		doBackup = new DoBackup();

		if (Starter.countSpecified == Starter.lastSavedCount) {
			checkForHowManyTimesDone(doBackup);
		} else {
			Starter.lastSavedCount = Starter.countSpecified;
			Starter.howManyTimesDone = 0;
//			doBackup.makeBackup();
			Starter.howManyTimesDone = Starter.countSpecified == 0 ? 0 : Starter.howManyTimesDone++;
		}
	}

	public void checkForHowManyTimesDone(DoBackup doBackup) {
		if (Starter.countSpecified != 0) {
			if (Starter.lastSavedCount == Starter.howManyTimesDone) {
				doBackup.removeOldFolder();
//				doBackup.makeBackup();
			} else {
//				doBackup.makeBackup();
				Starter.howManyTimesDone++;
			}
		} else {
//			doBackup.makeBackup();
		}
	}
}
