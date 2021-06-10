package customer.login;



import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class SignUpForm extends JFrame implements ActionListener{

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
	private JButton btnchk, btnSignUp;
	private JLabel lblAdd,lblLNKor, lblLNEng, lblID, lblPW, lblPWchk, lblBirth, lblSex, lblEmail, lblPhone;
	private JTextField tfLNKor, tfLNEng, tfID, tfEmail, tfPhone;
	private JPasswordField tfPW, tfPWchk;
	private ButtonGroup rg;
	private JRadioButton rbMan, rbWoman;
	private JPanel jpTitle;
	private JLabel lblTitle;
	private JPanel jpInfR;
	private JTextField tfBirth;
	private JLabel lblEmailEx;
	private JLabel lblPhoneEx;


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
		jpInfL.setBackground(Color.white);
		
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
		btnchk.addActionListener(this);
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
		jpInfR.setLocation(410, 100);
		jpInfR.setBackground(Color.white);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setSize(300, 30);
		lblBirth.setLocation(0, 0);
		lblBirth.setFont(fontNanumGothic18);
		jpInfR.add(lblBirth);
		
		tfBirth = new JTextField("");
		tfBirth.setSize(300, 30);
		tfBirth.setLocation(0, 30);
		tfBirth.setBackground(Color.white);
		jpInfR.add(tfBirth);
		
		lblSex = new JLabel("성별");
		lblSex.setSize(300, 30);
		lblSex.setLocation(0, 70);
		lblSex.setFont(fontNanumGothic18);
		jpInfR.add(lblSex);
		
		rg = new ButtonGroup();
		rbMan = new JRadioButton("남자");
		rbMan.setSize(50, 30);
		rbMan.setLocation(0, 100);
		rbWoman = new JRadioButton("여자");
		rbWoman.setSize(50, 30);
		rbWoman.setLocation(80, 100);
		rbMan.setBackground(Color.white);
		rbWoman.setBackground(Color.white);
		rg.add(rbMan);
		rg.add(rbWoman);
		jpInfR.add(rbMan);
		jpInfR.add(rbWoman);
		
		lblEmail = new JLabel("이메일 주소");
		lblEmail.setSize(300, 30);
		lblEmail.setLocation(0, 140);
		lblEmail.setFont(fontNanumGothic18);
		jpInfR.add(lblEmail);
		
		lblEmailEx = new JLabel("예) kyeonw1109@gmail.com");
		lblEmailEx.setSize(300, 30);
		lblEmailEx.setLocation(120, 140);
		lblEmailEx.setFont(fontNanumGothic13);
		jpInfR.add(lblEmailEx);
		
		tfEmail = new JTextField();
		tfEmail.setSize(300, 30);
		tfEmail.setLocation(0, 170);
		jpInfR.add(tfEmail);
		
		lblPhone = new JLabel("휴대전화 번호");
		lblPhone.setSize(300, 30);
		lblPhone.setLocation(0, 210);
		lblPhone.setFont(fontNanumGothic18);
		jpInfR.add(lblPhone);
		
		lblPhoneEx = new JLabel("예) 01092032769");
		lblPhoneEx.setSize(300, 30);
		lblPhoneEx.setLocation(140, 210);
		lblPhoneEx.setFont(fontNanumGothic13);
		jpInfR.add(lblPhoneEx);
		
		tfPhone = new JTextField();
		tfPhone.setSize(300, 30);
		tfPhone.setLocation(0, 240);
		jpInfR.add(tfPhone);
		
		
		lblAdd = new JLabel("마케팅 및 광고 활용 동의");
		lblAdd.setSize(300, 30);
		lblAdd.setLocation(0, 280);
		lblAdd.setFont(fontNanumGothic18);
		jpInfR.add(lblAdd);
		
		chkNewsLetter = new JCheckBox("뉴스레터(회원 소식지 등)");
		chkNewsLetter.setSize(300, 30);
		chkNewsLetter.setLocation(0, 310);
		chkNewsLetter.setBackground(Color.white);
		jpInfR.add(chkNewsLetter);
		
		chkPromotion = new JCheckBox("프로모션 정보(이벤트, 할인 쿠폰)");
		chkPromotion.setSize(300, 30);
		chkPromotion.setLocation(0, 340);
		chkPromotion.setBackground(Color.white);
		jpInfR.add(chkPromotion);

		chkSMS = new JCheckBox("SMS 수신 동의");
		chkSMS.setSize(300, 30);
		chkSMS.setLocation(0, 370);
		chkSMS.setBackground(Color.white);
		jpInfR.add(chkSMS);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.setBackground(new Color(10,90,150));
		btnSignUp.setSize(200, 50);
		btnSignUp.setLocation(280, 550);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(fontNanumGothic18);
		btnSignUp.addActionListener(this);
		
	
		add(jpTitle);
		add(jpInfL);
		add(jpInfR);
		add(btnSignUp);
	}


	public static void main(String[] args) {
		new SignUpForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnchk) {
			
		} else if (obj == btnSignUp) {
			
		}
		
	}

}

