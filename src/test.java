
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

public class test extends JFrame implements ActionListener {
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	private JPanel pnTOP;
	
	public test() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 이거 건들지말기
		setLayout(null);
		setUpMenu();
		
		setVisible(true);
	}


	// 이거 건들지말기
	private void setUpMenu() {
		// 상단 판넬
		pnTOP = new JPanel();		// 상단 판넬 생성
		pnTOP.setLayout(null);		// 상단 판넬 배치관리자 설정
		pnTOP.setSize(1120, 80);	// 상단 판넬 사이즈 설정
		pnTOP.setLocation(0, 0);	// 상단 판넬 위치 설정
		pnTOP.setBackground(Color.black);	// 상단 패널 배경색 설정
		
		add(pnTOP);
	}


	public static void main(String[] args) {
		new test();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
