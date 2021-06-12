package minbohyun;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
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

import customer.book.ticketing.TicketingRoundTripComingFormX;
import customer.start.MainMenuForm;

public class ticketttttt2 extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 폰트 사용 위함
	private JButton btnMainMenu;
	// 예원 - Forms
	private MainMenuForm mainMenuForm;
	private TicketingRoundTripComingFormX tkRTComForm;
	
	// 예원 - 색상
	Color colorLogo = new Color(24, 62, 111);
	// 예원 - 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	private JPanel jpSelectedInfo;
	//--가상의 고객이 선택한 정보
	private String DepP = " "; //고객이 선택한 정보 : 
	private String ArrP = " "; // 출발지 GMP 도착지 PUS (P : place)
	private String GoDay = " "; //출발 날짜 : 21.0515- 
//	private String ComeDay = " ";//도착 날짜 : 0601(화)    (D : date)
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



//	public void setComeDay(String comeDay) {
//		ComeDay = comeDay;
//	}



	public void setAdultP(int adultP) {
		AdultP = adultP;
	}



	public void setChildP(int childP) {
		ChildP = childP;
	}



	public void setInfantP(int infantP) {
		InfantP = infantP;
	}
		
		private JLabel lblArrow; //왕복 화살표
//		private JLabel lblAdult; //성인임을 나타냄 유아인 경우 children
//		private JLabel lblNumP; //인원 수 
		private JLabel lblPassenger;// 탑승 인원 정보 (성인인지 유아인지의 정보 + 인원수)
		
		private JPanel jpFlight1; // 시간 선택시 비행기1
		private JPanel jpFlight2; // 비행기 2
		private JPanel jpFlight3; // 비행기 3
		
		private JPanel btnFir1; //비행기 1의 일등석. 퍼스트석
		private JPanel btnPres1;//비행기 1의 비즈니스석
		private JPanel btnEco1;// 비행기 1의 이코노미석
		
		private JPanel btnEco2; //비행기 2의 이코노미
		private JPanel btnPres2; //       비즈니스
		private JPanel btnFir2;// 		퍼스트석
		
		private JPanel btnEco3;//비행기 3의 이코노미
		private JPanel btnPres3; //      비즈니스
		private JPanel btnFir3; //      퍼스트
		
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
		Font fontNanumGothic25Plain = new Font("NanumGothic", Font.PLAIN, 25);	// 나눔고딕 25
		Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 30
//		private JLabel lblFliCo;
		private JLabel lblDepP;
		private JLabel lblArrP;
		private JLabel lblDate;
//		private String scheduleNo;
//		private String airline;
//		private String flightCode;
//		private String from;
//		private String fromDate;
//		private String to;
//		private String toDate;
//		private String fromTime;
//		private String toTime;
		private String scheduleNo;
		private String flightCode;
		private String from;
		private String fromDate;
		private String to;
		private String toDate;
		private String fromTime;
		private String toTime;
		private JLabel lblFliCo;
//		private JLabel lblFromT;
//		private JLabel lblToT;
		private JLabel lblTime;
		private dbstart ds;
//		private String ecoPrice;
//		private String presPrice;
//		private String firPrice;
		private String economyClass;
		private String prestigeClass;
		private String firstClass;
		private JLabel eco1;
//		private Component ecoPrice1;
		private JLabel pres1;
		private JLabel fir1;
		
