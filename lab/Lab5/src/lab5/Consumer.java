package lab5;

public class Consumer extends Thread {
	Fifo f;
	String s;
	int n;

	public Consumer(Fifo f, String s, int n) {
		this.f = f;
		this.s = s;
		this.n = n;
	}

	public void run() {
		while (true) {
			try {
				System.out.println("consumed " + s + " " + f.get() + " " + Long.toString(System.currentTimeMillis())
						.substring(Long.toString(System.currentTimeMillis()).length() - 5));
				Thread.sleep(n);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
