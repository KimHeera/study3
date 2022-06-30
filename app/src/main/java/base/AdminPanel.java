package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminPanel extends JPanel{
	JPanel p = new JPanel();
	JPanel sp = new JPanel();
	
	public AdminPanel() {
		getAdminPage();
	}

	
	public void getAdminPage() {
		
		
		Font font = new Font("Arial", Font.BOLD, 40);
		
		JLabel lblNewLabel = new JLabel("관리자 Page");
		lblNewLabel.setBounds(520, 50, 300, 50);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(font);
		p.add(lblNewLabel, BorderLayout.WEST);
		
		
//		table = new JTable(data, column);
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(100, 100, 1000, 500);
//		p.add(scrollPane, BorderLayout.WEST);
		
		JButton undo = new JButton();
		undo.setText("뒤로가기");
		undo.setOpaque(true);
		undo.addActionListener(listener);
		undo.setContentAreaFilled(false);
		undo.setLayout(null);
		undo.setVisible(true);
		undo.setBounds(490, 610, 100, 70);
		p.add(undo, BorderLayout.WEST);
		
		
		JButton allclear = new JButton();
		allclear.setText("전체 계정 삭제");
		allclear.setOpaque(true);
		allclear.addActionListener(listener);
		allclear.setContentAreaFilled(false);
		allclear.setLayout(null);
		allclear.setVisible(true);
		allclear.setBounds(590, 610, 180, 70);
		p.add(allclear, BorderLayout.WEST);
		
		
		
		sp.setBounds(290 ,100, 600, 500);
		sp.setBackground(Color.DARK_GRAY);
		System.out.println(Database.arr.size());
		sp.setLayout(new GridLayout(Database.arr.size(), 1));
		JLabel s_n = new JLabel("username  userid  userpw  userbirth  usergender  userphone  userhint\n");
		s_n.setBounds(310, 127, 800, 20);
		s_n.setForeground(Color.WHITE);
		s_n.setFont(new Font("", Font.ITALIC, 15));
		p.add(s_n, BorderLayout.CENTER);
		
		for(int i = 0; i < Database.arr.size(); i++) {
			JLabel s = new JLabel("    " + Database.arr.get(i) + "\n");
			s.setForeground(Color.WHITE);
			s.setFont(new Font("", Font.ITALIC, 15));
			
			sp.add(s);
		}
		
		p.add(sp);
		
		p.setVisible(true); 
		p.setSize(1200, 700);
		p.setLayout(new BorderLayout());
		p.setBackground(Color.LIGHT_GRAY);
		p.setOpaque(true);
		
		MainFrame.mainFrame.add(p);
	}
	
	ActionListener listener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String cmd = e.getActionCommand(); 
    		
    		
    		switch(cmd) { // 메뉴 아이템의 종류 구분
    		case "뒤로가기" : {
    			Database.arr.clear();
    			MainFrame.basicPanel.setVisible(true);
    			p.setVisible(false);
    			
    			break;
    			
    		}
    		case "전체 계정 삭제" : {
    			int okay= JOptionPane.showConfirmDialog(null, "전체 계정을 삭제하시겠습니까?", "" ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				
				if(okay==0) {
					Database.delete();
					MainFrame.out.setText("");
					MainFrame.idInputt.setText("  학번");
					MainFrame.pwdInputt.setText("  비밀번호");
					MainFrame.idInputt.setForeground(Color.LIGHT_GRAY);
					MainFrame.pwdInputt.setForeground(Color.LIGHT_GRAY);
					Database.arr.clear();
					MainFrame.basicPanel.setVisible(true);
	    			p.setVisible(false);
					break;
				}
				
    		}
    		}
    		
    	}
    };

}
