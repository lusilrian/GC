package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.dao.MemberDao;
import model.dao.MovieDao;
import model.vo.Member;
import model.vo.Movie;
import model.vo.Store;

public class MainPanel extends JPanel implements Runnable{
	MovieDao movieDao = new MovieDao();
	MemberDao memberDao = new MemberDao();
	JFrame mf;
	JPanel panel;
	JLabel menuName;
	JLabel timer = new JLabel();
	JPanel loginUp = new JPanel();
	JPanel main = new JPanel();
	JPanel sub = new JPanel();
	private ArrayList<Member> memberlist = new ArrayList<Member>();
	private ArrayList<Movie> movielist = movieDao.getMovieList();
	private ArrayList<Store> storelist = new ArrayList<Store>();
	MainPanel mp = this;
	JButton home;
	JButton movie,res,store;
	public MainPanel(JFrame mf){
		this.mf = mf;
		panel = this;
		Font font = new Font("gulim", Font.BOLD, 16);
		Thread time = new Thread(this);
		time.start();
		this.setBounds(0, 0, 640, 860);
		this.setLayout(null);
		this.setBackground(Color.white);
		main.setBounds(0, 0, 640, 115);
		main.setLayout(null);
		main.setBackground(Color.white);
		sub.setBounds(0, 120, 640, 655+130);
		sub.setLayout(null);
		sub.setBackground(Color.white);


		//텍스트칸
		menuName = new JLabel("");
		menuName.setBackground(Color.white);
		menuName.setFont(font);
		menuName.setLocation(135, 45);
		menuName.setSize(130, 55);
		timer.setBounds(270, 45, 80, 115);
		//로그인
		JButton login = new JButton("로그인");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,loginUp,memberDao, mp, movieDao);

			}

		});
		//회원가입
		JButton signUp = new JButton(new ImageIcon("images/cat.PNG"));
		signUp.setLocation(120, 0);
		signUp.setSize(100, 40);  
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUp(memberlist, memberDao);

			}

		});

		//<선 레이아웃>1
		JButton line = new JButton("");
		line.setLocation(20, 110);
		line.setSize(580, 5);

		//영화, 예매, 스토어 버튼
		movie = new JButton("영화");
		movie.setLocation(40, 0);
		movie.setSize(160, 55);
		movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MovieMenu m = new MovieMenu(movielist,mp);
				panel.removeAll();
				panel.add(main);
				panel.add(m);
				menuName.setText("영화");
				panel.repaint();

			}

		});

		res = new JButton("예매");
		res.setLocation(40+190, 0);
		res.setSize(160, 55); 

		res.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(memberDao.getLoginMember() != null){
					ResMenu m = new ResMenu(movielist,mp);
					panel.removeAll();
					panel.add(main);
					panel.add(m);
					menuName.setText("예매");
					panel.repaint();
				}

			}

		});

		store = new JButton("스토어");
		store.setLocation(40+190+190, 0);
		store.setSize(160, 55); 
		store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StoreMenu m = new StoreMenu(storelist,mp);
				panel.removeAll();
				panel.add(main);
				panel.add(m);
				menuName.setText("스토어");
				panel.repaint();

			}

		});

		//<선 레이아웃>2
		JButton line1 = new JButton("");
		line1.setLocation(20, 55+5);
		line1.setSize(580, 5);

		//메인화면 포스터
		JPanel poster = new JPanel();
		poster.setLocation(10, 15+55);
		poster.setSize(580, 295);
		poster.setLayout(null);
		poster.setBackground(Color.WHITE);
		for(int i = 0; i < 3;i++){
			try{
				Image originImg = movielist.get(i).getPoster().getImage(); 
				Image changedImg= originImg.getScaledInstance(180, 220, Image.SCALE_SMOOTH );
				ImageIcon Icon = new ImageIcon(changedImg);
				JLabel posterl = new JLabel(Icon);
				posterl.setBounds(0+(i*10)+(i*190), 0, 190, 295);
				poster.add(posterl);
			}catch(IndexOutOfBoundsException e){

			}
		}

		//<선 레이아웃>3
		JButton line2 = new JButton("");
		line2.setLocation(20, 295+15+10+55);
		line2.setSize(580, 5); 

		//메인화면 스토어
		JPanel storeMenu = new JPanel();
		storeMenu.setLocation(30, 295+15+10+5+10+55);
		storeMenu.setSize(560, 250);

		//뒤로가기 버튼
		home = new JButton("home");
		home.setLocation(45, 45);
		home.setSize(80, 55);  
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(main);
				panel.add(sub);
				menuName.setText("");
				panel.repaint();

			}

		});


		loginUp.setBounds(350, 55, 220, 40);
		loginUp.setBackground(Color.white);
		loginUp.setLayout(null);
		loginUp.setOpaque(false);

		main.add(line);
		main.add(timer);
		sub.add(line1);
		if(memberDao.getLoginMember() != null)
		{

			System.out.println("자동로그인");
			JLabel idLabel = new JLabel(memberDao.getLoginMember().getUserId() + "님");
			idLabel.setBounds(0, 0, 100, 40);
			idLabel.setFont(new Font("gulim",font.BOLD,18));
			JButton myPage = new JButton("마이페이지");
			myPage.setBounds(110, 0, 100, 40);
			myPage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new MyPage(memberDao.getLoginMember().getUserId(),memberDao.getLoginMember().getUserPwd(),memberDao,mp, movieDao);
				}
			});
			loginUp.add(idLabel);
			loginUp.add(myPage);
		}
		else
		{
			loginUp = LoginUp();
			//			loginUp.add(login);
			//			loginUp.add(signUp);
		}
		main.add(loginUp);
		main.add(home);
		main.add(menuName);
		sub.add(movie);
		sub.add(res);
		sub.add(store);
		sub.add(poster);
		sub.add(storeMenu);
		sub.add(line2);
		this.add(main);
		this.add(sub);
	}

	public MemberDao getMemberDao(){
		return memberDao;
	}
	public MovieDao getMovieDao(){
		return movieDao;
	}
	public JPanel LoginUp(){
		JPanel loginUp = new JPanel();
		loginUp.setBounds(350, 55, 220, 40);
		loginUp.setBackground(Color.white);
		loginUp.setLayout(null);
		loginUp.setOpaque(false);
		//로그인
		JButton login = new JButton("로그인");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,loginUp,memberDao, mp, movieDao);

			}

		});
		//회원가입
		JButton signUp = new JButton(new ImageIcon("images/cat.PNG"));
		signUp.setLocation(120, 0);
		signUp.setSize(100, 40);  
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUp(memberlist, memberDao);

			}

		});
		loginUp.add(login);
		loginUp.add(signUp);
		return loginUp;
	}

	@Override
	public void run() {
		while(true){
			try {
				Calendar c = Calendar.getInstance(); 
				int hour = c.get(Calendar.HOUR_OF_DAY); 
				int min = c.get(Calendar.MINUTE); 
				int second = c.get(Calendar.SECOND); 
				String clockText = Integer.toString(hour); 
				clockText = clockText.concat(":"); 
				clockText = clockText.concat((min < 10) ? "0" + Integer.toString(min) : Integer.toString(min)); 
				clockText = clockText.concat(":"); 
				clockText = clockText.concat((second < 10) ? "0" + Integer.toString(second) : Integer.toString(second)); 
				timer.setText(clockText);
				for(int i = 0; i < memberDao.getLoginMember().getM1().size(); i++){
					String temp = memberDao.getLoginMember().getM1().get(i).getTheater().getTime2();
					System.out.println(temp);
					if(memberDao.getLoginMember().getM1().get(i).isAlarm()){
						if(temp.equals(timer.getText().substring(0, 5))){
							JOptionPane.showMessageDialog(null, memberDao.getLoginMember().getM1().get(i).getName()+"영화 상영시간입니다");
							memberDao.getLoginMember().getM1().get(i).setAlarm(1);
						}
					}
				}





				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (NullPointerException e1) {

			}
		}

	}



}
