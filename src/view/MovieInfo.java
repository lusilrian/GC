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
		/*
		JButton btn = new JButton("");
		btn.setLocation(20, 110);
		btn.setSize(580, 5);
		
		JButton btn1 = new JButton("");
		btn1.setLocation(20, 585);
		btn1.setSize(580, 5);

		//뒤로가기 버튼
		JButton btn2 = new JButton("<");
		btn2.setLocation(45, 45);
		btn2.setSize(55, 55);  

		//메뉴이름
		JButton btn3 = new JButton("상세정보");
		btn3.setLocation(120, 45);
		btn3.setSize(130, 55);*/

		//영화이름
		JButton btn4 = new JButton(movie.getName());
		btn4.setLocation(70, 125-115);
		btn4.setSize(480, 50); 

		//포스터사진
		Image originImg = movie.getPoster().getImage(); 
		Image changedImg= originImg.getScaledInstance(200, 180, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		JButton btn5 = new JButton(Icon);
		btn5.setLocation(100, 185-115);
		btn5.setSize(200, 180);

		//예매하기
		JButton btn7 = new JButton("예매하기");
		btn7.setLocation(95, 405-145);
		btn7.setSize(430, 40); 

		//줄거리
		JButton btn8 = new JButton(movie.getStr());
		btn8.setLocation(320, 185-115);
		btn8.setSize(200, 180);
		
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
		/*//스틸컷
		JButton btn9 = new JButton("스틸컷");
		btn9.setLocation(30, 465-155);
		btn9.setSize(560, 290); */
		
		
		this.add(btn4);
		this.add(btn5);
		this.add(btn7);
		this.add(btn8);
		this.add(jsp);
		
		
		
		
		
	}

}
