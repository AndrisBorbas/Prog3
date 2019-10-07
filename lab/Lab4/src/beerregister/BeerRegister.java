package beerregister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import beerregister.blist.BList;

public class BeerRegister {

	public static void main(String[] args) throws IOException {
		BList beerList = new BList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = reader.readLine();

			String[] temp = s.split(" ");

			if (temp[0].equals("add") && temp.length == 4) {
				beerList.add(temp);
			}
			if (temp[0].equals("list")) {
				beerList.list();
			}
			if (temp[0].equals("save") && temp.length == 2) {
				beerList.save(temp[1]);
			}
			if (temp[0].equals("load") && temp.length == 2) {
				beerList.load(temp[1]);
			}
		}
	}

}
