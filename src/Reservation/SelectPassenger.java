package Reservation;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPassenger extends JFrame implements ActionListener{

	// Title 및 사이즈 설정
	private String title = "승객 선택";
	private int width = 500, height = 500;
	
	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 9
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	private JPanel jpTitle;
	private JLabel lblTitle;
	
	
	
	public SelectPassenger() {
		
		//this.mainForm = mainForm;
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		
		setPassenger();
		
		setVisible(true);
		
	}
	
	
	
	
	private void setPassenger() {
		
		//제목판넬
		jpTitle = new JPanel();
		jpTitle.setLayout(null);
		jpTitle.setSize(200, 60);
		jpTitle.setLocation(20, 20);
		jpTitle.setBackground(Color.white);
		//제목라벨
		lblTitle = new JLabel("승객 선택");
		lblTitle.setFont(fontNanumGothic20);
		lblTitle.setSize(150, 40);
		lblTitle.setLocation(10, 0);
		jpTitle.add(lblTitle);
		
		add(jpTitle);
		
	}


	public static void main(String[] args) {
		new SelectPassenger();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
