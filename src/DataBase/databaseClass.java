package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Constants;
import common.DatabaseConfig;

/**
 * Legacy database class - maintained for backward compatibility
 * New code should use DatabaseConfig instead
 *
 * @deprecated Use {@link DatabaseConfig} for new implementations
 */
@Deprecated
public class databaseClass {
	private static Connection conn;
	private static Statement stmt;

	/**
	 * Connect to database using default configuration
	 */
	public static void connect() {
		connect(Constants.DB_URL);
	}

	/**
	 * SQLite connection method (only file path needed)
	 */
	public static void connect(String dbURL) {
		try {
			// Database connection
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(dbURL);
			System.out.println(Constants.MSG_DB_CONNECT_SUCCESS);

			// Create Statement object for queries
			stmt = conn.createStatement();

		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(Constants.MSG_DB_CONNECT_FAIL);
			e.printStackTrace();
		}
	}

	/**
	 * Legacy MySQL compatibility method (dbID, dbPassword are ignored)
	 * @deprecated SQLite doesn't require username/password
	 */
	@Deprecated
	public static void connect(String dbURL, String dbID, String dbPassword) {
		connect(dbURL);
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
	
	
	
	/**
	 * Test method for database connection
	 */
	public static void main(String[] args) {
		connect();  // Use default database URL from Constants
		System.out.println("Database connection test completed");
		closeDB();
	}
}
