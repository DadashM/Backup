package main;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Starter {

	// variables
	int countSpecified;
	int lastSavedCount;
	int howManyTimesDone;

	String fromPath;
	String toPath;

	// object references

	static Starter starter;
	CheckForArguments checkForArguments;
	ArrayList<String> argArray;
	// -----------

	public static void main(String[] args) {
		starter = new Starter();
		starter.getArguments(args);
	}

	public Starter() {
		checkForArguments = new CheckForArguments();
		argArray = new ArrayList<>();
	}

	public void getArguments(String[] args) {

		for (String string : args) {
			argArray.add(string);
		}

		starter.countSpecified = starter.checkForArguments.checkForCountSpecifiedArg(argArray.get(0));
		starter.fromPath = starter.checkForArguments.checkForFromPathArg(argArray.get(1));
		starter.toPath = starter.checkForArguments.checkForToPathArg(argArray.get(2));

	}
}
