package base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignToNext implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String gen ="";
		String bir = sPanel.yearinput.getText() + sPanel.moninput.getSelectedItem().toString() + sPanel.dayinput.getSelectedItem().toString();
		
		new Database();
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
		case "이름" :{
			sPanel.nameinput.setText("");
			
			break;
		}  
		case "중복 확인하기" :{
			
			Database.selectid(Integer.parseInt(sPanel.idinput.getText()));
			
			if(Database.count ==1 ) {
				sPanel.checklab.setText("이미 사용 중인 아이디입니다.");
				sPanel.dou = false;
				break;
			}
			//아이디 조회해서 중복이면 
			
			if(Database.count !=1 )  {
				sPanel.checklab.setText("사용 가능한 아이디입니다.");
				sPanel.dou = true;
				break;
			}
			
			//중복 아니면 다른 텍스트로 바꾸기
		
		}
		case "비밀번호 일치 확인하기" :{
			String fp = new String(sPanel.pwdinput.getPassword());
			
			String sp = new String(sPanel.pwdcheck.getPassword());
			//일치하면
			if(fp.equals(sp)) {
				sPanel.pwdchlab.setText("일치합니다");
				sPanel.same = true;
			}
			//일치하지 않으면 
			else {
				sPanel.pwdchlab.setText("일치하지 않습니다.");
				sPanel.same = false;
			}
		
			break;
		}
		case "뒤로가기" :{
			sPanel.signpanel.setVisible(false);
			MainFrame.basicPanel.setVisible(true);
			
			
			break;
		}
		case "male" :{
			gen = sPanel.male.getText();
			
			break;
		}
		case "female" :{
			gen = sPanel.female.getText();
			
			
			break;
		}
		case "non" :{
			gen = sPanel.non.getText();
			
			
			break;
		}
		
		case "가입하기" :{
			String fp = new String(sPanel.pwdinput.getPassword());
			
			String sp = new String(sPanel.pwdcheck.getPassword());
			
			if(sPanel.nameinput.getText().equals("  이름") || sPanel.idinput.getText().equals("  학번 8자리") || fp.equals("     ") || sp.equals("     ") || sPanel.hintinput.getText().equals("6글자 이내로 입력해주세요.")) {
				new SignFail();
				break;
			}
			else if(sPanel.dou ==false || sPanel.same == false) {
				new SignCheck();
				break;
			}
			
			else{
				Database.insert(sPanel.nameinput.getText(), Integer.parseInt(sPanel.idinput.getText()), fp, bir, gen,sPanel.phoneinput.getText(), sPanel.hintinput.getText());
				new SignPop();
				break;
			}
			
			
			
		}
		case "로그인 하기" :{
			MainFrame.basicPanel.setVisible(true);
			sPanel.signpanel.setVisible(false);
			
			SignPop.go.hide();
			
			break;
		}
		case "확인" :{
			SignFail.fail.hide();
			
			break;
		}
		case "닫기" :{
			SignCheck.che.hide();
			
			break;
		}
		
	}
	
	System.out.println("버튼 선택 : " + cmd);
	
	System.out.println("날짜 : " + bir);
	
		
	}

}
