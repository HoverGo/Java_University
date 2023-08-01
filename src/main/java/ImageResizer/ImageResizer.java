package ImageResizer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageResizer {

	public static void resize(String path, int width) {
		// TODO реализовать метод resize, который принимает путь до папки с
		// изображениями и меняет их размер
		File folder = new File(path);
		if (!truePath(path)) {
			throw new IllegalArgumentException();
		} else {
			File[] fileSet = folder.listFiles();
			if (fileSet.length == 0) {
				throw new IllegalArgumentException();
			}

			for (File file : fileSet) {
				try {
					BufferedImage image = ImageIO.read(file);
					int imgHeight = image.getHeight();
					int imgWidth = image.getWidth();
					double ratio = imgWidth/imgHeight;
					int newHeight = (int)Math.round(imgHeight*ratio);
					BufferedImage result = Scalr.resize(image, width, newHeight);
					ImageIO.write(result, "jpg", file);
					} catch (IOException e) {
						
					}
			}
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
