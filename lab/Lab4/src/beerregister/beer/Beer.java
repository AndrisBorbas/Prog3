package beerregister.beer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

public class Beer implements Serializable {

	private String name, style, strength;

	public Beer() {
	}

	public Beer(String name, String style, String strength) {
		this.name = name;
		this.style = style;
		this.strength = strength;
	}

	public void list() {
		System.out.println("Name: " + name + ", Style: " + style + ", Strength: " + strength + "%");
	}

	public void save(BufferedWriter bw) throws IOException {
		bw.write(name + " " + style + " " + strength + "\n");
	}

	public int compareName(Beer b) {
		return (this.name.compareTo(b.name));
	}

	public int compareStyle(Beer b) {
		return (this.style.compareTo(b.style));
	}

	public int compareStrength(Beer b) {
		return (this.strength.compareTo(b.strength));
	}
}
