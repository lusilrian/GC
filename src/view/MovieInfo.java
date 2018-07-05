package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import model.vo.Movie;

public class MovieInfo extends JPanel {
	private JPanel panel;
	public MovieInfo(Movie movie) {
		panel = this;
		this.setBounds(10, 205, 620, 655);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		//영화이름
		JButton movieName = new JButton(movie.getName());
		movieName.setLocation(70, 125-115);
		movieName.setSize(480, 50); 

		//포스터사진
		Image originImg = movie.getPoster().getImage(); 
		Image changedImg= originImg.getScaledInstance(200, 180, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		JButton posterImg = new JButton(Icon);
		posterImg.setLocation(100, 185-115);
		posterImg.setSize(200, 180);

		//예매하기
		JButton resBtn = new JButton("예매하기");
		resBtn.setLocation(95, 405-145);
		resBtn.setSize(430, 40); 

		//줄거리
		JButton story = new JButton(movie.getStr());
		story.setLocation(320, 185-115);
		story.setSize(200, 180);
		
		JPanel panelS = new JPanel();
		panelS.setLayout(new GridLayout(1, 3));
		JScrollPane jsp = new JScrollPane();
		jsp.setLocation(30, 465-155);
		jsp.setSize(560, 290);
		jsp.setPreferredSize(new Dimension(600, 300));
		jsp.setViewportView(panelS);
		ImageIcon mc[] = movie.getCut();
		for(int i = 0; i < mc.length; i++){
			originImg = mc[i].getImage(); 
			changedImg= originImg.getScaledInstance(200, 260, Image.SCALE_SMOOTH );
			Icon = new ImageIcon(changedImg);
			int j = i;
			JPanel p = new JPanel();
			JLabel poster = new JLabel(Icon);
			poster.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					
					JFrame fdsa = new JFrame();
					fdsa.setSize(360, 540);
					Image originImg = mc[j].getImage(); 
					Image changedImg= originImg.getScaledInstance(360, 540, Image.SCALE_SMOOTH );
					ImageIcon Icon = new ImageIcon(changedImg);
					JLabel ds = new JLabel(Icon);
					fdsa.add(ds);
					fdsa.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(MouseEvent e) {
							
							fdsa.dispose();
							
						}

					});
					fdsa.setVisible(true);
					
				}

			});
			p.add(poster);
			panelS.add(p);
		}
		
		
		this.add(movieName);
		this.add(posterImg);
		this.add(resBtn);
		this.add(story);
		this.add(jsp);
		
		
		
		
		
	}

}
