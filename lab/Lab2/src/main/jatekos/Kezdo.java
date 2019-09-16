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
		return (super.toString() + " id: " + String.valueOf(super.currentID));
	}
	
	public void finalize() {
		super.finalize();
	}

}