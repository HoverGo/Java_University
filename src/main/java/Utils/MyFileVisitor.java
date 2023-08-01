package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.SimpleFileVisitor;

public class MyFileVisitor extends SimpleFileVisitor {
	
	
	public static void visitFile(String sourceDirectory, String destinationDirectory) throws IOException {
		InputStream folder = null;
		OutputStream folder2 = null;
		try {
			folder = new FileInputStream(sourceDirectory);
			System.out.println(folder);
			folder2 = new FileOutputStream(destinationDirectory);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = folder.read(buffer)) > 0) {
				folder2.write(buffer, 0, length);
			}
		} catch (FileNotFoundException e) {

		} finally {

		}
	}

}
