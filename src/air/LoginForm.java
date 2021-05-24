package air;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import main.MainForm;
import menu.MenuBar;

public class LoginForm extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 폰트
	Font fontNanumGothic12 = new Font("NanumGothic", Font.PLAIN , 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.PLAIN, 15);	// 나눔고딕 15
	Font fontNanumGothic16 = new Font("NanumGothic", Font.BOLD, 16);	// 나눔고딕 16
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	
	// 색상
	Color colorLogin = new Color(10,90,150);
	Color colorHyper = new Color(000, 102, 255);
	
	// 컴포턴트
	private JPanel jpLogin;
	private JPanel jpTop, jpCenter, jpBottom;
	private JLabel lblId, lblPw;
	private JTextField tfId, tfPw;
	private JButton btnLogin, btnFindIdPw, btnSignUp;
	
	
	// Forms
	private MainMenuForm mainMenuForm;
	
	public LoginForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// 배경색
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		
		// 로그인 패널
		jpLogin = new JPanel(new BorderLayout());
		jpLogin.setSize(400, 500);
		jpLogin.setLocation(360, 100);
//		jpLogin.setBorder(new EtchedBorder(EtchedBorder.RAISED));		// 테두리 설정
		
		// 연우 - 로그인 레이아웃 구성
		setLogin();
		
		// 컴포넌트 붙이기
		add(jpLogin);
		
		setVisible(true);
	}

	// 연우 - 로그인 레이아웃 구성
	private void setLogin() {
		//상단판넬
		jpTop = new JPanel();
		jpTop.setBackground(Color.white);
		jpTop.setPreferredSize(new Dimension(400, 100)); //판넬사이즈 설정
		jpTop.setLayout(new BorderLayout());
		
		JLabel login = new JLabel("로그인"); //로그인 라벨
		login.setFont(fontNanumGothic25);
		login.setHorizontalAlignment(JLabel.CENTER);
		//btnClose = new JButton();
		jpTop.add(login);
		jpLogin.add(jpTop, BorderLayout.NORTH);
		
		
		//중앙판넬
		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(5, 1, 10, 10));
		jpCenter.setBackground(Color.white);
		lblId = new JLabel("아이디"); //아이디 라벨
		tfId = new JTextField(); //아이디 입력
		lblPw = new JLabel("비밀번호"); //비밀번호 라벨
		tfPw = new JTextField(); //비밀번호 입력
		lblId.setFont(fontNanumGothic15);
		lblPw.setFont(fontNanumGothic15);
		tfId.setFont(fontNanumGothic15);
		tfPw.setFont(fontNanumGothic15);
				
				
		btnLogin = new JButton("로그인"); //로그인 버튼
		btnLogin.setFont(fontNanumGothic16);
		btnLogin.setBorderPainted(false); //버튼 윤곽선 제거
		btnLogin.setBackground(colorLogin); //버튼 색 설정
		btnLogin.setForeground(Color.WHITE);
		jpCenter.add(lblId);
		jpCenter.add(tfId);
		jpCenter.add(lblPw);
		jpCenter.add(tfPw);
		jpCenter.add(btnLogin);
		jpLogin.add(jpCenter, BorderLayout.CENTER);
		
		
		//하단판넬
		jpBottom = new JPanel();
		jpBottom.setPreferredSize(new Dimension(400, 100));
		jpBottom.setLayout(new GridLayout(3,1));
		jpBottom.setBackground(Color.white);
		jpBottom.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		btnFindIdPw = new JButton("<HTML><U>아이디/비밀번호찾기></U></HTML>"); //아이디/비밀번호 찾기 버튼 추가
		btnFindIdPw.setForeground(colorHyper);
		btnFindIdPw.addActionListener(this);
		btnFindIdPw.setBorderPainted(false); //버튼 윤곽선 제거
		btnFindIdPw.setContentAreaFilled(false); //버튼배경 제거
		btnSignUp = new JButton("<HTML><U>회원가입></U></HTML>"); //회원가입 버튼 추가
		btnSignUp.setForeground(colorHyper);
		btnSignUp.addActionListener(this);
		btnSignUp.setBorderPainted(false); //버튼 윤곽선 제거
		btnSignUp.setContentAreaFilled(false); //버튼배경 제거
		btnFindIdPw.setFont(fontNanumGothic12);
		btnSignUp.setFont(fontNanumGothic12);
		
		jpBottom.add(btnFindIdPw);
		jpBottom.add(btnSignUp);
				
		jpLogin.add(jpBottom, BorderLayout.SOUTH);
		
		
		//좌우판넬
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(50, 500));
		west.setBackground(Color.WHITE);
		jpLogin.add(west, BorderLayout.WEST);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(50, 500));
		east.setBackground(Color.WHITE);
		jpLogin.add(east, BorderLayout.EAST);
		
		// 예원 - 액션 추가
		btnLogin.addActionListener(this);
	}

	public static void main(String[] args) {
		new LoginForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnLogin) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
		}
	}
}
