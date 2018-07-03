package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel {
	private JFrame mf;
	private JPanel panel;


	public ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	public void change(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}

}
