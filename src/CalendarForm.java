import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Basic.BasicForm;

//연우 - 탑승일 선택 작성

public class CalendarForm extends JFrame implements ActionListener {
	
	//private MainForm mainForm;

	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	private JPanel jpTitle, jpSelect, jpCalendar, jpBtn;
	private JLabel lblTitle;

	

	public CalendarForm(String title, int width, int height) {
			
		//this.mainForm = mainForm;
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(new BorderLayout());
		
		
		setCalendarForm();
		
		setVisible(true);
		
	}

	private void setCalendar() {
		
	}
	
	
	private void setCalendarForm() {
		
		//제목판넬
		jpTitle = new JPanel();
		jpTitle.setLayout(null);
		jpTitle.setSize(200, 60);
		jpTitle.setLocation(50, 40);
		jpTitle.setBackground(Color.white);
		//제목라벨
		lblTitle = new JLabel("탑승일 선택");
		lblTitle.setFont(fontNanumGothic25);
		lblTitle.setSize(150, 40);
		lblTitle.setLocation(10, 0);
		jpTitle.add(lblTitle);
		
		//날짜표시판넬
		jpSelect = new JPanel();
		jpSelect.setLayout(null);
		jpSelect.setSize(650, 50);
		jpSelect.setLocation(50, 100);
		jpSelect.setBackground(Color.red);
		//가는날 라벨, 
		
		
		
		jpCalendar = new JPanel();
		setCalendar();
		
		
		//하단 버튼 판넬
		jpBtn = new JPanel();
		
		
		add(jpTitle);
		add(jpSelect);
		add(jpCalendar);
		add(jpBtn);
		
	}



	public static void main(String[] args) {
		new CalendarForm("탑승일 선택", 800, 700);
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
