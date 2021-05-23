package nonLogin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NonLogin extends JFrame{

	private JPanel jpLogin;
	private JLabel lblReserve ,lblName, lblLogin;
	private JTextField tfReserve, tfName;
	private JButton  btnLogin, btnSer, btnReturn;
	private ImageIcon image;


	public NonLogin(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jpLogin = new JPanel();
		jpLogin.setLayout(null);
		
		lblLogin = new JLabel("로그인하시면 예약 목록을 확인할 수 있습니다.");
		lblLogin.setSize(400, 20);
		lblLogin.setLocation(10, 20);
		
		//버튼 텍스트에 밑줄 넣기
		btnLogin = new JButton("<html><body><u>로그인하기</u></body></html>");
		btnLogin.setSize(100, 20);
		btnLogin.setLocation(300, 20);
		//버튼 색 없애기
		btnLogin.setContentAreaFilled(false);
		//버튼 윤곽선 없애기
		btnLogin.setBorderPainted(false);
		
		
		lblReserve = new JLabel("예약번호");
		lblReserve.setSize(400, 20);
		lblReserve.setLocation(10, 50);
		
		tfReserve = new JTextField("예)예약번호",30);
		tfReserve.setSize(400, 20);
		tfReserve.setLocation(10, 70);
		
		lblName = new JLabel("승객이름");
		lblName.setSize(400, 20);
		lblName.setLocation(10, 95);
		
		tfName = new JTextField(30);
		tfName.setSize(400, 20);
		tfName.setLocation(10, 115);
		
		btnSer = new JButton("조회");
		btnSer.setSize(100, 30);
		tfName.setLocation(10, 115);
		
		//액션 리스너 넣어서 메인 화면으로 돌아가는 버튼
		btnReturn = new JButton("돌아가기");
		btnReturn.setSize(100, 30);
		tfName.setLocation(10, 115);
		
		
		
		jpLogin.add(lblLogin);
		jpLogin.add(btnLogin);
		jpLogin.add(lblReserve);
		jpLogin.add(tfReserve);
		jpLogin.add(lblName);
		jpLogin.add(tfName);
		jpLogin.add(btnSer);
		jpLogin.add(btnReturn);
		
		setVisible(true);
		
		
		
		
		add(jpLogin);
		
		
	}


	public static void main(String[] args) {
		new NonLogin("INHA AIR", 500, 200);
	}

}
