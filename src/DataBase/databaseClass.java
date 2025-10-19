package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//
// SQLite 연결 코드 (MySQL에서 변경됨)
//
public class databaseClass {
	private static Connection conn;
	private static Statement stmt;

	// SQLite용 연결 메서드 (파일 경로만 필요)
	public static void connect(String dbURL) {
		try {
			// Database 연결
			Class.forName("org.sqlite.JDBC");	// SQLite 드라이버 로드
			conn = DriverManager.getConnection(dbURL);	// 연결 (ID, Password 불필요)
			System.out.println("데이터베이스 연결 성공!");

			// 쿼리 수행을 위한 Statement 객체 생성
			stmt = conn.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("에러");
			e.printStackTrace();
		}
	}

	// 기존 MySQL 호환성을 위한 메서드 (dbID, dbPassword는 무시됨)
	public static void connect(String dbURL, String dbID, String dbPassword) {
		connect(dbURL);  // SQLite는 ID/Password가 필요없으므로 URL만 사용
	}
	
	public static void closeDB() {
		try {
			conn.close();
			System.out.println("데이터베이스 연결 해제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	// SELECT
	//
	public static ResultSet select(String sql) {
		// 쿼리 수행
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//
	// INSERT
	//
	public static int insert(String sql) {
		// 쿼리 수행
		int rs = 0;
				
		try {
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//
	// UPDATE
	//
	public static int update(String sql) {
		// 쿼리 수행
		int rs = 0;
				
		try {
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//
	// DELETE
	//
	public static int delete(String sql) {
		// 쿼리 수행
		int rs = 0;
				
		try {
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
	public static void main(String[] args) {
		// SQLite 데이터베이스 파일 경로 (프로젝트 루트에 생성됨)
		String dbURL="jdbc:sqlite:inhaair.db";

		connect(dbURL);

	}
}
