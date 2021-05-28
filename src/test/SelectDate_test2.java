package test;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

//연우 - 탑승일 선택 작성

public class SelectDate_test2 extends JFrame implements ActionListener {
	
	// Title 및 사이즈 설정
	private String title = "탑승일 선택";
	private int width = 430, height = 700;
	
	//private MainForm mainForm;

	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 9
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	private JPanel jpTitle, jpSelect, jpBtn, jpCal;
	private JLabel lblTitle;
	private JLabel lblCome;
	private JLabel lblGo;
	private JTextField tfGo;
	private JTextField tfCome;
	private JButton btnReselect;
	private JButton btnSelect;
	private static Calendar cal = Calendar.getInstance(); //캘린더 객체 생성;
	private String[] day = new String[] {"S", "M", "T", "W", "T", "F", "S"};
	private JLabel lblday;
	private JLabel lblYear;
	private JLabel lblMonth;
	private ArrayList<JButton> lstBtn = new ArrayList<JButton>();
	private JButton btnDay;
	private int dayY;
	private int dayX;
	private int todayYear = cal.get(Calendar.YEAR);
	private int todayMonth = cal.get(Calendar.MONTH)+1;
	private int setTime = 0;
	private JButton btnLeft;
	private JButton btnRight;
	private int selectindex = 0;
	private int sDayNum;
	private int endDate;
	private int intDateNum;
	private String lblstringYear;
	private String lblstringMonth;
	private JPanel jpDay;
	
	

