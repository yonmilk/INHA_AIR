package menu;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import menu.MenuBar;

// 예원 - 메뉴 화면
public class MenuForm extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 700, height = 550;
	
	// 폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 22
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 25);					// 영어
	
	// 닫기 버튼 관련
	private JPanel jpClose;
	private JButton btnClose;
	
	// 메뉴 관련
	private JPanel jpBook, jpAirport, jpInFight;
	
	// 예
	
	public MenuForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true); //타이틀바 없애기 
		
		// 레이아웃 설정
		setLayout(null);
		
		// 닫기 버튼
		setClose();
		
		setMenu();
		
		// 배경색
//		Container c = getContentPane();
//		c.setBackground(Color.WHITE);
		
		setVisible(true);
	}

	
	private void setMenu() {
		jpBook = new JPanel();
		jpBook.setSize(210, 480);
		jpBook.setLocation(10, 60);
		jpBook.setBackground(Color.yellow);
		
		jpAirport = new JPanel();
		jpAirport.setSize(210, 480);
		jpAirport.setLocation(240, 60);
		jpAirport.setBackground(Color.blue);
		
		jpInFight = new JPanel();
		jpInFight.setSize(210, 480);
		jpInFight.setLocation(470, 60);
		jpInFight.setBackground(Color.green);
		
		add(jpBook);
		add(jpAirport);
		add(jpInFight);
	}


	private void setClose() {
		jpClose = new JPanel();
		jpClose.setSize(700, 50);
		jpClose.setLocation(0, 5);
		jpClose.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		jpClose.setBackground(Color.black);
		
		btnClose = new JButton("X");
		btnClose.addActionListener(this);
		btnClose.setFont(fontArial);
		btnClose.setBorderPainted(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setFocusPainted(false);
		
		jpClose.add(btnClose);
		add(jpClose);
	}

	public static void main(String[] args) {
		new MenuForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnClose)
		{
			this.dispose(); //해당 창만 끄게 하기
		}
	}
}
