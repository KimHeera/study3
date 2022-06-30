package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Mypage extends JPanel{
static JPanel mypanel = new JPanel();
	
	JLabel mp = new JLabel();
	
	JLabel namelab = new JLabel();
	JLabel idlab = new JLabel();
	static JLabel checklab = new JLabel();
	JLabel pwdlab = new JLabel();
	JLabel pwdchecklab = new JLabel();
	static JLabel pwdchlab = new JLabel();
	JLabel btdlab = new JLabel();
	JLabel genderlab = new JLabel();
	JLabel numlab = new JLabel();
	JLabel findlab = new JLabel();
	
	
	static JTextField nameinput = new JTextField();
	static JTextField idinput = new JTextField();
	static JTextField yearinput = new JTextField();
	static JTextField phoneinput = new JTextField();
	static JTextField hintinput = new JTextField();
	static JTextField gender = new JTextField();
	
	
	static JPasswordField pwdinput = new JPasswordField();
	static JPasswordField pwdcheck = new JPasswordField();
	
	JButton doublecheckbtn = new JButton();
	JButton passbtn = new JButton();
	JButton unbtn = new JButton();
	JButton gotobtn = new JButton();
	
	static boolean dou;
	static boolean same;
	
	
	static String[] month = {"월 선택", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	static String[] date = {"일 선택","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	
	
	static JComboBox moninput = new JComboBox(month);
	static JComboBox dayinput = new JComboBox(date);
	
	String inf=null; 
	
	public Mypage(){
		makemy();
	}
	
	void makemy() {
		FinalToNext fntn = new FinalToNext();
		
		inf= Arrays.toString(Database.select(MainToNext.id));
		System.out.println(inf);
		inf = inf.substring(1, inf.length()-1);
		String[] info = inf.split(",");
		
		
		Font SIGNINfont = new Font("Arial", Font.BOLD, 40);
		Font labelfont = new Font("Arial", Font.BOLD, 18);
		Font signfont = new Font("Arial", Font.BOLD, 15);
		Font checkfont = new Font("Arial", Font.ITALIC, 13);
		
//패널 sign 표시
		mp.setText("My Page");
		mp.setBounds(mypanel.HEIGHT/2+540, mypanel.WIDTH/2 + 100, 180, 50);
		mp.setForeground(Color.BLACK);
		mp.setFont(SIGNINfont);
		mypanel.add(mp, BorderLayout.WEST);
		
		
		
//이름 라벨
		namelab.setText("  이름 : ");
		namelab.setBounds(mypanel.HEIGHT/2+410, mypanel.WIDTH/2 + 165, 130, 50);
		namelab.setForeground(Color.BLACK);
		namelab.setFont(labelfont);
		mypanel.add(namelab, BorderLayout.WEST);
		
//이름 적는 칸
		nameinput.setText(info[0]);
		nameinput.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 170, 150, 40);
		nameinput.setForeground(Color.LIGHT_GRAY);
		nameinput.setFont(signfont);
		nameinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(nameinput.getText().equals(info[0])) {
	            	 nameinput.setText("");
	            	 nameinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 nameinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(nameinput.getText().equals("")) {
	            	 nameinput.setText(info[0]);
	            	 nameinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 nameinput.setForeground(Color.BLACK);
	          } 
	      });
		mypanel.add(nameinput, BorderLayout.WEST);
		
//아이디 라벨
		idlab.setText("  학번 : ");
		idlab.setBounds(mypanel.HEIGHT/2+410, mypanel.WIDTH/2 + 215, 130, 50);
		idlab.setForeground(Color.BLACK);
		idlab.setFont(labelfont);
		mypanel.add(idlab, BorderLayout.WEST);
		
//아이디 적는 칸		
		idinput.setText(info[1]);
		idinput.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 220, 150, 40);
		idinput.setForeground(Color.BLACK);
		idinput.setFont(signfont);
		idinput.setEnabled(false);
		mypanel.add(idinput, BorderLayout.WEST);
		
		
//비밀번호 라벨
		pwdlab.setText(" 새 비밀번호 : ");
		pwdlab.setBounds(mypanel.HEIGHT/2+360, mypanel.WIDTH/2 + 265, 130, 50);
		pwdlab.setForeground(Color.BLACK);
		pwdlab.setFont(labelfont);
		mypanel.add(pwdlab, BorderLayout.WEST);
		
//비밀번호 적는 칸
		pwdinput.setText("");
		pwdinput.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 270, 150, 40);
		pwdinput.setForeground(Color.LIGHT_GRAY);
		pwdinput.setFont(signfont);
		pwdinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(pwdinput.getText().equals("")) {
	            	 pwdinput.setText("");
	            	 pwdinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 pwdinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(pwdinput.getText().equals("")) {
	            	 pwdinput.setText("");
	            	 pwdinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 pwdinput.setForeground(Color.BLACK);
	          } 
	      });
		
		mypanel.add(pwdinput, BorderLayout.WEST);
		
		
