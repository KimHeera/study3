package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainToNext implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "아이디/비밀번호 찾기" :{
				new fPanel();
				MainFrame.basicPanel.setVisible(false);
				
				
				break;
			}
			case "회원가입 하기" :{
				new sPanel();
				MainFrame.basicPanel.setVisible(false);
				
			
				break;
			}
			case "로그인 하기" :{
				new finPanel();
				MainFrame.basicPanel.setVisible(false);
				
				break;
			}
			
		}
		
		System.out.println("패널 변경 : " + cmd);
	
	}
	
}