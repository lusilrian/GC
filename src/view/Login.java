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

import model.dao.MemberDao;

public class Login extends JFrame {
	JFrame mf;
	JPanel panel;
	JFrame a = this;
	MainPanel mp;
	MemberDao md = new MemberDao();
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
		//1.�α���
		//�α���ȭ��
		//GC Cinema �ΰ�
		JButton btn = new JButton("GC Cinema");
		btn.setLocation(120, 40);
		btn.setSize(160, 160);
		/*
		//���̵��Է�ĭ
		JButton btn1 = new JButton("���̵� �Է�");
		btn1.setLocation(65, 220);
		btn1.setSize(270, 50);
		 */
		JPanel userName = new JPanel();
		userName.setBackground(Color.white);
		userName.setBounds(65, 220, 270, 50);
		userName.setLayout(null);
		JLabel nameLabel = new JLabel("�� �� ��  ");
		nameLabel.setBounds(0, 0, 80, 50);
		nameLabel.setFont(pwdFont);
		JTextField nameTxt = new JTextField(16);
		nameTxt.setBounds(80, 10, 270-80, 35);
		nameTxt.setFont(font);
		userName.add(nameLabel);
		userName.add(nameTxt);


		//��й�ȣ�Է�ĭ
		/*JButton btn2 = new JButton("��й�ȣ �Է�");
		btn2.setLocation(65, 280);
		btn2.setSize(270, 50);
		 */
		JPanel userPwd = new JPanel();
		userPwd.setBackground(Color.white);
		userPwd.setBounds(65, 280, 270, 50);
		userPwd.setLayout(null);
		JLabel pwdLabel = new JLabel("��й�ȣ  ");
		pwdLabel.setBounds(0, 0, 80, 50);
		pwdLabel.setFont(pwdFont);
		JPasswordField pwdTxt = new JPasswordField(16);
		pwdTxt.setBounds(80, 10, 270-80, 35);
		pwdTxt.setFont(font);
		userPwd.add(pwdLabel);
		userPwd.add(pwdTxt);

		//�ڵ��α���
		/*JButton btn3 = new JButton("�ڵ��α���");
		btn3.setLocation(65, 340);
		btn3.setSize(100, 30); */

		JCheckBox jc = new JCheckBox("�ڵ� �α���");
		jc.setBounds(65, 340, 116, 30);
		jc.setBackground(Color.white);
		jc.setFont(font);
		//�α��ι�ư
		JButton btn4 = new JButton("�α���");
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

					JLabel overlap = new JLabel("���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ���ϼ���!");
					JButton overlapBtn = new JButton("Ȯ��");

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
							dialog.setVisible(false);
						}
					});
				}
				else
				{
					panel.removeAll();
					panel2.setBounds(350, 55, 220, 40);
					panel2.setBackground(Color.white);
					JButton sdf = new JButton("�α��ε�");
					sdf.setBounds(0, 0, 220, 40);
					panel.add(sdf);
					mp.setLogin(true);
					mf.repaint();
					System.out.println(mp.getLogin());
					sdf.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							String password = "";
							char[] pass = pwdTxt.getPassword();

							for(int i=0; i<pass.length; i++)
							{
								password += pass[i];
							}
							ChangePanel c = new ChangePanel(mf, mp);
							MyAccount m = new MyAccount(mf, nameTxt.getText(), password);
							c.change(m);
						}
					});
					a.setVisible(false);
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
