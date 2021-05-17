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
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Basic.BasicForm;

//연우 - 탑승일 선택 작성

public class CalendarForm extends JFrame implements ActionListener {
	
	// Title 및 사이즈 설정
	private String title = "탑승일 선택";
	private int width = 800, height = 700;
	
	//private MainForm mainForm;

	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	private JPanel jpTitle, jpSelect, jpCalendar, jpBtn;
	private JLabel lblTitle;
	private JLabel lblCome;
	private JLabel lblGo;
	private JTextField tfGo;
	private JTextField tfCome;
	private JButton btnReselect;
	private JButton btnSelect;

	

	public CalendarForm() {
			
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
		lblTitle.setFont(fontNanumGothic20);
		lblTitle.setSize(150, 40);
		lblTitle.setLocation(10, 0);
		jpTitle.add(lblTitle);
		
		//가는날, 오는날
		jpSelect = new JPanel(); //날짜표시 판매
		jpSelect.setLayout(null);
		jpSelect.setSize(650, 40);
		jpSelect.setLocation(50, 100);
		jpSelect.setBackground(Color.white);
		
		lblGo = new JLabel("가는 날"); //가는날 라벨
		lblGo.setFont(fontNanumGothic18);
		lblGo.setSize(150, 40);
		lblGo.setLocation(10, 0);

		tfGo = new JTextField(); //가는 날짜 선택 시 확인
		tfGo.setFont(fontNanumGothic18);
		tfGo.setSize(150, 40);
		tfGo.setLocation(90,0);
		
		lblCome = new JLabel("오는 날 "); //오는날 라벨
		lblCome.setFont(fontNanumGothic18);
		lblCome.setSize(150, 40);
		lblCome.setLocation(375, 0);
		tfCome = new JTextField(); //오는 날짜 선택 시 확인
		tfCome.setFont(fontNanumGothic18);
		tfCome.setSize(150, 40);
		tfCome.setLocation(455, 0);
		
		jpSelect.add(lblGo);
		jpSelect.add(tfGo);
		jpSelect.add(lblCome);
		jpSelect.add(tfCome);
		
		jpCalendar = new JPanel();
		setCalendar();
		
		
		//다시선택, 왕복/편도 선택
		jpBtn = new JPanel(); //하단 버튼 판넬
		btnReselect = new JButton("다시 선택"); //다시 선택 버튼
		btnSelect = new JButton("편도 선택"); //왕복/편도 선택 버튼
		
		
		//jpBtn.add(btnReselect);
		//jpBtn.add(btnSelect);
		
		add(jpTitle);
		add(jpSelect);
		add(jpCalendar);
		add(jpBtn);
		
	}



	public static void main(String[] args) {
		new CalendarForm();
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
