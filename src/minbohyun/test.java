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
				
				String DepP = "GMP";
				String ArrP = "CJU";
				String GoDay = "20210531";
				
				
				String sql;
//				sql = "SELECT * FROM airSchedule";
				sql = "SELECT * FROM airSchedule WHERE `from` = '"+ DepP +"' and fromDate = " + GoDay +" and `to` = '" + ArrP +"'";
				
//				System.out.println(sql);
				ResultSet rs = state.executeQuery(sql);
				
				while (rs.next()) {
					String scheduleNo = rs.getString("scheduleNo");
					String airline = rs.getString("airline");
					String flightCode = rs.getString("flightCode");
					String from = rs.getString("from");
					String fromDate = rs.getString("fromDate");
					String to = rs.getString("to");
					String toDate = rs.getString("toDate");
					if(from.equals("GMP") && to.equals("CJU") && toDate.equals("20210531") ) {
					System.out.println(scheduleNo + " " + airline + " " + flightCode + " " +
							from + " " + fromDate + " " + to + " " + toDate + " \n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				}
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
//	    System.out.println("close");
	    }
	public static void main(String[] args) {
		new test();
	}
	}
	
