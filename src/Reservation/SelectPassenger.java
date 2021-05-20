package Reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//연우 - 승객선택
public class SelectPassenger extends JFrame implements ActionListener{

	// Title 및 사이즈 설정
	private String title = "승객 선택";
	private int width = 490, height = 500;
	
	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 9
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	private ImageIcon questionIcon = new ImageIcon("imgs/questionMark.png");
	private ImageIcon plusIcon = new ImageIcon("imgs/plus.png");
	private ImageIcon minusIcon = new ImageIcon("imgs/minus.png");
	private JPanel jpTitle;
	private JLabel lblTitle;
	private JPanel jpAge;
	private JPanel jpNumSelect;
	private JPanel jpAgeCal;
	private JLabel lblAdult;
	private JLabel lblInfant;
	private JLabel lblChild;
	private JButton btnAdult;
	private JButton btnInfant;
	private JButton btnChild;
	private JButton btnPlusAdult;
	private JButton btnMinusAdult;
	private JButton btnPlusInfant;
	private JButton btnMinusInfant;
	private JButton btnPlusChild;
	private JButton btnMinusChild;
	private JLabel lblNumAdult;
	private JLabel lblNumInfant;
	private JLabel lblNumChild;
	
	
	
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
		
		//제목패널
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
		
		//연령패널
		jpAge = new JPanel();
		jpAge.setLayout(null);
		jpAge.setSize(90, 200);
		jpAge.setLocation(20, 90);
		jpAge.setBackground(Color.white);
		jpAge.setLayout(new GridLayout(3, 2));
		
		
		lblAdult = new JLabel("성인"); 
		lblAdult.setFont(fontNanumGothic18);
		btnAdult = new JButton(questionIcon); //국제선 만 12세 이상, 국내선 만 13세 이상
		btnAdult.setBorderPainted(false); //버튼 윤곽선 제거
		btnAdult.setContentAreaFilled(false); //버튼배경 제거
		lblInfant = new JLabel("소아");
		lblInfant.setFont(fontNanumGothic18);
		btnInfant = new JButton(questionIcon); //국제선 만 12세 미만, 국내선 만 13세 미만
		btnInfant.setBorderPainted(false); //버튼 윤곽선 제거
		btnInfant.setContentAreaFilled(false); //버튼배경 제거
		lblChild = new JLabel("유아");
		lblChild.setFont(fontNanumGothic18);
		btnChild = new JButton(questionIcon); //만 2세 미만
		btnChild.setBorderPainted(false); //버튼 윤곽선 제거
		btnChild.setContentAreaFilled(false); //버튼배경 제거
		jpAge.add(lblAdult);
		jpAge.add(btnAdult);
		jpAge.add(lblInfant);
		jpAge.add(btnInfant);
		jpAge.add(lblChild);
		jpAge.add(btnChild);

		
		//인원선택 패널
		jpNumSelect = new JPanel();
		jpNumSelect.setLayout(null);
		jpNumSelect.setSize(200, 200);
		jpNumSelect.setLocation(250, 90);
		jpNumSelect.setBackground(Color.white);
		jpNumSelect.setLayout(new GridLayout(3, 3));
		btnPlusAdult = new JButton(plusIcon);
		btnPlusAdult.setBorderPainted(false); //버튼 윤곽선 제거
		btnPlusAdult.setContentAreaFilled(false); //버튼배경 제거
		lblNumAdult = new JLabel("0");
		lblNumAdult.setFont(fontNanumGothic18);
		lblNumAdult.setHorizontalAlignment(JLabel.CENTER);
		btnMinusAdult = new JButton(minusIcon);
		btnMinusAdult.setBorderPainted(false); //버튼 윤곽선 제거
		btnMinusAdult.setContentAreaFilled(false); //버튼배경 제거
		btnPlusInfant = new JButton(plusIcon);
		btnPlusInfant.setBorderPainted(false); //버튼 윤곽선 제거
		btnPlusInfant.setContentAreaFilled(false); //버튼배경 제거
		lblNumInfant = new JLabel("0");
		lblNumInfant.setFont(fontNanumGothic18);
		lblNumInfant.setHorizontalAlignment(JLabel.CENTER);
		btnMinusInfant = new JButton(minusIcon);
		btnMinusInfant.setBorderPainted(false); //버튼 윤곽선 제거
		btnMinusInfant.setContentAreaFilled(false); //버튼배경 제거
		btnPlusChild = new JButton(plusIcon);
		btnPlusChild.setBorderPainted(false); //버튼 윤곽선 제거
		btnPlusChild.setContentAreaFilled(false); //버튼배경 제거
		lblNumChild = new JLabel("0");
		lblNumChild.setFont(fontNanumGothic18);
		lblNumChild.setHorizontalAlignment(JLabel.CENTER);
		btnMinusChild = new JButton(minusIcon);
		btnMinusChild.setBorderPainted(false); //버튼 윤곽선 제거
		btnMinusChild.setContentAreaFilled(false); //버튼배경 제거
		
		
		jpNumSelect.add(btnPlusAdult);
		jpNumSelect.add(lblNumAdult);
		jpNumSelect.add(btnMinusAdult);
		jpNumSelect.add(btnPlusInfant);
		jpNumSelect.add(lblNumInfant);
		jpNumSelect.add(btnMinusInfant);
		jpNumSelect.add(btnPlusChild);
		jpNumSelect.add(lblNumChild);
		jpNumSelect.add(btnMinusChild);
		
		//나이계산기 패널  및 확인버튼
		jpAgeCal = new JPanel();
		jpAgeCal.setLayout(null);
		jpAgeCal.setSize(430, 150);
		jpAgeCal.setLocation(20, 300);
		jpAgeCal.setBackground(Color.CYAN);
		
		add(jpTitle);
		add(jpAge);
		add(jpNumSelect);
		add(jpAgeCal);
		
	}


	public static void main(String[] args) {
		new SelectPassenger();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
