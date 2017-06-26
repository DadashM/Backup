package main;

public class CheckConfig {
	public void checkCounts(int countEntered, int lastCount){
		if (countEntered == lastCount) {
			checkForHowManyTimesDone();
		}
	}
	
	public void checkForHowManyTimesDone(){
		if (countEntered != 0){
			if (lastCount == currentCount){
				removeOldFolder();
				doBackup();
			} else{
				doBackup();
				currentCount++;
			}
		} else{
			doBackup();
		}
	}
}
