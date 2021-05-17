import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//연우-로그인 화면 생성

public class LoginForm extends JFrame implements ActionListener {

	Font fontNanumGothic12 = new Font("NanumGothic", Font.PLAIN , 12);	// 나눔고딕 12
	Font fontNanumGothic15 = new Font("NanumGothic", Font.PLAIN, 15);	// 나눔고딕 15
	Font fontNanumGothic16 = new Font("NanumGothic", Font.BOLD, 16);	// 나눔고딕 16
	Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
	
	
	private MainForm mainForm;
	
	private JPanel top, center, bottom;
	private JLabel lbId, lbPw;
	private JTextField taId, taPw;
	private JButton btnLogin, findIdPw, signUp;
	//private JButton btnClose;
	
	
	public LoginForm(String title, int width, int height, MainForm mainForm) {
		
		this.mainForm = mainForm;
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(new BorderLayout());
		//this.setUndecorated(true); //타이틀바 없애기 
		//setFont(fontNanumGothic);
		
		setLogin();
		
		setVisible(true);
		
	}
	
	private void setLogin() {
		
		//상단판넬
		top = new JPanel();
		top.setBackground(Color.white);
		top.setPreferredSize(new Dimension(400, 100)); //판넬사이즈 설정
		top.setLayout(new BorderLayout());
		JLabel login = new JLabel("로그인"); //로그인 라벨
		login.setFont(fontNanumGothic25);
		login.setHorizontalAlignment(JLabel.CENTER);
		//btnClose = new JButton();
		top.add(login);
		add(top, BorderLayout.NORTH);
		
		//중앙판넬
		center = new JPanel();
		center.setLayout(new GridLayout(5, 1, 10, 10));
		center.setBackground(Color.white);
		lbId = new JLabel("아이디"); //아이디 라벨
		taId = new JTextField(); //아이디 입력
		lbPw = new JLabel("비밀번호"); //비밀번호 라벨
		taPw = new JTextField(); //비밀번호 입력
		lbId.setFont(fontNanumGothic15);
		lbPw.setFont(fontNanumGothic15);
		taId.setFont(fontNanumGothic15);
		taPw.setFont(fontNanumGothic15);
		
		
		btnLogin = new JButton("로그인"); //로그인 버튼
		btnLogin.setFont(fontNanumGothic16);
		btnLogin.setBorderPainted(false); //버튼 윤곽선 제거
		btnLogin.setBackground(new Color(153, 204, 255)); //버튼 색 설정
		center.add(lbId);
		center.add(taId);
		center.add(lbPw);
		center.add(taPw);
		center.add(btnLogin);
		add(center, BorderLayout.CENTER);
		
		
		//하단판넬
		bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(400, 100));
		bottom.setLayout(new GridLayout(3,1));
		bottom.setBackground(Color.white);
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		findIdPw = new JButton("<HTML><U>아이디/비밀번호 찾기</U></HTML>"); //아이디/비밀번호 찾기 버튼 추가
		findIdPw.setForeground(new Color(000, 102, 255));
		findIdPw.addActionListener(this);
		findIdPw.setBorderPainted(false); //버튼 윤곽선 제거
		findIdPw.setContentAreaFilled(false); //버튼배경 제거
		signUp = new JButton("<HTML><U>회원가입</U></HTML>"); //회원가입 버튼 추가
		signUp.setForeground(new Color(000, 102, 255));
		signUp.addActionListener(this);
		signUp.setBorderPainted(false); //버튼 윤곽선 제거
		signUp.setContentAreaFilled(false); //버튼배경 제거
		findIdPw.setFont(fontNanumGothic12);
		signUp.setFont(fontNanumGothic12);
		
		bottom.add(findIdPw);
		bottom.add(signUp);
		
		add(bottom, BorderLayout.SOUTH);
		
		
		//좌우판넬
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(50, 500));
		west.setBackground(Color.WHITE);
		add(west, BorderLayout.WEST);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(50, 500));
		east.setBackground(Color.WHITE);
		add(east, BorderLayout.EAST);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
	}
	
}
