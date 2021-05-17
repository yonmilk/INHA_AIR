import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Basic.BasicForm;

public class CalendarForm extends JFrame implements ActionListener {
	
// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	private JPanel pnTOP;
	
	public CalendarForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 이거 건들지말기
		setLayout(null);
		setUpMenu();
		
		setVisible(true);
	}


	// 이거 건들지말기
	private void setUpMenu() {
		
	}


	public static void main(String[] args) {
		new BasicForm();
	}






	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
