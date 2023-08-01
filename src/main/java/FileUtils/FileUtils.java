package FileUtils;

import java.io.File;

public class FileUtils {

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
	
	public static boolean truePath(String path) {
		boolean buly = true;
		if (path.isEmpty() || !new File(path).exists()) {
			buly = false;
		}
		
		return buly;
	}
}