import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener {
	
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	private JPanel main, sub;
	private JButton btn1;
	
	public MainForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		
		mainPan();
		
		subPan();
		
		setVisible(true);
	}


	private void mainPan() {
		main = new JPanel();
		main.setLayout(null);
		main.setSize(1120, 80);
		main.setLocation(0, 0);
		main.setBackground(Color.WHITE);
		
		btn1 = new JButton("INHA");
		btn1.setBackground(Color.white);
		btn1.setSize(80, 80);
		btn1.setLocation(50, 0);
		btn1.addActionListener(this);
		main.add(btn1);
		
		add(main);
	}

	private void subPan() {
		sub = new JPanel();
		sub.setLayout(null);
		sub.setSize(1120, 300);
		sub.setLocation(0, 0);
		sub.setBackground(Color.yellow);
		
//		add(sub);
	}

	public static void main(String[] args) {
		new MainForm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn1)
		{
			main.setVisible(false);
			add(sub);
		}
	}

}
