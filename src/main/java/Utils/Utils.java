package Utils;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Utils {

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

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {
            Path sourcePath = Paths.get(sourceDirectory);
            Path destinationPath = Paths.get(destinationDirectory);
            if (!Files.exists(sourcePath)) {
                throw new IllegalArgumentException();
            }
            if (!Files.isDirectory(sourcePath)) {
                throw new IllegalArgumentException();
            }
            if (!Files.exists(destinationPath)) {
                Files.createDirectories(destinationPath);
            }

            MyFileVisitor MFvisitor = new MyFileVisitor(sourcePath, destinationPath);
            Files.walkFileTree(sourcePath, MFvisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FolderSizeCalculator extends SimpleFileVisitor<Path> {
        private long size = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            size += Files.size(file);
            return FileVisitResult.CONTINUE;
        }

        public long getSize() {
            return size;
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private Path sourcePath;
        private Path destinationPath;

        public MyFileVisitor(Path sourcePath, Path destinationPath) {
            this.sourcePath = sourcePath;
            this.destinationPath = destinationPath;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Path targetPath = destinationPath.resolve(sourcePath.relativize(dir));
            if (!Files.exists(targetPath)) {
                Files.createDirectories(targetPath);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Path targetPath = destinationPath.resolve(sourcePath.relativize(file));
            Files.copy(file, targetPath, StandardCopyOption.REPLACE_EXISTING);
            return FileVisitResult.CONTINUE;
        }
    }
}