import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);
	Font fontNanumGothic = new Font("NanumGothic", Font.BOLD, 18);
	Font fontArial = new Font("Arial", Font.PLAIN, 12);
	
	// 상단 메뉴 관련 
	private JPanel pnTOP, pnMenu;
	private JButton btnLogo, btnBook, btnAirport, btnInFight, btnMyPage, btnLogin;
	
	// 로그인 프레임
	private LoginForm login;
	
	public MainForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		setLayout(null);	// 배치관리자 제거
		c.setBackground(Color.WHITE);
		
		// 메뉴 판넬
		setMenu();
		
		
		setVisible(true);
	}


	private void setMenu() {
		// 상단 판넬
		pnTOP = new JPanel();		// 상단 판넬 생성
		pnTOP.setLayout(null);		// 상단 판넬 배치관리자 설정
		pnTOP.setSize(1120, 80);	// 상단 판넬 사이즈 설정
		pnTOP.setLocation(0, 0);	// 상단 판넬 위치 설정
		pnTOP.setBackground(Color.WHITE);	// 상단 패널 배경색 설정
		
		// 로고 버튼
		btnLogo = new JButton("INHA AIR");
		btnLogo.setSize(200, 70);
		btnLogo.setLocation(10, 5);
		btnLogo.addActionListener(this);
		
		// 메뉴 선택 판넬
		pnMenu = new JPanel();
		pnMenu.setLayout(null);
//		pnMenu.setSize(700, 70);
		pnMenu.setSize(1000, 50);
//		pnMenu.setLocation(250, 5);
		pnMenu.setLocation(70, 40);
//		pnMenu.setBackground(Color.LIGHT_GRAY);
		
		// 메뉴 버튼
		btnBook = new JButton("예매");			// 예매 버튼 생성
		btnBook.setSize(150, 40);				// 버튼 사이즈 지정
//		btnBook.setLocation(10, 0);				// 버튼 위치 지정
		btnBook.setLocation(200, 0);				// 버튼 위치 지정
		btnBook.addActionListener(this);
		btnBook.setFont(fontNanumGothic);		// 버튼 폰트 설정
//		btnBook.setBackground(Color.LIGHT_GRAY);	// 버튼 배경색 설정
		btnBook.setBorderPainted(false);		// 버튼 테두리 제거
		btnBook.setContentAreaFilled(false);	// 버튼 내용영역 채우기 제거
//		btnBook.setFocusPainted(false);			// 버튼 포커스 시 테두리 제거
		
		btnAirport = new JButton("항공");
		btnAirport.setSize(150, 40);
//		btnAirport.setLocation(180, 0);
		btnAirport.setLocation(350, 0);
		btnAirport.addActionListener(this);
		btnAirport.setFont(fontNanumGothic);
		btnAirport.setBorderPainted(false);
		btnAirport.setContentAreaFilled(false);
		
		btnInFight = new JButton("기내");
		btnInFight.setSize(150, 40);
//		btnInFight.setLocation(350, 0);
		btnInFight.setLocation(500, 0);
		btnInFight.addActionListener(this);
		btnInFight.setFont(fontNanumGothic);
		btnInFight.setBorderPainted(false);
		btnInFight.setContentAreaFilled(false);
		
		btnMyPage = new JButton("마이페이지");
		btnMyPage.setSize(150, 40);
//		btnMyPage.setLocation(520, 0);
		btnMyPage.setLocation(650, 0);
		btnMyPage.addActionListener(this);
		btnMyPage.setFont(fontNanumGothic);
		btnMyPage.setBorderPainted(false);
		btnMyPage.setContentAreaFilled(false);
		
		// 로그인 버튼
		btnLogin = new JButton("<HTML><U>LOGIN</U></HTML>");
		btnLogin.setSize(80, 50);
//		btnLogin.setLocation(970, 35);
		btnLogin.setLocation(970, 5);
		btnLogin.addActionListener(this);
		btnLogin.setFont(fontArial);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		
		pnTOP.add(btnLogo);
		pnTOP.add(pnMenu);
		
		
		pnMenu.add(btnBook);
		pnMenu.add(btnAirport);
		pnMenu.add(btnInFight);
		pnMenu.add(btnMyPage);
		
		
		pnTOP.add(btnLogin);
		
		add(pnTOP);
		
	}


	public static void main(String[] args) {
		new MainForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnLogin)
		{
			new LoginForm("LOGIN", 400, 500, this);
		}
	}
}
