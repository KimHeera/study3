package base;


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
				new POPF();
				MainFrame.basicPanel.setVisible(false);
				
				
			
				break;
			}
			case "로그인 하러 가기" :{
				MainFrame.basicPanel.setVisible(true);
				fPanel.findpanel.setVisible(false);
				
				POPF.popup.hide();

			
				break;
			}
			
			
		}
		
		System.out.println(" 아이디/비번 찾기에서 패널 변경 : " + cmd);
		
	}
}
