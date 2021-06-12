package customer.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindIdForm extends JFrame implements ActionListener{
	private String title = "아이디 찾기";
	private int width = 400, height = 300;
	
	// 폰트
	Font fontArial30 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	Font fontNanumGothic13 = new Font("NanumGothic", Font.BOLD, 13);
	Font fontNanumGothic15 = new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 18
	Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
	Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 20
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	private JPanel jpTitle;
	private JLabel lblTitle;
	private JPanel jpChPw;
	private Component lblPw;
	private Component tfPw;
	private Component lblPwChk;
	private JTextField tfPwChk;
	private JButton btnChangePw;

	
	public FindIdForm(FindIdPwForm findIdPwForm) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		
		setLayout(null);
		//this.setUndecorated(true); //타이틀바 없애기 
		//setFont(fontNanumGothic);
		
		setFindId();
		
		setVisible(true);
	}

	private void setFindId() {
		
		//비밀번호변경 제목
		jpTitle = new JPanel();
		jpTitle.setLayout(null);
		jpTitle.setSize(350, 100);
		jpTitle.setLocation(40, 0);
		jpTitle.setBackground(Color.white);
		
		lblTitle = new JLabel("비밀번호 변경");
		lblTitle.setFont(fontNanumGothic25);
		lblTitle.setSize(150, 35);
		lblTitle.setLocation(0, 10);
		jpTitle.add(lblTitle);
		
		//좌측 정보 창
		jpChPw = new JPanel();
		jpChPw.setLayout(null);
		jpChPw.setSize(350, 400);
		jpChPw.setLocation(40, 100);
		jpChPw.setBackground(Color.white);
		
		lblPw= new JLabel("한글 이름");
		lblPw.setSize(300, 30);
		lblPw.setLocation(0, 0);
		lblPw.setFont(fontNanumGothic18);
		jpChPw.add(lblPw);
		
		tfPw = new JTextField();
		tfPw.setSize(300, 30);
		tfPw.setLocation(0, 30);
		jpChPw.add(tfPw);
	
		lblPwChk = new JLabel("영문 이름");
		lblPwChk.setSize(350, 30);
		lblPwChk.setLocation(0, 70);
		lblPwChk.setFont(fontNanumGothic18);
		jpChPw.add(lblPwChk);
		
		tfPwChk = new JTextField();
		tfPwChk.setSize(300, 30);
		tfPwChk.setLocation(0, 100);
		jpChPw.add(tfPwChk);
		
		btnChangePw = new JButton("비밀번호 변경");
		btnChangePw.setBackground(new Color(10,90,150));
		btnChangePw.setSize(200, 50);
		btnChangePw.setLocation(280, 550);
		btnChangePw.setForeground(Color.WHITE);
		btnChangePw.setFont(fontNanumGothic18);
		btnChangePw.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	
}
