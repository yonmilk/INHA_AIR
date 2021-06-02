package minbohyun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import customer.book.ticketing.TicketingOneWay;

public class test {
	
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
	private final String DB_URL = "jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false"; //접속할 DB 서버
		
	private final String USER_NAME = "inhaair"; //DB에 접속할 사용자 이름을 상수로 정의
	private final String PASSWORD = "1234"; //사용자의 비밀번호를 상수로 정의

	
	public test(){ 
	    Connection conn = null; 
		Statement state = null; 
	    try{
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				System.out.println("CON");
				state = conn.createStatement();
				
				String DepP = "GMP";
				String ArrP = "CJU";
				String GoDay = "20210531";
				
				
				String sql;
//				sql = "SELECT * FROM airSchedule";
				sql = "SELECT * FROM airSchedule WHERE `from` = '"+ DepP +"' and fromDate = " + GoDay +" and `to` = '" + ArrP +"'";
				
				System.out.println(sql);
				ResultSet rs = state.executeQuery(sql);
				
				while (rs.next()) {
					String scheduleNo = rs.getString("scheduleNo");
					String airline = rs.getString("airline");
					String flightCode = rs.getString("flightCode");
					String from = rs.getString("from");
					String fromDate = rs.getString("fromDate");
					String to = rs.getString("to");
					String toDate = rs.getString("toDate");
//					if(from.equals("GMP") && to.equals("CJU") && toDate.equals("2021-05-31") ) {
					System.out.println(scheduleNo + " " + airline + " " + flightCode + " " +
							from + " " + fromDate + " " + to + " " + toDate + " \n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//				}
				}
				//scheduleNo, airline, flightCode, from, fromDate, to, toDate
				
				rs.close();
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
	    System.out.println("close");
	    }
	public static void main(String[] args) {
		new test();
	}
	}
	
