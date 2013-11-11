package com.epam.data_readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MailReader {

	private static Scanner in;
	private static File file = null;

	public static String readEmail(String folderPath)
			throws FileNotFoundException, InterruptedException {

		String message = "";

		file = getFile(folderPath);

		in = new Scanner(file, "UTF-8");

		while (in.hasNext()) {
			message = in.next();
		}

		in.close();

		deleteFile(folderPath);

		return message;

	}

	private static File getFile(String folderPath) throws InterruptedException,
			FileNotFoundException {

		File list = new File(folderPath);

		int i = 0;

		while (list.listFiles().length == 0) {
			i++;
			Thread.sleep(500);
			if (i == 5)
				throw new FileNotFoundException();

		}

		return list.listFiles()[0];
	}

	public static void deleteFile(String folderPath) {

		File[] list = new File(folderPath).listFiles();

		for (File file : list) {
			file.delete();
		}

	}
}
