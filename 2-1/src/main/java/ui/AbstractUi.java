package ui;

import java.util.Scanner;

public abstract class AbstractUi {
	abstract public void show();
	protected String getInputedString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