//비밀번호 체크 라벨
		pwdchecklab.setText("  비밀번호 확인 : ");
		pwdchecklab.setBounds(mypanel.HEIGHT/2+344, mypanel.WIDTH/2 + 315, 130, 50);
		pwdchecklab.setForeground(Color.BLACK);
		pwdchecklab.setFont(labelfont);
		mypanel.add(pwdchecklab, BorderLayout.WEST);
		
//비밀번호 확인하는 칸
		pwdcheck.setText("     ");
		pwdcheck.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 320, 150, 40);
		pwdcheck.setForeground(Color.LIGHT_GRAY);
		pwdcheck.setFont(signfont);
		pwdcheck.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(pwdcheck.getText().equals("     ")) {
	            	 pwdcheck.setText("");
	            	 pwdcheck.setForeground(Color.LIGHT_GRAY);
	             }
	            	 
	             else
	            	 pwdcheck.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(pwdcheck.getText().equals("")) {
	            	 pwdcheck.setText("     ");
	            	 pwdcheck.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 pwdcheck.setForeground(Color.BLACK);
	          } 
	      });
		mypanel.add(pwdcheck, BorderLayout.WEST);
		
//비번 중복 확인 버튼
		passbtn.setText("비밀번호 일치 확인하기");
		passbtn.setOpaque(true);
		passbtn.addActionListener(fntn);
		passbtn.setContentAreaFilled(false);
		passbtn.setLayout(null);
		passbtn.setVisible(true);
		passbtn.setBounds(mypanel.HEIGHT/2+620, mypanel.WIDTH/2 + 275, 150, 30);
		mypanel.add(passbtn, BorderLayout.WEST);
		
//비밀번호 중복 확인하면 나오는 문구 라벨
		pwdchlab.setText("");
		pwdchlab.setBounds(mypanel.HEIGHT/2+630, mypanel.WIDTH/2 + 315, 160, 50);
		pwdchlab.setForeground(Color.BLACK);
		pwdchlab.setFont(checkfont);
		mypanel.add(pwdchlab, BorderLayout.WEST);
		
//생년월일 라벨
		btdlab.setText("  생년월일 : ");
		btdlab.setBounds(mypanel.HEIGHT/2+ 380 , mypanel.WIDTH/2 + 365, 130, 50);
		btdlab.setForeground(Color.BLACK);
		btdlab.setFont(labelfont);
		mypanel.add(btdlab, BorderLayout.WEST);
		
//생년월일
		yearinput.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 370, 150, 40);
		yearinput.setForeground(Color.LIGHT_GRAY);
		yearinput.setFont(signfont);
		yearinput.setText(info[3]);
		yearinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(yearinput.getText().equals(info[3])) {
	            	 yearinput.setText("");
	            	 yearinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 yearinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(yearinput.getText().equals("")) {
	            	 yearinput.setText(info[3]);
	            	 yearinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 yearinput.setForeground(Color.BLACK);
	          } 
	      });
		
		mypanel.add(yearinput, BorderLayout.WEST);
		
		
