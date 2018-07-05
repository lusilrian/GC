package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.MemberDao;

public class MainPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private boolean bLogin = false;
	private JPanel loginUp = new JPanel();
	private JPanel main = new JPanel();
	private JPanel sub = new JPanel();
	private MainPanel mp = this;
	
	public MainPanel(JFrame mf){
		this.mf = mf;
		panel = this;
		Font font = new Font("gulim", Font.BOLD, 16);

		this.setBounds(0, 0, 640, 860);
		this.setLayout(null);
		this.setBackground(Color.white);
		main.setBounds(0, 0, 640, 205);
		main.setLayout(null);
		main.setBackground(Color.white);
		sub.setBounds(0, 205, 640, 860-205);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		//뒤로가기 버튼
		JButton back = new JButton("<");
		back.setLocation(45, 45);
		back.setSize(55, 55);  

		//텍스트칸
		JLabel menuName = new JLabel("텍스트");
		menuName.setBackground(Color.white);
		menuName.setFont(font);
		menuName.setLocation(120, 45);
		menuName.setSize(130, 55);

		//로그인
		JButton login = new JButton("로그인");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,loginUp,mp);

			}

		});

		//회원가입
		JButton signUp = new JButton("회원가입");
		signUp.setLocation(120, 0);
		signUp.setSize(100, 40);  
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUp();

			}

		});

		//<선 레이아웃>1
		JButton line = new JButton("");
		line.setLocation(20, 110);
		line.setSize(580, 5);

		//영화, 예매, 스토어 버튼
		JButton movie = new JButton("영화");
		movie.setLocation(40, 130);
		movie.setSize(160, 55);
		movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

			}

		});
		
		JButton res = new JButton("예매");
		res.setLocation(40+190, 130);
		res.setSize(160, 55); 
		res.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		
		JButton store = new JButton("스토어");
		store.setLocation(40+190+190, 130);
		store.setSize(160, 55); 
		store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		
		//<선 레이아웃>2
		JButton line1 = new JButton("");
		line1.setLocation(20, 200);
		line1.setSize(580, 5);
		
		//메인화면 포스터
		JButton pooster = new JButton("");
		pooster.setLocation(30, 15);
		pooster.setSize(560, 295);

		//<선 레이아웃>3
		JButton line2 = new JButton("");
		line2.setLocation(20, 295+15+10);
		line2.setSize(580, 5); 

		//메인화면 스토어
		JButton storeMenu = new JButton("");
		storeMenu.setLocation(30, 295+15+10+5+10);
		storeMenu.setSize(560, 250);



		loginUp.setBounds(350, 55, 220, 40);
		loginUp.setBackground(Color.white);
		loginUp.setLayout(null);
		loginUp.add(login);
		loginUp.add(signUp);
		main.add(line);
		main.add(line1);
		main.add(movie);
		main.add(res);
		main.add(store);
		main.add(loginUp);
		main.add(back);
		main.add(menuName);
		sub.add(pooster);
		sub.add(storeMenu);
		sub.add(line2);
		this.add(main);
		this.add(sub);
	}

	public void setLogin(boolean b){
		this.bLogin = b;
	}

	public boolean getLogin(){
		return bLogin;
	}
}
