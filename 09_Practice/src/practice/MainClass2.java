package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass2 {

	// 문제8. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86_64.zip 파일을
	// C:\storage\eclipse.zip으로 복사하시오.
		public static void ex08() {
			
			String sep = File.separator;
			File from = new File("C:" + sep + "GDJ" + sep + "install" + sep + "eclipse-jee-2021-03-R-win32-x86_64.zip");
			File to = new File("C:" + sep + "storage" + "eclipse.zip");
			
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				
				bin = new BufferedInputStream(new FileInputStream(from));
				bout = new BufferedOutputStream(new FileOutputStream(to));
				
				byte[] b = new byte[1024];
				int readByte = 0;
				while((readByte = bin.read(b)) != -1) {
					bout.write(b, 0, readByte);
				}
				
				System.out.println("복사 완료되었습니다.");
				
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(bout != null) { bout.close();}
					if(bin != null) { bin.close();}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	public static void main(String[] args) {
		ex08();

	}

}