//성별 라벨
		genderlab.setText("  성별 : ");
		genderlab.setBounds(mypanel.HEIGHT/2+410, mypanel.WIDTH/2 + 415, 130, 50);
		genderlab.setForeground(Color.BLACK);
		genderlab.setFont(labelfont);
		mypanel.add(genderlab, BorderLayout.WEST);
		
		
		
//성별 선택		
		gender.setText(info[4]);
		gender.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 420, 150, 40);
		gender.setForeground(Color.BLACK);
		gender.setFont(signfont);
		gender.setEnabled(false);
		mypanel.add(gender, BorderLayout.WEST);
		
		
//연락처 라벨		
		numlab.setText("  연락처 : ");
		numlab.setBounds(mypanel.HEIGHT/2+395, mypanel.WIDTH/2 + 465, 130, 50);
		numlab.setForeground(Color.BLACK);
		numlab.setFont(labelfont);
		mypanel.add(numlab, BorderLayout.WEST);
		
//연락처 받는 칸
		phoneinput.setText(info[5]);
		phoneinput.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 475, 120, 30);
		phoneinput.setForeground(Color.LIGHT_GRAY);
//		phoneinput.addActionListener(cch);
		phoneinput.setFont(signfont);
		phoneinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(phoneinput.getText().equals(info[5])) {
	            	 phoneinput.setText("");
	            	 phoneinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 phoneinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(phoneinput.getText().equals("")) {
	            	 phoneinput.setText(info[5]);
	            	 phoneinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 phoneinput.setForeground(Color.BLACK);
	          } 
	      });
		mypanel.add(phoneinput, BorderLayout.WEST);
		
		
//아이디/비밀번호 찾을 라벨
		findlab.setText("  아이디/비밀번호 힌트 : ");
		findlab.setBounds(mypanel.HEIGHT/2+285, mypanel.WIDTH/2 + 515, 191, 50);
		findlab.setForeground(Color.BLACK);
		findlab.setFont(labelfont);
		mypanel.add(findlab, BorderLayout.WEST);
		
//힌트 입력하는 칸
		hintinput.setText(info[6]);
		hintinput.setBounds(mypanel.HEIGHT/2+470, mypanel.WIDTH/2 + 525, 180, 30);
		hintinput.setForeground(Color.LIGHT_GRAY);
//		hintinput.addActionListener(cch);
		hintinput.setFont(signfont);
		hintinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(hintinput.getText().equals(info[6])) {
	            	 hintinput.setText("");
	            	 hintinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 hintinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(hintinput.getText().equals("")) {
	            	 hintinput.setText(info[6]);
	            	 hintinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 hintinput.setForeground(Color.BLACK);
	          } 
	      });
		mypanel.add(hintinput, BorderLayout.WEST);
		
//뒤로가기버튼		
		
		unbtn.setText("뒤로가기");
		unbtn.setOpaque(true);
		unbtn.addActionListener(fntn);
		unbtn.setContentAreaFilled(false);
		unbtn.setLayout(null);
		unbtn.setVisible(true);
		unbtn.setBounds(mypanel.HEIGHT/2+520, mypanel.WIDTH/2 + 570, 100, 60);
		mypanel.add(unbtn, BorderLayout.WEST);
		
		
//확인 버튼
		gotobtn.setText("수정하기");
		gotobtn.setOpaque(true);
		gotobtn.addActionListener(fntn);
		gotobtn.setContentAreaFilled(false);
		gotobtn.setLayout(null);
		gotobtn.setVisible(true);
		gotobtn.setBounds(mypanel.HEIGHT/2+620, mypanel.WIDTH/2 + 570, 100, 60);
		mypanel.add(gotobtn, BorderLayout.WEST);	
		
//회원가입 패널
		
		mypanel.setVisible(true); 
		mypanel.setSize(1200, 700);
		mypanel.setLayout(new BorderLayout());
		mypanel.setBackground(Color.LIGHT_GRAY);
		mypanel.setOpaque(true);
		MainFrame.mainFrame.add(mypanel);
		
		
	}
}