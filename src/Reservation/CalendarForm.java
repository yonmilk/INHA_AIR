package Reservation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

//연우 - 탑승일 선택 작성

public class CalendarForm extends JFrame implements ActionListener {
	
	// Title 및 사이즈 설정
	private String title = "탑승일 선택";
	private int width = 750, height = 800;
	
	//private MainForm mainForm;

	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 9
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
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
	private static Calendar cal = Calendar.getInstance(); //캘린더 객체 생성;
	private String[] day = new String[] {"S", "M", "T", "W", "T", "F", "S"};
	private int thisYear;
	private int thisMonth;
	private int today;
	private JLabel lblday;
	private JLabel lblYear;
	private JLabel lblMonth;
	private ArrayList<JButton> lstBtn = new ArrayList<JButton>();
	private JButton btnDay;
	private int dayY;
	private int dayX;
	private static int todayYear = cal.get(Calendar.YEAR);
	private static int todayMonth = cal.get(Calendar.MONTH)+1;
	
	

	public CalendarForm() {
			
		//this.mainForm = mainForm;
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		
		
		setCalendarForm();
		
		setVisible(true);
		
	}

	private void setCalendar(int year, int month, int x, int y) {
		
		//달력 생성 함수
		jpCalendar = new JPanel();
		jpCalendar.setLayout(null);
		jpCalendar.setSize(290, 370);
		jpCalendar.setLocation(x, y);
		jpCalendar.setBackground(Color.WHITE);
		
		thisYear = year; //현재 년
		thisMonth = month; //현재 달
		today = cal.get(Calendar.DATE);

		
		cal.set(thisYear, thisMonth-1, 1); //캘린더 객체에 년도, 달 설정과 Date 1로 설정
		
		int sDayNum = cal.get(Calendar.DAY_OF_WEEK); //1일의 요일 얻어오기
		int endDate = cal.getActualMaximum(Calendar.DATE); //달의 마지막 일 얻기
		
		int intDateNum = 1;
		
		lblYear = new JLabel(thisYear+"년");
		lblYear.setFont(fontNanumGothic12);
		lblYear.setSize(150, 40);
		lblYear.setLocation(10, 2);
		lblMonth = new JLabel(thisMonth+"월");
		lblMonth.setFont(fontNanumGothic18);
		lblMonth.setSize(80, 40);
		lblMonth.setLocation(60, 0);
		jpCalendar.add(lblYear);
		jpCalendar.add(lblMonth);
		
		
		for (int i = 0; i<7; i++) { //요일 추가
			lblday = new JLabel(day[i]);
			lblday.setFont(fontNanumGothic15);
			lblday.setSize(100, 40);
			lblday.setLocation(40*i + 18, 30);
			jpCalendar.add(lblday);
			
		}
		
		dayX = 0;
		dayY = 70;
		
		for (int i = 1; intDateNum <= endDate; i++) { //intDateNum이 1일부터 마지막일이 될 때까지 반복 
		
			
			
			if (i<sDayNum) //i가 요일숫자보다 작으면 공백 버튼
			{
				btnDay = new JButton("");
				btnDay.setFont(fontNanumGothic9);
				btnDay.setBorderPainted(false); //버튼 윤곽선 제거
				//btnDay.setBackground(new Color(153, 204, 255)); //버튼 색 설정
				btnDay.setBackground(Color.white); //버튼 색 설정
				btnDay.setSize(45, 50);
				btnDay.setLocation(dayX, dayY);
				lstBtn.add(btnDay);
				jpCalendar.add(btnDay);
				
				dayX += 40;
			}
			else //date값의 버튼 출력 
			{
				btnDay = new JButton(intDateNum+"");
				btnDay.addActionListener(this);
				btnDay.setFont(fontNanumGothic9);
				btnDay.setBorderPainted(false); //버튼 윤곽선 제거
				//btnDay.setBackground(new Color(153, 204, 255)); //버튼 색 설정
				btnDay.setBackground(Color.white); //버튼 색 설정
				btnDay.setSize(45, 50);
				btnDay.setLocation(dayX, dayY);
				lstBtn.add(btnDay);
				jpCalendar.add(btnDay);
				
				intDateNum++; //출력할 date 증가
				dayX += 40;
			}
			
			if(i%7 == 0) //i가 7로 나눠지면 다음 줄로 이동
			{
				dayY += 50;
				dayX = 0;
			}
			
		}
		
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

		
		//달력추가
		setCalendar(todayYear, todayMonth, 50, 160);
		//setCalendar(todayYear+1, todayMonth+1, 160, 160);
		
		//하단 버튼 판넬
		jpBtn = new JPanel();
		jpBtn.setLayout(null);
		jpBtn.setSize(650, 80);
		jpBtn.setLocation(50, 550);
		jpBtn.setBackground(Color.white);
		
		//버튼 추가 및 설정
		btnReselect = new JButton("다시 선택");
		btnReselect.setFont(fontNanumGothic18);
		btnReselect.setSize(230, 60);
		btnReselect.setLocation(20, 0);
		btnReselect.setBorderPainted(false); //버튼 윤곽선 제거
		btnReselect.setBackground(new Color(153, 204, 255)); //버튼 색 설정
		btnSelect = new JButton("왕복 선택");
		btnSelect.setFont(fontNanumGothic18);
		btnSelect.setSize(230, 60);
		btnSelect.setLocation(370, 0);
		btnSelect.setBorderPainted(false); //버튼 윤곽선 제거
		btnSelect.setBackground(new Color(153, 204, 255)); //버튼 색 설정
		
		jpBtn.add(btnReselect);
		jpBtn.add(btnSelect);
		
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
