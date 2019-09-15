package main;

import main.asztal.Asztal;
import main.jatekos.*;

public class Main {
	public static void main(String[] args) {
		Asztal asztal = new Asztal();
		Kezdo jatekos1 = new Kezdo();
		Robot jatekos2 = new Robot();
		Kezdo jatekos3 = new Kezdo();

		asztal.addJatekos(jatekos1);
		asztal.addJatekos(jatekos2);
		asztal.addJatekos(jatekos3);
		asztal.kor();
		asztal.kor();
		asztal.kor();

	}
}
