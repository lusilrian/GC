package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.dao.MemberDao;
import model.dao.MovieDao;



public class MyPage extends JFrame {
	JFrame jf = this;
	public MyPage(String Id,String password,MemberDao md, MainPanel mp, MovieDao mvd) {
		// <���>
		Font pwdFont = new Font("gulim", Font.BOLD, 15);
		Font pwdFont2 = new Font("gulim", Font.BOLD, 15);
		Font font = new Font("gulim", Font.BOLD, 16);
		this.setSize(640, 860);
		this.setLayout(null);
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 640, 860);
		jp.setLayout(null);
		jp.setBackground(Color.white);

		// <�� ���̾ƿ�>
		JButton btn = new JButton("");
		btn.setLocation(20, 110);
		btn.setSize(580, 5);
		JButton btn2 = new JButton("");
		btn2.setLocation(20, 460-110);
		btn2.setSize(580, 5);

		// �޴��̸�
		JButton btn7 = new JButton("����������");
		btn7.setLocation(120, 45);
		btn7.setSize(130, 55);

		// �α׾ƿ�
		JButton btn8 = new JButton("�α׾ƿ�");
		btn8.setLocation(455, 55);
		btn8.setSize(100, 40);
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				md.getLoginMember().setAutoLoginCheck(false);
				md.setLoginMember(null);
				md.fileSave();
				mp.loginUp.removeAll();
				mp.loginUp = mp.LoginUp();
				mp.main.add(mp.loginUp);
				mp.repaint();
				jf.dispose();
			}
		});
		
		

		JButton auto = new JButton("�ڵ��α���");
		auto.setLocation(345, 55);
		auto.setSize(100, 40);
		auto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				md.getLoginMember().setAutoLoginCheck(true);
				md.fileSave();
			}
		});

		// �ι��̹��� ����
		JButton btn9 = new JButton("�ι� �̹��� ����");
		btn9.setLocation(115, 240-110);
		btn9.setSize(185, 185);

		// ���̵� ����
		JButton btn10 = new JButton(Id);
		btn10.setLocation(315, 305-110);
		btn10.setSize(190, 60);


		// ���ų���
		JButton btn11 = new JButton("���ų���");
		btn11.setLocation(110, 500-110);
		btn11.setSize(400, 55);
		btn11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PayInfo(md,1, mvd);
			}
		});
		
		
		

		// ����������
		JButton btn12 = new JButton("����������");
		btn12.setLocation(110, 570-110);
		btn12.setSize(400, 55);
		btn12.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MyAccount m = new MyAccount(jf, Id, password,md);
				jp.removeAll();
				jp.add(m);
				jp.repaint();
			}
		});

		this.add(jp);
		jp.add(btn);
		jp.add(btn2);
		jp.add(auto);
		jp.add(btn7);
		jp.add(btn8);
		jp.add(btn9);
		jp.add(btn10);
		jp.add(btn11);
		jp.add(btn12);


		this.setVisible(true);
	}
}