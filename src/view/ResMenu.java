package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.vo.Movie;
import model.vo.Theater;

public class ResMenu extends JPanel {
	JPanel panel;
	JButton daySel, timeSel, movieSel, theaterSel;
	MouseAdapter m;
	int index;
	JComboBox theaterList;
	JComboBox dayList;
	JComboBox timeList;
	int selmovie;
	ResMenu rm = this;
	JPanel selPanel;
	MainPanel mp;
	public ResMenu(ArrayList<Movie> list, MainPanel mp){
		panel = this;
		this.setBounds(0, 120, 640, 655+130);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.mp = mp;
		selPanel = new JPanel();
		selPanel.setLocation(40, 405-130);
		selPanel.setSize(540, 370); 
		selPanel.setLayout(null);
		selPanel.setBackground(Color.white);

		//영화, 극장, 날짜, 시간버튼
		JButton movie = new JButton("영화");
		movie.setLocation(35, 0);
		movie.setSize(125, 45); 
		JButton theater = new JButton("극장");
		theater.setLocation(175, 0);
		theater.setSize(125, 45); 
		JButton day = new JButton("날짜");
		day.setLocation(315, 0);
		day.setSize(125, 45); 
		JButton time = new JButton("시간");
		time.setLocation(455, 0);
		time.setSize(125, 45); 
		m = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				switch(j.getText()){
				case"영화 선택" :
					selPanel.removeAll();
					JPanel panelS = new JPanel();
					panelS.setLayout(new GridLayout(1, 1));
					JScrollPane jsp = new JScrollPane();
					jsp.setLocation(0, 0);
					jsp.setSize(530, 370);
					jsp.setPreferredSize(new Dimension(500, 370));
					jsp.setViewportView(panelS);

					for(int i = 0; i < list.size(); i++){
						int a = i;
						JPanel p = new JPanel();
						Image originImg = list.get(a).getPoster().getImage(); 
						Image changedImg= originImg.getScaledInstance(200,330, Image.SCALE_SMOOTH );
						ImageIcon Icon = new ImageIcon(changedImg);
						JLabel poster = new JLabel(Icon);
						poster.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								Image originImg = list.get(a).getPoster().getImage(); 
								Image changedImg= originImg.getScaledInstance(125, 150, Image.SCALE_SMOOTH );
								ImageIcon Icon = new ImageIcon(changedImg);
								selmovie = a;
								movieSel.setText(list.get(a).getName());
								movieSel.setIcon(Icon);
								selPanel.removeAll();
								selPanel.repaint();

								theaterSel.addMouseListener(m);
								movieSel.removeMouseListener(m);
							}

						});
						p.add(poster);
						panelS.add(p);

					}
					selPanel.add(jsp);
					jsp.repaint();
					mp.mf.setVisible(true);
					break;

				case"극장 선택" : 
					selPanel.removeAll();
					String[] areas = {"서울", "경기"};
					JButton area = new JButton("지역");
					JButton theater = new JButton("극장");
					theater.setLocation(0, 100);
					theater.setSize(100, 40);
					String[][] theaters = {{"가산디지털","건대입구","신도림","청량리","홍대입구"},{"검단","부평","성남","수원","인천"}};
					theaterList = new JComboBox(theaters[index]);
					theaterList.setBounds(0, 150, 540, 40);
					area.setBounds(0, 0, 100, 40);
					JButton sel = new JButton("확인");
					JComboBox areaList = new JComboBox(areas);
					areaList.setBounds(0, 50, 540, 40);
					areaList.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							//어떤 메뉴를 선택했는지에 대한 요소를 가져온다.
							selPanel.removeAll();
							JComboBox jc = (JComboBox)e.getSource();
							index = jc.getSelectedIndex();
							theaterList = new JComboBox(theaters[index]);
							theaterList.setBounds(0, 150, 540, 40);
							selPanel.add(area);
							selPanel.add(areaList);
							selPanel.add(sel);
							selPanel.add(theater);
							selPanel.add(theaterList);
							selPanel.repaint();
						}
					});
					
					sel.setLocation(200, 200);
					sel.setSize(100, 60);
					sel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == sel){
								theaterSel.setText((String) theaterList.getSelectedItem());
								selPanel.removeAll();
								selPanel.repaint();

								daySel.addMouseListener(m);
								theaterSel.removeMouseListener(m);
							}
						}
					});
					selPanel.add(area);
					selPanel.add(areaList);
					selPanel.add(sel);
					selPanel.add(theater);
					selPanel.add(theaterList);
					selPanel.repaint();
					mp.mf.setVisible(true);
					
					break;
				case"날짜 선택" : 
					selPanel.removeAll();
					String[] days = new String[7];
					for(int i = 0; i < days.length; i++){
						Calendar d = new GregorianCalendar();
						if((d.get(Calendar.DATE)+i)<=d.getActualMaximum(Calendar.DATE)){
							days[i] = "" + (d.get(Calendar.DAY_OF_MONTH)+2) + "/" + (d.get(Calendar.DATE)+i);
						}else{
							days[i] = "" + (d.get(Calendar.DAY_OF_MONTH)+3) + "/" + (d.get(Calendar.DATE)+i);
						}
					}
					JButton day = new JButton("날짜");
					day.setLocation(0, 0);
					day.setSize(100, 40);
					dayList = new JComboBox(days);
					dayList.setBounds(0, 50, 540, 40);
					sel = new JButton("확인");
					
					sel.setLocation(200, 200);
					sel.setSize(100, 60);
					sel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == sel){
								daySel.setText((String) dayList.getSelectedItem());
								selPanel.removeAll();
								selPanel.repaint();

								timeSel.addMouseListener(m);
								daySel.removeMouseListener(m);
							}
						}
					});
					selPanel.add(day);
					selPanel.add(dayList);
					selPanel.add(sel);
					selPanel.repaint();
					mp.mf.setVisible(true);
					
					break;
				case"시간 선택" : 
					selPanel.removeAll();
					String[] times = new String[list.get(0).getTimes().length];
					ArrayList<Theater> arr = list.get(selmovie).getTheaters(theaterSel.getText(), daySel.getText());
					for(int i = 0; i < arr.size(); i++){
						times[i] = arr.get(i).getTime();
					}
					JButton time = new JButton("상영 시간");
					time.setLocation(0, 0);
					time.setSize(100, 40);
					timeList = new JComboBox(times);
					timeList.setBounds(0, 50, 540, 40);
					sel = new JButton("확인");
					
					sel.setLocation(200, 200);
					sel.setSize(100, 60);
					sel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == sel){
								String t = (String) timeList.getSelectedItem();
								timeSel.setText(t.substring(0, 5));
								
								selPanel.removeAll();
								JButton seat = new JButton("좌석 선택");
								seat.setBounds(100, 100, 200, 160);
								seat.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										if(e.getSource() == seat){
											new SeatSel(list.get(selmovie), rm, timeList.getSelectedIndex());
										}
									}
								});
								selPanel.add(seat);
								selPanel.repaint();
								timeSel.removeMouseListener(m);
							}
						}
					});
					selPanel.add(time);
					selPanel.add(timeList);
					selPanel.add(sel);
					selPanel.repaint();
					mp.mf.setVisible(true);
					
					break;
				}

			}

		};
		//영화, 극장, 날짜, 시간목록
		movieSel = new JButton("영화 선택");
		movieSel.setLocation(35, 180-130);
		movieSel.setSize(125, 150); 
		movieSel.addMouseListener(m);

		theaterSel = new JButton("극장 선택");
		theaterSel.setLocation(175, 180-130);
		theaterSel.setSize(125, 150); 

		daySel = new JButton("날짜 선택");
		daySel.setLocation(315, 180-130);
		daySel.setSize(125, 150);


		timeSel = new JButton("시간 선택");
		timeSel.setLocation(455, 180-130);
		timeSel.setSize(125, 150); 

		//예매 초기화 버튼
		JButton reset = new JButton("예매 초기화");
		reset.setLocation(55, 345-130);
		reset.setSize(510, 45); 
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == reset){
					movieSel.setText("영화 선택");
					movieSel.setIcon(null);
					theaterSel.setText("극장 선택");
					daySel.setText("날짜 선택");
					timeSel.setText("시간 선택");
					movieSel.addMouseListener(m);
					selPanel.removeAll();
					selPanel.repaint();
				}
			}
		});

		this.add(movie);
		this.add(theater);
		this.add(day);
		this.add(time);
		this.add(movieSel);
		this.add(theaterSel);
		this.add(daySel);
		this.add(timeSel);
		this.add(reset);

		this.add(selPanel);
	}

	public ResMenu(Movie list, MainPanel mp){
		panel = this;
		
		this.setBounds(0, 0, 640, 655+130);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.mp = mp;
		selPanel = new JPanel();
		selPanel.setLocation(40, 405-130);
		selPanel.setSize(540, 370); 
		selPanel.setLayout(null);
		selPanel.setBackground(Color.white);

		//영화, 극장, 날짜, 시간버튼
		JButton movie = new JButton("영화");
		movie.setLocation(35, 0);
		movie.setSize(125, 45); 
		JButton theater = new JButton("극장");
		theater.setLocation(175, 0);
		theater.setSize(125, 45); 
		JButton day = new JButton("날짜");
		day.setLocation(315, 0);
		day.setSize(125, 45); 
		JButton time = new JButton("시간");
		time.setLocation(455, 0);
		time.setSize(125, 45); 
		m =new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				switch(j.getText()){
				case"극장 선택" : 
					selPanel.removeAll();
					String[] areas = {"서울", "경기"};
					JButton area = new JButton("지역");
					JButton theater = new JButton("극장");
					theater.setLocation(0, 100);
					theater.setSize(100, 40);
					String[][] theaters = {{"가산디지털","건대입구","신도림","청량리","홍대입구"},{"검단","부평","성남","수원","인천"}};
					theaterList = new JComboBox(theaters[index]);
					theaterList.setBounds(0, 150, 540, 40);
					area.setBounds(0, 0, 100, 40);
					JButton sel = new JButton("확인");
					JComboBox areaList = new JComboBox(areas);
					areaList.setBounds(0, 50, 540, 40);
					areaList.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							//어떤 메뉴를 선택했는지에 대한 요소를 가져온다.
							selPanel.removeAll();
							JComboBox jc = (JComboBox)e.getSource();
							index = jc.getSelectedIndex();
							theaterList = new JComboBox(theaters[index]);
							theaterList.setBounds(0, 150, 540, 40);
							selPanel.add(area);
							selPanel.add(areaList);
							selPanel.add(sel);
							selPanel.add(theater);
							selPanel.add(theaterList);
							selPanel.repaint();
						}
					});
					
					sel.setLocation(200, 200);
					sel.setSize(100, 60);
					sel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == sel){
								theaterSel.setText((String) theaterList.getSelectedItem());
								selPanel.removeAll();
								selPanel.repaint();
								daySel.addMouseListener(m);
								theaterSel.removeMouseListener(m);
							}
						}
					});
					selPanel.add(area);
					selPanel.add(areaList);
					selPanel.add(sel);
					selPanel.add(theater);
					selPanel.add(theaterList);
					selPanel.repaint();
					mp.mf.setVisible(true);
					
					break;
				case"날짜 선택" : 
					selPanel.removeAll();
					String[] days = new String[7];
					for(int i = 0; i < days.length; i++){
						Calendar d = new GregorianCalendar();
						if((d.get(Calendar.DATE)+i)<=d.getActualMaximum(Calendar.DATE)){
							days[i] = "" + (d.get(Calendar.DAY_OF_MONTH)+2) + "/" + (d.get(Calendar.DATE)+i);
						}else{
							days[i] = "" + (d.get(Calendar.DAY_OF_MONTH)+3) + "/" + (d.get(Calendar.DATE)+i);
						}
					}
					JButton day = new JButton("날짜");
					day.setLocation(0, 0);
					day.setSize(100, 40);
					dayList = new JComboBox(days);
					dayList.setBounds(0, 50, 540, 40);
					sel = new JButton("확인");
					
					sel.setLocation(200, 200);
					sel.setSize(100, 60);
					sel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == sel){
								daySel.setText((String) dayList.getSelectedItem());
								selPanel.removeAll();
								selPanel.repaint();

								timeSel.addMouseListener(m);
								daySel.removeMouseListener(m);
							}
						}
					});
					selPanel.add(day);
					selPanel.add(dayList);
					selPanel.add(sel);
					selPanel.repaint();
					mp.mf.setVisible(true);
					
					break;
				case"시간 선택" : 
					selPanel.removeAll();
					String[] times = new String[list.getTimes().length];
					ArrayList<Theater> arr = list.getTheaters(theaterSel.getText(), daySel.getText());
					for(int i = 0; i < arr.size(); i++){
						times[i] = arr.get(i).getTime();
					}
					JButton time = new JButton("상영 시간");
					time.setLocation(0, 0);
					time.setSize(100, 40);
					timeList = new JComboBox(times);
					timeList.setBounds(0, 50, 540, 40);
					sel = new JButton("확인");
					
					sel.setLocation(200, 200);
					sel.setSize(100, 60);
					sel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == sel){
								String t = (String) timeList.getSelectedItem();
								timeSel.setText(t.substring(0, 5));
								
								selPanel.removeAll();
								JButton seat = new JButton("좌석 선택");
								seat.setBounds(100, 100, 200, 160);
								seat.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										if(e.getSource() == seat){
											new SeatSel(list, rm, timeList.getSelectedIndex());
										}
									}
								});
								selPanel.add(seat);
								selPanel.repaint();
								timeSel.removeMouseListener(m);
							}
						}
					});
					selPanel.add(time);
					selPanel.add(timeList);
					selPanel.add(sel);
					selPanel.repaint();
					mp.mf.setVisible(true);
					
					break;
				}

			}

		};
		Image originImg = list.getPoster().getImage(); 
		Image changedImg= originImg.getScaledInstance(125, 150, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		//영화, 극장, 날짜, 시간목록
		movieSel = new JButton(Icon);
		movieSel.setText(list.getName());
		movieSel.setLocation(35, 180-130);
		movieSel.setSize(125, 150); 

		theaterSel = new JButton("극장 선택");
		theaterSel.setLocation(175, 180-130);
		theaterSel.setSize(125, 150); 
		theaterSel.addMouseListener(m);

		daySel = new JButton("날짜 선택");
		daySel.setLocation(315, 180-130);
		daySel.setSize(125, 150);


		timeSel = new JButton("시간 선택");
		timeSel.setLocation(455, 180-130);
		timeSel.setSize(125, 150); 

		//예매 초기화 버튼
		JButton reset = new JButton("예매 초기화");
		reset.setLocation(55, 345-130);
		reset.setSize(510, 45); 
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == reset){
					theaterSel.setText("극장 선택");
					daySel.setText("날짜 선택");
					timeSel.setText("시간 선택");
					theaterSel.addMouseListener(m);
					selPanel.removeAll();
					selPanel.repaint();
				}
			}
		});

		this.add(movie);
		this.add(theater);
		this.add(day);
		this.add(time);
		this.add(movieSel);
		this.add(theaterSel);
		this.add(daySel);
		this.add(timeSel);
		this.add(reset);

		this.add(selPanel);
	}
}
