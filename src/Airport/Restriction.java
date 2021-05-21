package Airport;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import main.MainForm;
import menu.MenuBar;

public class Restriction extends JFrame implements ActionListener {
	//폰트
		Font fontGothic = new Font("Gothic", Font.BOLD, 20);				// 고딕
		Font fontNanumGothic9 = new Font("NanumGothic", Font.BOLD, 9);	// 나눔고딕 18
		Font fontNanumGothic12 = new Font("NanumGothic", Font.BOLD, 12);	// 나눔고딕 18
		Font fontNanumGothic15= new Font("NanumGothic", Font.BOLD, 15);	// 나눔고딕 15
		Font fontNanumGothic18 = new Font("NanumGothic", Font.BOLD, 18);	// 나눔고딕 18
		Font fontNanumGothic20 = new Font("NanumGothic", Font.BOLD, 20);	// 나눔고딕 20
		Font fontNanumGothic22 = new Font("NanumGothic", Font.BOLD, 22);	// 나눔고딕 22
		Font fontNanumGothic25 = new Font("NanumGothic", Font.BOLD, 25);	// 나눔고딕 25
		Font fontNanumGothic30 = new Font("NanumGothic", Font.BOLD, 30);	// 나눔고딕 30
		Font fontArial = new Font("Arial", Font.PLAIN, 12);					// 영어
		Color crNavy = new Color(30,30,170); // 수하물 유의사항 색

		Font fontNanumGothic9P = new Font("NanumGothic", Font.PLAIN, 9);	// 나눔고딕 9, 보통
		Font fontNanumGothic12P = new Font("NanumGothic", Font.PLAIN, 12);	// 나눔고딕 12, 보통
		Font fontNanumGothic15P = new Font("NanumGothic", Font.PLAIN, 15);	// 나눔고딕 15, 보통
		Font fontNanumGothic18P = new Font("NanumGothic", Font.PLAIN, 18);	// 나눔고딕 18, 보통
	
	// Title 및 사이즈 설정
	private String title = "INHA AIR";
	private int width = 1120, height = 770;
	
	// 폰트 사용 위함
//	private MainForm main;
	
