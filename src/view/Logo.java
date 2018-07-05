package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Logo extends JFrame {
	JFrame mf = this;
	JPanel panel;
	
	public Logo()
	{
		this.setBounds(0, 0, 640, 860);
		this.setLayout(null);
		this.setTitle("GC영화관");
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.setBounds(0, 0, 640, 860);
		ImageIcon i = new ImageIcon("images/a.png");
		JButton btn = new JButton(i);//로고 이미지 넣기
//		JButton btn1 = new JButton("asdf");
		btn.setLocation(130, 200);
		btn.setSize(350, 350);
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setContentAreaFilled(false);
		/*btn1.setLocation(130, 200);
		btn1.setSize(350, 350);
		btn1.setBorderPainted(false);
		btn1.setFocusable(false);
		btn1.setContentAreaFilled(false);*/
//		this.add(btn1);
//		this.add(btn);
		panel.add(btn);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				ChangePanel c = new ChangePanel(mf, panel);
				MainPanel m = new MainPanel(mf);
				c.change(m);
			}
			
		});
		
		this.add(panel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
