package main;

public class CopyFromArgNotFoundException extends IllegalArgumentException {
	public CopyFromArgNotFoundException() {
		super("\"Copy from\" argument is incorrect or not specified !");
	}
}
