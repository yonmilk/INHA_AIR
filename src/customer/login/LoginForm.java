package customer.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataBase.databaseClass;
import Management.User.UserList;
import common.Constants;
import customer.start.MainMenuForm;

/**
 * Login form for INHA AIR application
 * Keeps original component styling, only uses Constants for shared values
 */
public class LoginForm extends JFrame implements ActionListener {

	// Fonts - keep original specific sizes for each component
	private Font fontNanumGothic12 = new Font("NanumGothic", Font.PLAIN, 12);
	private Font fontNanumGothic15 = new Font("NanumGothic", Font.PLAIN, 15);
	private Font fontNanumGothic16 = new Font("NanumGothic", Font.BOLD, 16);
	private Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);

	// Colors - keep original specific colors
	private Color colorLogin = new Color(10, 90, 150);
	private Color colorHyper = new Color(0, 102, 255);

	// Components
	private JPanel jpLogin;
	private JPanel jpTop, jpCenter, jpBottom;
	private JLabel lblId, lblPw;
	private JTextField tfId;
	private JPasswordField pwfPw;
	private JButton btnLogin, btnFindIdPw, btnSignUp;


	// Forms
	private MainMenuForm mainMenuForm;
	private SignUpForm signUpForm;
	private FindIdPwForm findIdPwForm;
	private UserList adminForm;


	public LoginForm() {
		// Frame setup
		setTitle(Constants.APP_NAME);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		// Background color
		getContentPane().setBackground(Color.WHITE);

		// Setup login panel
		setLogin();

		setVisible(true);
	}

	// 연우 - 로그인 레이아웃 구성
	private void setLogin() {
		
		// 로그인 패널
		jpLogin = new JPanel(new BorderLayout());
		jpLogin.setSize(400, 500);
		jpLogin.setLocation(360, 100);
//		jpLogin.setBorder(new EtchedBorder(EtchedBorder.RAISED));		// 테두리 설정
		
		//상단패널
		jpTop = new JPanel();
		jpTop.setBackground(Color.white);
		jpTop.setPreferredSize(new Dimension(400, 100)); //판넬사이즈 설정
		jpTop.setLayout(new BorderLayout());
		
		JLabel login = new JLabel("로그인");
		login.setFont(fontNanumGothic25);
		login.setHorizontalAlignment(JLabel.CENTER);
		jpTop.add(login);
		jpLogin.add(jpTop, BorderLayout.NORTH);

		// Central panel
		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(5, 1, 10, 10));
		jpCenter.setBackground(Color.white);

		lblId = new JLabel("아이디");
		lblId.setFont(fontNanumGothic15);
		tfId = new JTextField();
		tfId.setFont(fontNanumGothic15);
		lblPw = new JLabel("비밀번호");
		lblPw.setFont(fontNanumGothic15);
		pwfPw = new JPasswordField();
		pwfPw.setFont(fontNanumGothic15);

		// Login button - keep original styling
		btnLogin = new JButton("로그인");
		btnLogin.setFont(fontNanumGothic16);
		btnLogin.setBorderPainted(false);
		btnLogin.setOpaque(true);
		btnLogin.setBackground(colorLogin);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(this);
		
		//값들 추가
		jpCenter.add(lblId);
		jpCenter.add(tfId);
		jpCenter.add(lblPw);
		jpCenter.add(pwfPw);
		jpCenter.add(btnLogin);
		jpLogin.add(jpCenter, BorderLayout.CENTER);
		
		
		//하단패널
		jpBottom = new JPanel();
		jpBottom.setPreferredSize(new Dimension(400, 100));
		jpBottom.setLayout(new GridLayout(3,1));
		jpBottom.setBackground(Color.white);
		jpBottom.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		// Text buttons (hyperlink style) - keep original styling
		btnFindIdPw = new JButton("<HTML><U>아이디/비밀번호찾기></U></HTML>");
		btnFindIdPw.setFont(fontNanumGothic12);
		btnFindIdPw.setForeground(colorHyper);
		btnFindIdPw.setBorderPainted(false);
		btnFindIdPw.setContentAreaFilled(false);
		btnFindIdPw.addActionListener(this);

		btnSignUp = new JButton("<HTML><U>회원가입></U></HTML>");
		btnSignUp.setFont(fontNanumGothic12);
		btnSignUp.setForeground(colorHyper);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.addActionListener(this);
		
		jpBottom.add(btnFindIdPw);
		jpBottom.add(btnSignUp);
				
		jpLogin.add(jpBottom, BorderLayout.SOUTH);
		
		
		//좌우판넬
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(50, 500));
		west.setBackground(Color.WHITE);
		jpLogin.add(west, BorderLayout.WEST);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(50, 500));
		east.setBackground(Color.WHITE);
		jpLogin.add(east, BorderLayout.EAST);
		
		// 컴포넌트 붙이기
		add(jpLogin);
		
		
	}

	public static void main(String[] args) {
		// Connect to database using default configuration
		databaseClass.connect();
		new LoginForm();
	}


	//연우 - 로그인 액션 추가
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnLogin) {	//로그인버튼 눌렀을 경우
			
			String id = tfId.getText();
			String pw = pwfPw.getText();
			
			// Validation
			if (id.isEmpty() && pw.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력해주세요.",
					"Error", JOptionPane.ERROR_MESSAGE);
			} else if (id.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.",
					"Error", JOptionPane.ERROR_MESSAGE);
			} else if (pw.isEmpty()){
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.",
					"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				// Check credentials
				boolean check = checkIDPW(id, pw);
				if(check) {
					JOptionPane.showMessageDialog(this, id + "님 안녕하세요.",
						"Success", JOptionPane.INFORMATION_MESSAGE);

					if(id.equals("admin")) {
						adminForm = new UserList();
						this.setVisible(false);
					} else {
						mainMenuForm = new MainMenuForm();
						mainMenuForm.setId(id);
						this.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 잘못 입력되었습니다.",
						"Error", JOptionPane.ERROR_MESSAGE);
					tfId.setText("");
					pwfPw.setText("");
					tfId.requestFocus();
				}
			}
			
		} else if(obj == btnFindIdPw) { //아이디비밀번호찾기 버튼 눌렀을 때
			findIdPwForm = new FindIdPwForm(); //아이디비밀번호찾기 창 띄우기
		} else if(obj == btnSignUp) { //회원가입 버튼 눌렀을 때
			signUpForm = new SignUpForm(); //회원가입 창 띄우기
		}
	}

	/**
	 * Check if ID and password match in database
	 * TODO: Use PreparedStatement to prevent SQL injection
	 */
	private boolean checkIDPW(String id, String pw) {
		String sql = "SELECT * FROM login WHERE ID = '" + id + "' AND password='" + pw + "'";
		ResultSet rs = databaseClass.select(sql);

		try {
			return rs != null && rs.next();
		} catch (SQLException e) {
			System.err.println("Error checking credentials: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
