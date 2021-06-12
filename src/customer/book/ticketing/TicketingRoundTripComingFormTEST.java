package customer.book.ticketing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import be.main.MainForm;
import be.menu.MenuBar;
import customer.book.ReservationDetailForm;
import customer.start.MainMenuForm;


public class TicketingRoundTripComingFormTEST extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 예원 - 컴포넌트
	private JButton btnMainMenu;
	// 예원 - Forms
	private MainMenuForm mainMenuForm;
	
	// 예원 - 색상
	Color colorLogo = new Color(24, 62, 111);
	// 예원 - 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	private TicketingRoundTripGoingForm rtg1;
	
	private JPanel jpSelectedInfo;
	//--가상의 고객이 선택한 정보
	private String DepP = " "; //고객이 선택한 정보 : 
	private String ArrP = " "; // 출발지 GMP 도착지 PUS (P : place)
	private String GoDay = ""; //출발 날짜 : 21.0515- 
	private String ComeDay = "";//도착 날짜 : 0601(화)    (D : date)
	private int AdultP = 3;//성인
	private int ChildP = 2;//소아인원
	private int InfantP = 1;//소아인원
	private String ID = "";
//	private int AdultP = rtg1.getAdultP();//성인
//	private int ChildP = rtg1.getChildP();//소아인원
//	private int InfantP = rtg1.getInfantP();//소아인원
//	private String ID = rtg1.getID();
	private String reserveNum;
	
	
	
	public void setDepP(String depP) {
		DepP = depP;
	}

	public void setArrP(String arrP) {
		ArrP = arrP;
	}

	public void setGoDay(String goDay) {
		GoDay = goDay;
	}

	public void setComeDay(String comeDay) {
		ComeDay = comeDay;
	}

	public void setAdultP(int adultP) {
		AdultP = adultP;
	}

	public void setChildP(int childP) {
		ChildP = childP;
	}

	public void setInfantP(int infantP) {
		InfantP = infantP;
	}
	public String getCOMSheduleNo() {
		return COMscheduleNo;
	}
	
	public String getReserveNum() {
		return reserveNum;
		
		
	}
	

		private JLabel lblArrow; //왕복 화살표
		private JLabel lblPassenger;// 탑승 인원 정보 (성인인지 유아인지의 정보 + 인원수)
		
		private JPanel jpFlight1; // 시간 선택시 비행기1
		private JPanel jpFlight2; // 비행기 2
		private JPanel jpFlight3; // 비행기 3
		
		private Color crInfo; //고객이 선택한 정보를 나타내는 바의 색 
		private Color crClass;//좌석 등급 버튼 색
		private JPanel jpTotalPay; // 예상 결제금액 + 버튼 나타내는 패널
		private Component lblTotalPay; //"예상결제금액"문구 나타내는 라벨
		private JLabel lblPayment;// 실제 예상 결제금액이 뜨는 곳
		private JButton btnMember; //회원으로 진행 버튼
		private JButton btnNonMember; //비회원으로 진행 버튼
//		private ImageIcon imgArrow;
//		private ImageIcon imgAeroPlane;
		private Color crMember; //회원 버튼 색
		private Color crNonMember;// 비회원 버튼 색
		
		Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
		Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 18
		Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 18
		Font fontNanumGothic15= new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 18
		Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
		Font fontNanumGothic18Plain = new Font("NanumGothic", Font.PLAIN, 18);	// 나눔고딕 18
		Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
		Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
		Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
		Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 25
		Font fontNanumGothic25Plain = new Font("NanumGothic", Font.PLAIN, 25);	// 나눔고딕 25
	
		private JLabel lblDepP;
		private JLabel lblArrP;
		private JLabel lblGoComeDate;

		private String scheduleNo;
		private String flightCode;
		private String from;
		private String fromDate;
		private String to;
		private String toDate;
		private String fromTime;
		private String toTime;
		private JLabel lblFliCo;
		private JLabel lblTime;
		private String economyClass;
		private String prestigeClass;
		private String firstClass;
		private JLabel eco1;
		private JLabel pres1;
		private JLabel fir1;
		private JPanel jpFlightTOP;
		private Color crTop;
		private JLabel lblDate;
		private JLabel lblAirportD;
		private JLabel lblAirportA;
		private JLabel lblEcon;
		private JLabel lblEconPr;
		private String economy;
		private JButton btnEcon;
		private Color crSelect;
		private Component lblPres;
		private Component lblPresPr;
		private JButton btnPres;
		private String prestige;
		private Component lblFirs;
		private Component lblFirsPr;
		private JButton btnFirs;
		private String first;
		private JLabel lblTotalPayGoing;
		private int finaltotalPay;
		private String airportD;
		private String airportA;
