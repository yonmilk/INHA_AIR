package customer.book.ticketing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.awt.BorderLayout;

import be.main.MainForm;
import be.menu.MenuBar;
import customer.start.MainMenuForm;
//import sun.awt.www.content.image.jpeg;


public class TicketingRoundTripGoingForm3 extends JFrame implements ActionListener{
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 예원 - 컴포넌트
	private JButton btnMainMenu;
	// 예원 - Forms
	private MainMenuForm mainMenuForm;
	private TicketingRoundTripComingForm2 tkRTComForm;
	
	// 예원 - 색상
	Color colorLogo = new Color(24, 62, 111);
	// 예원 - 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	private JPanel jpSelectedInfo;
	//--가상의 고객이 선택한 정보
		String DepP = "CJU";
		String ArrP = "GMP";
		String GoDay = "20210531";
//		private String DepP = " "; //고객이 선택한 정보 : 
//		private String ArrP = " "; // 출발지 GMP 도착지 PUS (P : place)
//		private String GoDay = " "; //출발 날짜 : 21.0515- 
		private String ComeDay = "20210609";//도착 날짜 : 0601(화)    (D : date)
		private int AdultP = 0;//성인
		private int ChildP = 0;//소아인원
		private int InfantP = 0;//소아인원
		
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
//		
		
		
		public String getGOscheduleNo() {
			return GOscheduleNo;
		}
		
		public void setGOscheduleNo(String GOscheduleNo) {
			GOscheduleNo = this.GOscheduleNo;
		}
		
		
//		private JLabel lblDepartP; //고객이 선택한 출발지 정보
//		private JLabel lblArriveP; //         도착지
//		private JLabel lblDepArrD;	//고객이 선택한 출발일 + 도착일
		private JLabel lblArrow; //왕복 화살표
//		private JLabel lblAdult; //성인임을 나타냄 유아인 경우 children
//		private JLabel lblNumP; //인원 수 
		private JLabel lblPassenger;// 탑승 인원 정보 (성인인지 유아인지의 정보 + 인원수)
		
