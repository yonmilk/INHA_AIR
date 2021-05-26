package customer.flightSchedule;
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

import be.main.MainForm;
import be.menu.MenuBar;
import customer.start.MainMenuForm;

public class FlightStatusForm extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	// 색상
	Color colorLogo = new Color(24, 62, 111);	
	Color colorBtn = new Color(10,90,150);
	
	// 버튼
	private JButton btnMainMenu;
		
	// Forms
	private MainMenuForm mainMenuForm;
	
	// 예원 - 시작 화면
	public FlightStatusForm() {
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
				
		// 예매 조회창
		setFindTrips();
		
		// 리스너
		btnMainMenu.addActionListener(this);
		
		// 컴포넌트 붙이기
		add(btnMainMenu);
		
		
		setVisible(true);
	}

	// 예매 조회창
	private void setFindTrips() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new FlightStatusForm();
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