//		private TicketingRoundTripGoingForm rtg1;
		private int payGo;
		private String selectedSeatCome;
		private int intEcoPrice;
		private int intPayGo;
		private int intBusPrice;
		private int intFirPrice;
		private String COMscheduleNo;
		
		
	public TicketingRoundTripComingFormTEST() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 레이아웃 설정
		setLayout(null);
		
		// 배경색
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		
		// 예원 - 메인메뉴로 돌아가기 버튼
		btnMainMenu = new JButton("INHA AIR");
		btnMainMenu.setSize(200, 50);
		btnMainMenu.setLocation(10, 10);
		btnMainMenu.setFont(fontArial30);
		btnMainMenu.setForeground(colorLogo);
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setBackground(Color.WHITE);
		
		// 예원 - 리스너
		btnMainMenu.addActionListener(this);
		
		// 예원 - 컴포넌트 붙이기
		add(btnMainMenu);
				
		crInfo = new Color(240,240,240);//고객이 선택한 정보를 나타내는 바의 색 
		crClass = new Color(213, 230, 250);//좌석 등급 선택 버튼의 색
		crTop = new Color(230,230,235);//고객이 선택한 정보를 나타내는 바의 색 
		crSelect = new Color(120,180,250);

		crMember = new Color(10,90,150); //회원 버튼 색깔
		crNonMember = new Color(150,150,150); //비회원 버튼 색깔
		
		jpSelectedInfo = new JPanel(); //고객이 선택한 정보를 표시하는 바
		jpSelectedInfo.setLayout(null);
		jpSelectedInfo.setSize(1000,60);
		jpSelectedInfo.setLocation(70,100);
		jpSelectedInfo.setBackground(crInfo);
		
		lblArrow = new JLabel("→"); //문자로 넣을지 그림으로 넣을지 ..
		lblArrow.setFont(fontNanumGothic30);
		lblArrow.setBounds(135, -20, 200, 100);

		lblPassenger = new JLabel("    성인  " + AdultP + "명   " +"  |  "+ "  소아  "+ ChildP + "명"); //고객이 선택한 탑승자 정보
		lblPassenger.setFont(fontNanumGothic18Plain);
		lblPassenger.setBounds(640, -20, 500, 100);
		
		jpFlightTOP = new JPanel(); //3개의 시간표 중 선택 1
		jpFlightTOP.setLayout(null);
		jpFlightTOP.setSize(1000,100);
		jpFlightTOP.setLocation(70,185);
		jpFlightTOP.setBackground(crTop);
		
		jpFlight1 = new JPanel(); //3개의 시간표 중 선택 1
		jpFlight1.setLayout(null);
		jpFlight1.setSize(1000,70);
		jpFlight1.setLocation(70,310);
		jpFlight1.setBackground(crInfo);
		
		jpFlight2 = new JPanel();//선택 2
		jpFlight2.setLayout(null);
		jpFlight2.setSize(1000,70);
		jpFlight2.setLocation(70,400);
		jpFlight2.setBackground(crInfo);
		
		
		jpFlight3 = new JPanel();// 선택 3
		jpFlight3.setLayout(null);
		jpFlight3.setSize(1000,70);
		jpFlight3.setLocation(70,490);
		jpFlight3.setBackground(crInfo);

		jpSelectedInfo.add(lblArrow); // 화살표
		jpSelectedInfo.add(lblPassenger); //탑승 인원 정보(성인인지 유아인지 + 인원수)
		
		jpTotalPay = new JPanel();//예상 결제 금액 + 버튼 라벨나타내는 패널
		jpTotalPay.setLayout(null);
		jpTotalPay.setSize(1120,130);
		jpTotalPay.setLocation(00,590);
		jpTotalPay.setBackground(Color.white);
		jpTotalPay.setBorder(new LineBorder(Color.black,1));
		
		lblTotalPay = new JLabel("예상 결제 금액"); // "예상 결제 금액" 라벨
		lblTotalPay.setFont(fontNanumGothic20);
		lblTotalPay.setBounds(50,0,200,100);
	
		lblTotalPayGoing = new JLabel("pay");
		lblTotalPayGoing.setFont(fontNanumGothic20);
		lblTotalPayGoing.setBounds(500,0,200,100);
		
		
		jpTotalPay.add(lblTotalPayGoing);
		
		btnMember = new JButton("예매 진행"); // 회원 진행 버튼
		btnMember.setFont(fontNanumGothic20);
		btnMember.setBackground(crMember);
		btnMember.setForeground(Color.white);
		btnMember.setBounds(905, 0, 200, 100);
		
		// 예원 - 리스너
		btnMember.addActionListener(this);
		
		jpTotalPay.add(lblTotalPay);
		jpTotalPay.add(btnMember);
		
		add(jpSelectedInfo);
		add(jpFlightTOP);

		add(jpFlight1);
		add(jpFlight2);
		add(jpFlight3);
		
		add(jpTotalPay);
		
		Find();
		
		lblEcon = new JLabel("이코노미 클래스");
		lblEcon.setFont(fontNanumGothic25);
		lblEcon.setBounds(60, -15, 200, 100);
		
		lblEconPr = new JLabel(economyClass + " 원          " + " 현재 잔여           "+ economy + "석" );
		lblEconPr.setFont(fontNanumGothic20);
		lblEconPr.setBounds(350, -15,400, 100);
		
		btnEcon = new JButton("선택");
		btnEcon.setFont(fontNanumGothic18Plain);
		btnEcon.setBounds(810, 20,100, 30);
		btnEcon.setBackground(crSelect);
		btnEcon.setForeground(Color.white);
		btnEcon.addActionListener(this);

		
		jpFlight1.add(lblEcon);
		jpFlight1.add(lblEconPr);
		jpFlight1.add(btnEcon);
		
		
		
		lblPres = new JLabel("프레스티지 클래스");
		lblPres.setFont(fontNanumGothic25);
		lblPres.setBounds(60, -15, 400, 100);
		
		lblPresPr = new JLabel(prestigeClass + " 원          " + " 현재 잔여           "+ prestige + "석" );
		lblPresPr.setFont(fontNanumGothic20);
		lblPresPr.setBounds(350, -15,400, 100);
		
		btnPres = new JButton("선택");
		btnPres.setFont(fontNanumGothic18Plain);
		btnPres.setBounds(810, 20,100, 30);
		btnPres.setBackground(crSelect);
		btnPres.setForeground(Color.white);
		btnPres.addActionListener(this);

		jpFlight2.add(lblPres);
		jpFlight2.add(lblPresPr);
		jpFlight2.add(btnPres);
		
		lblFirs = new JLabel("퍼스트 클래스");
		lblFirs.setFont(fontNanumGothic25);
		lblFirs.setBounds(60, -15, 400, 100);
		
		lblFirsPr = new JLabel(firstClass + " 원          " + " 현재 잔여           "+ first + "석" );
		lblFirsPr.setFont(fontNanumGothic20);
		lblFirsPr.setBounds(350, -15,400, 100);
		
		btnFirs = new JButton("선택");
		btnFirs.setFont(fontNanumGothic18Plain);
		btnFirs.setBounds(810, 20,100, 30);
		btnFirs.setBackground(crSelect);
		btnFirs.setForeground(Color.white);
		btnFirs.addActionListener(this);

		jpFlight3.add(lblFirs);
		jpFlight3.add(lblFirsPr);
		jpFlight3.add(btnFirs);
		
		
		lblDepP = new JLabel(from);
		lblDepP.setFont(fontNanumGothic25);
		lblDepP.setBounds(50, -20, 200, 100);
		
		lblArrP = new JLabel(to);
		lblArrP.setFont(fontNanumGothic25);
		lblArrP.setBounds(180, -20, 200, 100);
		
