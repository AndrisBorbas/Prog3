package javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

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

			if (cmd[0].equals("length"))
				length(cmd);

			if (cmd[0].equals("tail"))
				tail(cmd);

			if (cmd[0].equals("grep"))
				grep(cmd);
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

	protected static void length(String[] args) {
		if (args.length == 2) {
			File[] files = f.listFiles();
			for (File i : files) {
				if (i.getName().equals(args[1])) {
					System.out.println(i.length() + " bytes");
					return;
				}
			}
		}
		System.out.println("File not found!");
	}

	protected static void tail(String[] args) throws FileNotFoundException, IOException {
		int n = 0;
		File file = null;
		if (args.length == 4) {
			if (args[1].equals("-n")) {
				n = Integer.parseInt(args[2]);
				file = new File(f.getCanonicalPath() + "/" + args[3]);
			}

		}
		if (args.length == 2) {
			n = 10;
			file = new File(f.getCanonicalPath() + "/" + args[1]);
		}
		if (file == null || n <= 0) {
			System.out.println("Wrong command!");
			return;
		}
		if (!file.exists()) {
			System.out.println("File doesn't exist!");
			return;
		}

		LinkedList<String> list = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file.getCanonicalPath()));
		String temp = br.readLine();
		while (temp != null) {
			if (list.size() == n) {
				list.removeFirst();
			}
			list.add(temp);
			temp = br.readLine();
		}
		for (String i : list) {
			System.out.println(i);
		}
		br.close();
	}

	protected static void grep(String[] args) throws IOException {
		if (args.length != 3) {
			System.out.println("Wrong command!");
			return;
		}
		File file = null;
		file = new File(f.getCanonicalPath() + "/" + args[2]);
		if (!file.exists()) {
			System.out.println("File doesn't exist!");
			return;
		}
		
		String pattern = args[1];
		BufferedReader br = new BufferedReader(new FileReader(file.getCanonicalPath()));
		String line;
		while ((line = br.readLine()) != null) {
			if (line.matches("(.*)" + pattern + "(.*)")) {
				System.out.println(line);
			}
		}
		br.close();
	}
}
