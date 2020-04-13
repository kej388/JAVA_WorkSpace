import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC03 {
	
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false", "root", "1234");
			System.out.println("DB 연결 완료");
			
			stmt = conn.createStatement();
			
			//stmt.executeUpdate("insert into student values('0000001', '세종 ', '국문학')");
			//stmt.executeUpdate("update student set name = '세종대왕' where id = '0000001'" );
			//int result = stmt.executeUpdate("delete from student where id='0000001'");
			
			/*
			 * if(result != 0) {
			 * 
			 * }
			 */
			rs = stmt.executeQuery("select * from student");
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("dept"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();	
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
