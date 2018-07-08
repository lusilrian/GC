package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dao.MemberDao;
import model.dao.MovieDao;
import model.vo.Member;
import model.vo.Movie;

public class Pay extends JFrame{
	
	ResMenu rm;
	MemberDao md;
	MovieDao movieDao;
	Member mem;
	Movie movietemp,movie;
	int sel;
	SeatSel ss;
	JFrame p = this;
	public Pay(ResMenu rm, SeatSel ss, int sel, String paysel){
		super(paysel);
		this.rm = rm;
		this.sel = sel;
		this.ss = ss;
		movieDao = rm.mp.getMovieDao();
		md = rm.mp.getMemberDao();
		mem = md.getLoginMember();
		movietemp = ss.getMovie();
		movie = new Movie(movietemp.getName(),movietemp.getPoster(),movietemp.getStr(),movietemp.getCut(),movietemp.getTheaters().get(sel).getTime(),rm.daySel.getText(),rm.theaterSel.getText());
		movie.getTheater().setSeat(ss.seats);
		movie.setNumber(ss.seatTemp.size());
		System.out.println(movie);
		this.setSize(670,630);
		this.setLayout(null);
		
		JPanel main = new JPanel();
		main.setBounds(0, 0, 670, 630);
		main.setLayout(null);
		main.setBackground(Color.white);
		
		JPanel infoPanel  = new JPanel();
		infoPanel.setBounds(20, 20, 540, 260);
		infoPanel.setLayout(null);
		infoPanel.add(ss.info2(rm));
		if(paysel.equals("카드결제")){
			System.out.println(paysel);
			main.add(cardPanel());
			
		}else if(paysel.equals("핸드폰결제")){
			System.out.println(paysel);
			main.add(phonePanel());
		}
		main.add(infoPanel);
		this.add(main);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		

	}
	
	public JPanel cardPanel(){
		JPanel sub = new JPanel();
		sub.setLayout(null);
		sub.setBackground(Color.white);
		sub.setBounds(80, 270, 630, 360);
		JLabel cardNuml = new JLabel("카드 번호 : ");
		cardNuml.setBounds(0, 0, 100, 40);
		JTextField cardNum1 = new JTextField();
		cardNum1.setBounds(70+40, 0, 60, 40);
		JTextField cardNum2 = new JTextField();
		cardNum2.setBounds(140+40, 0, 60, 40);
		JTextField cardNum3 = new JTextField();
		cardNum3.setBounds(210+40, 0, 60, 40);
		JTextField cardNum4 = new JTextField();
		cardNum4.setBounds(280+40, 0, 60, 40);
		
		JLabel dayNuml = new JLabel("유효 기간 : ");
		dayNuml.setBounds(0, 50, 100, 40);
		JTextField dayNum1 = new JTextField();
		dayNum1.setBounds(70+40, 50, 60, 40);
		JTextField dayNum2 = new JTextField();
		dayNum2.setBounds(140+40, 50, 60, 40);
		
		JLabel passNuml = new JLabel("비밀 번호 : ");
		passNuml.setBounds(0, 100, 100, 40);
		JTextField passNum1 = new JTextField();
		passNum1.setBounds(70+40, 100, 60, 40);
		
		JLabel money = new JLabel((ss.seatTemp.size()*10000)+"원");
		money.setBounds(0, 150, 200, 80);
		money.setFont(new Font("gulim", Font.BOLD, 20));
		JButton btn = new JButton("결제");
		btn.setBounds(210, 150, 60, 80);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mem.setM1(movie);
				md.fileSave();
				movietemp.getTheaters().get(sel).setSeat(ss.seats);
				movieDao.fileSave();
				rm.selPanel.removeAll();
				rm.selPanel.add(ss.infoEnd(rm));
				rm.repaint();
				p.dispose();
			}
		});
		sub.add(cardNuml);
		sub.add(cardNum1);
		sub.add(cardNum2);
		sub.add(cardNum3);
		sub.add(cardNum4);
		sub.add(dayNuml);
		sub.add(dayNum1);
		sub.add(dayNum2);
		sub.add(passNuml);
		sub.add(passNum1);
		sub.add(money);
		sub.add(btn);
		
		
		
		return sub;
	}
	
	public JPanel phonePanel(){
		JPanel sub = new JPanel();
		sub.setLayout(null);
		sub.setBackground(Color.white);
		sub.setBounds(80, 270, 630, 360);
		String[] phones = {"SKT", "KT", "LG"};
		JComboBox phoneBox = new JComboBox(phones);
		phoneBox.setBounds(0, 0, 100, 40);
		JTextField phoneNum1 = new JTextField();
		phoneNum1.setBounds(70+40, 0, 60, 40);
		JTextField phoneNum2 = new JTextField();
		phoneNum2.setBounds(140+40, 0, 60, 40);
		JTextField phoneNum3 = new JTextField();
		phoneNum3.setBounds(210+40, 0, 60, 40);
		
		JLabel namel = new JLabel("이    름 : ");
		namel.setBounds(0, 50, 100, 40);
		JTextField name = new JTextField();
		name.setBounds(70+40, 50, 100, 40);
		
		JLabel passNuml = new JLabel("주민등록번호 : ");
		passNuml.setBounds(0, 100, 100, 40);
		JTextField passNum1 = new JTextField();
		passNum1.setBounds(70+40, 100, 100, 40);
		JTextField passNum2 = new JTextField();
		passNum2.setBounds(70+40+40, 100, 100, 40);
		
		JLabel money = new JLabel((ss.seatTemp.size()*10000)+"원");
		money.setBounds(0, 150, 200, 80);
		money.setFont(new Font("gulim", Font.BOLD, 20));
		JButton btn = new JButton("결제");
		btn.setBounds(210, 150, 60, 80);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rm.selPanel.removeAll();
				rm.selPanel.add(ss.infoEnd(rm));
				
				rm.repaint();
				p.dispose();
			}
		});
		
		sub.add(phoneBox);
		sub.add(phoneNum1);
		sub.add(phoneNum2);
		sub.add(phoneNum3);
		sub.add(passNuml);
		sub.add(passNum1);
		sub.add(passNum2);
		sub.add(money);
		sub.add(btn);
		return sub;
	}
	
	
}
