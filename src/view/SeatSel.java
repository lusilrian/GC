package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public SeatSel(Movie m, ResMenu rm, int sel){
		super("¡¬ºÆ º±≈√");
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
		JLabel name = new JLabel("¡¬ºÆ º±≈√");
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

		JButton ok = new JButton("»Æ¿Œ");
		ok.setBounds(240,440, 160, 40);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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
	
}
