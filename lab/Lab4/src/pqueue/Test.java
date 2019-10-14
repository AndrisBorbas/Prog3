package pqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {
	public static void main(String[] args) throws IOException {

		try {
			PQueue<String> pq = new PQueue<String>();

			while (true) {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				String s = br.readLine();
				String[] ss = s.split(" ");

				if (ss[0].equals("push")) {
					pq.push(ss[1]);
				} else if (ss[0].equals("pop")) {
					String tp = pq.pop();
					System.out.println(tp);
				} else if (ss[0].equals("top")) {
					String tp = pq.top();
					System.out.println(tp);
				}
				if (ss[0].equals("size")) {
					int tp = pq.size();
					System.out.println(tp);
				}
				if (ss[0].equals("clear")) {
					pq.clear();
				}

			}

		} catch (EmptyQueueException e) {
			System.out.println("Error!");
		}
	}
}