	// 상단 메뉴바
	private menu.MenuBar menubar;
	private ScrollPane sp1;
	private JScrollPane scPane;
	private JPanel jpWhite;
	private JLabel lblRestrict;
	private Component lblRestrictCont;
	private Component lblBanned;
	private JLabel lblBannedCont;
	private Component lblFlame;
	private Component lblFlameCont;
	private Component lblGas;
	private Component lblGasCont;
	private JLabel lblWeapon;
	private Component lblWeaponCont;
	private Component lblDanger;
	private Component lblDangerCont;
	private JLabel lblLithium;
	private Component lblLithiumCont;
	private Component lblAble;
	private Component lblAbleCont;
	private Component lblLiquid;
	private Component lblLiquidCont;
	private Component lblMedicine;
	private JLabel lblMedicineCont;
	private Component lblMacBook;
	private Component lblMacBookCont;
	private Component lblEtc;
	private Component lblEtcCont;
	private JScrollBar scBar;
	
	
	public Restriction() {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 레이아웃 설정
		setLayout(null);
		
		// 배경색
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		
		jpWhite = new JPanel();
		jpWhite.setLayout(null);
		jpWhite.setBackground(Color.white);
		jpWhite.setBounds(0,0,1100,580);
		
		scPane = new JScrollPane(jpWhite,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 30);
		scPane.setBounds(0, 100, 1107, 600);
		
		lblRestrict = new JLabel("운송 제한 물품"); //큰 제목
		lblRestrict.setBounds(40,10 , 200, 50);
		lblRestrict.setFont(fontNanumGothic30);
		
		lblRestrictCont = new JLabel("안전한 항공 여행을 위해 반입이 제한되는 물품이 있습니다.");
		lblRestrictCont.setBounds(30,60 ,500, 20);
		lblRestrictCont.setFont(fontNanumGothic15P);
		
		lblBanned = new JLabel("항공기 반입금지 물품");// 제목 1
		lblBanned.setBounds(40,100 ,500, 30);
		lblBanned.setFont(fontNanumGothic25);
		lblBanned.setForeground(crNavy);
		
		lblBannedCont = new JLabel("아래 품목은 휴대 수하물로 기내 반입하거나 위탁 수하물로 운송하는 것이 금지되어 있습니다. (휴대 X, 위탁 X)");
		lblBannedCont.setBounds(30,135 ,1000, 20);
		lblBannedCont.setFont(fontNanumGothic15P);
		
		lblFlame = new JLabel("발화성/인화성 물질"); // 소제목
		lblFlame.setBounds(40,150,300,60);
		lblFlame.setFont(fontNanumGothic20);
		
		lblFlameCont = new JLabel("휘발유, 페인트, 라이터용 연료 등 발화성/인화성 물질");
		lblFlameCont.setBounds(40,195 ,1000, 20);
		lblFlameCont.setFont(fontNanumGothic15P);
		
		lblGas = new JLabel("고압가스 용기"); // 소제목
		lblGas.setBounds(600,150,300,60);
		lblGas.setFont(fontNanumGothic20);
		
		lblGasCont = new JLabel("산소캔, 부탄가스캔 등 고압가스 용기");
		lblGasCont.setBounds(600,195 ,1000, 20);
		lblGasCont.setFont(fontNanumGothic15P);
		
		lblWeapon  = new JLabel("무기 및 폭발물 종류"); // 소제목
		lblWeapon.setBounds(40,205,300,60);
		lblWeapon.setFont(fontNanumGothic20);
		
		lblWeaponCont = new JLabel("총기, 폭죽 등 무기 및 폭발물 종류");
		lblWeaponCont.setBounds(40,250 ,1000, 20);
		lblWeaponCont.setFont(fontNanumGothic15P);
		
		lblDanger = new JLabel("기타 위험 물질"); // 소제목
		lblDanger.setBounds(600,205,300,60);
		lblDanger.setFont(fontNanumGothic20);
		
		lblDangerCont = new JLabel("<html>소화기, 에어로졸(살충제 등), 락스, 파마약 등 탑승객 및 항공기에 위험이 <br>될 가능성이 있는 물질<html>");
		lblDangerCont.setBounds(600,250 ,1000, 35);
		lblDangerCont.setFont(fontNanumGothic15P);

		lblLithium  = new JLabel("리튬 배터리 장착 전자기기"); // 소제목
		lblLithium.setBounds(40,275,300,60);
		lblLithium.setFont(fontNanumGothic20);
		
		lblLithiumCont = new JLabel("<html>· 배터리 용량이 160Wh를 초과하는 리튬 배터리가 장착된 전자기기. 전동휠체어 등 보행 보조기구는 예외"
				+ "<br>· 배터리 용량이 160Wh를 초과하는 보조/여분의 리튬 배터리. "
				+ "<br>· 리튬 배터리가 분리되지 않는 전동 휠, 스마트 가방. 배터리를 분리할 수 있으며 용량이 160Wh 이내인 경우는 배터리 분리 후 배터리는 휴대, 휠/가방 등은  휴대 또는 위탁 할 수 있습니다."
				+ "<br>· 배터리 분리가 불가한 헤어컬(고데기). 일본 출발편 한정. "
				+ "유의사항</html>");
		lblLithiumCont.setBounds(40,320 ,1000, 90);
		lblLithiumCont.setFont(fontNanumGothic15P);
		
		//------
		
		lblAble = new JLabel("제한적으로 기내 반입 가능한 물품"); //큰 제목
		lblAble.setBounds(40,420 , 500, 50);
		lblAble.setFont(fontNanumGothic25);
		lblAble.setForeground(crNavy);
		
		lblAbleCont = new JLabel("다음 품목은 기내로 소량 반입할 수 있습니다. (휴대 △, 위탁 O)");
		lblAbleCont.setBounds(30,465 ,500, 20);
		lblAbleCont.setFont(fontNanumGothic15P);
		
		lblLiquid = new JLabel("액체류 (국제선 출발, 환승에 한함)");// 제목 1
		lblLiquid.setBounds(40,495 ,500, 30);
		lblLiquid.setFont(fontNanumGothic20);
		
		lblLiquidCont = new JLabel("<html>· 음료, 식품, 화장품 등 액체류(스프레이) 및 젤류(젤 또는 크림) 물품<br>· 개별 용기당 100ml 이하로 1인당 총 1L 용량의 비닐 지퍼백 1개</html>");
		lblLiquidCont.setBounds(30,525 ,1000, 45);
		lblLiquidCont.setFont(fontNanumGothic15P);
		
		lblMedicine = new JLabel("의약품"); // 소제목
		lblMedicine.setBounds(40,560,300,60);
		lblMedicine.setFont(fontNanumGothic20);
		
		lblMedicineCont = new JLabel("여행 중 필요한 개인용 의약품. 의사가 처방한 의약품은 의사소견서 혹은 처방전 등을 제시할 수 있어야 합니다.");
		lblMedicineCont.setBounds(40,580 ,1000, 20);
		lblMedicineCont.setFont(fontNanumGothic15P);
		
		lblMacBook = new JLabel("고압가스 용기"); // 소제목
		lblMacBook.setBounds(600,150,300,60);
		lblMacBook.setFont(fontNanumGothic20);
		
		lblMacBookCont = new JLabel("산소캔, 부탄가스캔 등 고압가스 용기");
		lblMacBookCont.setBounds(600,195 ,1000, 20);
		lblMacBookCont.setFont(fontNanumGothic15P);
		
		lblEtc  = new JLabel("무기 및 폭발물 종류"); // 소제목
		lblEtc.setBounds(40,205,300,60);
		lblEtc.setFont(fontNanumGothic20);
		
		lblEtcCont = new JLabel("총기, 폭죽 등 무기 및 폭발물 종류");
		lblEtcCont.setBounds(40,250 ,1000, 20);
		lblEtcCont.setFont(fontNanumGothic15P);
		
		
		
		jpWhite.add(lblRestrict);
		jpWhite.add(lblRestrictCont);
		jpWhite.add(lblBanned);
		jpWhite.add(lblBannedCont);
		jpWhite.add(lblFlame);
		jpWhite.add(lblFlameCont);
		jpWhite.add(lblGas);
		jpWhite.add(lblGasCont);
		jpWhite.add(lblWeapon);
		jpWhite.add(lblWeaponCont);
		jpWhite.add(lblDanger);
		jpWhite.add(lblDangerCont);
		jpWhite.add(lblLithium);
		jpWhite.add(lblLithiumCont);
		jpWhite.add(lblAble);
		jpWhite.add(lblAbleCont);
		jpWhite.add(lblLiquid);
		jpWhite.add(lblLiquidCont);
		jpWhite.add(lblMedicine);
		jpWhite.add(lblMedicineCont);
		
		
		
//		JLabel lb1 = new JLabel("fjsdlkfjdjfjlfjgkfjgjfgljljgjfgjlsjglkjfgjfjl");
//		lb1.setBounds(0,0,500,100);
//		jpWhite.add(lb1);		
		
		// 상단 메뉴바
		setUpMenu();
		

		c.add(scPane);
		
		setVisible(true);
	}


	// 상단 메뉴바
	private void setUpMenu() {
		menubar = new MenuBar();
		add(menubar.getPnTOP());
	}


	public static void main(String[] args) {
		new Restriction();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
