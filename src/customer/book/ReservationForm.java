package customer.book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.cj.x.protobuf.MysqlxSession.Reset;

import DataBase.databaseClass;
import be.main.MainForm;
import be.menu.MenuBar;
import customer.start.MainMenuForm;

public class ReservationForm extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 예원 - 메인 버튼 컴포넌트
	private JButton btnMainMenu;
	// 예원 - Forms
	private MainMenuForm mainMenuForm;
	private ReservationDetailForm informationForm;
	
	// 예원 - 색상
	Color colorLogo = new Color(24, 62, 111);
	// 예원 - 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	// 폰트
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 25
	
	// 컴포넌트
	private JPanel jpSet;
	private JButton btnOK;
	
	// 승객 수에 따라 라벨/버튼 개수가 변하므로 배열로 선언
	private JLabel[] lbls;
	private JButton[] btns;

	// 예매 정보 
	private String reserveNum = "";	// 티켓선택 창에서 넘어올 때 같이 넘어옴
	private int people = 0;	// 데이터베이스로 추출
	

	// Getter&Setter
	public JLabel[] getLbls() {
		return lbls;
	}


	public void setLbls(JLabel[] lbls) {
		this.lbls = lbls;
	}


	public JButton[] getBtns() {
		return btns;
	}


	public void setBtns(JButton[] btns) {
		this.btns = btns;
	}



	public ReservationForm(String reserveNum) {
		this.reserveNum = reserveNum;
		
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
				
		// 승객 정보 입력 레이아웃
		setInputBtns();
		
		// 예원 - 리스너
		btnMainMenu.addActionListener(this);
		
		// 예원 - 컴포넌트 붙이기
		add(btnMainMenu);
		
		setVisible(true);
	}

	// 승객 수에 따른 입력 버튼 생성 레이아웃
	private void setInputBtns() {
		
		// 승객 수 받아오기
		String sql = "SELECT people FROM reservation WHERE reserveNum = '" + reserveNum + "'";
		ResultSet rs = databaseClass.select(sql);
		
	}


	public static void main(String[] args) {
		new ReservationForm("test001010");	// 테스트값
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnMainMenu) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
			
		}
	}
}
