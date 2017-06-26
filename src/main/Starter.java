package main;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Starter {

	// variables
	int countSpecified;
	static int lastSavedCount;
	static int howManyTimesDone;

	String fromPath;
	String toPath;

	// object references

	static Starter starter;
	CheckForArguments checkForArguments;
	IsConfigFileExist isConfigFileExistClass;
	LoadConfig loadConfig;
	ArrayList<String> argArray;
	// -----------

	public static void main(String[] args) {
		starter = new Starter();
		starter.getArguments(args);
		starter.isConfigFileExistClass.isConfigExist();
		starter.loadConfig.loadValuesFromConfig();
		//checkConfig
		System.out.println(lastSavedCount);
		System.out.println(howManyTimesDone);
	}

	public Starter() {
		checkForArguments = new CheckForArguments();
		isConfigFileExistClass = new IsConfigFileExist();
		loadConfig = new LoadConfig();
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
