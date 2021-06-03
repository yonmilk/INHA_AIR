package customer.book;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DataBase.databaseClass;
import customer.start.MainMenuForm;

//연우 - 출발지 선택 폼

public class SelectDep extends JFrame implements ActionListener {
	
	//데이터베이스 관련
	static String dbURL="jdbc:mysql://114.71.137.174:61083/inhaair?serverTimezone=UTC&useSSL=false";
	static String dbID="inhaair";
	static String dbPassword="1234";

	// Title 및 사이즈 설정
	private String title = "출발지 선택";
	private int width = 800, height = 550;
	
	//private MainForm mainForm;

	//폰트
	Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
	Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);		// 나눔고딕 9
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 25
	Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
	
	//String [] lstContinet = {"북아메리카", "아시아", "오세아니아", "유럽"};
	private Vector<String> lstCountryCity = new Vector<String>();
	private String SelectDep;
	private String SelectDepCode;
//	private String SelectContinet;
//	private String SelectCountry;
//	private String SelectCity;

	
	
	
	
	private BookForm bookForm;
	private JPanel jpTitle;
	private JLabel lblTitle;
	private JList<String> jlstContinet;
	private JList<String> jlstCountryCity;
	private JScrollPane scrollPane;
	private JPanel jpList;
	
	
	private int countryIndex = 0;
	private JButton btnSelect;
	
	
	public SelectDep(BookForm bookForm) {
		//this.mainForm = mainForm;
		this.bookForm = bookForm; //bookForm에 대한 정보
		
//		this.goDay = bookForm.getGoDay();
//		this.comeDay = bookForm.getComeDay();
//		this.roundTrip = bookForm.getRoundTrip();
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		
		
		setDep();

//		tfGo.setText(goDay);
//		tfCome.setText(comeDay);
		
		setVisible(true);
		
		
	}

	private void setDep() {
		
		//제목패널
		jpTitle = new JPanel();
		jpTitle.setLayout(null);
		jpTitle.setSize(300, 40);
		jpTitle.setLocation(20, 20);
		jpTitle.setBackground(Color.white);
		//제목라벨
		lblTitle = new JLabel("출발 지역과 도시 선택");
		lblTitle.setFont(fontNanumGothic20);
		lblTitle.setSize(300, 40);
		lblTitle.setLocation(15, 0);
		jpTitle.add(lblTitle);
		
		//리스트 패널
		jpList = new JPanel(); //날짜표시 판매
		jpList.setLayout(null);
		jpList.setSize(700, 350);
		jpList.setLocation(35, 70);
		jpList.setBackground(Color.red);
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		jpList.setBorder(tb);
		
		
		
		//나라(지역) 리스트
		
		
		String sql = "SELECT continent, code, country, city FROM airport ORDER BY continent, country";
		ResultSet rs = databaseClass.select(sql);

		
		
		try {
			while(rs.next()) {
				//System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "/" + rs.getString(3));
				//lstCountryCity.add("<HTML>"+ rs.getString(1) +"\t\t"+rs.getString(2)  + "\t"+ rs.getString(3)+ "/" + rs.getString(4)  + "</HTML>");	
				lstCountryCity.add(rs.getString(1) +"    "+rs.getString(2)  + "     "+ rs.getString(3)+ "/" + rs.getString(4));		
			}
		} catch (SQLException e) {
			//System.out.println("SQL문을 다시 확인해주세요");
			e.printStackTrace();
		}
		
		
		for ( int i = 0; i < lstCountryCity.size(); i++)
			//System.out.println(lstCountryCity.get(i));
		
		
//		scrollPane = new JScrollPane(jlstContinet, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
//		scrollPane.setLayout(null);
//		scrollPane.setSize(20, 30);
//		scrollPane.setLocation(1, 1);
//		scrollPane.setBackground(Color.white);
//		scrollPane.setFont(fontNanumGothic18);
//		jpList.add(scrollPane);
		
		//jlstContinet = new JList<String>(lstContinet);
		jlstContinet = new JList<String>(lstCountryCity);		
		jlstContinet.setLayout(null);
		jlstContinet.setSize(698, 348);
		jlstContinet.setLocation(1, 1);
		jlstContinet.setBackground(Color.white);
		jlstContinet.setFont(fontNanumGothic18);
		jpList.add(jlstContinet);
//		jpList.add(new JScrollPane(jlstContinet));
		
		
		
		//도시 스크롤 리스트
//		jlstCountryCity = new JList<String>(lstCountryCity);
//		jlstCountryCity.setLayout(null);
//		jlstCountryCity.setSize(359, 398);
//		jlstCountryCity.setLocation(340, 1);
//		jlstCountryCity.setBackground(Color.white);
//		jlstCountryCity.setFont(fontNanumGothic18);
//		jpList.add(jlstCountryCity);
		//jpList.add(new JScrollPane(jlstCountryCity));
		
		
		btnSelect = new JButton("출발지 선택");
		btnSelect.setFont(fontNanumGothic18);
		btnSelect.setSize(160, 40);
		btnSelect.setLocation(300, 440);
		btnSelect.setBorderPainted(false); //버튼 윤곽선 제거
		btnSelect.setBackground(new Color(10,90,150)); //버튼 색 설정
		btnSelect.setForeground(Color.white);
		btnSelect.addActionListener(this);
		
		add(jpTitle);
		add(jpList);
		add(btnSelect);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		if (obj == btnSelect) {
			
			SelectDep = jlstContinet.getSelectedValue();
			//System.out.println(SelectDep);
			
			//영어만 남게 하기
			Pattern nonValidPattern = Pattern.compile("[a-zA-Z]");
			Matcher matcher = nonValidPattern.matcher(SelectDep);
			SelectDepCode = ""; 
			  
			while (matcher.find()) {
				SelectDepCode += matcher.group(); 
			}
			//System.out.println(SelectCode);
			
			int result = JOptionPane.showConfirmDialog(null, "출발지 " + SelectDep + "으로 선택되었습니다.", "출발지 선택", JOptionPane.YES_NO_OPTION);
			
			if(result == JOptionPane.YES_OPTION) {
		
				bookForm.setSelectDep(SelectDep);
				bookForm.setSelectDepCode(SelectDepCode);
				bookForm.setDep();
				
				setVisible(false);
				
			}
		}
	}

}