//		lblDate = new JLabel("<html>"+fromDate + "&nbsp;&nbsp;&nbsp; ~ &nbsp;&nbsp;&nbsp;" + toDate+"</html>");
		lblGoComeDate = new JLabel(GoDay + " ~ "+ComeDay);
		lblGoComeDate.setFont(fontNanumGothic18Plain);
		lblGoComeDate.setBounds(300, -20, 400, 100);

		lblFliCo = new JLabel(flightCode);
		lblFliCo.setFont(fontNanumGothic30);
		lblFliCo.setBounds(70, 0, 300, 100);
		
		
		lblDate = new JLabel(fromDate);
		lblDate.setFont(fontNanumGothic18Plain);
		lblDate.setBounds(230, 0, 300, 100);
		
		lblTime = new JLabel("출발 "+ fromTime+"   -  "+" 도착 "+toTime);
//		lblTime = new JLabel("출발 "+ fromTime.substring(0, 5)+"   -  "+" 도착 "+toTime.substring(0, 5));
		lblTime.setFont(fontNanumGothic18Plain);
		lblTime.setBounds(500, 0, 300, 100);
		
		lblAirportD = new JLabel(airportD);
		lblAirportD.setFont(fontNanumGothic30);
		lblAirportD.setBounds(350, 0, 200, 100);
		
		lblAirportA = new JLabel(airportA);
		lblAirportA.setFont(fontNanumGothic30);
		lblAirportA.setBounds(780, 0, 200, 100);
		
