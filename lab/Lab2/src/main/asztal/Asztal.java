package main.asztal;

import main.jatekos.Jatekos;

public class Asztal {
	private Jatekos jatekosok[];
	private double tet;
	private int korok;

	public Asztal() {
		jatekosok = new Jatekos[0];
		ujJatek();
	}

	public void ujJatek() {
		tet = 0;
		korok = 0;
	}

	public void addJatekos(Jatekos j) {
		j.setAsztal(this);
		Jatekos temp[] = new Jatekos[jatekosok.length + 1];
		for (int i = 0; i < jatekosok.length; i++) {
			temp[i] = jatekosok[i];
		}
		temp[jatekosok.length] = j;
		jatekosok = temp;
	}

	public int getKor() {
		return korok;
	}

	public void emel(double d) {

	}

	public void kor() {
		for (int i = 0; i < jatekosok.length; i++) {
			jatekosok[i].lep();
		}
		System.out.println("Tét: " + tet);
		korok++;
	}
}
