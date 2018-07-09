package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import model.dao.MemberDao;
import model.dao.MovieDao;
import model.vo.Movie;
import model.vo.Theater;

public class PayInfo extends JFrame {
	int a;
	Movie change;
	JFrame mf;
	ArrayList<Theater> t;
	
	public PayInfo(MemberDao md, int sel, MovieDao mvd) {
		this.setBounds(0, 0, 680, 860);
		this.setLayout(null);
		this.mf = this;
		ArrayList<Movie> movielist = md.getLoginMember().getM1();
		ArrayList<Movie> chanelist = mvd.getMovieList();
		JPanel panelS = new JPanel();
		GridLayout gl = new GridLayout(0,1);
		Color[] c = {Color.blue,Color.yellow,Color.red};
		panelS.setLayout(gl);
		JScrollPane jsp = new JScrollPane();
		jsp.setLocation(0, 0);
		jsp.setSize(650, 800);
		jsp.setHorizontalScrollBarPolicy(jsp.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setViewportView(panelS);

		for(int i = 0; i < movielist.size(); i++){
			//			----------------------------------------------
			int a = i;
			ArrayList<int[]> temp = new ArrayList<int[]>();
			Font font = new Font("gulim", Font.BOLD, 20);
			JPanel info = new JPanel();
			info.setBorder(new BevelBorder(BevelBorder.LOWERED));
			info.setPreferredSize(new Dimension(650,250));
			info.setLayout(new GridLayout(0, 1));
			info.setBackground(Color.white);
			JLabel movie = new JLabel("영화이름 : " + movielist.get(i).getName());
			movie.setBounds(50,0,650,40);
			movie.setFont(font);

			JLabel theater = new JLabel("상 영 관 : " + movielist.get(i).getTheater().getName());
			theater.setBounds(50,50,650,40);
			theater.setFont(font);

			JLabel day = new JLabel("날    짜 : " + movielist.get(i).getTheater().getDay());
			day.setBounds(50,100,650,40);
			day.setFont(font);
			JLabel time = new JLabel("시    간 : " + movielist.get(i).getTheater().getTime2());
			time.setBounds(50,150,650,40);
			time.setFont(font);
			String seatStr = "";
			int[] seatTemp = new int[2];
			for(int j = 0; j < movielist.get(i).getTheater().getSeat().length; j++){
				for(int k = 0; k < movielist.get(i).getTheater().getSeat()[j].length; k++){
					if(movielist.get(i).getTheater().getSeat()[j][k] == 1){
						temp.add(new int[]{j,k});
						switch(j){
						case 0: seatStr += "A"; break;
						case 1: seatStr += "B"; break;
						case 2: seatStr += "C"; break; 
						case 3: seatStr += "D"; break;
						case 4: seatStr += "E"; break;
						}
						seatStr += (k+1) + " ";
					}
				}
			}
			JLabel seat = new JLabel("선택좌석 : " + seatStr);
			seat.setBounds(50,200,200,40);
			seat.setFont(font);
			JButton cancel = new JButton("취소");
			cancel.setBounds(400,150,100,40);
			cancel.setFont(font);
			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					Movie mc = movielist.get(a);
					for(int i = 0; i < chanelist.size(); i++){
						if(mc.getName().equals(chanelist.get(i).getName())){
							change = chanelist.get(i);
						}
					}
					int[][] changeSeat = null;
					t = change.getTheaters();
					int index = 0;
					for(Theater temp : t){
						if(temp.getDay().equals(mc.getTheater().getDay())){
							if(temp.getTime2().equals(mc.getTheater().getTime2())){
								if(temp.getName().equals(mc.getTheater().getName())){
									change.setTheater(temp);
									changeSeat = temp.getSeat();
									break;
								}
							}
						}
						index++;
					}

					for(int i = 0; i < temp.size(); i++){
						changeSeat[temp.get(i)[0]][temp.get(i)[1]] = 0;
					}
					change.getTheaters().get(index).setSeat(changeSeat);
					md.getLoginMember().removeM1(mc);
					md.fileSave();
					mvd.fileSave();
					mf.dispose();

				}
			});

			info.add(movie);
			info.add(theater);
			info.add(day);
			info.add(time);
			info.add(seat);
			info.add(cancel);

			//			----------------------------------------------
			panelS.add(info);
		}

		this.add(jsp);
		this.setVisible(true);


	}

}

