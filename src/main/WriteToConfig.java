package main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WriteToConfig {
public static void main(String[] args) {
	File dele = new File("D:\\vpn\\asd");
	try {
		FileUtils.deleteDirectory(dele);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
