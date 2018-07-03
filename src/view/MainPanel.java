package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private boolean bLogin = false;
	private JPanel panel2 = new JPanel();
	private MainPanel mp = this;
	public MainPanel(JFrame mf){
		this.mf = mf;
		panel = this;

		//<선 레이아웃>
		this.setBounds(0, 0, 640, 860);
		this.setLayout(null);
		this.setBackground(Color.white);

		JButton btn = new JButton("");
		btn.setLocation(20, 110);
		btn.setSize(580, 5);
		JButton btn1 = new JButton("");
		btn1.setLocation(20, 200);
		btn1.setSize(580, 5);
		JButton btn2 = new JButton("");
		btn2.setLocation(20, 520);
		btn2.setSize(580, 5); 

		//영화, 예매, 스토어 버튼
		JButton btn3 = new JButton("");
		btn3.setLocation(40, 130);
		btn3.setSize(160, 55); 
		JButton btn4 = new JButton("");
		btn4.setLocation(40+190, 130);
		btn4.setSize(160, 55); 
		JButton btn5 = new JButton("");
		btn5.setLocation(40+190+190, 130);
		btn5.setSize(160, 55); 

		//메인화면 포스터
		JButton btn6 = new JButton("");
		btn6.setLocation(30, 215);
		btn6.setSize(560, 295);

		//메인화면 스토어
		JButton btn7 = new JButton("");
		btn7.setLocation(30, 535);
		btn7.setSize(560, 250); 

		//로그인
		JButton login = new JButton("로그인");
		login.setLocation(0, 0);
		login.setSize(100, 40); 

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login(mf,panel2,mp);

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
		//뒤로가기 버튼
		JButton btn10 = new JButton("<");
		btn10.setLocation(45, 45);
		btn10.setSize(55, 55);  

		//텍스트칸
		JButton btn11 = new JButton("텍스트");
		btn11.setLocation(120, 45);
		btn11.setSize(130, 55);
		panel2.setBounds(350, 55, 220, 40);
		panel2.setBackground(Color.white);
		panel2.setLayout(null);
		panel2.add(login);
		panel2.add(signUp);
		this.add(btn);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(panel2);
		//		this.add(login);
		//		this.add(signUp);
		this.add(btn10);
		this.add(btn11);
	}

	public void setLogin(boolean b){
		this.bLogin = b;
	}

	public boolean getLogin(){
		return bLogin;
	}
}