//		lblAirportD = new JLabel(from);
//		lblAirportD.setFont(fontNanumGothic30);
//		lblAirportD.setBounds(400, 0, 200, 100);
//		
//		lblArrP2 = new JLabel(to);
//		lblArrP2.setFont(fontNanumGothic30);
//		lblArrP2.setBounds(750, 0, 200, 100);
		
		jpSelectedInfo.add(lblDepP);
		jpSelectedInfo.add(lblArrP);
		jpSelectedInfo.add(lblGoComeDate);
		
		jpFlightTOP.add(lblFliCo);
		jpFlightTOP.add(lblDate);
		jpFlightTOP.add(lblTime);
		jpFlightTOP.add(lblAirportD);
		jpFlightTOP.add(lblAirportA);
		
//		System.out.println(rtg2.getGoDay());
		
		
		setVisible(true);
	}
	private void Find() {
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
//				System.out.println("oo");
				
//				String DepP = "GMP";
				
				TicketingRoundTripGoingForm rt1 = new TicketingRoundTripGoingForm();
//				rt1.setVisible(false);
				String DepP = rt1.getArrP();
				
//				String ArrP = "GMP";
				
				String sql;
				sql = "SELECT * FROM airport WHERE `code` = '"+ DepP +"' ";
				
				ResultSet rs = state.executeQuery(sql);
				while (rs.next()) {
					airportD = rs.getString("airport");
						
//					System.out.println(airportD);
					
//					DepAP = airportD;
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
		
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				state = conn.createStatement();
//				System.out.println("oo");
				
//				String ArrP = "CJU";
				
				TicketingRoundTripGoingForm rt2 = new TicketingRoundTripGoingForm();
				rt2.setVisible(false);
				((Connection) rt2).close();
				String ArrP = rt2.getDepP();
				
				String sql;
				sql = "SELECT * FROM airport WHERE `code` = '"+ ArrP +"' ";
				
				ResultSet rs = state.executeQuery(sql);
				while (rs.next()) {
					airportA = rs.getString("airport");
						
//					System.out.println(airportA);
					
//					ArrAP = airportA;
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
			
			 try{
					Class.forName(driver);
					conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
					state = conn.createStatement();
//					System.out.println("oo");
					
					String SelectedFliCo = "IH8985";
					
					String sql;
					sql = "SELECT * FROM airPrice WHERE `flightCode` = '"+ SelectedFliCo +"' ";
					
					ResultSet rs = state.executeQuery(sql);
					while (rs.next()) {
						economyClass = rs.getString("economyClass");
						prestigeClass = rs.getString("prestigeClass");
						firstClass = rs.getString("firstClass");
							
//						System.out.println(economyClass + " " + prestigeClass + " " +
//								firstClass + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
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
		    try{
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			state = conn.createStatement();	
					
					String DepP = "CJU";
					String ArrP = "GMP";
					String GoDay = "20210531";
				
					String sql;
					sql = "SELECT * FROM airSchedule WHERE `from` = '"+ ArrP +"' and fromDate = " + GoDay +" and `to` = '" + DepP +"'and toDate = " + ComeDay +"";
					
					ResultSet rs = state.executeQuery(sql);
					while (rs.next()) {
						scheduleNo = rs.getString("scheduleNo");
						flightCode = rs.getString("flightCode");
						
						from = rs.getString("from");
						fromDate = rs.getString("fromDate");
						fromTime = rs.getString("fromTime");

						to = rs.getString("to");
						toDate = rs.getString("toDate");
						toTime = rs.getString("toTime");
						
						COMscheduleNo = scheduleNo;
					}
						
//					rs.close();
//					state.close();
//					conn.close();
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
		new TicketingRoundTripComingFormTEST();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnMainMenu) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
			
		} else if(obj == btnMember) {
//			new ReservationDetailForm();
			this.setVisible(false);
		}
		else if(obj == btnEcon)
		{
			rtg1 = new TicketingRoundTripGoingForm();
			payGo = rtg1.getTotalPay();
			intEcoPrice = Integer.parseInt(economyClass);
//			intPayGo = Integer.parseInt(payGo);
			finaltotalPay = intEcoPrice+payGo;
			
			lblTotalPayGoing.setText(finaltotalPay + "원");
			
			selectedSeatCome = "economy";
		}
		else if(obj == btnPres)
		{
			rtg1 = new TicketingRoundTripGoingForm();
			payGo = rtg1.getTotalPay();
			
			intBusPrice = Integer.parseInt(prestigeClass);
//			intPayGo = Integer.parseInt(payGo);
			finaltotalPay = intBusPrice + payGo;
			
//			finaltotalPay = Integer.parseInt(prestigeClass) + Integer.parseInt(payGo)+ " ";
			lblTotalPayGoing.setText(finaltotalPay + "원");	
			selectedSeatCome = "prestige";
			}
		else if(obj == btnFirs)
		{
			rtg1 = new TicketingRoundTripGoingForm();
			payGo = rtg1.getTotalPay();
			
			intFirPrice = Integer.parseInt(firstClass);
//			intPayGo = Integer.parseInt(payGo);
			finaltotalPay = intFirPrice+ payGo;
			
			
//			finaltotalPay = Integer.parseInt(firstClass) + Integer.parseInt(payGo)+ " ";
			lblTotalPayGoing.setText(finaltotalPay + "원");	
			selectedSeatCome = "first";
			}
	}
	
}

