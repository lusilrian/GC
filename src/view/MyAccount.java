package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dao.MemberDao;
import model.vo.Member;

public class MyAccount extends JPanel
{
	private MemberDao md = new MemberDao();
	JFrame mf;
	JPanel panel; 
	ArrayList<Member> list = new ArrayList<Member>();

	public MyAccount(JFrame mf, String getId, String getPwd)
	{
		list.addAll(md.myAccount(getId, getPwd));

		this.mf = mf;
		panel = this;
		this.setBounds(0, 0, 640, 860);
		this.setLayout(null);
		panel.setBounds(0, 0, 640, 860);
		panel.setLayout(null);
		panel.setBackground(Color.white);

		JLabel userId = new JLabel(this.list.get(0).getUserId() + " 님");
		userId.setLocation(270, 150);
		userId.setSize(300, 40);
		userId.setFont(new Font("gulim", Font.BOLD, 20));

		JLabel line = new JLabel(new ImageIcon("images/line_img.png"));
		line.setLocation(20, 110);
		line.setSize(580, 5);
		//메뉴이름
		JLabel myAccount = new JLabel("내정보관리");
		myAccount.setLocation(120, 45);
		myAccount.setSize(130, 55);
		//뒤로가기 버튼
		JLabel btn2 = new JLabel(new ImageIcon("images/btn_뒤로가기.png"));
		btn2.setLocation(45, 45);
		btn2.setSize(55, 55); 
		btn2.setBackground(Color.white);

		//이름 표시
		JTextField name = new JTextField(this.list.get(0).getName());
		name.setEditable(false);
		name.setLocation(70, 230);
		name.setSize(480, 55);
		name.setBackground(Color.white); 

		//생일 표시
		JTextField birth = new JTextField(this.list.get(0).getBirthDay().substring(0, 6));
		birth.setEditable(false);
		birth.setLocation(70, 285);
		birth.setSize(480, 55);
		birth.setBackground(Color.white);

		//휴대폰 번호 표시
		String setPhone = this.list.get(0).getPhoneNumber();
		JTextField phone = new JTextField(this.list.get(0).getPhoneNumber());
		phone.setLocation(70, 335);
		phone.setSize(480, 55);
		phone.setBackground(Color.white);
		phone.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				phone.setText("");
			}
			/*@Override
			public void mouseExited(MouseEvent e)
			{
				phone.setText(setPhone);
			}*/
		});

		//이메일 표시
		JTextField email = new JTextField(md.myAccount(getId, getPwd).get(0).getEmail());
		email.setLocation(70, 390);
		email.setSize(480, 55);
		email.setBackground(Color.WHITE);
		email.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				email.setText("");
			}
			/*@Override
			public void mouseExited(MouseEvent e)
			{
				email.setText("이메일주소");
			}*/
		});

		//비밀번호 변경
		JTextField setPassword = new JTextField("변경할 비밀번호");
		setPassword.setLocation(70, 445);
		setPassword.setSize(480, 55); 
		setPassword.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				setPassword.setText("");
			}
			/*@Override
			public void mouseExited(MouseEvent e)
			{
				setPassword.setText("변경할 비밀번호");
			}*/
		});

		//취소 버튼
		JLabel cancle = new JLabel(new ImageIcon("images/btn_취소2.PNG"));
		cancle.setLocation(155, 580);
		cancle.setSize(150, 55);
		cancle.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});
		
		//수정 버튼
		JLabel apply = new JLabel(new ImageIcon("images/btn_수정.PNG"));
		apply.setLocation(305, 580);
		apply.setSize(150, 55);
		apply.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				list.get(0).setPhoneNumber(phone.getText());
				list.get(0).setEmail(email.getText());
				list.get(0).setUserPwd(setPassword.getText());
				md.modifyAccount(list);
				
				ChangePanel c = new ChangePanel(mf, panel);
				MainPanel m = new MainPanel(mf);
				c.change(m);
			}
		});


		panel.add(userId);
		panel.add(line);
		panel.add(myAccount);
		panel.add(btn2);
		panel.add(name);
		panel.add(birth);
		panel.add(phone);
		panel.add(email);
		panel.add(setPassword);
		panel.add(cancle);
		panel.add(apply);

		this.mf.add(panel);
		this.setVisible(true);
	}
}