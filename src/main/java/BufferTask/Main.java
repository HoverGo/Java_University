package BufferTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		File file1 = new File("C:\\Users\\hover\\Desktop\\Stud\\abba\\ssss.txt");
		
		try {
			Path path = file1.toPath();
			ReadableByteChannel in = FileChannel.open(path);
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			File file = new File(path.toString().substring(0, path.toString().length()-8) + "newFile.txt");
    		OutputStream newFileStream = new FileOutputStream(file);
    		WritableByteChannel out = Channels.newChannel(newFileStream);
			int count = 0;
			while (in.read(buffer) >= 0 || buffer.position() != 0) {
				int index = 0;
				byte[] byteArr = buffer.array();
				byte[] byteArr2 = new byte[1024];
				for (int i = 0; i<byteArr.length; i++) {
					char a = (char)byteArr[i];
					if (String.valueOf(a).matches("\\d+")) {
						byteArr[i] = 0;

					} else {
						byteArr2[count] = byteArr[i];
						count++;
					}
				}
				
				for (int i = 0; i<byteArr2.length; i++) {
					if (byteArr2[i] == 0) {
						index = i;
						break;
					}
				}

				byte[] byteArrNew = new byte[index];
				for (int i = 0; i<byteArrNew.length; i++) {
					byteArrNew[i] = byteArr2[i];
				}
				
				buffer.flip();
				buffer = buffer.wrap(byteArrNew);
    			out.write(buffer);
    			buffer.compact();
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
