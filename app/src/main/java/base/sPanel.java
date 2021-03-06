package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class sPanel extends JPanel{
	static JPanel signpanel = new JPanel();
	
	JLabel SIGNIN = new JLabel();
	
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
	
	static JRadioButton male=new JRadioButton("남");
	static JRadioButton female=new JRadioButton("여");
	static JRadioButton non=new JRadioButton("선택 안함", true);
	ButtonGroup gender = new ButtonGroup();
	
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
	
	public sPanel(){
		makesign();
	}
	
	void makesign() {
		Font SIGNINfont = new Font("Arial", Font.BOLD, 40);
		Font labelfont = new Font("Arial", Font.BOLD, 18);
		Font signfont = new Font("Arial", Font.BOLD, 15);
		Font checkfont = new Font("Arial", Font.ITALIC, 13);
		
		
		
		SignToNext listener = new SignToNext();
//패널 sign 표시
		SIGNIN.setText("SIGN IN");
		SIGNIN.setBounds(signpanel.HEIGHT/2+540, signpanel.WIDTH/2 + 100, 150, 50);
		SIGNIN.setForeground(Color.BLACK);
		SIGNIN.setFont(SIGNINfont);
		signpanel.add(SIGNIN, BorderLayout.WEST);
		
		
		
//이름 라벨
		namelab.setText(" *이름 : ");
		namelab.setBounds(signpanel.HEIGHT/2+410, signpanel.WIDTH/2 + 165, 130, 50);
		namelab.setForeground(Color.BLACK);
		namelab.setFont(labelfont);
		signpanel.add(namelab, BorderLayout.WEST);
		
//이름 적는 칸
		nameinput.setText("  이름");
		nameinput.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 170, 150, 40);
		nameinput.addActionListener(listener);
		nameinput.setForeground(Color.LIGHT_GRAY);
		nameinput.setFont(signfont);
		nameinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(nameinput.getText().equals("  이름")) {
	            	 nameinput.setText("");
	            	 nameinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 nameinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(nameinput.getText().equals("")) {
	            	 nameinput.setText("  이름");
	            	 nameinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 nameinput.setForeground(Color.BLACK);
	          } 
	      });
		signpanel.add(nameinput, BorderLayout.WEST);
		
//아이디 라벨
		idlab.setText(" *학번 적기 : ");
		idlab.setBounds(signpanel.HEIGHT/2+375, signpanel.WIDTH/2 + 215, 130, 50);
		idlab.setForeground(Color.BLACK);
		idlab.setFont(labelfont);
		signpanel.add(idlab, BorderLayout.WEST);
		
//아이디 적는 칸		
		idinput.setText("  학번 8자리");
		idinput.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 220, 150, 40);
		idinput.setForeground(Color.LIGHT_GRAY);
		idinput.setFont(signfont);
		idinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(idinput.getText().equals("  학번 8자리")) {
	            	 idinput.setText("");
	            	 idinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 idinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(idinput.getText().equals("")) {
	            	 idinput.setText("  학번 8자리");
	            	 idinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 idinput.setForeground(Color.BLACK);
	          } 
	      });
		signpanel.add(idinput, BorderLayout.WEST);
		
		
//중복 확인하는 버튼
		doublecheckbtn.setText("중복 확인하기");
		doublecheckbtn.setOpaque(true);
		doublecheckbtn.addActionListener(listener);
		doublecheckbtn.setContentAreaFilled(false);
		doublecheckbtn.setLayout(null);
		doublecheckbtn.setVisible(true);
		doublecheckbtn.setBounds(signpanel.HEIGHT/2+620, signpanel.WIDTH/2 + 225, 100, 30);
		signpanel.add(doublecheckbtn, BorderLayout.WEST);
		
//중복 확인 했을때 나오는 멘트 라벨	
		checklab.setText("");
		checklab.setBounds(signpanel.HEIGHT/2+475, signpanel.WIDTH/2 + 245, 200, 40);
		checklab.setForeground(Color.BLACK);
		checklab.setFont(checkfont);
		signpanel.add(checklab, BorderLayout.WEST);
		
		
//비밀번호 라벨
		pwdlab.setText(" *비밀번호 : ");
		pwdlab.setBounds(signpanel.HEIGHT/2+380, signpanel.WIDTH/2 + 265, 130, 50);
		pwdlab.setForeground(Color.BLACK);
		pwdlab.setFont(labelfont);
		signpanel.add(pwdlab, BorderLayout.WEST);
		
