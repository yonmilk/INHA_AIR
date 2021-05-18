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
public class MenuPanel extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 800, height = 300;
	
	// 폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothicPlain18 = new Font("NanumGothic", Font.PLAIN, 18);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 22
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 25);					// 영어
	
	// 닫기 버튼 관련
	private JPanel jpClose;
	private JButton btnClose;
	
	// 메뉴 관련
	private JPanel jpMenu, jpBook, jpAirport, jpInFight;
		
	// 예매 Book
	private JButton btnKoreaDomestic,		// 국내선
					btnInternational,		// 국제선
					btnRefund;				// 환불
		
	// 공항 Airport
	private JLabel lblBaggage;				// 수화물
	private JButton	btnBaggageInformation,	// 수화물 안내
					btnRestrictedItems,		// 운송제한물품
					btnDamagedOrLost;		// 파손 및 유실물
		
	// 기내 InFight
	private JLabel	lblInFlightService;		// 기내 서비스
	private JButton	btnInFlightMeals,		// 기내식
					btnDutyFree,			// 면세품
					btnGuide;				// 가이드
	private JLabel	lblFleet;				// 항공기 안내
	private JButton btnFleetInformation;	// 항공기 정보
		
	
	// 메뉴폼
	public MenuPanel() {
		setTitle(title);
		setSize(width, height);
//		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setUndecorated(true); //타이틀바 없애기 
		
		// 레이아웃 설정
		setLayout(null);
		
		// 배경색
//		Container c = getContentPane();
//		c.setBackground(Color.WHITE);
		
//		// 닫기 버튼
//		setClose();
		
		// 예매 메뉴
		setMenuPop();
		
		setVisible(true);
	}

	
	private void setMenuPop() {
		// 닫기 버튼
		setClose();
		
		jpMenu = new JPanel();
		jpMenu.setLayout(null);
		jpMenu.setSize(775, 200);
		jpMenu.setLocation(5, 55);
		jpMenu.setBackground(Color.YELLOW);
		
		add(jpMenu);
	}

	// 닫기 버튼
	private void setClose() {
		jpClose = new JPanel();
		jpClose.setSize(790, 50);
		jpClose.setLocation(0, 0);
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
		new MenuPanel();
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
