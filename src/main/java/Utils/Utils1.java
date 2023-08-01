package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils1 {

	public static long calculateFolderSize(String path) {
		File folder = new File(path);
		long size = 0;
		if (!truePath(path)) {
			throw new IllegalArgumentException();
		} else if (folder.isFile()) {
			size = folder.length();
		} else {
			File[] fileSet = folder.listFiles();
			for (File file : fileSet) {
				if (file.isFile()) {
					size += file.length();
				} else {
					size += calculateFolderSize(file.getAbsolutePath());
				}
			}
		}
		return size;
	}

	public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
		String newFolder = destinationDirectory + "\\" + sourceDirectory.split("\\")[-1];
		// TODO реализовать метод копирования папки sourceDirectory в
		// destinationDirectory

		if (!truePath(sourceDirectory)) {
			throw new IllegalArgumentException(sourceDirectory);
		} else {
			Files.createDirectory(Paths.get(newFolder));
			

		}
	}

	public static boolean truePath(String path) {
		boolean buly = true;
		if (path.isEmpty() || !new File(path).exists()) {
			buly = false;
		}

		return buly;
	}

}