//비밀번호 적는 칸
		pwdinput.setText("     ");
		pwdinput.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 270, 150, 40);
		pwdinput.setForeground(Color.LIGHT_GRAY);
		pwdinput.setFont(signfont);
		pwdinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(pwdinput.getText().equals("     ")) {
	            	 pwdinput.setText("");
	            	 pwdinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 pwdinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(pwdinput.getText().equals("")) {
	            	 pwdinput.setText("     ");
	            	 pwdinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 pwdinput.setForeground(Color.BLACK);
	          } 
	      });
		
		signpanel.add(pwdinput, BorderLayout.WEST);
		
		
//비밀번호 체크 라벨
		pwdchecklab.setText(" *비밀번호 확인 : ");
		pwdchecklab.setBounds(signpanel.HEIGHT/2+344, signpanel.WIDTH/2 + 315, 130, 50);
		pwdchecklab.setForeground(Color.BLACK);
		pwdchecklab.setFont(labelfont);
		signpanel.add(pwdchecklab, BorderLayout.WEST);
		
//비밀번호 확인하는 칸
		pwdcheck.setText("     ");
		pwdcheck.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 320, 150, 40);
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
		signpanel.add(pwdcheck, BorderLayout.WEST);
		
//비번 중복 확인 버튼
		passbtn.setText("비밀번호 일치 확인하기");
		passbtn.setOpaque(true);
		passbtn.addActionListener(listener);
		passbtn.setContentAreaFilled(false);
		passbtn.setLayout(null);
		passbtn.setVisible(true);
		passbtn.setBounds(signpanel.HEIGHT/2+620, signpanel.WIDTH/2 + 275, 150, 30);
		signpanel.add(passbtn, BorderLayout.WEST);
		
//비밀번호 중복 확인하면 나오는 문구 라벨
		pwdchlab.setText("");
		pwdchlab.setBounds(signpanel.HEIGHT/2+630, signpanel.WIDTH/2 + 315, 160, 50);
		pwdchlab.setForeground(Color.BLACK);
		pwdchlab.setFont(checkfont);
		signpanel.add(pwdchlab, BorderLayout.WEST);
		
//생년월일 라벨
		btdlab.setText("  생년월일 : ");
		btdlab.setBounds(signpanel.HEIGHT/2+ 380 , signpanel.WIDTH/2 + 365, 130, 50);
		btdlab.setForeground(Color.BLACK);
		btdlab.setFont(labelfont);
		signpanel.add(btdlab, BorderLayout.WEST);
		
//생년월일
//		CalenderChooseer cch = new CalenderChooseer();
		yearinput.setText("YYYY");
		yearinput.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 380, 70, 30);
		yearinput.setForeground(Color.LIGHT_GRAY);
//		yearinput.addActionListener(cch);
		yearinput.setFont(signfont);
		yearinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(yearinput.getText().equals("YYYY")) {
	            	 yearinput.setText("");
	            	 yearinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 yearinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(yearinput.getText().equals("")) {
	            	 yearinput.setText("YYYY");
	            	 yearinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 yearinput.setForeground(Color.BLACK);
	          } 
	      });
		signpanel.add(yearinput, BorderLayout.WEST);
		
//월 선택 
		moninput.setToolTipText("월 입력");
		moninput.setBounds(signpanel.HEIGHT/2+540, signpanel.WIDTH/2 + 370, 100, 50);
		moninput.setForeground(Color.BLACK);
//		moninput.addActionListener(listener);
		moninput.setFont(signfont);
		signpanel.add(moninput, BorderLayout.WEST);
		
		
//		String n = moninput.getSelectedItem().toString();
//		System.out.println(n);
		
		
//월 선택 
		dayinput.setToolTipText("일 입력");
		dayinput.setBounds(signpanel.HEIGHT/2+640, signpanel.WIDTH/2 + 370, 100, 50);
		dayinput.setForeground(Color.BLACK);
//				moninput.addActionListener(listener);
		dayinput.setFont(signfont);
		signpanel.add(dayinput, BorderLayout.WEST);
		
//성별 라벨
		genderlab.setText(" *성별 : ");
		genderlab.setBounds(signpanel.HEIGHT/2+410, signpanel.WIDTH/2 + 415, 130, 50);
		genderlab.setForeground(Color.BLACK);
		genderlab.setFont(labelfont);
		signpanel.add(genderlab, BorderLayout.WEST);
		
		
		
