//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Lab6
//  @ File Name : PercentCounter.java
//  @ Date : 2019-10-21
//  @ Author : AndrisBorbas

public class PercentCounter extends Observable {
	private int percent;

	public void run() {
		for (percent = 0; percent <= 100; percent++)
			if (percent % 10 == 0)
				this.reportToObservers();
	}

	@Override
	public String toString() {
		return percent + "%";
	}
}
