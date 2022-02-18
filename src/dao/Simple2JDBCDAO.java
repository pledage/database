package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Simple2JDBCDAO {

	public static void main(String[] args) throws Exception {
//		JDBC 프로그래밍
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "SELECT * FROM exam";
		
//		1. 드라이버 로드(Class.forName())
		Class.forName("com.mysql.cj.jdbc.Driver");
//		2. DB연결(DriverManager.getConnection())
		Connection conn = DriverManager.getConnection(url, user, password);
//		3. SQL문작성(Statement, PrepareStatement) 앞의 두가지 방법이 있다(Statement직접실행, PrepareStatement설정후 실행)
		Statement stmt = conn.createStatement();//스테이트먼트 객체 생성
//		4. SQL문실행(executeQuery(), executeUpdate())
		ResultSet rs = stmt.executeQuery(sql);
//		5. Select문 만 ResultSet 객체를 반환한다.
//		   나머진 int를 반환한다.
		while(rs.next()) {
		System.out.printf("varchartest:%s",rs.getString("varchartest"));
		System.out.printf("chatTest:%s",rs.getString("chatTest"));
		System.out.printf("intTest:%s",rs.getString("intTest"));
		System.out.printf("dateTest:%s",rs.getString("dateTest"));
		System.out.printf("dateTimeTest:%s %n",rs.getString("dateTimeTest"));
		}
//		6. 닫기(close())// TODO Auto-generated method stub
		rs.close();
		stmt.close();
		conn.close();

	}

}