		private JPanel jpFlight1; // 시간 선택시 비행기1
		private JPanel jpFlight2; // 비행기 2
		private JPanel jpFlight3; // 비행기 3
		
//		private JPanel btnFir1; //비행기 1의 일등석. 퍼스트석
//		private JPanel btnPres1;//비행기 1의 비즈니스석
//		private JPanel btnEco1;// 비행기 1의 이코노미석
//		
//		private JPanel btnEco2; //비행기 2의 이코노미
//		private JPanel btnPres2; //       비즈니스
//		private JPanel btnFir2;// 		퍼스트석
//		
//		private JPanel btnEco3;//비행기 3의 이코노미
//		private JPanel btnPres3; //      비즈니스
//		private JPanel btnFir3; //      퍼스트
//		
		private Color crInfo; //고객이 선택한 정보를 나타내는 바의 색 
		private Color crClass;//좌석 등급 버튼 색
		private JPanel jpTotalPay; // 예상 결제금액 + 버튼 나타내는 패널
		private Component lblTotalPay; //"예상결제금액"문구 나타내는 라벨
		private JButton btnNext; //다음(왕복 오는 편 선택창으로 가는) 버튼
//		private ImageIcon imgArrow;
//		private ImageIcon imgAeroPlane;
		private Color crNext; //다음 버튼 색
		
		
	
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
		private JLabel lblDepP2;
		private JLabel lblArrP2;
		private JLabel lblEcon;
		private JLabel lblEconPr;
		private int economy = 0;
		private JButton btnEcon;
		private Color crSelect;
		private Component lblPres;
		private Component lblPresPr;
		private Component btnPres;
		private int prestige = 0;
		private Component lblFirs;
		private Component lblFirsPr;
		private Component btnFirs;
		private int first = 0;
		private String code;
		private String airportD;
		private String DepAP;
		private String ArrAP;
		private String airportA;
		private JLabel lblTotal;
		private String GOscheduleNo;
		private String pay = " ";
		
		
	public TicketingRoundTripGoingForm3() {
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
		crTop = new Color(230,230,235);//고객이 선택한 정보를 나타내는 바의 색 
		crClass = new Color(213, 230, 250);//좌석 등급 선택 버튼의 색
		crSelect = new Color(120,180,250);
		crNext = new Color(10,90,150); //다음 버튼 색깔
		
		Find();
		
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
		
		lblTotalPay = new JLabel("예상 결제 금액" + pay + "원"); // "예상 결제 금액" 라벨
		lblTotalPay.setFont(fontNanumGothic20);
		lblTotalPay.setBounds(50,0,800,100);
//		
//		lblTotal = new JLabel(economyClass + " 원");
//		lblTotal.setFont(fontNanumGothic30);
//		lblTotal.setBounds(250,0,300,100);

		btnNext = new JButton("다음"); // 회원 진행 버튼
		btnNext.setFont(fontNanumGothic20);
		btnNext.setBackground(crNext);
		btnNext.setForeground(Color.white);
		btnNext.setBounds(905, 0, 200, 100);
		btnNext.addActionListener(this);
		
		
		jpTotalPay.add(lblTotalPay);
		jpTotalPay.add(btnNext);
//		jpTotalPay.add(lblTotal);
		
		add(jpSelectedInfo);
		add(jpFlightTOP);
		add(jpFlight1);
		add(jpFlight2);
		add(jpFlight3);
		
		
		add(jpTotalPay);
		
		
		
//		btnEco1 = new JPanel();//비행기 1의 이코노미 좌석 
//		btnEco1.setLayout(new BorderLayout());
//		btnEco1.setSize(180,110);
//		btnEco1.setLocation(458,0);
//		btnEco1.setBackground(crClass);
//		
//		eco1 = new JLabel("<html>" + "이코노미 클래스 "+ "<br>" +economyClass +" 원"+ "</html>");
//		eco1.setFont(fontNanumGothic18);
//		eco1.setHorizontalAlignment(JLabel.CENTER);
//		btnEco1.add(eco1);
//		
//		btnEco2 = new JPanel(); //비행기 2의 이코노미 좌석
//		btnEco2.setLayout(null);
//		btnEco2.setSize(180,110);
//		btnEco2.setLocation(458,0);
//		btnEco2.setBackground(crClass);
//		
//		btnEco3 = new JPanel(); //비행기 3의 이코노미 좌석
//		btnEco3.setLayout(null);
//		btnEco3.setSize(180,110);
//		btnEco3.setLocation(458,0);
//		btnEco3.setBackground(crClass);
//		
//		btnPres1 = new JPanel();//비행기 1의 비즈니스 좌석
//		btnPres1.setLayout(new BorderLayout());
//		btnPres1.setSize(180,110);
//		btnPres1.setLocation(639,0);
//		btnPres1.setBackground(crClass);
//		
//		pres1 = new JLabel("<html>" + "프레스티지 클래스 "+ "<br>" +prestigeClass +" 원"+ "</html>");
//		pres1.setFont(fontNanumGothic18);
//		pres1.setHorizontalAlignment(JLabel.CENTER);
//		btnPres1.add(pres1);
//		
//		
//		btnPres2 = new JPanel();// 비행기 2의 비즈니스 좌석
//		btnPres2.setLayout(null);
//		btnPres2.setSize(180,110);
//		btnPres2.setLocation(639,0);
//		btnPres2.setBackground(crClass);
//		
//		btnPres3 = new JPanel();// 비행기 3의 비즈니스 좌석
//		btnPres3.setLayout(null);
//		btnPres3.setSize(180,110);
//		btnPres3.setLocation(639,0);
//		btnPres3.setBackground(crClass);
//		
//		btnFir1 = new JPanel(); // 비행기1 의 퍼스트 좌석
//		btnFir1.setLayout(new BorderLayout());
//		btnFir1.setSize(180,110);
//		btnFir1.setLocation(820,0);
//		btnFir1.setBackground(crClass);
//		
//		fir1 = new JLabel("<html>" + "퍼스트 클래스 "+ "<br>" +firstClass +" 원"+ "</html>");
//		fir1.setFont(fontNanumGothic18);
//		fir1.setHorizontalAlignment(JLabel.CENTER);
//		
//		btnFir1.add(fir1);
//		
//		btnFir2 = new JPanel(); // 비행기 2의 퍼스트 좌석
//		btnFir2.setLayout(null);
//		btnFir2.setSize(180,110);
//		btnFir2.setLocation(820,0);
//		btnFir2.setBackground(crClass);
//		
//		btnFir3 = new JPanel();// 비행기 3의 퍼스트 좌석
//		btnFir3.setLayout(null);
//		btnFir3.setSize(180,110);
//		btnFir3.setLocation(820,0);
//		btnFir3.setBackground(crClass);
//		
//		
//		jpFlight2.add(btnEco2);
//		jpFlight3.add(btnEco3);
//		
//		jpFlight1.add(btnPres1);
//		jpFlight2.add(btnPres2);
//		jpFlight3.add(btnPres3);
//		
//		jpFlight1.add(btnFir1);
//		jpFlight2.add(btnFir2);
//		jpFlight3.add(btnFir3);
		
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
		lblGoComeDate = new JLabel("<html>"+GoDay + "&nbsp;&nbsp;&nbsp; ~ &nbsp;&nbsp;&nbsp;" + ComeDay+"</html>");
		lblGoComeDate.setFont(fontNanumGothic18Plain);
		lblGoComeDate.setBounds(300, -20, 400, 100);

		lblFliCo = new JLabel(flightCode);
		lblFliCo.setFont(fontNanumGothic30);
		lblFliCo.setBounds(70, 0, 300, 100);
		
		
		lblDate = new JLabel(fromDate);
		lblDate.setFont(fontNanumGothic18Plain);
		lblDate.setBounds(230, 0, 300, 100);
		
		lblTime = new JLabel("출발 "+ fromTime.substring(0, 5)+"   -  "+" 도착 "+toTime.substring(0, 5));
		lblTime.setFont(fontNanumGothic18Plain);
		lblTime.setBounds(550, 0, 350, 100);
		
		lblDepP2 = new JLabel(airportD);
		lblDepP2.setFont(fontNanumGothic30);
		lblDepP2.setBounds(350, 0, 200, 100);
		
		lblArrP2 = new JLabel(airportA);
		lblArrP2.setFont(fontNanumGothic30);
		lblArrP2.setBounds(780, 0, 200, 100);
		
		jpSelectedInfo.add(lblDepP);
		jpSelectedInfo.add(lblArrP);
		jpSelectedInfo.add(lblGoComeDate);
		
		jpFlightTOP.add(lblFliCo);
		jpFlightTOP.add(lblDate);
		jpFlightTOP.add(lblTime);
		jpFlightTOP.add(lblDepP2);
		jpFlightTOP.add(lblArrP2);
		
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
				
				String DepP = "CJU";
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
				
				String ArrP = "GMP";
				
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
					
					
				
					String sql;
					sql = "SELECT * FROM airSchedule WHERE `from` = '"+ DepP +"' and fromDate = " + GoDay +" and `to` = '" + ArrP +"'";
					
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
						
						GOscheduleNo = scheduleNo;
						
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
		new TicketingRoundTripGoingForm3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnMainMenu) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
			
		} else if(obj == btnNext)
		{
			tkRTComForm= new TicketingRoundTripComingForm2();
			this.setVisible(false);
		}
		
		else if(obj == btnEcon) {
//			jpTotalPay.add(lblTotal);
//			System.out.println("111111");
			pay = economyClass;
			
		}
		
	}

	
}