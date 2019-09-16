package main;

import main.asztal.Asztal;
import main.exception.NincsJatekos;
import main.jatekos.*;

public class Main {
	public static void main(String[] args) {

		try {
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
			
			asztal=null;
			System.gc();

			Asztal retardasztal = new Asztal();
			retardasztal.kor();
			retardasztal.kor();
		} catch (NincsJatekos e) {
			System.out.println("retard");
		} finally {
			// Exit(0);
		}
	}
}
