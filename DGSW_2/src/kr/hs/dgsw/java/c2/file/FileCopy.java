package kr.hs.dgsw.java.c2.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public void copy(String source, String target) throws Exception {
		File sourceFile = new File(source);
		File targetFile = new File(target);
		
		InputStream is = new FileInputStream(sourceFile);
		OutputStream os = new FileOutputStream(targetFile);
		
		while (is.available() > 0) {
			int value = is.read();
			os.write(value);
			
		}
	}
	
	private void mian() {
		FileCopy copy = new FileCopy();
		
		try {
			copy.copy("C:/2021_DGSW/DGSW_2/abc.txt", "C:/2021_DGSW/DGSW_2/ABC.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
