package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import model.vo.Movie;

public class MovieMenu extends JPanel {
	private JPanel panel;
	public MovieMenu(ArrayList<Movie> list, MainPanel mp){
		panel = this;
		this.setBounds(10, 205, 620, 655);
		this.setBackground(Color.white);
		JPanel panelS = new JPanel();
		panelS.setLayout(new GridLayout(2, 3));
		panelS.setOpaque(false);
		JScrollPane jsp = new JScrollPane();
		jsp.setPreferredSize(new Dimension(600, 610));
		jsp.setViewportView(panelS);
		
		for(int i = 0; i < list.size(); i++){
			int j = i;
			JPanel p = new JPanel();
			JLabel poster = new JLabel(list.get(i).getPoster());
			poster.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					ChangePanel cp = new ChangePanel(mp.panel, panel);
					MovieInfo m = new MovieInfo(list.get(j));
					mp.menuName.setText(list.get(j).getName());
					mp.home.setText("<");
					mp.home.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							mp.panel.removeAll();
							mp.panel.add(mp.main);
							mp.panel.add(panel);
							mp.menuName.setText("¿µÈ­");
							mp.panel.repaint();
							mp.home.setText("home");
							mp.home.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									mp.panel.removeAll();
									mp.panel.add(mp.main);
									mp.panel.add(mp.sub);
									mp.menuName.setText("");
									mp.panel.repaint();

								}

							});

						}

					});
					cp.changeP(m);
					mp.main.remove(mp.movie);
					mp.main.remove(mp.res);
					mp.main.remove(mp.store);
					
				}

			});
			p.add(poster);
			panelS.add(p);
		}
		this.add(jsp);
	}
}
