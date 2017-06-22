package main;

public class CheckForArguments {

	public int checkForCountSpecifiedArg(String countSpecified) {
		int cutted = 0;

		if (countSpecified.toLowerCase().startsWith("-c:")) {
			if (countSpecified.length() < 4) {
				throw new NumberFormatException("Number of copies for preserving isn't specified !");
			} else {
				cutted = Integer.parseInt(countSpecified.substring(3));
				return cutted;
			}
		} else {
			return 0;
		}
	}

	
	public String checkForFromPathArg(String fromPath){
		String cutted = "";
		
		if (cutted.toLowerCase().startsWith("-f:")) {
			if (fromPath.length() < 2) {
				throw new ArrayIndexOutOfBoundsException("\"Copy from\" argument is incorrect !");
			} else{
				cutted = fromPath.substring(3);
				return cutted;
			}
		}
	}
}
