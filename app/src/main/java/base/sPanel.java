package base;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class sPanel extends JPanel{
	JPanel signpanel = new JPanel();
	
	public sPanel(){
		makesign();
	}
	
	void makesign() {
		signpanel.setVisible(true); 
		signpanel.setSize(1200, 700);
		signpanel.setLayout(new BorderLayout());
		signpanel.setBackground(Color.BLUE);
		signpanel.setOpaque(true);
		MainFrame.mainFrame.add(signpanel);
	}
}