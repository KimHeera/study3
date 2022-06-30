package base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class FinalToNext implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "마이페이지" :{
				String inf=null; 
				
				inf= Arrays.toString(Database.select(MainToNext.id));
				System.out.println(inf);
				inf = inf.substring(1, inf.length()-1);
				
				String[] info = inf.split(",");
				
				new Mypage();
				finPanel.finishpanel.setVisible(false);
				
				break;
			}
			case "로그아웃" :{
				MainFrame.out.setText("");
				MainFrame.idInputt.setText("  학번");
				MainFrame.pwdInputt.setText("  비밀번호");
				MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
				MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
				
				finPanel.finishpanel.setVisible(false);
//				Mypage.mypanel.setVisible(false);
				MainFrame.basicPanel.setVisible(true);
				break;
			}
			case "뒤로가기" :{
				finPanel.finishpanel.setVisible(true);
				Mypage.mypanel.setVisible(false);
				
				break;
			}
			case "수정하기" :{
				if(Mypage.same) {
					Database.update(Mypage.nameinput.getText(),MainToNext.id, Mypage.pwdinput.getText(), Mypage.yearinput.getText(), Mypage.phoneinput.getText(), Mypage.hintinput.getText());
					JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					
					finPanel.finishpanel.setVisible(true);
					Mypage.mypanel.setVisible(false);
					
					
				}
				break;
				
			}
			case "비밀번호 일치 확인하기" :{
				String fp = new String(Mypage.pwdinput.getPassword());
				
				String sp = new String(Mypage.pwdcheck.getPassword());
				//일치하면
				if(fp.equals(sp)) {
					Mypage.pwdchlab.setText("일치합니다");
					Mypage.same = true;
				}
				//일치하지 않으면 
				else {
					Mypage.pwdchlab.setText("일치하지 않습니다.");
					Mypage.same = false;
				}
							
				break;
			}
			case "탈퇴하기" :{
				int okay= JOptionPane.showConfirmDialog(null, "탈퇴하시겠습니까?", "" ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				
				if(okay==0) {
					Database.delete(MainToNext.id);
					MainFrame.out.setText("");
					MainFrame.idInputt.setText("  학번");
					MainFrame.pwdInputt.setText("  비밀번호");
					MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
					MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
					
					Mypage.mypanel.setVisible(false);
					finPanel.finishpanel.setVisible(false);
					MainFrame.basicPanel.setVisible(true);
					break;
				}
				
				
				break;
			}
			
		}
//		System.out.println(inf);
		
		System.out.println(" 마지막 패널에서 패널 변경 : " + cmd);
	}
}

