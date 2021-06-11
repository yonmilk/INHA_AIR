package customer.book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DataBase.databaseClass;
import be.main.MainForm;
import be.menu.MenuBar;
import customer.start.MainMenuForm;

public class SelectPaymentForm2 extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 예원 - 컴포넌트
	private JButton btnMainMenu;
	// 예원 - Forms
	private MainMenuForm mainMenuForm;
	private PaymentForm paymentForm;
	
	// 예원 - 색상
	Color colorLogo = new Color(24, 62, 111);
	Color colorBtn = new Color(10,90,150);
	Color colorGrayBtn = new Color(150,150,150);
	// 예원 - 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	
	// 폰트
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 25
	
	// 결제 부분
	private JPanel jpPayment, jpLbl, jpBtn;
	private JLabel lblGo, lblCom, lblGoDate, lblComDate, lblAdult, lblChild, lblInfant, lblBaggage, lblPay;
	private ButtonGroup bgPayment;		// 결제수단 버튼 그룹
	private JButton btnCancle, btnOK;	// 취소, 결제 버튼
	
	// 데이터 저장
	private String reserveNum = "test001010";			// 예매 번호(테스트값)
	
	
	//
//	private ReservationDetailForm informationF;
	
	public SelectPaymentForm2() {
//		this.informationF = informationF;
		
		// DB 정보 - 테스트 소스
		String dbURL="jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false";
		String dbID="inhaair";
		String dbPassword="1234";
		// 데이터베이스 연결 - 테스트 소스
		databaseClass.connect(dbURL, dbID, dbPassword);
		
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
		
		// 결제 화면
		setPayment();
		
		setVisible(true);
	}


	// 결제수단 선택 화면
	private void setPayment() {
		jpPayment = new JPanel(null);
		jpPayment.setSize(1100, 635);
		jpPayment.setLocation(3, 90);
		jpPayment.setBackground(Color.WHITE);
		
		// 라벨 부분
		jpLbl = new JPanel(null);
		jpLbl.setSize(1000, 500);
		jpLbl.setLocation(50, 10);
		jpLbl.setBorder(new EtchedBorder(EtchedBorder.RAISED));		// 테두리 설정
		jpLbl.setBackground(Color.WHITE);
		
		// 예매 확인 내용 표시
		setCheck();
		
		// 결제하기 버튼 부분
		jpBtn = new JPanel(new GridLayout(1, 2, 30, 30));
		jpBtn.setBorder(new EmptyBorder(30, 50, 30, 50));
//		jpBtn = new JPanel();
		jpBtn.setSize(1100, 100);
		jpBtn.setLocation(0, 520);
		jpBtn.setBackground(Color.WHITE);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(this);
		btnCancle.setFont(fontNanumGothic20);
		btnCancle.setVerticalAlignment(SwingConstants.CENTER);
		btnCancle.setBackground(colorGrayBtn);
		btnCancle.setForeground(Color.WHITE);
		btnCancle.setBorderPainted(false);
		jpBtn.add(btnCancle);
		
		btnOK = new JButton("결제");
		btnOK.addActionListener(this);
		btnOK.setFont(fontNanumGothic20);
		btnOK.setVerticalAlignment(SwingConstants.CENTER);
		btnOK.setBackground(colorBtn);
		btnOK.setForeground(Color.WHITE);
		btnOK.setBorderPainted(false);
		jpBtn.add(btnOK);

		jpPayment.add(jpLbl);
		jpPayment.add(jpBtn);
		
		add(jpPayment);
	}

	// 예매 확인 내역 표시
	private void setCheck() {
		// 예매확인 라벨
		JLabel lblTitle = new JLabel("예매 확인");
		lblTitle.setFont(fontNanumGothic30);
		lblTitle.setHorizontalAlignment(JLabel.LEFT);
		lblTitle.setSize(900, 50);
		lblTitle.setLocation(50, 20);
		
		// 예매 내역 표시 패널
		JPanel jpCheck = new JPanel(new GridLayout(6, 1, 10, 10));
		jpCheck.setBorder(new EmptyBorder(0, 10, 10, 0));
		jpCheck.setSize(900, 400);
		jpCheck.setLocation(50, 80);
//		jpCheck.setBackground(Color.WHITE);
		
		// 예매 번호
		JPanel jpReserveNum = new JPanel(new GridLayout(1, 2, 5, 5));
		jpReserveNum.setBackground(Color.WHITE);
		JLabel lblReserveNum = new JLabel("예매번호");
		lblReserveNum.setFont(fontNanumGothic15);
		
		
		jpCheck.add(jpReserveNum);
		
		jpLbl.add(lblTitle);
		jpLbl.add(jpCheck);
	}


	// 결제 수단 버튼 그룹
