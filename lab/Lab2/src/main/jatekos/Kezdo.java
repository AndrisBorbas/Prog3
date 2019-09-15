package main.jatekos;

public class Kezdo extends Jatekos {
	public void lep() {
		if ((super.asztal.getKor() % 2) == 0) {
			super.asztal.emel(1);
		} else {

		}

		System.out.println(toString() + " Kör: " + String.valueOf(super.asztal.getKor()));

	}

	public String toString() {
		String temp = super.toString();
		temp = temp.concat(" id: ");
		return temp.concat(String.valueOf(super.id));
	}

}