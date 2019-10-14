package lab5;

public class Producer extends Thread {

	String s;
	Fifo f;
	int n;

	public Producer(String s, Fifo f, int n) {
		this.s = s;
		this.f = f;
		this.n = n;
	}

	public void go() throws InterruptedException {
		int i = 0;
		while (true) {
			// System.out.println(s + " " + i++ + " " +
			// Long.toString(System.currentTimeMillis())
			// .substring(Long.toString(System.currentTimeMillis()).length() - 5));
			f.put(s + " " + i++);
			n += (n * 0.5);
			Thread.sleep(n);
		}
	}

	@Override
	public void run() {
		try {
			this.go();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
