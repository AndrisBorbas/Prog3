package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Match {

	public static File f = new File(System.getProperty("user.dir"));

	public static void main(String[] args) throws IOException {
		String pattern = "";
		String input = null;
		String output = null;

		for (int i = 0; i < args.length; i++) {
			if ((i + 1 < args.length) && args[i].equals("-i")) {
				i++;
				input = args[i];
			} else if ((i + 1 < args.length) && args[i].equals("-o")) {
				i++;
				output = args[i];
			} else if ((i + 1 < args.length) && args[i].equals("-p")) {
				i++;
				pattern = args[i];
			}
		}

		/*
		 * System.out.println(pattern); System.out.println(input);
		 * System.out.println(output);
		 */

		File[] files = f.listFiles();

		File in = null;

		for (File i : files) {
			if (i.getName().equals(input)) {
				in = new File(f.getCanonicalPath() + "/" + input);
			}
		}
		if (in == null) {
			System.exit(404);
		}

		BufferedReader br = new BufferedReader(new FileReader(in.getCanonicalPath()));

		File out = new File(f.getCanonicalPath() + "/" + output);
		BufferedWriter bw = new BufferedWriter(new FileWriter(out.getCanonicalPath()));

		String line;
		while ((line = br.readLine()) != null) {
			if (line.matches("(.*)" + pattern + "(.*)")) {
				bw.write(line + "\n");
			}
		}
		br.close();
		bw.close();
	}
}
