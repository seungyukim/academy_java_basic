package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SCOTT 계정의 EMP 테이블을 조회하여
 * 데이터베이스 접속을 확인하는 클래스
 * 
 * 1. 드라이버 로드 
 * 2. 커넥션 맺기
 * 3. 쿼리 준비
 * 4. 쿼리 실행
 * 5. 결과 처리
 * 6. 자원 해제
 * ------------------------------------
 * @author PC38209
 *
 */
public class DriverLoadtype5 {

	private static final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";
	private static final String DRIVER = "oracle.jdbc.OracleDriver";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// 1. 드라이버 로드 : 방법 1 : 클래스를 바로 메모리에 로드
		Class.forName(DRIVER);
		
		// 2. 커넥션 맺기
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// 3. 쿼리 준비
		String sql = "SELECT e.EMPNO"
				+ "         ,e.ENAME"
				+ "     FROM emp e"
				+ "    ORDER BY e.ENAME";
		
		Statement stmt = conn.createStatement();
		
		// 4. 쿼리 실행
		ResultSet result = stmt.executeQuery(sql);
		
		// 5. 결과 처리 : 반복수행 (DQL 실행 결과는 보통 여러 행이기 때문)
		
		// 결과 셋의 정보
		ResultSetMetaData meta = result.getMetaData();
		String empnoCol = meta.getColumnName(1);
		String enameCol = meta.getColumnName(2);
		
		System.out.printf("%6s   | %6s%n", empnoCol, enameCol);
		
		while (result.next()) {
			int empno = result.getInt(1);
			String ename = result.getString(2);
			System.out.printf("사번:%d | 이름:%s%n", empno, ename);
		}
		
		// 6. 자원 해제
		//    순서 : 오픈한 반대 순서
		//         result => stmt => conn
		if (result != null) 
			result.close();
		
		if (stmt != null)
			stmt.close();
		
		if (conn != null)
			conn.close();
		
		
	}

}
