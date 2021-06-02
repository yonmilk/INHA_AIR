package minbohyun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import customer.book.ticketing.TicketingOneWay;

public class success {
	
	public success(){ 
		abc();
	}
	private void abc() {
	String driver = "com.mysql.cj.jdbc.Driver"; //드라이버
	String dbURL = "jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false"; //접속할 DB 서버
	String dbID = "inhaair"; //DB에 접속할 사용자 이름을 상수로 정의
	String dbPassword = "1234"; //사용자의 비밀번호를 상수로 정의
		
	    Connection conn = null; 
		Statement state = null; 
	    try{
				Class.forName(driver);
				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				state = conn.createStatement();
				
				String DepP = "GMP";
				String ArrP = "CJU";
				String GoDay = "20210531";
				String sql;
				sql = "SELECT * FROM airSchedule WHERE `from` = '"+ DepP +"' and fromDate = " + GoDay +" and `to` = '" + ArrP +"'";
				
				ResultSet rs = state.executeQuery(sql);
				while (rs.next()) {
					String scheduleNo = rs.getString("scheduleNo");
					String airline = rs.getString("airline");
					String flightCode = rs.getString("flightCode");
					String from = rs.getString("from");
					String fromDate = rs.getString("fromDate");
					String to = rs.getString("to");
					String toDate = rs.getString("toDate");
					System.out.println(scheduleNo + " " + airline + " " + flightCode + " " +
							from + " " + fromDate + " " + to + " " + toDate + " \n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				}
				
				rs.close();
				state.close();
				conn.close();
	    }
	    catch (Exception e) {
		}finally {
			try {
				if(state!=null) 
					state.close();
			}catch (SQLException ex1) {
			}
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException ex2) {
			}
		}
	    
	}
	public static void main(String[] args) {
		new success();
		}
	
	}
	
