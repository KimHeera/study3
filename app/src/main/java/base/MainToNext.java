package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainToNext implements ActionListener {
	Database sql = new Database();
	static int id;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "아이디/비밀번호 찾기" :{
				MainFrame.out.setText("");
				MainFrame.idInputt.setText("  학번");
				MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
				MainFrame.pwdInputt.setText("  비밀번호");
				MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
				
				new fPanel();
				MainFrame.basicPanel.setVisible(false);
				
				
				break;
			}
			case "회원가입 하기" :{
				MainFrame.out.setText("");
				MainFrame.idInputt.setText("  학번");
				MainFrame.pwdInputt.setText("  비밀번호");
				MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
				MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
				new sPanel();
				MainFrame.basicPanel.setVisible(false);
				
			
				break;
			}
			case "로그인 하기" :{
				id = Integer.parseInt(MainFrame.idInputt.getText());
				
				Database.selectidpwd(Integer.parseInt(MainFrame.idInputt.getText()), MainFrame.pwdInputt.getText());
				if(Database.count ==1 ) {
					if(id==22100241) {
						Database.select();
						new AdminPanel();
						MainFrame.out.setText("");
						MainFrame.idInputt.setText("  학번");
						MainFrame.pwdInputt.setText("  비밀번호");
						MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
						MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
						
						MainFrame.basicPanel.setVisible(false);
						break;
					}
					else {
						Database.selectidpwC(Integer.parseInt(MainFrame.idInputt.getText()), MainFrame.pwdInputt.getText());
						MainFrame.out.setText("");
						MainFrame.idInputt.setText("  학번");
						MainFrame.pwdInputt.setText("  비밀번호");
						MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
						MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
						new finPanel();
						finPanel.info.setText(""+Database.usern + "님 반갑습니다!");
						MainFrame.basicPanel.hide();
						break;
					}
					
				}
				
				if(Database.count ==0) {
					MainFrame.out.setText(" 다시 입력해주세요. ");
					break;
				}
				
			}
			
		}
		
		System.out.println("패널 변경 : " + cmd);
	
	}
	
}