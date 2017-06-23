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
			throw new NumberFormatException("Number of copies for preserving isn't specified !");
		}
	}

	public String checkForFromPathArg(String fromPath) {
		String cutted = "";

		if (fromPath.toLowerCase().startsWith("-f:")) {
			if (fromPath.length() < 5) {
				throw new CopyFromArgNotFoundException();
			} else {
				cutted = fromPath.substring(3);
				return cutted;
			}
		} else {
			throw new CopyFromArgNotFoundException();
		}
	}

	public String checkForToPathArg(String toPath) {
		String cutted = "";

		if (toPath.toLowerCase().startsWith("-t:")) {
			if (toPath.length() < 5) {
				throw new CopyToArgNotFoundException();
			} else {
				cutted = toPath.substring(3);
				return cutted;
			}
		} else {
			throw new CopyToArgNotFoundException();
		}
	}

}
