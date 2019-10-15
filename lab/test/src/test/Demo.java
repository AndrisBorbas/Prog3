package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo {

	static float[] asd = new float[10];

	public static void main(String[] args) throws IOException {

		asd[0] = 4;

		for (Float i : asd) {
			System.out.println(i);
		}
	}
}