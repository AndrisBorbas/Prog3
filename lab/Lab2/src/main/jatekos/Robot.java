package main.jatekos;

public class Robot extends Jatekos {
	public void lep() {
		System.out.println(toString() + " K�r: " + String.valueOf(super.asztal.getKor()));

	}

	public String toString() {
		String temp = super.toString();
		temp = temp.concat(" id: ");
		return temp.concat(String.valueOf(super.id));
	}
}