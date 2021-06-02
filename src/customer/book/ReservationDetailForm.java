package customer.book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import DataBase.databaseClass;
import customer.start.MainMenuForm;

public class ReservationDetailForm extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	Font fontNanumGothicP15 = new Font("NanumGothic", Font.PLAIN, 15);
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);
	
	// 색상
	Color colorLogo = new Color(24, 62, 111);	
	Color colorBtn = new Color(10,90,150);
	
	// 컴포넌트
	private JButton btnMainMenu;
	private JPanel jpSet;
	
	// 컴포넌트
	private JPanel jpInputInfor, jpBtns;
	private JLabel lblFamilyNameKor, lblNameKor, lblFamilyNameEng, lblNameEng, 
					lblSex, lblPassport, lblTel, lblEmail, lblBirth;
	private JTextField tfFamilyNameKor, tfNameKor, tfFamilyNameEng, tfNameEng,
					tfPassport, tfTel, tfEmail, tfBirth;
	private ButtonGroup bgSex;
	private JRadioButton rbWoman, rbMan;
	private JCheckBox cbAgree;
	private JButton btnOK, btnBaggage, btnSeat;
	
	// Forms
	private MainMenuForm mainMenuForm;
	private SelectBaggageForm baggageFrom;
	private SelectPaymentForm paymentForm;
	
	// 데이터 저장용
	private String reserveNum = "test001010";			// 예매 번호(테스트값)
	private String ID = "test1";			// 아이디(테스트값)
	private String nameKOR = "";			// 한글이름
	private String nameENG = "";			// 영문이름
	private String sex = "";				// 성별(남 또는 여)
	private String passport = "";			// 여권번호
	private String birth = "";				// 생년월일
	private String tel = "";				// 연락처
	private String email = "";				// 이메일
	private int agree = 0;			// 수신동의
	private String hydrate = "0";			// 추과수하물 (기본값: 0)
	public void setAddHydrate(String hydrate) {
		this.hydrate = hydrate;
	}
	private String seatNum = "0";			// 좌석번호 (기본값: 0)
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	// 예원 - 시작 화면
	public ReservationDetailForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 배경색
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		
		// 레이아웃 설정
		setLayout(null);
		
		// 시작 버튼
		btnMainMenu = new JButton("INHA AIR");
		btnMainMenu.setSize(200, 50);
		btnMainMenu.setLocation(10, 10);
		btnMainMenu.setFont(fontArial30);
		btnMainMenu.setForeground(colorLogo);
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setBackground(Color.WHITE);
		
		// 예매창 패널
		jpSet = new JPanel(new BorderLayout(10, 35));
		jpSet.setSize(1000, 600);
		jpSet.setLocation(50, 90);
		jpSet.setBackground(Color.WHITE);
		
		// 정보 입력 레이아웃
		setInput();
		
		// 버튼 레이아웃
		setBtns();
		
		// 리스너
		btnMainMenu.addActionListener(this);
		
		// 컴포넌트 붙이기
		add(btnMainMenu);
		add(jpSet);
		
		setVisible(true);
		
		// DB 정보 - 테스트 소스
		String dbURL="jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false";
		String dbID="inhaair";
		String dbPassword="1234";
		// 데이터베이스 연결 - 테스트 소스
		databaseClass.connect(dbURL, dbID, dbPassword);
	}

	// 버튼 레이아웃
	private void setBtns() {
		
		jpBtns = new JPanel(new GridLayout(1, 3, 10, 10));
		jpBtns.setBackground(Color.WHITE);
		
		// 버튼
		btnBaggage = new JButton("초과수하물");
		btnBaggage.setFont(fontNanumGothic20);
		btnBaggage.setBackground(colorBtn);
		btnBaggage.setForeground(Color.WHITE);
		btnSeat = new JButton("좌석배정");
		btnSeat.setFont(fontNanumGothic20);
		btnSeat.setBackground(colorBtn);
		btnSeat.setForeground(Color.WHITE);
		btnOK = new JButton("입력 완료");
		btnOK.setFont(fontNanumGothic20);
		btnOK.setBackground(colorBtn);
		btnOK.setForeground(Color.WHITE);
		
		// 리스너
		btnBaggage.addActionListener(this);
		btnSeat.addActionListener(this);
		btnOK.addActionListener(this);
		
		// 컴포넌트 붙이기
		jpBtns.add(btnBaggage);
		jpBtns.add(btnSeat);
		jpBtns.add(btnOK);
		
		jpSet.add(jpBtns, BorderLayout.SOUTH);
	}


	// 정보 입력 레이아웃
	private void setInput() {
		
		jpInputInfor = new JPanel(new GridLayout(12, 1, 10, 10));
		jpInputInfor.setBackground(Color.WHITE);
		
		// 라벨
		JLabel lblInformation = new JLabel("예매 정보 입력");
		lblInformation.setFont(fontNanumGothic25);
		
		// 한글 이름 라벨
		JPanel jpLblNameKor = new JPanel(new GridLayout(1, 2, 10, 10));
		jpLblNameKor.setBackground(Color.WHITE);
		lblFamilyNameKor = new JLabel("한글 성");
		lblFamilyNameKor.setFont(fontNanumGothic15);
		lblNameKor = new JLabel("한글 이름");
		lblNameKor.setFont(fontNanumGothic15);
		jpLblNameKor.add(lblFamilyNameKor);
		jpLblNameKor.add(lblNameKor);
		
		// 한글 이름 택스트박스
		JPanel jpTfNameKor = new JPanel(new GridLayout(1, 2, 10, 10));
		jpTfNameKor.setBackground(Color.WHITE);
		tfFamilyNameKor = new JTextField(20);
		tfFamilyNameKor.setFont(fontNanumGothicP15);
		tfFamilyNameKor.setText("예: 이");
		tfNameKor = new JTextField(20);
		tfNameKor.setFont(fontNanumGothicP15);
		tfNameKor.setText("예: 은선");
		jpTfNameKor.add(tfFamilyNameKor);
		jpTfNameKor.add(tfNameKor);
		
		// 영문 이름 라벨
		JPanel jpLblNameEng = new JPanel(new GridLayout(1, 2, 10, 10));
		jpLblNameEng.setBackground(Color.WHITE);
		lblFamilyNameEng = new JLabel("영문 성");
		lblFamilyNameEng.setFont(fontNanumGothic15);
		lblNameEng = new JLabel("영문 이름");
		lblNameEng.setFont(fontNanumGothic15);
		jpLblNameEng.add(lblFamilyNameEng);
		jpLblNameEng.add(lblNameEng);
		
		// 영문 이름 텍스트필드
		JPanel jpTfNameEng = new JPanel(new GridLayout(1, 2, 10, 10));
		jpTfNameEng.setBackground(Color.WHITE);
		tfFamilyNameEng = new JTextField(20);
		tfFamilyNameEng.setFont(fontNanumGothicP15);
		tfFamilyNameEng.setText("예: LEE");
		tfNameEng = new JTextField(20);
		tfNameEng.setFont(fontNanumGothicP15);
		tfNameEng.setText("예: EUNSEON");
		jpTfNameEng.add(tfFamilyNameEng);
		jpTfNameEng.add(tfNameEng);
		
		// 성별 라벨
		lblSex = new JLabel("성별");
		lblSex.setFont(fontNanumGothic15);
		
		// 성별 라디오버튼
		JPanel jpSex = new JPanel(new GridLayout(1, 2, 10, 10));
		jpSex.setBackground(Color.WHITE);
		bgSex = new ButtonGroup();
		rbMan = new JRadioButton("남자", false);
		rbMan.setFont(fontNanumGothic15);
		rbMan.setBackground(Color.WHITE);
		rbWoman = new JRadioButton("여자", true);
		rbWoman.setFont(fontNanumGothic15);
		rbWoman.setBackground(Color.WHITE);
		bgSex.add(rbMan);
		bgSex.add(rbWoman);
		jpSex.add(rbMan);
		jpSex.add(rbWoman);
		
		// 여권번호/생년월일 라벨
		JPanel jpLblPss = new JPanel(new GridLayout(1, 2, 10, 10));
		jpLblPss.setBackground(Color.WHITE);
		lblPassport = new JLabel("여권 번호");
		lblPassport.setFont(fontNanumGothic15);
		lblBirth = new JLabel("생년월일");
		lblBirth.setFont(fontNanumGothic15);
		jpLblPss.add(lblPassport);
		jpLblPss.add(lblBirth);
		
		// 여권번호/생년월일 텍스트필드
		JPanel jpTfPss = new JPanel(new GridLayout(1, 2, 10, 10));
		jpTfPss.setBackground(Color.WHITE);
		tfPassport = new JTextField(20);
		tfPassport.setFont(fontNanumGothicP15);
		tfPassport.setText("예: M46910832");
		tfBirth = new JTextField(20);
		tfBirth.setFont(fontNanumGothicP15);
		tfBirth.setText("예: 20010414");
		jpTfPss.add(tfPassport);
		jpTfPss.add(tfBirth);
		
		// 연락처 라벨
		JPanel jpLblTel = new JPanel(new GridLayout(1, 2, 10, 10));
		jpLblTel.setBackground(Color.WHITE);
		lblTel = new JLabel("연락처");
		lblTel.setFont(fontNanumGothic15);
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(fontNanumGothic15);
		jpLblTel.add(lblTel);
		jpLblTel.add(lblEmail);
		
		// 연락처 택스트필드
		JPanel jptfTel = new JPanel(new GridLayout(1, 2, 10, 10));
		jptfTel.setBackground(Color.WHITE);
		tfTel = new JTextField(20);
		tfTel.setFont(fontNanumGothicP15);
		tfTel.setText("예: 01092032769");
		tfEmail = new JTextField(20);
		tfEmail.setFont(fontNanumGothicP15);
		tfEmail.setText("예: oow214@gmail.com");
		jptfTel.add(tfTel);
		jptfTel.add(tfEmail);
		
		// 동의 
		cbAgree = new JCheckBox("예약 여정의 정보를 이메일과 SMS로 수신하는 것에 동의합니다.");
		cbAgree.setFont(fontNanumGothic15);
		cbAgree.setBackground(Color.WHITE);
		
		// 컴포넌트 붙이기
		jpInputInfor.add(lblInformation);
		jpInputInfor.add(jpLblNameKor);
		jpInputInfor.add(jpTfNameKor);
		jpInputInfor.add(jpLblNameEng);
		jpInputInfor.add(jpTfNameEng);
		jpInputInfor.add(lblSex);
		jpInputInfor.add(jpSex);
		jpInputInfor.add(jpLblPss);
		jpInputInfor.add(jpTfPss);
		jpInputInfor.add(jpLblTel);
		jpInputInfor.add(jptfTel);
		jpInputInfor.add(cbAgree);
		
		
		jpSet.add(jpInputInfor);
	}



	public static void main(String[] args) {
		new ReservationDetailForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnMainMenu) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
			
		} else if(obj == btnOK) {
			
			if(cbAgree.isSelected()) {
				insertInformationData();
				
//				paymentForm = new SelectPaymentForm(this);
//				this.setVisible(false);
				
			} else {
				JOptionPane.showMessageDialog(null, "이메일과 SMS 수신 동의해주십시오.", "동의 안내", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} else if(obj == btnBaggage) {
			nameKOR = tfFamilyNameKor.getText().toString() + tfNameKor.getText().toString();
			baggageFrom = new SelectBaggageForm(this, nameKOR);
			
		} else if(obj == btnSeat) {
			
		}
	}

	private void insertInformationData() {
		// reservationDetail 테이블에 insert 하는 sql문
		String sql = "INSERT INTO reservationDetail "
				+ "(reserveNum, nameKOR, nameENG, sex, passport, birth, tel, email, agree, hydrate, seatNum) "
				+ "VALUES('";
		
		nameKOR = tfFamilyNameKor.getText().toString() + tfNameKor.getText().toString();
		nameENG = tfFamilyNameEng.getText().toString() + tfNameEng.getText().toString();
		
		if(rbMan.isSelected()) {
			sex = "남";
		} else if(rbWoman.isSelected()) {
			sex = "여";
		}
		
		passport = tfPassport.getText().toString();
		birth = tfBirth.getText().toString();
		tel = tfTel.getText().toString();
		email = tfEmail.getText().toString();
		if(cbAgree.isSelected()) {
			agree = 1;
		}
		
		sql += reserveNum + "', '" + nameKOR + "', '" + nameENG + "', '" + sex + "', '" + passport + "', '" + birth + "', '"
			+ tel + "', '" + email + "', " + agree + ", " + hydrate + ", " + seatNum + ")";
		
//		System.out.println(sql);
		
		// sql문 수행
		int result = databaseClass.insert(sql);
		if(result == 1) {
			// insert 성공 시 결제로 넘어감
			paymentForm = new SelectPaymentForm(this);
			this.setVisible(false);
		} else {
			// insert 실패시 안내 다이얼로그
			JOptionPane.showMessageDialog(null, "입력한 정보를 확인해주십시오.", "예매 안내", JOptionPane.WARNING_MESSAGE);
		}
	}
}
