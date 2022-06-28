package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	static JFrame mainFrame = new JFrame();
	static JPanel basicPanel = new JPanel();
	
	JButton goToLogin = new JButton();
	JButton findIdPwd = new JButton();
	JButton goToSign = new JButton();
	
	
	JTextField idInput = new JTextField();
	JTextField pwdInput = new JTextField();
	
	
	public MainFrame(){
		mainframe();
		
	}
	
	public void mainframe() {
		
		Font font = new Font("Arial", Font.BOLD, 15);
		
//아이디 적는 칸
		idInput.setText("  아이디");
		idInput.setBounds(basicPanel.HEIGHT/2+470, basicPanel.WIDTH/2 + 210, 300, 50);
		idInput.setForeground(Color.LIGHT_GRAY);
		idInput.setFont(font);
		basicPanel.add(idInput, BorderLayout.WEST);
		
		
//비밀번호 적는 칸
		pwdInput.setText("  비밀번호");
		pwdInput.setBounds(basicPanel.HEIGHT/2+470, basicPanel.WIDTH/2 + 260, 300, 50);
		pwdInput.setForeground(Color.LIGHT_GRAY);
		pwdInput.setFont(font);
		basicPanel.add(pwdInput, BorderLayout.WEST);
		
		
		
//아이디 비밀번호 찾는 버튼
		MainToNext cp = new MainToNext();
		
		findIdPwd.setText("아이디/비밀번호 찾기");
		findIdPwd.setOpaque(true);
		findIdPwd.addActionListener(cp);
		findIdPwd.setContentAreaFilled(false);
		findIdPwd.setLayout(null);
		findIdPwd.setVisible(true);
		findIdPwd.setBounds(basicPanel.HEIGHT/2+475, basicPanel.WIDTH/2 + 315, 150, 30);
		basicPanel.add(findIdPwd, BorderLayout.WEST);
		
		
//회원가입 하는 버튼
		goToSign.setText("회원가입 하기");
		goToSign.setOpaque(true);
		goToSign.addActionListener(cp);
		goToSign.setContentAreaFilled(false);
		goToSign.setLayout(null);
		goToSign.setVisible(true);
		goToSign.setBounds(basicPanel.HEIGHT/2+615, basicPanel.WIDTH/2 + 315, 150, 30);
		basicPanel.add(goToSign, BorderLayout.WEST);
		
		
		
//로그인 하는 버튼		
		goToLogin.setText("로그인 하기");
		goToLogin.setOpaque(true);
		goToLogin.addActionListener(cp);
		goToLogin.setContentAreaFilled(false);
		goToLogin.setLayout(null);
		goToLogin.setVisible(true);
		goToLogin.setBounds(basicPanel.HEIGHT/2+470, basicPanel.WIDTH/2 + 350, 300, 60);
		basicPanel.add(goToLogin, BorderLayout.WEST);
		
//메인 패널
		basicPanel.setVisible(true); 
		basicPanel.setSize(1200, 700);
		basicPanel.setLayout(new BorderLayout());
		basicPanel.setBackground(Color.DARK_GRAY);
		basicPanel.setOpaque(true);
		
		
//메인 프레임		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(basicPanel, BorderLayout.CENTER);
		
		mainFrame.setTitle("Log in&out"); //타이틀
		mainFrame.setSize(1220, 750); //프레임 초기 사이즈
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setResizable(true); //프레임크기 조절 가능
		mainFrame.setVisible(true); //프레임이 보이도록
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 활성
	}
	
	
	
	

}