	public SelectDate_test2() {
			
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
	
	private void setCalendarForm() {
	
		//달력패널 생성 및 설정
		jpCal = new JPanel();
		jpCal.setLayout(null);
		jpCal.setSize(300, 370);
		jpCal.setLocation(60, 160);
		jpCal.setBackground(Color.white);
		
		todayYear = cal.get(Calendar.YEAR);
		todayMonth = cal.get(Calendar.MONTH)+1;
		cal.set(todayYear, todayMonth-1, 1); //캘린더 객체에 년도, 달 설정과 Date 1로 설정
		
		
		lblYear = new JLabel(todayYear+"년"); //년도 표시 라벨
		lblYear.setFont(fontNanumGothic12);
		lblYear.setSize(150, 40);
		lblYear.setLocation(15, 2);
		lblMonth = new JLabel(todayMonth+"월"); //달 표시 라벨
		lblMonth.setFont(fontNanumGothic18);
		lblMonth.setSize(80, 40);
		lblMonth.setLocation(65, 0);
		jpCal.add(lblYear);
		jpCal.add(lblMonth);
		
		for (int i = 0; i<7; i++) { //요일 추가
			lblday = new JLabel(day[i]); //day[i]로 요일 배열 추가
			lblday.setFont(fontNanumGothic15);
			lblday.setSize(100, 40);
			lblday.setLocation(40*i + 16, 30); //위치 설정
			jpCal.add(lblday);
			
		}
		
		//달력 일 패널
		jpDay = new JPanel();
		jpDay.setLayout(new GridLayout(6,7));
		jpDay.setSize(280, 300);
		jpDay.setLocation(0, 70);
		jpDay.setBackground(Color.white);
		
		
		
		for (int i = 0; i < 42; i++) { //달력에 42(6*7)개의 버튼 추가 
			
			lstBtn.add(new JButton());
			lstBtn.get(i).setBackground(Color.white);
			lstBtn.get(i).addActionListener(this);
			lstBtn.get(i).setFont(fontNanumGothic12);
			lstBtn.get(i).setBorderPainted(false); //버튼 윤곽선 제거
			//lstBtn.get(i).setBackground(new Color(153, 204, 255)); //버튼 색 설정
			lstBtn.get(i).setBorder(BorderFactory.createEmptyBorder(0 , 0 , 0 , 0)); //안쪽 여백 설정
			lstBtn.get(i).setBackground(Color.white); //버튼 색 설정
			lstBtn.get(i).setSize(40, 40);
			
			jpDay.add(lstBtn.get(i));
		}
		
		
		intDateNum = 1; //1일부터 날짜 시작
		sDayNum = cal.get(Calendar.DAY_OF_WEEK); //1일의 요일 얻어오기 (일(1), 월(2)~토(7)
		endDate = cal.getActualMaximum(Calendar.DATE); //달의 마지막 일 얻기
		
		for (int i = 0; intDateNum <= endDate; i++) { //intDateNum이 1일부터 마지막일이 될 때까지 반복 
			
			if (i<sDayNum-1) //i가 요일숫자보다 작으면 공백 버튼
			{
				lstBtn.get(i).setText("");
			}
			if ((i<sDayNum-1)==false) //date값의 버튼 출력 
			{
				
				
				if (i%7 ==0) {
					lstBtn.get(i).setForeground(Color.red); //일요일은 빨간색 설정
				} else if ((i-6)%7 ==0) {
					lstBtn.get(i).setForeground(Color.blue); //토요일은 파란색 설정
				} else {
					lstBtn.get(i).setForeground(Color.black); //나머지 검정색 설정
				}
				
				lstBtn.get(i).setText(intDateNum+"");
				
				intDateNum++; //출력할 date 증가
			}
		
		}
		
		jpCal.add(jpDay);
		
		//캘린더 변경 버튼
		btnLeft = new JButton("<");
		btnLeft.setFont(fontNanumGothic12);
		btnLeft.setSize(50, 300);
		btnLeft.setLocation(5, 200);
		btnLeft.setBorderPainted(false);
		btnLeft.setBackground(Color.white);
		btnLeft.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 0 , 0));
		btnLeft.addActionListener(this);
		btnRight = new JButton(">");
		btnRight.setFont(fontNanumGothic12);
		btnRight.setSize(50, 300);
		btnRight.setLocation(360, 200);
		btnRight.setBorderPainted(false);
		btnRight.setBackground(Color.white);
		btnRight.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 0 , 0));
		btnRight.addActionListener(this);
		
		add(btnLeft);
		add(btnRight);
		add(jpCal);
		
	}

	

	public static void main(String[] args) {
		new SelectDate_test2();
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String objText = e.getActionCommand();

		if (obj == btnSelect) {
			
		} 
		else if (obj == btnReselect) {
			tfGo.setText("");
			tfCome.setText("");
			selectindex  = 0;
		} else if (obj == btnDay) {
			System.out.println(btnDay.getText());
		} else if ((obj == btnLeft) || (obj==btnRight)) {
			
			if (obj == btnLeft) { //이전 달 달력 출력
				
				todayMonth--; //이전달로
				
				 if(todayMonth<1) { //1월 이전 달로 넘길 때 이전년도 12월로 설정
					 todayMonth=12;
					todayYear--;
				}
			} else if (obj == btnRight) { //다음 달 출력
					
					todayMonth++; //다음달로
					
					if(todayMonth>12) { //12월 다음 달로 넘길 때 다음년도 1월로 설정
						todayMonth=1;
						todayYear++;
					}
			}
			
			lblMonth.setText(todayMonth+"월");
			lblYear.setText(todayYear+"년");
			
			cal.set(todayYear, todayMonth-1, 1); //캘린더 객체에 년도, 달 설정과 Date 1로 설정
			
			intDateNum = 1; //1일부터 날짜 시작
			sDayNum = cal.get(Calendar.DAY_OF_WEEK); //1일의 요일 얻어오기 (일(1), 월(2)~토(7)
			endDate = cal.getActualMaximum(Calendar.DATE); //달의 마지막 일 얻기
			
			for (int i = 0; i < 42; i++) { //intDateNum이 1일부터 마지막일이 될 때까지 반복 
				
				if (i<sDayNum-1) //i가 요일숫자보다 작으면 공백 버튼
				{
					lstBtn.get(i).setText("");
				}
				else if ((i>sDayNum-2) && (intDateNum<endDate+1)) //date값의 버튼 출력 
				{
					if (i%7 ==0) {
						lstBtn.get(i).setForeground(Color.red); //일요일은 빨간색 설정
					} else if ((i-6)%7 ==0) {
						lstBtn.get(i).setForeground(Color.blue); //토요일은 파란색 설정
					} else {
						lstBtn.get(i).setForeground(Color.black); //나머지 검정색 설정
					}
					
					lstBtn.get(i).setText(intDateNum+"");
					
					intDateNum++; //출력할 date 증가
				} else {
					lstBtn.get(i).setText("");
				}
				
			}
		}
		 else {	//일 버튼을 클릭했을 경우
			
//			lblstringYear = lblYear.getText().substring(0,4);
//			lblstringMonth = lblMonth.getText().substring(0,lblMonth.getText().length()-1);
//			
//			if (selectindex == 0) {
//				
//				tfGo.setText(lblstringYear + "/" + lblstringMonth + "/" + objText);
//				tfCome.setText("");
//				selectindex++;
//			} else if(selectindex == 1) {
//				tfCome.setText(lblstringYear + "/" + lblstringMonth + "/" + objText);
//				selectindex--;
//			}
		}
	}
}
