package kr.hs.dgsw.java.c2.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileReader {
	
	public static void main(String[] args) {
		
		try {
			
			File file = new File("C:/2021_DGSW/DGSW_2/zzz.txt");
			OutputStream os = new FileOutputStream(file);
			
			os.write(49);
			os.write(65);
			os.write(105);
			
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
