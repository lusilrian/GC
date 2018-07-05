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
		System.out.println("change");
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
	public void changeP(JPanel changePanel) {
		System.out.println("change");
		mainPanel.remove(panel);
		mainPanel.add(changePanel);
		mainPanel.repaint();
	}

}