/*	private void setBtnGroup() {
		
		bgPayment = new ButtonGroup();
		
		btnCash = new JButton("무통장 입금");
		btnCash.setFont(fontNanumGothic20);
		btnCash.setSize(175, 200);
		btnCash.setLocation(295, 200);
//		btnCash.setBackground(Color.WHITE);
//		btnCash.setBackground(new Color(10,90,150));
		btnCash.setBackground(new Color(150,150,150));
		btnCash.setForeground(Color.WHITE);
		btnCash.setSelected(true);
//		btnCash.setBorderPainted(false);
		
		btnCard = new JButton("카드 결제");
		btnCard.setFont(fontNanumGothic20);
		btnCard.setSize(175, 200);
		btnCard.setLocation(535, 200);
		btnCard.setBackground(Color.WHITE);
		btnCard.setForeground(new Color(10,90,150));
//		btnCard.setBorderPainted(false);
		
		bgPayment.add(btnCash);
		bgPayment.add(btnCard);
		
		jpLbl.add(btnCash);
		jpLbl.add(btnCard);
	}
*/

	public static void main(String[] args) {
		new SelectPaymentForm2();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnMainMenu || obj == btnCancle) {
//			mainMenuForm = new MainMenuForm();
//			this.setVisible(false);
			
			clickMain();
			
		}  else if(obj == btnOK) {
			payment("cash");
			
		}
	}

	private void payment(String type) {
		String sql = "INSERT INTO payment(reserveNum, payable, pay) VALUES('" + reserveNum + "', '" + type + "', " + 
				"( SELECT pay FROM reservation WHERE reserveNum='" + reserveNum + "'))";
		
//		System.out.println(sql);
		
		int rs = databaseClass.insert(sql);
		
		if(rs == 1) {
			paymentForm = new PaymentForm();
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "결제 실패했습니다.", "결제 실패", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void clickMain() {
		// 정보 입력된 승객이 있는지 확인
		String sql = "SELECT COUNT(*) FROM reservationDetail WHERE reserveNum = '" + reserveNum + "'";
		ResultSet rs = databaseClass.select(sql);
					
		int rouCount = 0;
		try {
			while(rs.next()) {
			rouCount = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
		System.out.println(rouCount);
		
		int resdel = 0;
		
		if(rouCount == 0) {
			// 정보 입력된 승객이 없으면 
			
			// reservation 삭제
			resdel = delReservation();
			
			// 첫화면으로 이동
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
						
		} else {
			// 정보 입력된 승객이 있으면 승객 정보 삭제 
			sql = "DELETE FROM reservationDetail WHERE reserveNum = '" + reserveNum + "'";
			System.out.println(sql);
						
			int result = databaseClass.delete(sql);
			
			if(result == 1) {
				// reservation 삭제
				resdel = delReservation();
							
				// 첫 화면으로 
				mainMenuForm = new MainMenuForm();
				this.setVisible(false);
			} else {
				// 삭제 실패시 다이얼로그 띄움
				JOptionPane.showMessageDialog(null, "첫 화면으로 이동할 수 없습니다.", "오류 안내", JOptionPane.WARNING_MESSAGE);
			}
		}
					
	}
	
	// reservation 테이블에서 해당 예약 삭제
		private int delReservation() {
			int resdel = 0;
			
			String sql = "DELETE FROM reservation WHERE reserveNum = '" + reserveNum + "'";
			System.out.println(sql);
			
			resdel = databaseClass.delete(sql);
			
			return resdel;
			
		}

}
