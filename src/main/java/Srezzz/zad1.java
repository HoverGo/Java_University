package Srezzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Scanner;

public class zad1 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		String str;
		int counter = 0;
		str = input.next();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
			String line = reader.readLine();
			while (line != null) {
				if(line.contains(str)) {
					counter++;
				}
				
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Количество строк, в которых содержится эта строка");
		
		

	}

}