package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.MemberDao;
import model.dao.MovieDao;
import model.vo.Member;
import model.vo.Movie;
import model.vo.Store;

public class MainPanel extends JPanel {
	MovieDao movieDao = new MovieDao();
	MemberDao memberDao = new MemberDao();
	JFrame mf;
	JPanel panel;
	JLabel menuName;

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

		this.setBounds(0, 0, 640, 860);
		this.setLayout(null);
		this.setBackground(Color.white);
		main.setBounds(0, 0, 640, 115);
		main.setLayout(null);
		main.setBackground(Color.white);
		sub.setBounds(0, 120, 640, 655+130);
		sub.setLayout(null);
		sub.setBackground(Color.white);


		//�ؽ�Ʈĭ
		menuName = new JLabel("");
		menuName.setBackground(Color.white);
		menuName.setFont(font);
		menuName.setLocation(135, 45);
		menuName.setSize(130, 55);

		//�α���
		JButton login = new JButton("�α���");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,loginUp,memberDao, mp);

			}

		});
		//ȸ������
		JButton signUp = new JButton(new ImageIcon("images/cat.PNG"));
		signUp.setLocation(120, 0);
		signUp.setSize(100, 40);  
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUp(memberlist, memberDao);

			}

		});

		//<�� ���̾ƿ�>1
		JButton line = new JButton("");
		line.setLocation(20, 110);
		line.setSize(580, 5);

		//��ȭ, ����, ����� ��ư
		movie = new JButton("��ȭ");
		movie.setLocation(40, 0);
		movie.setSize(160, 55);
		movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MovieMenu m = new MovieMenu(movielist,mp);
				panel.removeAll();
				panel.add(main);
				panel.add(m);
				menuName.setText("��ȭ");
				panel.repaint();

			}

		});

		res = new JButton("����");
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
					menuName.setText("����");
					panel.repaint();
				}

			}

		});

		store = new JButton("�����");
		store.setLocation(40+190+190, 0);
		store.setSize(160, 55); 
		store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StoreMenu m = new StoreMenu(storelist,mp);
				panel.removeAll();
				panel.add(main);
				panel.add(m);
				menuName.setText("�����");
				panel.repaint();

			}

		});

		//<�� ���̾ƿ�>2
		JButton line1 = new JButton("");
		line1.setLocation(20, 55+5);
		line1.setSize(580, 5);

		//����ȭ�� ������
		JPanel poster = new JPanel();
		poster.setLocation(10, 15+55);
		poster.setSize(580, 295);
		poster.setLayout(null);
		poster.setBackground(Color.WHITE);
		for(int i = 0; i < 3;i++){
			Image originImg = movielist.get(i).getPoster().getImage(); 
			Image changedImg= originImg.getScaledInstance(180, 220, Image.SCALE_SMOOTH );
			ImageIcon Icon = new ImageIcon(changedImg);
			JLabel posterl = new JLabel(Icon);
			posterl.setBounds(0+(i*10)+(i*190), 0, 190, 295);
			poster.add(posterl);
		}

		//<�� ���̾ƿ�>3
		JButton line2 = new JButton("");
		line2.setLocation(20, 295+15+10+55);
		line2.setSize(580, 5); 

		//����ȭ�� �����
		JPanel storeMenu = new JPanel();
		storeMenu.setLocation(30, 295+15+10+5+10+55);
		storeMenu.setSize(560, 250);

		//�ڷΰ��� ��ư
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
		sub.add(line1);
		if(memberDao.getLoginMember() != null)
		{

			System.out.println("�ڵ��α���");
			JLabel idLabel = new JLabel(memberDao.getLoginMember().getUserId() + "��");
			idLabel.setBounds(0, 0, 100, 40);
			idLabel.setFont(new Font("gulim",font.BOLD,18));
			JButton myPage = new JButton("����������");
			myPage.setBounds(110, 0, 100, 40);
			myPage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new MyPage(memberDao.getLoginMember().getUserId(),memberDao.getLoginMember().getUserPwd(),memberDao,mp);
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

	public JPanel LoginUp(){
		JPanel loginUp = new JPanel();
		loginUp.setBounds(350, 55, 220, 40);
		loginUp.setBackground(Color.white);
		loginUp.setLayout(null);
		loginUp.setOpaque(false);
		//�α���
		JButton login = new JButton("�α���");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,loginUp,memberDao, mp);

			}

		});
		//ȸ������
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
}
