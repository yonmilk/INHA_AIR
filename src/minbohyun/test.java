package minbohyun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import customer.book.ticketing.TicketingOneWay;

public class test {
	
	private final String driver = "com.mysql.cj.jdbc.Driver"; //드라이버
	private final String dbURL = "jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false"; //접속할 DB 서버
	private final String dbID = "inhaair"; //DB에 접속할 사용자 이름을 상수로 정의
	private final String dbPassword = "1234"; //사용자의 비밀번호를 상수로 정의

	
	public test(){ 
	    Connection conn = null; 
		Statement state = null; 
	    try{
				Class.forName(driver);
				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				System.out.println("연결");
				state = conn.createStatement();
				
				state.close();
				conn.close();
	            
	    }
	    catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(state!=null) 
					state.close();
			}catch (SQLException ex1) {
				// TODO: handle exception
			}
			try {
				if(conn!=null)
					conn.close();
				
			} catch (SQLException ex2) {
				// TODO: handle exception
			}
		}
//	    System.out.println("close");
	    }
	public static void main(String[] args) {
		new test();
	}
	}
	
