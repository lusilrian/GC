package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import model.vo.Movie;

public class SeatSel extends JFrame {
	private JFrame jf;
	private Movie m;
	private int sel;
	private SeatSel ss;
	JPanel panel,seatpanel;
	int num = 0,max;
	int[][] seats;
	ArrayList<int[]> seatTemp = new ArrayList<int[]>();
	public SeatSel(Movie m, ResMenu rm, int sel){
		super("좌석 선택");
		jf = this;
		this.sel = sel;
		this.m = m;
		ss = this;
		seats = clone(m.getTheater()[sel].getSeat());
		this.setSize(670,630);
		this.setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 670, 630);
		panel.setBackground(Color.WHITE);
		JLabel name = new JLabel("좌석 선택");
		name.setBounds(20,20, 200,40);
		name.setFont(new Font("gulim", Font.BOLD, 20));
		panel.add(name);
		String[] nums = {"1","2","3","4"};
		JComboBox numBox = new JComboBox(nums);
		numBox.setBounds(240, 20, 200, 40);
		numBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				num = 0;
				seats = ss.clone(m.getTheater()[sel].getSeat());
				seatTemp = new ArrayList<int[]>();
				System.out.println(max);
				max = Integer.parseInt((String)numBox.getSelectedItem());
				panel.remove(seatpanel);
				printSeat();
				panel.add(seatpanel);
				panel.repaint();
			}
		});
		max = Integer.parseInt((String)numBox.getSelectedItem());
		panel.add(numBox);
		seatpanel = new JPanel();
		seatpanel.setBounds(5, 80, 670, 340);
		seatpanel.setLayout(null);
		printSeat();
		panel.add(seatpanel);
		panel.repaint();

		JButton ok = new JButton("확인");
		ok.setBounds(240,440, 160, 40);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rm.selPanel.removeAll();
				rm.selPanel.add(info(rm));
				rm.repaint();
				jf.dispose();
			}
		});

		panel.add(ok);
		this.add(panel);
		this.setVisible(true);
	}

	public int[][] clone(int[][] main){
		int[][] copy = new int[main.length][main[0].length];
		for(int i = 0; i < main.length; i++){
			for(int j = 0; j < main[i].length; j++){
				copy[i][j] = main[i][j];
			}
		}
		return copy;
	}

	public void printSeat(){
		seatpanel.removeAll();
		Image originImg = new ImageIcon("images/b.png").getImage(); 
		Image changedImg= originImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		ImageIcon[] icon = new ImageIcon[2];
		icon[0] = Icon;
		originImg = new ImageIcon("images/a.png").getImage(); 
		changedImg= originImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		icon[1] = Icon;
		int x = 0;
		int y = 0;
		//		int[][] seats = m.getTheater()[sel].getSeat();

		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				JLabel seat = new JLabel(icon[seats[i][j]]);
				seat.setBounds(x, y, 60, 60);
				int a = i,b = j;
				if(seats[i][j] == 0 && num < max){
					seat.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(MouseEvent e) {
							System.out.println("click");
							num++;
							int temp[] = {a,b};
							seatTemp.add(temp);
							seats[a][b] = 1;
						}

						@Override
						public void mouseExited(MouseEvent e) {
							System.out.println("exited");
							seatpanel.removeAll();
							seatpanel.repaint();
							printSeat();
						}



					});
				}
				seatpanel.add(seat);
				if(j == 3){
					x += 90;
				}
				x += 70;
			}
			x = 0;
			y += 70;
		}
	}

	public JPanel info(ResMenu rm){
		Font font = new Font("gulim", Font.BOLD, 20);
		JPanel info = new JPanel();
		info.setLocation(50, 0);
		info.setSize(540, 370); 
		info.setLayout(null);
		info.setBackground(Color.white);

		JLabel movie = new JLabel("영화이름 : " + rm.movieSel.getText());
		movie.setBounds(0,0,540,40);
		movie.setFont(font);

		JLabel theater = new JLabel("상 영 관 : " + rm.theaterSel.getText());
		theater.setBounds(0,50,540,40);
		theater.setFont(font);

		JLabel day = new JLabel("날    짜 : " + rm.daySel.getText());
		day.setBounds(0,100,540,40);
		day.setFont(font);

		JLabel time = new JLabel("시    간 : " + rm.timeSel.getText());
		time.setBounds(0,150,540,40);
		time.setFont(font);
		String seatStr = "";
		int[][] seats = m.getTheater()[sel].getSeat();
		for(int i = 0; i < seatTemp.size(); i++){
			switch(seatTemp.get(i)[0]){
			case 0: seatStr += "A"; break;
			case 1: seatStr += "B"; break;
			case 2: seatStr += "C"; break; 
			case 3: seatStr += "D"; break;
			case 4: seatStr += "E"; break;
			}
			seatStr += (seatTemp.get(i)[1]+1) + " ";
		}
		JLabel seat = new JLabel("선택좌석 : " + seatStr);
		seat.setBounds(0,200,540,40);
		seat.setFont(font);
		Image originImg = m.getPoster().getImage(); 
		Image changedImg= originImg.getScaledInstance(160, 240, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
	
		JLabel poster = new JLabel(Icon);
		poster.setBounds(250,0,160,240);
		String[] pays = {"카드결제", "핸드폰결제"};
		JComboBox payb = new JComboBox(pays);
		payb.setBounds(0,250,150,40);
		payb.setFont(font);
		
		JButton pay = new JButton("결    제");
		pay.setBounds(200,250,180,40);
		pay.setFont(font);
		pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == pay){
					new Pay(rm,ss,sel,(String)payb.getSelectedItem());
				}
			}
		});
		
		info.add(movie);
		info.add(theater);
		info.add(day);
		info.add(payb);
		info.add(time);
		info.add(seat);
		info.add(poster);
		info.add(pay);


		return info;
	}
	
	public JPanel info2(ResMenu rm){
		Font font = new Font("gulim", Font.BOLD, 20);
		JPanel info = new JPanel();
		info.setLocation(0, 0);
		info.setSize(540, 260); 
		info.setLayout(null);
		info.setBackground(Color.white);

		JLabel movie = new JLabel("영화이름 : " + rm.movieSel.getText());
		movie.setBounds(50,0,250,40);
		movie.setFont(font);

		JLabel theater = new JLabel("상 영 관 : " + rm.theaterSel.getText());
		theater.setBounds(50,50,250,40);
		theater.setFont(font);

		JLabel day = new JLabel("날    짜 : " + rm.daySel.getText());
		day.setBounds(50,100,250,40);
		day.setFont(font);

		JLabel time = new JLabel("시    간 : " + rm.timeSel.getText());
		time.setBounds(50,150,250,40);
		time.setFont(font);
		String seatStr = "";
		int[][] seats = m.getTheater()[sel].getSeat();
		for(int i = 0; i < seatTemp.size(); i++){
			switch(seatTemp.get(i)[0]){
			case 0: seatStr += "A"; break;
			case 1: seatStr += "B"; break;
			case 2: seatStr += "C"; break; 
			case 3: seatStr += "D"; break;
			case 4: seatStr += "E"; break;
			}
			seatStr += (seatTemp.get(i)[1]+1) + " ";
		}
		JLabel seat = new JLabel("선택좌석 : " + seatStr);
		seat.setBounds(50,200,200,40);
		seat.setFont(font);
		Image originImg = m.getPoster().getImage(); 
		Image changedImg= originImg.getScaledInstance(160, 240, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
	
		JLabel poster = new JLabel(Icon);
		poster.setBounds(300,0,160,240);
		
		info.add(movie);
		info.add(theater);
		info.add(day);
		info.add(time);
		info.add(poster);
		info.add(seat);

		return info;
	}
	
	public JPanel infoEnd(ResMenu rm){
		Font font = new Font("gulim", Font.BOLD, 20);
		JPanel info = new JPanel();
		info.setLocation(0, 0);
		info.setSize(540, 260); 
		info.setLayout(null);
		info.setBackground(Color.white);

		JLabel movie = new JLabel("결제 완료");
		movie.setBounds(50,0,250,40);
		movie.setFont(font);

		info.add(movie);

		return info;
	}
	
	public Movie getMovie(){
		return m;
	}
}
