//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Lab6
//  @ File Name : FileLogger.java
//  @ Date : 2019-10-21
//  @ Author : AndrisBorbas

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileLogger implements Observer {
	PrintWriter f;

	public FileLogger(String fileName) throws FileNotFoundException {
		f = new PrintWriter(new FileOutputStream(fileName));
	}

	@Override
	public void report(Observable observable) {
		f.println(observable);
		f.flush();
	}

	@Override
	public void finalize() {
		f.close();
	}
}
