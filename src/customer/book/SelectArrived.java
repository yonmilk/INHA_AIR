package customer.book;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//연우 - 도착지 선택 폼

public class SelectArrived extends JFrame implements ActionListener{
	
	// Title 및 사이즈 설정
	private String title = "도착지 선택";
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
	
	private BookForm bookForm;
	

	public SelectArrived(BookForm bookForm) {
		
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
		
		
		setArrived();

//		tfGo.setText(goDay);
//		tfCome.setText(comeDay);
		
		setVisible(true);
		
	}


	private void setArrived() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
