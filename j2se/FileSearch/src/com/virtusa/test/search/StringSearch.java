package com.virtusa.test.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSearch {

	static StringBuilder sb = null;
	static File[] filesAll = new File[65536];
	static int count = 0;
	static char keyFound = 'N';

	public static void main(String[] args) throws IOException,
			URISyntaxException {

		if (args.length < 2) {
			// To get the name of the jar executing this class
			File jarFile = new File(com.virtusa.test.search.StringSearch.class
					.getProtectionDomain().getCodeSource().getLocation()
					.toURI());
			System.out
					.println("Usage: " + jarFile.getName() + " directory key");
			return;
		} else {
			System.out.println("Started searching for the key \"" + args[1]
					+ "\" on \"" + args[0] + "\" directory...");
			sb = new StringBuilder("");
			System.out.println(new StringSearch().search(args[0], args[1])
					.toString());
			if (keyFound == 'N')
				System.out.println("No match found for the key \"" + args[1]
						+ "\"");
		}

	}

	StringBuilder search(String filePath, String key) throws IOException {
		// Create a pattern to match key
		Pattern p = Pattern
				.compile(".*" + key + ".*", Pattern.CASE_INSENSITIVE);
		new StringSearch().displayFilesRecursively(filePath);
		for (int i = 0; i < count; i++) {
			sb.append("\nFor " + filesAll[i].getName() + ": \n");
			new StringSearch().searchForWord(filesAll[i].getAbsolutePath(), p);
		}

		return sb;

	}

	StringBuilder searchForWord(String filePath, Pattern p) throws IOException {
		// Get a Channel for the source file
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		FileChannel fc = fis.getChannel();

		// Get a CharBuffer from the source file
		ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc
				.size());
		Charset cs = Charset.forName("8859_1");
		CharsetDecoder cd = cs.newDecoder();
		CharBuffer cb = cd.decode(bb);

		// Run some matches
		Matcher m = p.matcher(cb);
		while (m.find())
			sb.append(m.group().trim() + "\n");
		keyFound = 'Y';
		return sb;
	}

	// Displays the files in a current directory( ls -a)
	File[] displayFiles(String directory) {
		File dir = new File(directory);
		File[] files = dir.listFiles(filterEnd);
		// System.out.println("*************** Files in :" + directory +"
		// directory");
		if (files != null)
			for (File file : files) {
				if (file.isFile()) {
					// System.out.println(file.getName());
					new StringSearch().addFile(file);
				}
			}
		return files;
	}

	// Display all the files recursively
	void displayFilesRecursively(String directory) {
		File dir = new File(directory);
		if (dir.isDirectory()) {
			new StringSearch().displayFiles(directory);
			File[] files = dir.listFiles();
			if (files != null)
				for (File file : files) {
					if (file.isDirectory()) {
						new StringSearch().displayFilesRecursively(file
								.getPath());
					}
				}
		} else if (dir.isFile()) {
			// System.out.println(dir.getName());
			new StringSearch().addFile(dir);
		} else {
			sb.append("Invalid directory \"" + directory + "\"\n");
			sb.append("Quitting the search.");
			keyFound = 'Y';
		}

	}

	void addFile(File file) {
		filesAll[count++] = file;

	}

	// File filter to display the files ends with ".BAT"
	FilenameFilter filterEnd = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return name.endsWith(".doc");
		}
	};

}
