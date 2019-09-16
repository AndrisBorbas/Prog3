package main.jatekos;

import main.asztal.Asztal;

public class Jatekos {
	protected Asztal asztal;
	static int id;
	final int currentID;

	public Jatekos() {
		currentID = ++id;
	}

	public void lep() {

	}

	public void setAsztal(Asztal a) {
		asztal = a;
	}

}