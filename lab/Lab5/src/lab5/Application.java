package lab5;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		Fifo f = new Fifo();
		//Math.random();
		Producer p1 = new Producer("first", f, (int) (Math.random()*3000));
		Producer p2 = new Producer("second", f, (int) (Math.random()*3000));
		Producer p3 = new Producer("third", f, (int) (Math.random()*3000));
		Consumer s1 = new Consumer(f, "first", (int) (Math.random()*3000));
		Consumer s2 = new Consumer(f, "second", (int) (Math.random()*3000));
		Consumer s3 = new Consumer(f, "third", (int) (Math.random()*3000));
		Consumer s4 = new Consumer(f, "fourth", (int) (Math.random()*3000));
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		//Thread.sleep(5000);
		new Thread(s1).start();
		new Thread(s2).start();
		new Thread(s3).start();
		new Thread(s4).start();
	}

}
