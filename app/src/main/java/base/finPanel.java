package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class finPanel extends JPanel{
	static JPanel finishpanel = new JPanel();
	
	JLabel zzan = new JLabel();
	static JLabel info = new JLabel();
	
	
	JButton mypage = new JButton();
	JButton logout = new JButton();
	JButton drop = new JButton();
	
	
	
	public finPanel(){
		makefinish();
	}
	
	void makefinish() {
		Font findfont = new Font("Arial", Font.BOLD, 40);
		
		zzan.setText("짜잔");
		zzan.setBounds(finishpanel.HEIGHT/2+570, finishpanel.WIDTH/2 + 175, 500, 80);
		zzan.setForeground(Color.BLACK);
		zzan.setFont(findfont);
		finishpanel.add(zzan, BorderLayout.WEST);
		
		info.setText("");
		info.setBounds(finishpanel.HEIGHT/2+450, finishpanel.WIDTH/2 + 265, 520, 80);
		info.setForeground(Color.BLACK);
		info.setFont(findfont);
		finishpanel.add(info, BorderLayout.WEST);
		
		
		FinalToNext fntn = new FinalToNext();
		mypage.setText("마이페이지");
		mypage.setOpaque(true);
		mypage.addActionListener(fntn);
		mypage.setContentAreaFilled(false);
		mypage.setLayout(null);
		mypage.setVisible(true);
		mypage.setBounds(finishpanel.HEIGHT/2+420, finishpanel.WIDTH/2 + 380, 180, 70);
		finishpanel.add(mypage, BorderLayout.WEST);
		
		logout.setText("로그아웃");
		logout.setOpaque(true);
		logout.addActionListener(fntn);
		logout.setContentAreaFilled(false);
		logout.setLayout(null);
		logout.setVisible(true);
		logout.setBounds(finishpanel.HEIGHT/2+620, finishpanel.WIDTH/2 + 380, 180, 70);
		finishpanel.add(logout, BorderLayout.WEST);
		
		drop.setText("탈퇴하기");
		drop.setOpaque(true);
		drop.addActionListener(fntn);
		drop.setContentAreaFilled(false);
		drop.setLayout(null);
		drop.setVisible(true);
		drop.setBounds(finishpanel.HEIGHT/2+570, finishpanel.WIDTH/2 + 480, 80, 30);
		finishpanel.add(drop, BorderLayout.WEST);
		
		
		finishpanel.setVisible(true); 
		finishpanel.setSize(1200, 700);
		finishpanel.setLayout(new BorderLayout());
		finishpanel.setBackground(Color.LIGHT_GRAY);
		finishpanel.setOpaque(true);
		MainFrame.mainFrame.add(finishpanel);
	}
}