//		String fHour = fromTime.substring(0,1);
//		String tHour = toTime.substring(0,1);
//	    
//		String fMin = fromTime.substring(3,4);
//		String tMin = toTime.substring(3,4);
//		
//		private int hour = Integer.parseInt(tHour) - Integer.parseInt(fHour);
//		
//		private int min = Integer.parseInt(tMin) - Integer.parseInt(fMin);
//		
//		String timeTaking = hour +"시간" + min +"  분";

	public ticketttttt2() {
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
		
		crMember = new Color(10,90,150); //회원 버튼 색깔
		crNonMember = new Color(150,150,150); //비회원 버튼 색깔
		
		jpSelectedInfo = new JPanel(); //고객이 선택한 정보를 표시하는 바
		jpSelectedInfo.setLayout(null);
		jpSelectedInfo.setSize(1000,60);
		jpSelectedInfo.setLocation(70,100);
		jpSelectedInfo.setBackground(crInfo);
		
//		lblDepartP = new JLabel(DepP);//고객이 선택한 출발지 정보
//		lblDepartP.setFont(fontNanumGothic25);
//		lblDepartP.setBounds(50, -20, 200, 100);
//		
//		lblArriveP = new JLabel(ArrP);//고객이 선택한 도착지 정보
//		lblArriveP.setFont(fontNanumGothic25);
//		lblArriveP.setBounds(190, -20, 200, 100);
////		
//		imgAeroPlane = new ImageIcon("images/aeroplane.png");
//		imgArrow = new ImageIcon("images/arrow.png");
		
		lblArrow = new JLabel("→"); //문자로 넣을지 그림으로 넣을지 ..
		lblArrow.setFont(fontNanumGothic18);
		lblArrow.setBounds(135, -20, 200, 100);

//		lblDepartD = new JLabel(GoDay); //편도라서 출발일만 표시
//		lblDepartD.setFont(fontNanumGothic18Plain);
//		lblDepartD.setBounds(295, -20, 300, 100);

		
		lblPassenger = new JLabel("    성인  " + AdultP + "명     " +"  |  "+ "    소아  "+ ChildP + "명"); //고객이 선택한 탑승자 정보
		lblPassenger.setFont(fontNanumGothic18Plain);
		lblPassenger.setBounds(600, -20, 500, 100);
		
		jpFlight1 = new JPanel(); //3개의 시간표 중 선택 1
		jpFlight1.setLayout(null);
		jpFlight1.setSize(1000,110);
		jpFlight1.setLocation(70,190);
		jpFlight1.setBackground(crInfo);
		
		jpFlight2 = new JPanel();//선택 2
		jpFlight2.setLayout(null);
		jpFlight2.setSize(1000,110);
		jpFlight2.setLocation(70,320);
		jpFlight2.setBackground(Color.blue);
		
		jpFlight3 = new JPanel();// 선택 3
		jpFlight3.setLayout(null);
		jpFlight3.setSize(1000,110);
		jpFlight3.setLocation(70,450);
		jpFlight3.setBackground(Color.yellow);
		
	
		
//		jpSelectedInfo.add(lblDepartP); // 상단의 고객이 선택한 정보를 나타내는 바에 출발지 추가
//		jpSelectedInfo.add(lblArriveP);// 도착지 추가
		jpSelectedInfo.add(lblArrow); // 화살표
//		jpSelectedInfo.add(lblDepartD); //출발날짜 
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
		

//		lblPayment = new JLabel(""); // 진짜 예상 결제 금액 나타내는 라벨
		
		
		btnMember = new JButton("회원으로 진행"); // 회원 진행 버튼
		btnMember.setFont(fontNanumGothic20);
		btnMember.setBackground(crMember);
		btnMember.setForeground(Color.white);
		btnMember.setBounds(905, 0, 200, 100);
		
		btnNonMember = new JButton("비회원으로 진행"); // 회원 진행 버튼
		btnNonMember.setFont(fontNanumGothic20);
		btnNonMember.setBackground(crNonMember);
		btnNonMember.setForeground(Color.white);
		btnNonMember.setBounds(705, 0, 200, 100);
		
		
		jpTotalPay.add(lblTotalPay);
//		jpTotalPay.add(lblPayment);
		jpTotalPay.add(btnMember);
		jpTotalPay.add(btnNonMember);
		
		add(jpSelectedInfo);
		add(jpFlight1);
		add(jpFlight2);
		add(jpFlight3);
		
		
		add(jpTotalPay);
		
		Find();
		
		btnEco1 = new JPanel();//비행기 1의 이코노미 좌석 
		btnEco1.setLayout(new BorderLayout());
		btnEco1.setSize(180,110);
		btnEco1.setLocation(458,0);
		btnEco1.setBackground(crClass);
		
		eco1 = new JLabel("<html>" + "이코노미 클래스 "+ "<br>" +economyClass +" 원"+ "</html>");
		eco1.setFont(fontNanumGothic18);
//		eco1.setBounds(0, 30, 150, 50);
		eco1.setHorizontalAlignment(JLabel.CENTER);
		btnEco1.add(eco1);
		
		btnEco2 = new JPanel(); //비행기 2의 이코노미 좌석
		btnEco2.setLayout(null);
		btnEco2.setSize(180,110);
		btnEco2.setLocation(458,0);
		btnEco2.setBackground(crClass);
		
		btnEco3 = new JPanel(); //비행기 3의 이코노미 좌석
		btnEco3.setLayout(null);
		btnEco3.setSize(180,110);
		btnEco3.setLocation(458,0);
		btnEco3.setBackground(crClass);
		
		btnPres1 = new JPanel();//비행기 1의 비즈니스 좌석
		btnPres1.setLayout(new BorderLayout());
		btnPres1.setSize(180,110);
		btnPres1.setLocation(639,0);
		btnPres1.setBackground(crClass);
		
		pres1 = new JLabel("<html>" + "프레스티지 클래스 "+ "<br>" +prestigeClass +" 원"+ "</html>");
		pres1.setFont(fontNanumGothic18);
//		pres1.setBounds(10, 30, 200, 50);
		pres1.setHorizontalAlignment(JLabel.CENTER);
		btnPres1.add(pres1);
		
		btnPres2 = new JPanel();// 비행기 2의 비즈니스 좌석
		btnPres2.setLayout(new BorderLayout());
		btnPres2.setSize(180,110);
		btnPres2.setLocation(639,0);
		btnPres2.setBackground(crClass);
		
		btnPres3 = new JPanel();// 비행기 3의 비즈니스 좌석
		btnPres3.setLayout(null);
		btnPres3.setSize(180,110);
		btnPres3.setLocation(639,0);
		btnPres3.setBackground(crClass);
		
		
		btnFir1 = new JPanel(); // 비행기1 의 퍼스트 좌석
		btnFir1.setLayout(new BorderLayout());
		btnFir1.setSize(180,110);
		btnFir1.setLocation(820,0);
		btnFir1.setBackground(crClass);
		
		fir1 = new JLabel("<html>" + "퍼스트 클래스 "+ "<br>" +firstClass +" 원"+ "</html>");
		fir1.setFont(fontNanumGothic18);
//		fir1.setBounds(10, 30, 200, 50);
		fir1.setHorizontalAlignment(JLabel.CENTER);
		
		btnFir1.add(fir1);
		
		
		btnFir2 = new JPanel(); // 비행기 2의 퍼스트 좌석
		btnFir2.setLayout(null);
		btnFir2.setSize(180,110);
		btnFir2.setLocation(820,0);
		btnFir2.setBackground(crClass);
		
		btnFir3 = new JPanel();// 비행기 3의 퍼스트 좌석
		btnFir3.setLayout(null);
		btnFir3.setSize(180,110);
		btnFir3.setLocation(820,0);
		btnFir3.setBackground(crClass);
		
		jpFlight1.add(btnEco1);
		jpFlight2.add(btnEco2);
		jpFlight3.add(btnEco3);
		
		jpFlight1.add(btnPres1);
		jpFlight2.add(btnPres2);
		jpFlight3.add(btnPres3);
		
		jpFlight1.add(btnFir1);
		jpFlight2.add(btnFir2);
		jpFlight3.add(btnFir3);
		
		lblDepP = new JLabel(from);
		lblDepP.setFont(fontNanumGothic25);
		lblDepP.setBounds(50, -20, 200, 100);
		
		lblArrP = new JLabel(to);
		lblArrP.setFont(fontNanumGothic25);
		lblArrP.setBounds(180, -20, 200, 100);
		
		lblDate = new JLabel(fromDate + " ~ " + toDate);
		lblDate.setFont(fontNanumGothic18Plain);
		lblDate.setBounds(300, -20, 400, 100);

		lblFliCo = new JLabel(flightCode);
		lblFliCo.setFont(fontNanumGothic25Plain);
		lblFliCo.setBounds(40, 3, 100, 100);
		
		lblTime = new JLabel("출발 "+ fromTime.substring(0, 5)+"   -  "+" 도착 "+toTime);
		lblTime.setFont(fontNanumGothic18);
		lblTime.setBounds(160, 3, 300, 100);
		
//		lblFromT = new JLabel(fromTime.substring(0, 5));
//		lblFromT.setFont(fontNanumGothic20);
//		lblFromT.setBounds(140, 3, 200, 100);
//		
//		lblToT = new JLabel(toTime.substring(0, 5));
//		lblToT.setFont(fontNanumGothic20);
//		lblToT.setBounds(440, 3, 200, 100);
		
	
		
		jpSelectedInfo.add(lblDepP);
		jpSelectedInfo.add(lblArrP);
		jpSelectedInfo.add(lblDate);
		
		

		jpFlight1.add(lblFliCo);
		jpFlight1.add(lblTime);
		
		
		
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
					System.out.println("oo");
					
					String SelectedFliCo = "IH8985";
					//----------
					
					String sql;
					sql = "SELECT * FROM airPrice WHERE `flightCode` = '"+ SelectedFliCo +"' ";
					
					ResultSet rs = state.executeQuery(sql);
					while (rs.next()) {
						economyClass = rs.getString("economyClass");
						prestigeClass = rs.getString("prestigeClass");
						firstClass = rs.getString("firstClass");
							
						System.out.println(economyClass + " " + prestigeClass + " " +
								firstClass + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
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
					
					//----------
					String DepP = "GMP";
					String ArrP = "CJU";
					String GoDay = "20210531";
				
					//----------
					
					String sql;
					sql = "SELECT * FROM airSchedule WHERE `from` = '"+ DepP +"' and fromDate = " + GoDay +" and `to` = '" + ArrP +"'";
					
					ResultSet rs = state.executeQuery(sql);
					while (rs.next()) {
						scheduleNo = rs.getString("scheduleNo");
//						airline = rs.getString("airline");
						flightCode = rs.getString("flightCode");
						from = rs.getString("from");
						fromDate = rs.getString("fromDate");
						to = rs.getString("to");
						toDate = rs.getString("toDate");
						fromTime = rs.getString("fromTime");
						
						
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
		new ticketttttt2();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}

