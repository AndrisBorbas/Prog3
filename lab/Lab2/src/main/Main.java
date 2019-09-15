package main;

import main.asztal.Asztal;
import main.jatekos.*;

public class Main {
	public static void main(String[] args) {
		Asztal asztal = new Asztal();
		Jatekos jatekos1 = new Jatekos();
		Jatekos jatekos2 = new Jatekos();
		Jatekos jatekos3 = new Jatekos();

		asztal.addJatekos(jatekos1);
		asztal.addJatekos(jatekos2);
		asztal.addJatekos(jatekos3);
		asztal.kor();
		asztal.kor();
		asztal.kor();

	}
}
