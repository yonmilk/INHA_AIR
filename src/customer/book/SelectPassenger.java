package customer.book;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//연우 - 승객선택
public class SelectPassenger extends JFrame implements ActionListener{

	// Title 및 사이즈 설정
	private String title = "승객 선택";
	private int width = 490, height = 500;
	
	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);		// 나눔고딕 9
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	
	
	private ImageIcon qsIcon = new ImageIcon("imgs/questionMark.png");
	private Image imgQs = qsIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private ImageIcon imgQuestionIcon = new ImageIcon(imgQs);
	
	private ImageIcon plusIcon = new ImageIcon("imgs/plus.png");
	private Image imgPlus = plusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private ImageIcon imgPlusIcon = new ImageIcon(imgPlus);
	
	
	private ImageIcon minusIcon = new ImageIcon("imgs/minus.png");
	private Image imgMinus = minusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private ImageIcon imgMinusIcon = new ImageIcon(imgMinus);
	
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
	private JLabel lblAgeCal;
	private JLabel lblAgeGuide;
	private JTextField tfAge;
	private JButton btnCalculate;
	private JButton btnOk;
	
	int numAdult = 0;
	int numInfant = 0;
	int numChild = 0;
	
	
	
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
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				tfAge.requestFocus();
			}
		});
		
		setVisible(true);
		
	}
	
	
	
	
	private void setPassenger() {
		
		//제목패널
		jpTitle = new JPanel();
		jpTitle.setLayout(null);
		jpTitle.setSize(200, 60);
		jpTitle.setLocation(20, 20);
		jpTitle.setBackground(Color.white);
		lblTitle = new JLabel("승객 선택"); 		//제목라벨
		lblTitle.setFont(fontNanumGothic20);
		lblTitle.setSize(150, 40);
		lblTitle.setLocation(0, 10);
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
		btnAdult = new JButton(imgQuestionIcon); //국제선 만 12세 이상, 국내선 만 13세 이상
		btnAdult.setBorderPainted(false); //버튼 윤곽선 제거
		btnAdult.setContentAreaFilled(false); //버튼배경 제거
		btnAdult.addActionListener(this);
		lblInfant = new JLabel("소아");
		lblInfant.setFont(fontNanumGothic18);
		btnInfant = new JButton(imgQuestionIcon); //국제선 만 12세 미만, 국내선 만 13세 미만
		btnInfant.setBorderPainted(false); //버튼 윤곽선 제거
		btnInfant.setContentAreaFilled(false); //버튼배경 제거
		btnInfant.addActionListener(this);
		lblChild = new JLabel("유아");
		lblChild.setFont(fontNanumGothic18);
		btnChild = new JButton(imgQuestionIcon); //만 2세 미만
		btnChild.setBorderPainted(false); //버튼 윤곽선 제거
		btnChild.setContentAreaFilled(false); //버튼배경 제거
		btnChild.addActionListener(this);
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
		
		btnPlusAdult = new JButton(imgPlusIcon); //성인 인원라벨, +버튼, -버튼
		btnPlusAdult.setBorderPainted(false); //버튼 윤곽선 제거
		btnPlusAdult.setContentAreaFilled(false); //버튼배경 제거
		btnPlusAdult.addActionListener(this);
		lblNumAdult = new JLabel("0");
		lblNumAdult.setFont(fontNanumGothic18);
		lblNumAdult.setHorizontalAlignment(JLabel.CENTER);
		btnMinusAdult = new JButton(imgMinusIcon);
		btnMinusAdult.setBorderPainted(false); //버튼 윤곽선 제거
		btnMinusAdult.setContentAreaFilled(false); //버튼배경 제거
		btnMinusAdult.addActionListener(this);
		
		btnPlusInfant = new JButton(imgPlusIcon); //소아 인원라벨, +버튼, -버튼
		btnPlusInfant.setBorderPainted(false); //버튼 윤곽선 제거
		btnPlusInfant.setContentAreaFilled(false); //버튼배경 제거
		btnPlusInfant.addActionListener(this);
		lblNumInfant = new JLabel("0");
		lblNumInfant.setFont(fontNanumGothic18);
		lblNumInfant.setHorizontalAlignment(JLabel.CENTER);
		btnMinusInfant = new JButton(imgMinusIcon);
		btnMinusInfant.setBorderPainted(false); //버튼 윤곽선 제거
		btnMinusInfant.setContentAreaFilled(false); //버튼배경 제거
		btnMinusInfant.addActionListener(this);
		
		btnPlusChild = new JButton(imgPlusIcon); //유아 인원라벨, +버튼, -버튼
		btnPlusChild.setBorderPainted(false); //버튼 윤곽선 제거
		btnPlusChild.setContentAreaFilled(false); //버튼배경 제거
		btnPlusChild.addActionListener(this);
		lblNumChild = new JLabel("0");
		lblNumChild.setFont(fontNanumGothic18);
		lblNumChild.setHorizontalAlignment(JLabel.CENTER);
		btnMinusChild = new JButton(imgMinusIcon);
		btnMinusChild.setBorderPainted(false); //버튼 윤곽선 제거
		btnMinusChild.setContentAreaFilled(false); //버튼배경 제거
		btnMinusChild.addActionListener(this);

		jpNumSelect.add(btnMinusAdult);
		jpNumSelect.add(lblNumAdult);
		jpNumSelect.add(btnPlusAdult);
		jpNumSelect.add(btnMinusInfant);
		jpNumSelect.add(lblNumInfant);
		jpNumSelect.add(btnPlusInfant);
		jpNumSelect.add(btnMinusChild);
		jpNumSelect.add(lblNumChild);
		jpNumSelect.add(btnPlusChild);
		
		//나이계산기 패널  및 확인버튼
		jpAgeCal = new JPanel();
		jpAgeCal.setLayout(null);
		jpAgeCal.setSize(430, 150);
		jpAgeCal.setLocation(20, 300);
		jpAgeCal.setBackground(Color.white);
		
		lblAgeCal = new JLabel("나이계산기"); //나이계산기
		lblAgeCal.setFont(fontNanumGothic12);
		lblAgeCal.setSize(150, 40);
		lblAgeCal.setLocation(10, 0);
		lblAgeGuide = new JLabel("생년월일(예: 20020214)"); //예시
		lblAgeGuide.setFont(fontNanumGothic12);
		lblAgeGuide.setSize(150, 40);
		lblAgeGuide.setLocation(10, 20);
		lblAgeGuide.setForeground(Color.gray);
		tfAge = new JTextField(); //생년월일 입력 필드
		tfAge.setFont(fontNanumGothic12);
		tfAge.setSize(300, 30);
		tfAge.setLocation(10, 50);
		btnCalculate = new JButton("계산하기"); //계산하기 버튼
		btnCalculate.setFont(fontNanumGothic12);
		btnCalculate.setSize(100, 30);
		btnCalculate.setLocation(315, 50);
		btnCalculate.setBorder(new LineBorder(Color.gray,1));
		//btnCalculate.setContentAreaFilled(false); //버튼배경 제거
		btnCalculate.setBackground(Color.white);
		btnCalculate.addActionListener(this);
		btnOk = new JButton("확인"); //확인버튼
		btnOk.setFont(fontNanumGothic15);
		btnOk.setForeground(Color.white);
		btnOk.setSize(100, 30);
		btnOk.setLocation(150, 100);
		btnOk.setBorderPainted(false); //버튼 윤곽선 제거
		btnOk.setBackground(new Color(10,90,150));
		btnOk.addActionListener(this);
		
		
		jpAgeCal.add(lblAgeCal);
		jpAgeCal.add(lblAgeGuide);
		jpAgeCal.add(tfAge);
		jpAgeCal.add(btnCalculate);
		jpAgeCal.add(btnOk);
		
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
		Object obj = e.getSource();
		
		
		
		if (obj == btnAdult) { //성인 나이 기준 설명
			
		} else if (obj == btnInfant) { //소아 나이 기준 설명
			
		} else if (obj == btnChild) { //유아 나이 기준 설명
			
		} else if (obj == btnPlusAdult) { //성인라벨 인원 추가
			if(numAdult>0) {
				numAdult++;
			}
			lblNumAdult.setText(Integer.toString(numAdult));
		} else if (obj == btnMinusAdult) { //성인라벨 인원 감소
			if(numAdult<9) {
				numAdult--;
			} 
			lblNumAdult.setText(Integer.toString(numAdult));
		} else if (obj == btnPlusInfant) { //소아라벨 인원추가
			numInfant++;
			lblNumInfant.setText(Integer.toString(numInfant));
		} else if (obj == btnMinusInfant) { //소아라벨 인원감소
			numInfant--;
			lblNumInfant.setText(Integer.toString(numInfant));
		} else if (obj == btnPlusChild) { //유아라벨 인원추가
			numChild++;
			lblNumChild.setText(Integer.toString(numChild));
		} else if (obj == btnMinusChild) { //유아라벨 인원감소
			numChild--;
			lblNumChild.setText(Integer.toString(numChild));
		}
		
		//btnAdult(성인), btnChild(유아), btnInfant(소아) 성인-소아-유아
		//btnCalculate, btnOk
		//btnMinusAdult, btnMinusChild, btnMinusInfant
		//btnPlusAdult, btnPlusChild, btnPlusInfant
		
		
		
		
	}

}
