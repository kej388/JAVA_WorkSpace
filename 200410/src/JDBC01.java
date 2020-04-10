
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class JDBC01 {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "1234");
			System.out.println("DB 연결 완료");
		} catch(IOException e) {
			e.printStackTrace();
		}
	} 
}
