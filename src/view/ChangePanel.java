package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	private JPanel mainPanel;


	public ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	public ChangePanel(JPanel mainPanel, JPanel panel) {
		this.mainPanel = mainPanel;
		this.panel = panel;
	}
	
	public void change(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
	public void changeP(JPanel changePanel) {
		mainPanel.remove(panel);
		mainPanel.add(changePanel);
		mainPanel.repaint();
	}

}
