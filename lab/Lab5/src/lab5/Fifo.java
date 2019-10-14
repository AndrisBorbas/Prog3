package lab5;

import java.util.ArrayList;

public class Fifo {
	ArrayList<String> list;

	public Fifo() {
		list = new ArrayList<String>(10);
	}

	public synchronized void put(String s) throws InterruptedException {
		// System.out.println("put: " + Thread.currentThread());
		while (list.size() >= 10) {
			this.wait();
		}
		list.add(s);
		this.notify();
		System.out.println("produced " + s + " " + Long.toString(System.currentTimeMillis())
				.substring(Long.toString(System.currentTimeMillis()).length() - 5));

	}

	public synchronized String get() throws InterruptedException {
		// System.out.println("get: " + Thread.currentThread());
		while (list.size() <= 0) {
			this.wait();
		}
		String ret = list.get(0);
		list.remove(ret);
		this.notify();
		return ret;
	}
}
