package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Simple5JDBCDAO {

	public static void main(String[] args) {
		double param =100.001;
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "SELECT * FROM exam WHERE 	intTest = ? "+ param;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			try {
			//1. 드라이버 로드(Class.forName())
			Class.forName("com.mysql.cj.jdbc.Driver");			
			//2. DB연결(DriverManager.getConnection())
			conn = DriverManager.getConnection(url, user, password);
			//3. SQL문작성(Statement, PreparedStatement)
			stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, param);
			
			
			//4. SQL문실행(executeQuery(), executeUpdate())
			rs = stmt.executeQuery(sql);
			//5. Select문 만 ResultSet 객체를 반환한다.
			//   나머진 int를 반환한다.
			while(rs.next()) {
				System.out.printf("varcharTest:%s,",rs.getString("varchartest"));
				System.out.printf("charTest:%s,",rs.getString("chartest"));
				System.out.printf("intTest:%s,",rs.getString("intTest"));
				System.out.printf("dateTest:%s,",rs.getString("dateTest"));
				System.out.printf("dateTimeTest:%s %n",rs.getString("dateTimeTest"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//6. 닫기(close())
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		
	}

}




