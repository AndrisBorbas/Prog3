package beerregister.blist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import beerregister.beer.Beer;

public class BList {

	public ArrayList<Beer> beerList;

	public static final Comparator<Beer> cname = new CompareName();
	public static final Comparator<Beer> cstyle = new compareStyle();
	public static final Comparator<Beer> cstrenght = new compareStrenght();

	private static class CompareName implements Comparator<Beer> {
		public int compare(Beer b1, Beer b2) {
			return b1.compareName(b2);
		}
	}

	private static class compareStyle implements Comparator<Beer> {
		public int compare(Beer b1, Beer b2) {
			return b1.compareStyle(b2);
		}
	}

	private static class compareStrenght implements Comparator<Beer> {
		public int compare(Beer b1, Beer b2) {
			return b1.compareStrength(b2);
		}
	}

	public BList() {
		beerList = new ArrayList<Beer>();
	}

	public void add(String[] beer) {
		beerList.add(new Beer(beer[1], beer[2], beer[3]));
	}

	public void list(String cmd) {
		if (cmd.equalsIgnoreCase("name")) {
			Collections.sort(beerList, cname);
		}
		if (cmd.equalsIgnoreCase("style")) {
			Collections.sort(beerList, cstyle);
		}
		if (cmd.equalsIgnoreCase("strenght")) {
			Collections.sort(beerList, cstrenght);
		}
		for (Beer beer : beerList) {
			beer.list();
		}
	}

	public void save(String file) throws IOException {
		FileWriter fw = new FileWriter((System.getProperty("user.dir")) + "/" + file + ".txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (Beer beer : beerList) {
			beer.save(bw);
		}
		bw.close();
	}

	public void load(String file) throws IOException {
		String line = null;
		FileReader fr = new FileReader((System.getProperty("user.dir")) + "/" + file + ".txt");
		BufferedReader br = new BufferedReader(fr);

		while ((line = br.readLine()) != null) {
			String cmd[] = line.split(" ");
			beerList.add(new Beer(cmd[0], cmd[1], cmd[2]));
		}
		br.close();
	}

	public void delete(String beer) {
		int index = Collections.binarySearch(beerList, new Beer(beer, "", "0"), cname);
		beerList.remove(index);
	}

}
