package sender.console;

import java.util.*;

public class Console {
	private final static Scanner SCANNER = new Scanner(System.in);

	private Console() {
	}

	public final static String readLine() {
		return SCANNER.nextLine();
	}

	public final static void writeLine(Object obj) {
		System.out.println(obj);
	}

	public final static void writeError(Object obj) {
		try {
			Thread.sleep(5);
			System.err.println("-ERROR: " + obj);
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}
	}

	public final static void write(Object obj) {
		System.out.print(obj);
	}

	public final static void writeRow() {
		write("> ");
	}

	public final static void writeInfo(Object obj) {
		writeLine("-INFO: " + obj);
	}
}