//성별 선택		
		male.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 415, 70, 50);
		female.setBounds(signpanel.HEIGHT/2+550, signpanel.WIDTH/2 + 415, 70, 50);
		non.setBounds(signpanel.HEIGHT/2+630, signpanel.WIDTH/2 + 415, 90, 50);
		male.addActionListener(listener);
		female.addActionListener(listener);
		non.addActionListener(listener);
		
		gender.add(male);
		gender.add(female);
		gender.add(non);
		signpanel.add(male);
		signpanel.add(female);
		signpanel.add(non);
		
//연락처 라벨		
		numlab.setText("  연락처 : ");
		numlab.setBounds(signpanel.HEIGHT/2+395, signpanel.WIDTH/2 + 465, 130, 50);
		numlab.setForeground(Color.BLACK);
		numlab.setFont(labelfont);
		signpanel.add(numlab, BorderLayout.WEST);
		
//연락처 받는 칸
		phoneinput.setText("010XXXXXXXX");
		phoneinput.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 475, 120, 30);
		phoneinput.setForeground(Color.LIGHT_GRAY);
//		phoneinput.addActionListener(cch);
		phoneinput.setFont(signfont);
		phoneinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(phoneinput.getText().equals("010XXXXXXXX")) {
	            	 phoneinput.setText("");
	            	 phoneinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 phoneinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(phoneinput.getText().equals("")) {
	            	 phoneinput.setText("010XXXXXXXX");
	            	 phoneinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 phoneinput.setForeground(Color.BLACK);
	          } 
	      });
		signpanel.add(phoneinput, BorderLayout.WEST);
		
		
//아이디/비밀번호 찾을 라벨
		findlab.setText(" *아이디/비밀번호 힌트 : ");
		findlab.setBounds(signpanel.HEIGHT/2+285, signpanel.WIDTH/2 + 515, 191, 50);
		findlab.setForeground(Color.BLACK);
		findlab.setFont(labelfont);
		signpanel.add(findlab, BorderLayout.WEST);
		
//힌트 입력하는 칸
		hintinput.setText("6글자 이내로 입력해주세요.");
		hintinput.setBounds(signpanel.HEIGHT/2+470, signpanel.WIDTH/2 + 525, 180, 30);
		hintinput.setForeground(Color.LIGHT_GRAY);
//		hintinput.addActionListener(cch);
		hintinput.setFont(signfont);
		hintinput.addFocusListener(new FocusListener() {
	          public void focusGained(FocusEvent e) {
	             if(hintinput.getText().equals("6글자 이내로 입력해주세요.")) {
	            	 hintinput.setText("");
	            	 hintinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 hintinput.setForeground(Color.BLACK);
	          }

	          public void focusLost(FocusEvent e) {
	             if(hintinput.getText().equals("")) {
	            	 hintinput.setText("6글자 이내로 입력해주세요.");
	            	 hintinput.setForeground(Color.LIGHT_GRAY);
	             }
	             else
	            	 hintinput.setForeground(Color.BLACK);
	          } 
	      });
		signpanel.add(hintinput, BorderLayout.WEST);
		
//뒤로가기버튼		
		unbtn.setText("뒤로가기");
		unbtn.setOpaque(true);
		unbtn.addActionListener(listener);
		unbtn.setContentAreaFilled(false);
		unbtn.setLayout(null);
		unbtn.setVisible(true);
		unbtn.setBounds(signpanel.HEIGHT/2+520, signpanel.WIDTH/2 + 570, 100, 60);
		signpanel.add(unbtn, BorderLayout.WEST);
		
		
//확인 버튼
		gotobtn.setText("가입하기");
		gotobtn.setOpaque(true);
		gotobtn.addActionListener(listener);
		gotobtn.setContentAreaFilled(false);
		gotobtn.setLayout(null);
		gotobtn.setVisible(true);
		gotobtn.setBounds(signpanel.HEIGHT/2+620, signpanel.WIDTH/2 + 570, 100, 60);
		signpanel.add(gotobtn, BorderLayout.WEST);	
		
//회원가입 패널
		
		signpanel.setVisible(true); 
		signpanel.setSize(1200, 700);
		signpanel.setLayout(new BorderLayout());
		signpanel.setBackground(Color.LIGHT_GRAY);
		signpanel.setOpaque(true);
		MainFrame.mainFrame.add(signpanel);
		
		
	}
}



