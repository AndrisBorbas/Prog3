package main.jatekos;

public class Robot extends Jatekos {

	public void lep() {
		System.out.println(toString() + " Kör: " + String.valueOf(super.asztal.getKor()));

	}

	public String toString() {
		return (super.toString() + " id: " + String.valueOf(super.currentID));
	}
}