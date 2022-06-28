package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class fPanel extends JPanel{
	static JPanel findpanel = new JPanel();
	
	JLabel n = new JLabel();
	JLabel q = new JLabel();
	JLabel ques = new JLabel();
	
	JTextField name = new JTextField();
	JTextField an = new JTextField();
	
	JButton check = new JButton();
	JButton undo = new JButton();
	
	
	
	public fPanel(){
		makefind();
	}
	
	void makefind() {
		
		Font findfont = new Font("Arial", Font.BOLD, 15);
		
//이름 라벨 설정		
		n.setText(" 이름을 적어주세요.");
		n.setBounds(findpanel.HEIGHT/2+470, findpanel.WIDTH/2 + 175, 130, 50);
		n.setForeground(Color.BLACK);
		n.setFont(findfont);
		findpanel.add(n, BorderLayout.WEST);
		
//이름 적는 텍스트필드		
		name.setText("");
		name.setBounds(findpanel.HEIGHT/2+470, findpanel.WIDTH/2 + 210, 300, 50);
		name.setForeground(Color.LIGHT_GRAY);
		name.setFont(findfont);
		findpanel.add(name, BorderLayout.WEST);
	
//질문 라벨 설정		
		q.setText(" 질문에 대한 답변을 해주세요.");
		
		q.setBounds(findpanel.HEIGHT/2+470, findpanel.WIDTH/2 + 265, 200, 50);
		q.setForeground(Color.BLACK);
		q.setFont(findfont);
		findpanel.add(q, BorderLayout.WEST);	
		
//질문
		ques.setText(" 당신의 보물 1호는?");
		
		ques.setBounds(findpanel.HEIGHT/2+470, findpanel.WIDTH/2 + 290, 200, 50);
		ques.setForeground(Color.BLACK);
		ques.setFont(findfont);
		findpanel.add(ques, BorderLayout.WEST);	
		
		
		
//질문에 대한 답변 적는 칸	
		an.setText("");
		an.setBounds(findpanel.HEIGHT/2+470, findpanel.WIDTH/2 + 325, 300, 50);
		an.setForeground(Color.LIGHT_GRAY);
		an.setFont(findfont);
		findpanel.add(an, BorderLayout.WEST);
		
//뒤로가기 버튼		
		FindToNext ftn = new FindToNext();
		undo.setText("뒤로가기");
		undo.setOpaque(true);
		undo.addActionListener(ftn);
		undo.setContentAreaFilled(false);
		undo.setLayout(null);
		undo.setVisible(true);
		undo.setBounds(findpanel.HEIGHT/2+520, findpanel.WIDTH/2 + 380, 100, 60);
		findpanel.add(undo, BorderLayout.WEST);
		
		
//확인 버튼
		check.setText("확인");
		check.setOpaque(true);
		check.addActionListener(ftn);
		check.setContentAreaFilled(false);
		check.setLayout(null);
		check.setVisible(true);
		check.setBounds(findpanel.HEIGHT/2+620, findpanel.WIDTH/2 + 380, 100, 60);
		findpanel.add(check, BorderLayout.WEST);
		
		
//아이디/비밀번호 찾는 패널		
		findpanel.setVisible(true); 
		findpanel.setSize(1200, 700);
		findpanel.setLayout(new BorderLayout());
		findpanel.setBackground(Color.LIGHT_GRAY);
		findpanel.setOpaque(true);
		MainFrame.mainFrame.add(findpanel);
	}
}