package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainClass2 {

	public static void main(String[] args) {
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		
		// InputStream in = null;			// Daum 로그를 읽어 들이는 입력 스트림
		// FileOutputStream out = null;	// C:\storage\daum.png로 내보내는 출력 스트림
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		File file = new File("C:" + File.separator + "storage", "daum.png");

		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();		// 자바와 다음사이트를 연결하는메소드
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {			// 접속되었다면 작업을 수행하겠다.
				
				in = new BufferedInputStream(con.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file));
				
				//	in = con.getInputStream();
				//	out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "daum.png");	// 파일값 스트림으로 전달할 수 있음
				
				byte[] b = new byte[10];
				int readByte = 0;
				
				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte);
				}
				
				System.out.println("다운로드 완료");
				
				out.close();
				in.close();
				con.disconnect();
				
			}
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
		
	}

	}

}
