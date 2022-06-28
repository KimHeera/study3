package base;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class finPanel extends JPanel{
	JPanel finishpanel = new JPanel();
	
	public finPanel(){
		makefinish();
	}
	
	void makefinish() {
		finishpanel.setVisible(true); 
		finishpanel.setSize(1200, 700);
		finishpanel.setLayout(new BorderLayout());
		finishpanel.setBackground(Color.ORANGE);
		finishpanel.setOpaque(true);
		MainFrame.mainFrame.add(finishpanel);
	}
}