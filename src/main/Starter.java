package main;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Starter {

	// variables
	static int countSpecified;
	static int lastSavedCount;
	static int howManyTimesDone;

	static String fromPath;
	static String toPath;
	static String lastFromPath;
	static String lastToPath;
	static String lastRootBackupFolder;
	static boolean skipTableUpdate;

	// object references

	static Starter starter;
	CheckForArguments checkForArguments;
	IsConfigFileExist isConfigFileExistClass;
	LoadConfig loadConfig;
	CheckConfig checkConfig;
	WriteToConfig writeToConfig;
	ArrayList<String> argArray;
	// -----------

	public static void main(String[] args) {
		starter = new Starter();
		starter.getArguments(args);
		starter.isConfigFileExistClass.isConfigExist();
		starter.loadConfig.loadValuesFromConfig();
		starter.checkConfig.checkCounts();
		if (!skipTableUpdate) {
			starter.writeToConfig.updateRecords();
		}
		System.out.println(lastRootBackupFolder);
		//makeLogs
	}

	public Starter() {
		checkForArguments = new CheckForArguments();
		isConfigFileExistClass = new IsConfigFileExist();
		loadConfig = new LoadConfig();
		checkConfig = new CheckConfig();
		writeToConfig = new WriteToConfig();
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
