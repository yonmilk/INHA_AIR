package nonLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NonTel extends JFrame{
	
	Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);
	Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);
	Font fontNanumGothic8 = new Font("NanumGothic", Font.BOLD, 8);
	
	private JLabel lblPhoneNum, lblEmail, lblReserveNum, lblPWgo, lblPw, lblPWcheck, lblPwWrite, lblPwWrite2;
	private JPanel jpInf, jpPw;
	private JTextField tfPhoneNum, tfEmail;
	private JPasswordField pfPw, pfPWcheck;
	private JButton btnOK;

	public NonTel(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jpInf = new JPanel();
		jpInf.setBackground(Color.white);
		
		
		jpPw = new JPanel();
		jpPw.setLayout(new GridLayout(3, 2,20,0));
		jpPw.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		jpPw.setBackground(Color .white);
		
		lblPw = new JLabel("비밀번호");
		lblPw.setFont(fontNanumGothic12);
		
		lblPWcheck = new JLabel("비밀번호 확인");
		lblPWcheck.setFont(fontNanumGothic12);
		
		lblPwWrite = new JLabel("6~8자리 문자 또는 숫자 입력");
		lblPwWrite.setForeground(new Color(128,128,128));
		lblPwWrite.setFont(fontNanumGothic8);
		
		lblPwWrite2 = new JLabel("6~8자리 문자 또는 숫자 입력");
		lblPwWrite2.setForeground(new Color(128,128,128));
		lblPwWrite2.setFont(fontNanumGothic8);
		
		pfPw = new JPasswordField(10);
		pfPWcheck = new JPasswordField(10);
		
		jpPw.add(lblPw);
		jpPw.add(lblPWcheck);
		jpPw.add(lblPwWrite);
		jpPw.add(lblPwWrite2);
		jpPw.add(pfPw);
		jpPw.add(pfPWcheck);
		
		
		add(jpInf);
		add(jpPw, BorderLayout.SOUTH);
		setVisible(true);
		
	}


	public static void main(String[] args) {
		new NonTel("My Frame", 500, 500);
	}

}
