package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class POPF extends JFrame{
	static JFrame popup = new JFrame();
	
	JPanel infoPanel = new JPanel();
	
	JLabel idLb = new JLabel();
	JLabel pwdLb = new JLabel();
	
	JButton goLo = new JButton();
	
	POPF(){
		pop();
	}
	
	void pop() {
		Font infofont = new Font("Arial", Font.BOLD, 20);
		
//아이디 출력 라벨	
		idLb.setText("회원님의 아이디는 ~~~~~~~~~~~~ 이며, ");
		idLb.setBounds(infoPanel.HEIGHT/2 + 85, infoPanel.WIDTH/2 + 20, 350, 50);
		idLb.setForeground(Color.LIGHT_GRAY);
		idLb.setFont(infofont);
		infoPanel.add(idLb, BorderLayout.WEST);
		
//비밀번호 출력 라벨
		pwdLb.setText("비밀번호는 ~~~~~~~~~~~~ 입니다.");
		pwdLb.setBounds(infoPanel.HEIGHT/2 + 105, infoPanel.WIDTH/2 + 70, 350, 50);
		pwdLb.setForeground(Color.LIGHT_GRAY);
		pwdLb.setFont(infofont);
		infoPanel.add(pwdLb, BorderLayout.WEST);
		
//로그인 하러 가기 버튼 
		FindToNext ftn = new FindToNext();
		goLo.setText("로그인 하러 가기");
		goLo.setOpaque(true);
		goLo.addActionListener(ftn);
		goLo.setContentAreaFilled(false);
		goLo.setLayout(null);
		goLo.setVisible(true);
		goLo.setBounds(infoPanel.HEIGHT/2+190, infoPanel.WIDTH/2 + 130, 120, 60);
		infoPanel.add(goLo, BorderLayout.WEST);
		
		
		
//popup의 메인 패널		
		infoPanel.setVisible(true); 
		infoPanel.setSize(520, 550);
		infoPanel.setLayout(new BorderLayout());
		infoPanel.setBackground(Color.DARK_GRAY);
		infoPanel.setOpaque(true);
		
//popup의 메인 프레임		
		popup.setLayout(new BorderLayout());
		popup.add(infoPanel, BorderLayout.CENTER);
		
		popup.setTitle("Log in&out"); //타이틀
		popup.setSize(520, 250); //프레임 초기 사이즈
		popup.setLocationRelativeTo(null);
		popup.getContentPane().setBackground(Color.BLACK);
		popup.setResizable(true); //프레임크기 조절 가능
		popup.setVisible(true); //프레임이 보이도록
		popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //x버튼 활성
	}
}