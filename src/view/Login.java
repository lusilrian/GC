package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Login extends JFrame {
	JFrame mf;
	JPanel panel;
	JFrame a = this;
	MainPanel mp;
	public Login(JFrame mf2, JPanel panel2, MainPanel mp){
		this.mf = mf2;
		this.panel = panel2;
		this.mp = mp;
		this.setSize(420, 600);
		this.setLayout(null);
		JPanel p = new JPanel();
		p.setSize(420, 600);
		p.setBackground(Color.WHITE);
		p.setLayout(null);
		Font pwdFont = new Font("gulim", Font.BOLD, 15);
		Font pwdFont2 = new Font("gulim", Font.BOLD, 15);
		Font font = new Font("gulim", Font.BOLD, 16);
			//1.로그인
		//로그인화면
		//GC Cinema 로고
		JButton btn = new JButton("GC Cinema");
		btn.setLocation(120, 40);
		btn.setSize(160, 160);
/*
		//아이디입력칸
		JButton btn1 = new JButton("아이디 입력");
		btn1.setLocation(65, 220);
		btn1.setSize(270, 50);
		*/
		JPanel userName = new JPanel();
		userName.setBackground(Color.white);
		userName.setBounds(65, 220, 270, 50);
		userName.setLayout(null);
		JLabel nameLabel = new JLabel("아 이 디  ");
		nameLabel.setBounds(0, 0, 80, 50);
		nameLabel.setFont(pwdFont);
		JTextField nameTxt = new JTextField(16);
		nameTxt.setBounds(80, 10, 270-80, 35);
		nameTxt.setFont(font);
		userName.add(nameLabel);
		userName.add(nameTxt);
		
		
		//비밀번호입력칸
		/*JButton btn2 = new JButton("비밀번호 입력");
		btn2.setLocation(65, 280);
		btn2.setSize(270, 50);
		*/
		JPanel userPwd = new JPanel();
		userPwd.setBackground(Color.white);
		userPwd.setBounds(65, 280, 270, 50);
		userPwd.setLayout(null);
		JLabel pwdLabel = new JLabel("비밀번호  ");
		pwdLabel.setBounds(0, 0, 80, 50);
		pwdLabel.setFont(pwdFont);
		JTextField pwdTxt = new JTextField(16);
		pwdTxt.setBounds(80, 10, 270-80, 35);
		pwdTxt.setFont(font);
		userPwd.add(pwdLabel);
		userPwd.add(pwdTxt);
		
		//자동로그인
		/*JButton btn3 = new JButton("자동로그인");
		btn3.setLocation(65, 340);
		btn3.setSize(100, 30); */
		
		JCheckBox jc = new JCheckBox("자동 로그인");
		jc.setBounds(65, 340, 116, 30);
		jc.setBackground(Color.white);
		jc.setFont(font);
		//로그인버튼
		JButton btn4 = new JButton("로그인");
		btn4.setLocation(88, 400);
		btn4.setSize(230, 40); 
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel2.setBounds(350, 55, 220, 40);
				panel2.setBackground(Color.white);
				JButton sdf = new JButton("로그인됨");
				sdf.setBounds(0, 0, 220, 40);
				panel.add(sdf);
				mp.setLogin(true);
				mf.repaint();
				System.out.println(mp.getLogin());
				a.setVisible(false);
			}
			
		});
		
		p.add(btn);
		p.add(userName);
		p.add(userPwd);
		p.add(jc);
		p.add(btn4);
		this.add(p);
		this.setVisible(true);
		
	}
}
