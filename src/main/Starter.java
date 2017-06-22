package main;

import java.util.concurrent.CountDownLatch;

public class Starter {

	// variables
	int countSpecified;
	int lastSavedCount;
	int howManyTimesDone;

	String fromPath;
	String toPath;

	// object references

	CheckForArguments checkForArguments;

	// -----------

	public static void main(String[] args) {
		Starter starter = new Starter();
		for (String string : args) {
			starter.countSpecified = starter.checkForArguments.checkForCountSpecifiedArg(string);
		}
	}

	public Starter() {
		checkForArguments = new CheckForArguments();
	}
}
