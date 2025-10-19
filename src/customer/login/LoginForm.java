package customer.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataBase.databaseClass;
import Management.User.UserList;
import common.Constants;
import common.UIComponentFactory;
import customer.start.MainMenuForm;

/**
 * Login form for INHA AIR application
 * Refactored to use common constants and UI components
 */
public class LoginForm extends JFrame implements ActionListener {

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
		// Setup frame with standard properties
		UIComponentFactory.setupFrame(this, Constants.APP_NAME);
		setLayout(null);

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
		
		JLabel login = UIComponentFactory.createTitleLabel("로그인");
		login.setHorizontalAlignment(JLabel.CENTER);
		jpTop.add(login);
		jpLogin.add(jpTop, BorderLayout.NORTH);

		// Central panel
		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(5, 1, 10, 10));
		jpCenter.setBackground(Color.white);

		lblId = UIComponentFactory.createLabel("아이디");
		tfId = UIComponentFactory.createTextField();
		lblPw = UIComponentFactory.createLabel("비밀번호");
		pwfPw = UIComponentFactory.createPasswordField();
		tfId.setFont(Constants.FONT_REGULAR);
		pwfPw.setFont(Constants.FONT_REGULAR);

		// Login button with primary styling
		btnLogin = UIComponentFactory.createPrimaryButton("로그인");
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
		// Text buttons (hyperlink style)
		btnFindIdPw = UIComponentFactory.createTextButton("<HTML><U>아이디/비밀번호찾기></U></HTML>");
		btnFindIdPw.addActionListener(this);

		btnSignUp = UIComponentFactory.createTextButton("<HTML><U>회원가입></U></HTML>");
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
				UIComponentFactory.showErrorDialog(this, "아이디와 비밀번호를 입력해주세요.");
			} else if (id.isEmpty()) {
				UIComponentFactory.showErrorDialog(this, "아이디를 입력해주세요.");
			} else if (pw.isEmpty()){
				UIComponentFactory.showErrorDialog(this, "비밀번호를 입력해주세요.");
			} else {
				// Check credentials
				boolean check = checkIDPW(id, pw);
				if(check) {
					UIComponentFactory.showSuccessDialog(this, id + "님 안녕하세요.");

					if(id.equals("admin")) {
						adminForm = new UserList();
						this.setVisible(false);
					} else {
						mainMenuForm = new MainMenuForm();
						mainMenuForm.setId(id);
						this.setVisible(false);
					}
				} else {
					UIComponentFactory.showErrorDialog(this, Constants.MSG_LOGIN_FAIL);
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
		String sql = "SELECT * FROM " + Constants.VIEW_LOGIN +
		             " WHERE ID = '" + id + "' AND password='" + pw + "'";
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
