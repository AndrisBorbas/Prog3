package javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static File f = new File(System.getProperty("user.dir"));

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = reader.readLine();

			String cmd[] = s.split(" ");

			if (cmd[0].equals("exit"))
				exit();

			if (cmd[0].equals("pwd"))
				pwd();

			if (cmd[0].equals("cd"))
				cd(cmd);

			if (cmd[0].equals("ls"))
				ls(cmd);

			if (cmd[0].equals("reclist") || cmd[0].equals("lsdir"))
				reclist(f, "");
		}

	}

	protected static void exit() {
		System.exit(0);
	}

	protected static void pwd() throws IOException {
		System.out.println(f.getCanonicalPath());
	}

	protected static void cd(String[] args) throws IOException {
		if (args.length == 2) {
			if (args[1].equals("..")) {
				f = f.getParentFile();
				pwd();
				return;
			} else {
				String[] dirs = f.list();
				for (String i : dirs) {
					if (i.equals(args[1])) {
						f = new File(f.getCanonicalPath() + "/" + args[1]);
						pwd();
						return;
					}
				}
			}
		}
		System.out.println("No matching directory!");
		pwd();
	}

	protected static void ls(String[] args) {
		if (args.length == 2) {
			if (args[1].equals("-l")) {
				File files[] = f.listFiles();
				for (File i : files) {
					if (i.isDirectory()) {
						System.out.println("d | name: " + i.getName());
					} else {
						System.out.println("f | size: " + i.length() + " bytes \t | name: " + i.getName());
					}
				}
				return;
			}
		} else {
			String[] dirs = f.list();
			for (String i : dirs) {
				System.out.println(i);
			}
		}
	}

	protected static void reclist(File fr, String tab) {
		File[] files = fr.listFiles();
		for (File i : files) {
			System.out.println(tab + i.getName());
			if (i.isDirectory()) {
				reclist(i, tab + "  ");
			}
		}
	}
}
