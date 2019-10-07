package beerregister.blist;

import java.util.ArrayList;

import beerregister.beer.Beer;

public class BList {

	public ArrayList<Beer> beerList;

	public BList() {
		beerList = new ArrayList<Beer>();
	}

	public void add(String[] s) {
		beerList.add(new Beer(s));
	}
	
	public void list() {
		for (Beer beer : beerList) {
			beer.list();
		}
	}
	
	public void save(String s) {
		
	}
	
	public void load(String s) {
		
	}

}
