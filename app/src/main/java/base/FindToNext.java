package base;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FindToNext implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "뒤로가기" :{
//				new findPanel();
				MainFrame.basicPanel.setVisible(true);
				fPanel.findpanel.setVisible(false);
				
				break;
			}
			case "확인" :{
				Database.userid="";
				Database.userpw="";
				
				Database.selectnamean(fPanel.name.getText(), fPanel.an.getText());
				
				if(!Database.userid.equals("") && !Database.userpw.equals("")) {
				
					new POPF();
					POPF.idLb.setText("회원님의 아이디는 " + Database.userid + "이며, ");
					POPF.pwdLb.setText("비밀번호는 " + Database.userpw + "입니다.");
					MainFrame.basicPanel.setVisible(false);
					break;
				}
				
				else {
					fPanel.nn.setText(" 다시 입력해주세요. ");
					break;
				}
				
			}
			case "로그인 하러 가기" :{
				POPF.popup.hide();
				MainFrame.out.setText("");
				MainFrame.idInputt.setText("  학번");
				MainFrame.pwdInputt.setText("  비밀번호");
				MainFrame.pwdInputt.setEnabled(true);
				MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
				MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
				MainFrame.basicPanel.setVisible(true);
				fPanel.findpanel.setVisible(false);
				
				break;
			}
			
			
		}
		
		System.out.println(" 아이디/비번 찾기에서 패널 변경 : " + cmd);
		
	}
}
