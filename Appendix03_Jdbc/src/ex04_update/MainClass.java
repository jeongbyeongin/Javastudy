package ex04_update;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "UPDATE BOARD_TBL SET TITLE = '[NEW]' || TITLE";
			sql += " WHERE MEMBER_NO = (SELECT MEMBER_NO FROM MEMBER_TBL WHERE ID = ?)"; 	// 단일 행 서브쿼리라서 단일 행 연산자를 사용할 수 있었다
			
			ps = con.prepareStatement(sql);
			
			String id = "admin";
			
			ps.setString(1, id);
			
			int updateResult = ps.executeUpdate();
			
			System.out.println(updateResult + "개의 행이 수저응되었습니두아ㅋ");
			
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
