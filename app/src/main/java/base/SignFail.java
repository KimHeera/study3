package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignFail extends JFrame{
	static JFrame fail = new JFrame();
	
	JPanel infoPanel = new JPanel();
	JLabel pwdLb = new JLabel();
	
	JButton gogo = new JButton();
	
	SignFail(){
		signpop();
	}
	
	void signpop() {
		Font infofont = new Font("Arial", Font.BOLD, 20);
		

		pwdLb.setText("입력되지 않은 값이 있습니다.");
		pwdLb.setBounds(infoPanel.HEIGHT/2 + 135, infoPanel.WIDTH/2 + 70, 350, 50);
		pwdLb.setForeground(Color.LIGHT_GRAY);
		pwdLb.setFont(infofont);
		infoPanel.add(pwdLb, BorderLayout.WEST);
		
//로그인 하러 가기 버튼 
		SignToNext listener = new SignToNext();
		gogo.setText("확인");
		gogo.setOpaque(true);
		gogo.addActionListener(listener);
		gogo.setContentAreaFilled(false);
		gogo.setLayout(null);
		gogo.setVisible(true);
		gogo.setBounds(infoPanel.HEIGHT/2+190, infoPanel.WIDTH/2 + 130, 120, 60);
		infoPanel.add(gogo, BorderLayout.WEST);
		
		
		
//popup의 메인 패널		
		infoPanel.setVisible(true); 
		infoPanel.setSize(520, 550);
		infoPanel.setLayout(new BorderLayout());
		infoPanel.setBackground(Color.DARK_GRAY);
		infoPanel.setOpaque(true);
		
//popup의 메인 프레임		
		fail.setLayout(new BorderLayout());
		fail.add(infoPanel, BorderLayout.CENTER);
		
		fail.setTitle("Oh~"); //타이틀
		fail.setSize(520, 250); //프레임 초기 사이즈
		fail.setLocationRelativeTo(null);
		fail.getContentPane().setBackground(Color.BLACK);
		fail.setResizable(true); //프레임크기 조절 가능
		fail.setVisible(true); //프레임이 보이도록
		fail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //x버튼 활성
	}
}
