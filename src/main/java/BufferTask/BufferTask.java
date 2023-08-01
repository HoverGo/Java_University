package BufferTask;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferTask {

    public static void refactorFile() {
        //TODO
    	Path path = Paths.get("File.txt");
    	
    	try {
    		ReadableByteChannel in = FileChannel.open(path);
    		File file = new File(path.toString().substring(0, path.toString().length()-8) + "newFile.txt");
    		OutputStream newFileStream = new FileOutputStream(file);
    		WritableByteChannel out = Channels.newChannel(newFileStream);
    		
    		ByteBuffer buffer = ByteBuffer.allocate(2);
    		
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
    	} catch(IOException a) {
    		
    	}
    	
    }
}