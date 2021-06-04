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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import be.main.MainForm;
import be.menu.MenuBar;
import customer.start.MainMenuForm;
import jdk.tools.jlink.resources.jlink;

public class SelectPaymentForm extends JFrame implements ActionListener {
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
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 25
	
	// 결제 부분
	private JPanel jpPayment, jpLbl, jpBtn;
	private JLabel lblGo, lblCom, lblGoDate, lblComDate, lblAdult, lblChild, lblInfant, lblBaggage, lblPay;
	private ButtonGroup bgPayment;		// 결제수단 버튼 그룹
	private JButton btnCash, btnCard;	// 결제수단 - 무통장입금, 카드결제
	private JButton btnOK;
	
	// 데이터 저장
	private String reserveNum = "test001010";			// 예매 번호(테스트값)
	
	
	//
//	private ReservationDetailForm informationF;
	
	public SelectPaymentForm() {
//		this.informationF = informationF;
		
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
//		jpPayment.setBackground(Color.yellow);
		
		// 라벨 부분
		jpLbl = new JPanel(null);
//		jpLbl = new JPanel(new GridLayout(3, 1, 5, 5));
		jpLbl.setSize(1000, 500);
		jpLbl.setLocation(50, 10);
//		jpLbl.setBorder(new LineBorder(new Color(10,90,150), 1));
		jpLbl.setBorder(new EtchedBorder(EtchedBorder.RAISED));		// 테두리 설정
//		jpLbl.setBackground(Color.WHITE);
		
		// 예매 확인 내용 표시
		setCheck();
		
		// 결제 수단 버튼 그룹
//		setBtnGroup();
		
		// 결제하기 버튼 부분
		jpBtn = new JPanel(new GridLayout(1, 2, 30, 30));
		jpBtn.setBorder(new EmptyBorder(30, 50, 30, 50));
//		jpBtn = new JPanel();
		jpBtn.setSize(1100, 100);
		jpBtn.setLocation(0, 520);
		jpBtn.setBackground(Color.WHITE);
		
		btnCash = new JButton("무통장 입금");
		btnCash.addActionListener(this);
		btnCash.setFont(fontNanumGothic20);
		btnCash.setVerticalAlignment(SwingConstants.CENTER);
		btnCash.setBackground(colorGrayBtn);
		btnCash.setForeground(Color.WHITE);
		btnCash.setBorderPainted(false);
		jpBtn.add(btnCash);
		
		btnCard = new JButton("카드 결제");
		btnCard.addActionListener(this);
		btnCard.setFont(fontNanumGothic20);
		btnCard.setVerticalAlignment(SwingConstants.CENTER);
		btnCard.setBackground(colorBtn);
		btnCard.setForeground(Color.WHITE);
		btnCard.setBorderPainted(false);
		jpBtn.add(btnCard);

//		btnOK = new JButton("결제하기");
//		btnOK.addActionListener(this);
//		btnOK.setFont(fontNanumGothic20);
//		btnOK.setBackground(new Color(10,90,150));
//		btnOK.setForeground(Color.WHITE);
//		btnOK.setBorderPainted(false);
////		btnOK.setSize(250, 40);
////		btnOK.setLocation(425, 20);
//		btnOK.setHorizontalAlignment(JButton.CENTER);
//		jpBtn.add(btnOK);
		
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
		lblTitle.setSize(300, 50);
		lblTitle.setLocation(10, 10);
		
		// 예매 내역 표시 패널
		JPanel jpCheck = new JPanel(new GridLayout(4, 2, 10, 10));
		jpCheck.setBorder(new EmptyBorder(0, 10, 100, 0));
		jpCheck.setSize(800, 300);
		jpCheck.setLocation(10, 70);
		jpCheck.setBackground(colorGrayBtn);
		
		JLabel lblTrips = new JLabel("여행일정");
		lblTrips.setFont(fontNanumGothic25);
		lblTrips.setHorizontalAlignment(JLabel.RIGHT);
		
		lblGo = new JLabel("김포 -> 제주" + " 2020.05.01 12:00:00 ~ 2020.05.01 12:00:00");
		lblGo.setFont(fontNanumGothic22);
//		lblGo.setHorizontalAlignment(JLabel.LEFT);
		
		lblGoDate = new JLabel("2020.05.01 12:00:00 ~ 2020.05.01 12:00:00");
		lblGoDate.setFont(fontNanumGothic22);

		JLabel lblNull = new JLabel("");
		
		lblCom = new JLabel("제주 -> 김포" + " 2020.05.01 12:00:00 ~ 2020.05.01 12:00:00");
		lblCom.setFont(fontNanumGothic22);
		
		lblComDate = new JLabel("2020.05.01 12:00:00 ~ 2020.05.01 12:00:00");
		lblComDate.setFont(fontNanumGothic22);
		
		JLabel lblPeople = new JLabel("승객");
		lblPeople.setFont(fontNanumGothic25);
		lblPeople.setHorizontalAlignment(JLabel.RIGHT);
		
		lblAdult = new JLabel("승객 1명  " + "소아 1명  " + "유아 0명");
		lblAdult.setFont(fontNanumGothic22);

		lblChild = new JLabel("소아 1명");
		lblChild.setFont(fontNanumGothic22);
		
		lblInfant = new JLabel("유아 0명");
		lblInfant.setFont(fontNanumGothic22);
		
		JLabel lblAddBaggage = new JLabel("초과수하물");
		lblAddBaggage.setFont(fontNanumGothic25);
		lblAddBaggage.setHorizontalAlignment(JLabel.RIGHT);
		
		JLabel lbl10kg = new JLabel("10kg x " + "2개");
		lbl10kg.setFont(fontNanumGothic22);
		
		lblBaggage = new JLabel("2개");
		lblBaggage.setFont(fontNanumGothic22);
		
		jpCheck.add(lblTrips);
		jpCheck.add(lblGo);
//		jpCheck.add(lblGoDate);
		jpCheck.add(lblNull);
		jpCheck.add(lblCom);
//		jpCheck.add(lblComDate);
		jpCheck.add(lblPeople);
		jpCheck.add(lblAdult);
//		jpCheck.add(lblChild);
//		jpCheck.add(lblInfant);
		jpCheck.add(lblAddBaggage);
		jpCheck.add(lbl10kg);
//		jpCheck.add(lblBaggage);
		
		
		jpLbl.add(lblTitle);
		jpLbl.add(jpCheck);
	}


	// 결제 수단 버튼 그룹
	private void setBtnGroup() {
		
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


	public static void main(String[] args) {
		new SelectPaymentForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnMainMenu) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
			
		} else if(obj == btnOK) {
			paymentForm = new PaymentForm();
			this.setVisible(false);
		}
	}
}
