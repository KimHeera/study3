package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignCheck extends JFrame{
	static JFrame che = new JFrame();
	
	JPanel infoPanel = new JPanel();
	JLabel pwdLb = new JLabel();
	
	JButton gogo = new JButton();
	
	SignCheck(){
		signpop();
	}
	
	void signpop() {
		Font infofont = new Font("Arial", Font.BOLD, 20);
		

		pwdLb.setText("아이디 중복 / 비밀번호 일치 여부를 확인해주세요.");
		pwdLb.setBounds(infoPanel.HEIGHT/2 + 65, infoPanel.WIDTH/2 + 70, 400, 50);
		pwdLb.setForeground(Color.LIGHT_GRAY);
		pwdLb.setFont(infofont);
		infoPanel.add(pwdLb, BorderLayout.WEST);
		
//로그인 하러 가기 버튼 
		SignToNext listener = new SignToNext();
		gogo.setText("닫기");
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
		che.setLayout(new BorderLayout());
		che.add(infoPanel, BorderLayout.CENTER);
		
		che.setTitle("Oh~"); //타이틀
		che.setSize(520, 250); //프레임 초기 사이즈
		che.setLocationRelativeTo(null);
		che.getContentPane().setBackground(Color.BLACK);
		che.setResizable(true); //프레임크기 조절 가능
		che.setVisible(true); //프레임이 보이도록
		che.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //x버튼 활성
	}
}
