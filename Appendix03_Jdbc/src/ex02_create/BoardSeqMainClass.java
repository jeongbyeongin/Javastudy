package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class BoardSeqMainClass {

	public static void main(String[] args) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "CREATE SEQUENCE BOARD_SEQ NOCACHE";
			
			ps = con.prepareStatement(sql);
			if(ps.execute()) {
				System.out.println("BOARD_SEQ NOCACHE 생성이 실패햇두앜");
			} else {
				System.out.println("BOARD_SEQ NOCACHE 생성되엇디 ㅋㅋ");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
