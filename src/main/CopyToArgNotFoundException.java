package main;

public class CopyToArgNotFoundException extends IllegalArgumentException {
	public CopyToArgNotFoundException() {
		super("\"Copy to\" argument is incorrect or not specified !");
	}
}
