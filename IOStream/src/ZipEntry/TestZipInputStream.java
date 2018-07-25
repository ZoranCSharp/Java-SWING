package ZipEntry;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestZipInputStream {
	
	public static void main (String args[]) {
		
		ZipEntry ze = null;
		
		try (FileInputStream myFile = new FileInputStream("ProjekatProba.zip");
				BufferedInputStream buff = new BufferedInputStream(myFile);
				ZipInputStream myZip = new ZipInputStream(buff);){
			
			while((ze = myZip.getNextEntry()) != null){
				
				System.out.println(ze.getName());
				myZip.closeEntry();
			}
			
			
		}catch(IOException e) {
			
			System.out.println("Could not red file " + e.toString());
		}
	}

}
