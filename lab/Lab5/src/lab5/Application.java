package lab5;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		Fifo f = new Fifo();
		Producer p1 = new Producer("first", f, 150);
		Consumer s1 = new Consumer(f, "first", 250);
		new Thread(p1).start();
		Thread.sleep(5000);
		new Thread(s1).start();
	}

}
