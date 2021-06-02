package customer.book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	Color colorBtn = new Color(10,90,150);
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
	private int people = 0; // 총 인원
	private int adult = 0;	// 성인 인원 - 데이터베이스로 추출
	private int child = 0;	// 소아 인원
	private int infant = 0;	// 유아 인원

	

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
		
		// DB 정보 - 테스트 소스
		String dbURL="jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false";
		String dbID="inhaair";
		String dbPassword="1234";
		// 데이터베이스 연결 - 테스트 소스
		databaseClass.connect(dbURL, dbID, dbPassword);
		
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
		
		// 확인버튼
		btnOK = new JButton("결제하기");
		btnOK.setFont(fontNanumGothic20);
		btnOK.setBackground(colorBtn);
		btnOK.setForeground(Color.WHITE);
		btnOK.setSize(400, 50);
		btnOK.setLocation(350, 600);
		
				
		
		// 예원 - 리스너
		btnMainMenu.addActionListener(this);
		btnOK.addActionListener(this);
		
		// 예원 - 컴포넌트 붙이기
		add(btnMainMenu);
		add(jpSet);
		add(btnOK);
		
		setVisible(true);
		
		
	}

	// 승객 수에 따른 입력 버튼 생성 레이아웃
	private void setInputBtns() {
		
		// 승객 수 받아오기
		String sql = "SELECT adult, child, infant FROM reservation WHERE reserveNum = '" + reserveNum + "'";
		ResultSet rs = databaseClass.select(sql);
		try {
			while(rs.next()) {
				adult = Integer.parseInt(rs.getString("adult"));
				child = Integer.parseInt(rs.getString("child"));
				infant = Integer.parseInt(rs.getString("infant"));
			}
			
			people = adult + child + infant;
			System.out.println(people);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 승객 수 별로 버튼 생성
		jpSet = new JPanel(new GridLayout(10, 2, 0, 5));
		jpSet.setSize(400, 500);
		jpSet.setLocation(350, 90);
		jpSet.setBorder(new EmptyBorder(0, 70, 0, 70));
		jpSet.setBackground(Color.WHITE);
		
		btns = new JButton[people];
		lbls = new JLabel[people];
		
		JLabel lblInfo = new JLabel("정보 입력");
		lblInfo.setFont(fontNanumGothic22);
		lblInfo.setHorizontalAlignment(JLabel.CENTER);
		jpSet.add(lblInfo);
		
		for(int i=0; i<people; i++) {
			btns[i] = new JButton("승객" + (i+1));
			btns[i].addActionListener(this);
			btns[i].setFont(fontNanumGothic18);
			jpSet.add(btns[i]);
			
//			lbls[i] = new JLabel("test");
//			jpSet.add(lbls[i]);
		}
		
		
	}


	public static void main(String[] args) {
		new ReservationForm("test001010");	// 테스트값
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String str = e.getActionCommand();
		
		if(obj == btnMainMenu) {
			mainMenuForm = new MainMenuForm();
			this.setVisible(false);
			
		}
		else if(obj == btnOK) {
			
		}
		else {
			if(str == "입력 완료") {
				
			}else {
				informationForm = new ReservationDetailForm();
			}
		}
	}
}
