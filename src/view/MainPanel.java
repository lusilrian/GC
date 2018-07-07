package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.dao.MovieDao;
import model.vo.Member;
import model.vo.Movie;
import model.vo.Store;


public class MainPanel extends JPanel {
	MovieDao movieDao = new MovieDao();
	JFrame mf;
	JPanel panel;
	JLabel menuName;
	private JPanel loginUp = new JPanel();
	JPanel main = new JPanel();
	JPanel sub = new JPanel();
	private ArrayList<Member> memberlist = new ArrayList<Member>();
	private ArrayList<Movie> movielist = movieDao.getMovieList();
	private ArrayList<Store> storelist = new ArrayList<Store>();
	private MainPanel mp = this;

	JButton home;
	JButton movie,res,store;

	public MainPanel(JFrame mf){
		this.mf = mf;
		panel = this;
		Font font = new Font("gulim", Font.BOLD, 16);
		
		/*movielist.add(new Movie("a",null,new ImageIcon("images/cat.PNG"),"",asdf,1));
		movielist.add(new Movie("b",null,new ImageIcon("images/dog.PNG"),"",asdf,1));
		movielist.add(new Movie("c",null,new ImageIcon("images /tiger.PNG"),"",asdf,1));
		movielist.add(new Movie("e",null,new ImageIcon("images/cat.PNG"),"",asdf,1));
		movielist.add(new Movie("f",null,new ImageIcon("images/dog.PNG"),"",asdf,1));
		movielist.add(new Movie("g",null,new ImageIcon("images/tiger.PNG"),"",asdf,1));
		movielist.add(new Movie("h",null,new ImageIcon("images/cat.PNG"),"",asdf,1));
		movielist.add(new Movie("i",null,new ImageIcon("images/dog.PNG"),"",asdf,1));
		movielist.add(new Movie("j",null,new ImageIcon("images/tiger.PNG"),"",asdf,1));
		movielist.add(new Movie("a",null,new ImageIcon("images/cat.PNG"),"",asdf,1));
		movielist.add(new Movie("b",null,new ImageIcon("images/dog.PNG"),"",asdf,1));
		movielist.add(new Movie("c",null,new ImageIcon("images/tiger.PNG"),"",asdf,1));
		movielist.add(new Movie("e",null,new ImageIcon("images/cat.PNG"),"",asdf,1));
		movielist.add(new Movie("f",null,new ImageIcon("images/dog.PNG"),"",asdf,1));
		movielist.add(new Movie("g",null,new ImageIcon("images/tiger.PNG"),"",asdf,1));
		movielist.add(new Movie("h",null,new ImageIcon("images/cat.PNG"),"",asdf,1));
		movielist.add(new Movie("i",null,new ImageIcon("images/dog.PNG"),"",asdf,1));
		movielist.add(new Movie("j",null,new ImageIcon("images/tiger.PNG"),"",asdf,1));
		*/this.setBounds(0, 0, 640, 860);
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

		//로그인
		JButton login = new JButton("로그인");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,loginUp);

			}

		});
		//회원가입
		JButton signUp = new JButton(new ImageIcon("images/cat.PNG"));
		signUp.setLocation(120, 0);
		signUp.setSize(100, 40);  
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new SignUp(memberlist);


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
				ResMenu m = new ResMenu(movielist,mp);
				panel.removeAll();
				panel.add(main);
				panel.add(m);
				menuName.setText("예매");
				panel.repaint();

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
		JButton pooster = new JButton("");
		pooster.setLocation(30, 15+55);
		pooster.setSize(560, 295);

		//<선 레이아웃>3
		JButton line2 = new JButton("");
		line2.setLocation(20, 295+15+10+55);
		line2.setSize(580, 5); 

		//메인화면 스토어
		JButton storeMenu = new JButton("");
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
		loginUp.add(login);
		loginUp.add(signUp);
		main.add(line);
		sub.add(line1);
		main.add(loginUp);
		main.add(home);
		main.add(menuName);
		sub.add(movie);
		sub.add(res);
		sub.add(store);
		sub.add(pooster);
		sub.add(storeMenu);
		sub.add(line2);
		this.add(main);
		this.add(sub);
	}


}
