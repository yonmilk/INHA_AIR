package test;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SignUpForm extends JFrame{

	Font fontGothic = new Font("Gothic", Font.BOLD, 13);
	Font fontNanumGothic = new Font("NanumGothic", Font.BOLD, 20);
	
	private String title="INHA AIR - 회원가입";
	private int width = 800, height = 700;
	
	// 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	Font fontNanumGothic13 = new Font("NanumGothic", Font.BOLD, 13);
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 18
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25

	
	private JPanel jpInfL;
	private JCheckBox chkNewsLetter, chkPromotion, chkSMS;
	private JButton btnchk, btnBirth, btnBack, btnOk;
	private JLabel lblPerInf,lblAdd,lblLNKor, lblFNKor,lblLNEng,lblFNEng,lblID, lblPW, lblPWchk, lblBirth, lblSex, lblEmail, lblPhone;
	private JTextField tfLNKor, tfFNKor, tfLNEng, tfFNEng, tfID, tfEmail, tfPhone;
	private JPasswordField tfPW, tfPWchk;
	private ButtonGroup rg;
	private JRadioButton rbMan, rbWoman;
	private JPanel jpTitle;
	private JLabel lblTitle;
	private JPanel jpInfR;


	public SignUpForm() {
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 배경색
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		setLayout(null);
		
		setSignUpForm();
		
		
		
		setVisible(true);
	}


	private void setSignUpForm() {
		
		//회원가입 제목
		jpTitle = new JPanel();
		jpTitle.setLayout(null);
		jpTitle.setSize(350, 100);
		jpTitle.setLocation(40, 0);
		jpTitle.setBackground(Color.white);
		
		lblTitle = new JLabel("회원가입");
		lblTitle.setFont(fontNanumGothic25);
		lblTitle.setSize(150, 35);
		lblTitle.setLocation(0, 10);
		jpTitle.add(lblTitle);
		
		//좌측 정보 창
		jpInfL = new JPanel();
		jpInfL.setLayout(null);
		jpInfL.setSize(350, 400);
		jpInfL.setLocation(40, 100);
		jpInfL.setBackground(Color.red);
		
		lblLNKor= new JLabel("한글 이름");
		lblLNKor.setSize(300, 30);
		lblLNKor.setLocation(0, 0);
		lblLNKor.setFont(fontNanumGothic18);
		jpInfL.add(lblLNKor);
		
		tfLNKor = new JTextField();
		tfLNKor.setSize(300, 30);
		tfLNKor.setLocation(0, 30);
		jpInfL.add(tfLNKor);
	
		lblLNEng = new JLabel("영문 이름");
		lblLNEng.setSize(350, 30);
		lblLNEng.setLocation(0, 70);
		lblLNEng.setFont(fontNanumGothic18);
		jpInfL.add(lblLNEng);
		
		tfLNEng = new JTextField();
		tfLNEng.setSize(300, 30);
		tfLNEng.setLocation(0, 100);
		jpInfL.add(tfLNEng);
		
		lblID = new JLabel("회원 아이디");
		lblID.setSize(350, 30);
		lblID.setLocation(0, 140);
		lblID.setFont(fontNanumGothic18);
		jpInfL.add(lblID);
		
		tfID = new JTextField();
		tfID.setSize(190, 30);
		tfID.setLocation(0, 170);
		jpInfL.add(tfID);
		
		btnchk = new JButton("중복체크");
		btnchk.setSize(100, 30);
		btnchk.setLocation(200, 170);
		btnchk.setBackground(new Color(10,90,150));
		btnchk.setForeground(Color.white); //버튼 폰트 색 변경
		btnchk.setFont(fontNanumGothic13);
		jpInfL.add(btnchk);
		
		lblPW = new JLabel("비밀번호");
		lblPW.setSize(350, 30);
		lblPW.setLocation(0, 210);
		lblPW.setFont(fontNanumGothic18);
		jpInfL.add(lblPW);
		
		tfPW = new JPasswordField();
		tfPW.setSize(300, 30);
		tfPW.setLocation(0, 240);
		jpInfL.add(tfPW);
		
		lblPWchk = new JLabel("비밀번호 확인");
		lblPWchk.setSize(300, 30);
		lblPWchk.setLocation(0, 280);
		lblPWchk.setFont(fontNanumGothic18);
		jpInfL.add(lblPWchk);
		
		tfPWchk = new JPasswordField();
		tfPWchk.setSize(300, 30);
		tfPWchk.setLocation(0, 310);
		jpInfL.add(tfPWchk);
		
		
		//우측 정보 창
		jpInfR = new JPanel();
		jpInfR.setLayout(null);
		jpInfR.setSize(350, 400);
		jpInfR.setLocation(390, 100);
		jpInfR.setBackground(Color.blue);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setSize(300, 30);
		lblBirth.setLocation(0, 0);
		lblBirth.setFont(fontNanumGothic18);
		jpInfR.add(lblBirth);
		
		btnBirth = new JButton("");
		btnBirth.setSize(300, 30);
		btnBirth.setLocation(10, 375);
		btnBirth.setBackground(Color.white);
		jpInfR.add(btnBirth);
		
		lblSex = new JLabel("성별");
		lblSex.setSize(300, 50);
		lblSex.setLocation(10, 395);
		lblSex.setFont(fontGothic);
		jpInfR.add(lblSex);
		
		rg = new ButtonGroup();
		rbMan = new JRadioButton("남자");
		rbMan.setSize(50, 30);
		rbMan.setLocation(10, 430);
		rbWoman = new JRadioButton("여자");
		rbWoman.setSize(100, 30);
		rbWoman.setLocation(80, 430);
		rg.add(rbMan);
		rg.add(rbWoman);
		jpInfR.add(rbMan);
		jpInfR.add(rbWoman);
		
		lblEmail = new JLabel("이메일 주소");
		lblEmail.setSize(300, 50);
		lblEmail.setLocation(10, 455);
		lblEmail.setFont(fontGothic);
		jpInfR.add(lblEmail);
		
		tfEmail = new JTextField("예)javaboss@inhaair.com");
		tfEmail.setSize(300, 30);
		tfEmail.setLocation(10, 490);
		jpInfR.add(tfEmail);
		
		lblPhone = new JLabel("휴대전화 번호");
		lblPhone.setSize(300, 50);
		lblPhone.setLocation(10, 510);
		lblPhone.setFont(fontGothic);
		jpInfR.add(lblPhone);
		
		tfPhone = new JTextField("예)01019981222");
		tfPhone.setSize(300, 30);
		tfPhone.setLocation(10, 550);
		jpInfR.add(tfPhone);
		
		lblAdd = new JLabel("마케팅 및 광고 활용 동의");
		lblAdd.setSize(300, 50);
		lblAdd.setLocation(10, 580);
		lblAdd.setFont(fontGothic);
		jpInfR.add(lblAdd);
		
		chkNewsLetter = new JCheckBox("뉴스레터(회원 소식지 등)");
		chkNewsLetter.setSize(300, 30);
		chkNewsLetter.setLocation(10, 620);
		jpInfR.add(chkNewsLetter);
		
		chkPromotion = new JCheckBox("프로모션 정보(이벤트, 할인 쿠폰)");
		chkPromotion.setSize(300, 30);
		chkPromotion.setLocation(10, 650);
		jpInfR.add(chkPromotion);

		chkSMS = new JCheckBox("SMS 수신 동의");
		chkSMS.setSize(300, 30);
		chkSMS.setLocation(10, 680);
		jpInfR.add(chkSMS);
		
		btnBack = new JButton("이전");
		btnBack.setBackground(Color.white);
		btnBack.setSize(200, 30);
		btnBack.setLocation(10, 720);
		jpInfR.add(btnBack);
		
		btnOk = new JButton("확인");
		btnOk.setBackground(Color.BLUE);
		btnOk.setSize(200, 30);
		btnOk.setLocation(220, 720);
		btnOk.setForeground(Color.WHITE);
		jpInfR.add(btnOk);
	
		add(jpTitle);
		add(jpInfL);
		add(jpInfR);
	}


	public static void main(String[] args) {
		new SignUpForm();
	}

}

