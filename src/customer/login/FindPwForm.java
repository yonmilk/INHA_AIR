package customer.login;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class FindPwForm extends JFrame {
	
	private String title = "비밀번호 찾기";
	private int width = 400, height = 300;
	
	public FindPwForm(FindIdPwForm findIdPwForm) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		//this.setUndecorated(true); //타이틀바 없애기 
		//setFont(fontNanumGothic);
		
		setFindPw();
		
		setVisible(true);
	}

	private void setFindPw() {
		
		
		
	}
	
}
