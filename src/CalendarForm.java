import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Basic.BasicForm;

public class CalendarForm extends JFrame implements ActionListener {
	
	//private MainForm mainForm;


	public CalendarForm(String title, int width, int height) {
			
		//this.mainForm = mainForm;
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setLayout(new BorderLayout());
		//this.setUndecorated(true); //타이틀바 없애기 
		//setFont(fontNanumGothic);
		
		setCalendar();
		
		setVisible(true);
		
	}

	
	
	private void setCalendar() {
		
		
		
		
		
	}



	public static void main(String[] args) {
		new CalendarForm("탑승일 선택", 600, 600);
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
