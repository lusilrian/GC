package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;

import model.dao.MemberDao;

public class Login extends JFrame {
	JFrame mf;
	JPanel panel;
	JFrame a = this;

	public Login(JFrame mf2, JPanel panel2, MemberDao md){

		this.mf = mf2;
		this.panel = panel2;
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
		JPasswordField pwdTxt = new JPasswordField(16);
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
			public void mouseClicked(MouseEvent e)
			{
				String password = "";
				char[] pass = pwdTxt.getPassword();

				for(int i=0; i<pass.length; i++)
				{
					password += pass[i];
				}
				if(md.overlapId(nameTxt.getText()) == false || md.overlapPwd(password) == false)
				{
					JDialog dialog = new JDialog();

					dialog.setLayout(null);

					JLabel overlap = new JLabel("아이디 또는 비밀번호를 다시 확인하세요!");
					JButton overlapBtn = new JButton("확인");

					overlap.setBounds(25, 20, 250, 30);
					overlapBtn.setBounds(100, 60, 75, 35);
					dialog.add(overlapBtn);
					dialog.add(overlap);
					dialog.setBounds(250, 150, 300, 150);
					dialog.setVisible(true);

					overlapBtn.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{

							dialog.dispose();

						}
					});
				}
				else
				{
					panel.removeAll();
					panel2.setBounds(350, 55, 220, 40);
					panel2.setBackground(Color.white);

					JPanel sdf = new JPanel();

					sdf.setBounds(0, 0, 220, 40);
					sdf.setLayout(null);
					sdf.setBackground(Color.white);
					JLabel idLabel = new JLabel(nameTxt.getText() + "��");
					idLabel.setBounds(0, 0, 100, 40);
					idLabel.setFont(new Font("gulim",font.BOLD,18));
					JButton myPage = new JButton("����������");
					myPage.setBounds(110, 0, 100, 40);
					sdf.add(idLabel);
					sdf.add(myPage);
					panel.add(sdf);

					mf.repaint();
					a.dispose();

				}
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
