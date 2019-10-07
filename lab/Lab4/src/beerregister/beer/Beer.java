package beerregister.beer;

import java.io.Serializable;

public class Beer implements Serializable {

	private String name, style, strength;

	public Beer() {
	}

	public Beer(String[] s) {
		name = s[1];
		style = s[2];
		strength = s[3];
	}

	public void list() {
		System.out.println("Name: " + name + ", Style: " + style + ", Strength: " + strength + "%");
	}
}
