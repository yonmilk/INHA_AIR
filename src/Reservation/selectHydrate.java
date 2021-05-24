package Reservation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainForm;
import menu.MenuBar;

public class selectHydrate extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "초과수화물";
	private int width = 700, height = 600;
	
	// 폰트
		Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
		Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 9
		Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
		Font fontNanumGothic15= new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
		Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
		Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
		Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
		Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
		Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 25
		Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	
	// 초과수화물 가능 개수
	private String[] addCount = {"1", "2", "3"};
	
	// 컴포넌트
	private JPanel jpHydrate;
	private JCheckBox chName;
	private JLabel lblHydrate, lblFree, lblAddHydrate;
	private JTextField tfFree;					// 무료 수화물 개수
	private JComboBox<String> cbAddHydrate;		// 초과 수화물 선택
	private JButton btnOK;
	
	
	public selectHydrate() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 레이아웃 설정
		setLayout(null);
		
		
		// 안내 레이블
		lblHydrate = new JLabel("초과 수화물 선택해주세요.");
		lblHydrate.setFont(fontNanumGothic30);
//		lblHydrate.setForeground(new Color(10,90,150));
		lblHydrate.setHorizontalAlignment(JLabel.CENTER);
		lblHydrate.setSize(680, 40);
		lblHydrate.setLocation(10, 40);
		add(lblHydrate);

		// 초과수화물 선택 패널 생성
		addHydrate();
		
		
		// 확인 버튼
		btnOK = new JButton("확인");
		btnOK.setFont(fontNanumGothic20);
		btnOK.setSize(400, 50);
		btnOK.setLocation(145, 475);
		btnOK.setBackground(new Color(10,90,150));
		btnOK.setForeground(Color.WHITE);
		btnOK.setBorderPainted(false);
		btnOK.addActionListener(this);
		add(btnOK);
		
		// 배경색
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		
		
		
		setVisible(true);
	}

	// 초과 소화물 선택 패널 생성
	private void addHydrate() {
		
		jpHydrate = new JPanel();
		jpHydrate.setSize(645, 350);
		jpHydrate.setLocation(20, 100);
		
		
		// 이름 체크 박스
		String name = "승객1";
		chName = new JCheckBox(name);
		
		add(jpHydrate);
		
	}

	public static void main(String[] args) {
		new selectHydrate();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
