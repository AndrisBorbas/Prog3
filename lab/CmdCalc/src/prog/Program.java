package prog;

import echo.*;
import calc.Calculator;

public class Program {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			int temp = Integer.parseInt(args[i]);
			sum = c.add(sum, temp);
		}
		Echo e = new Echo();
		int sumEcho = e.number(sum);
		System.out.println("sumEcho=" + sumEcho);
	}
}
