package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	JFrame jf = this;
	public SignUp(){
		//2.회원가입
		Font pwdFont = new Font("gulim", Font.BOLD, 15);
		Font pwdFont2 = new Font("gulim", Font.BOLD, 15);
		Font idFont = new Font("gulim", Font.BOLD, 16);
		this.setSize(640,860);
		this.setLayout(null);
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 640, 860);
		jp.setLayout(null);
		jp.setBackground(Color.white);
		//뒤로가기 버튼
		JButton btn = new JButton("<");
		btn.setLocation(45, 45);
		btn.setSize(55, 55); 
		/*
		JButton btn1 = new JButton("아이디입력");
		btn1.setLocation(80, 135);
		btn1.setSize(460, 55); 
*/
		JPanel userId = new JPanel();
		userId.setBackground(Color.white);
		userId.setBounds(80, 135, 460, 55);
		userId.setLayout(null);
		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setBounds(0, 0, 70, 55);
		idLabel.setFont(idFont);
		JTextField idTxt = new JTextField(20);
		idTxt.setBounds(80, 10, 380, 35);
		idTxt.setFont(idFont);
		userId.add(idLabel);
		userId.add(idTxt);
		
		
		JButton btn2 = new JButton("중복검사 확인칸");
		btn2.setLocation(80, 195);
		btn2.setSize(230, 35); 
/*
		JButton btn3 = new JButton("비밀번호입력");
		btn3.setLocation(80, 240);
		btn3.setSize(460, 55); 
*/
		JPanel userPwd = new JPanel();
		userPwd.setBackground(Color.white);
		userPwd.setBounds(80, 240, 460, 55);
		userPwd.setLayout(null);
		JLabel pwdLabel = new JLabel("비밀번호 : ");
		pwdLabel.setBounds(0, 0, 80, 55);
		pwdLabel.setFont(pwdFont);
		JPasswordField pwdTxt = new JPasswordField(16);
		pwdTxt.setBounds(80, 10, 380, 35);
		userPwd.add(pwdLabel);
		userPwd.add(pwdTxt);
		
		/*JButton btn4 = new JButton("비밀번호재확인");
		btn4.setLocation(80, 300);
		btn4.setSize(460, 55);*/ 

		JPanel userPwd2 = new JPanel();
		userPwd2.setBackground(Color.white);
		userPwd2.setBounds(80, 300, 460, 55);
		userPwd2.setLayout(null);
		JLabel pwdLabel2 = new JLabel("확    인 : ");
		pwdLabel2.setBounds(0, 0, 80, 55);
		pwdLabel2.setFont(pwdFont2);
		JPasswordField pwdTxt2 = new JPasswordField(16);
		pwdTxt2.setBounds(80, 10, 380, 35);
		userPwd2.add(pwdLabel2);
		userPwd2.add(pwdTxt2);
		
		JButton btn5 = new JButton("이름입력");
		btn5.setLocation(80, 365);
		btn5.setSize(460, 55); 

		JButton btn6 = new JButton("성별");
		btn6.setLocation(80, 430);
		btn6.setSize(460, 55);

		JButton btn7 = new JButton("생년월일입력");
		btn7.setLocation(80, 495);
		btn7.setSize(460, 55);

		JButton btn8 = new JButton("휴대폰번호 입력");
		btn8.setLocation(80, 560);
		btn8.setSize(460, 55);

		JButton btn9 = new JButton("이메일주소 입력");
		btn9.setLocation(80, 625);
		btn9.setSize(460, 55);

		JButton btn10 = new JButton("회원가입버튼");
		btn10.setLocation(65, 705);
		btn10.setSize(490, 65);
		btn10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);

			}

		});
		JButton btn11 = new JButton("회원가입");
		btn11.setLocation(120, 45);
		btn11.setSize(130, 55); 
		
		//선레이아웃
		JButton btn12 = new JButton("");
		btn12.setLocation(20, 110);
		btn12.setSize(580, 5);
		jp.add(btn);
		jp.add(userId);
		jp.add(btn2);
		jp.add(userPwd);
		jp.add(userPwd2);
		jp.add(btn5);
		jp.add(btn6);
		jp.add(btn7);
		jp.add(btn8);
		jp.add(btn9);
		jp.add(btn10);
		jp.add(btn11);
		jp.add(btn12);
		this.add(jp);
		this.setVisible(true);
	}
}
