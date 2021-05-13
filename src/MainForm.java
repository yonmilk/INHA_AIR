import javax.swing.JFrame;

public class MainForm extends JFrame {
	
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	public MainForm() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MainForm();
	}

}
