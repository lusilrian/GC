package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dao.MemberDao;
import model.vo.Member;

public class SignUp extends JFrame
{
	MemberDao md = new MemberDao();
	JFrame jf = this;

	ArrayList<Member> list;
	MemberDao md = new MemberDao();
	public SignUp(ArrayList<Member> list){
		this.list = list;

		//폰트설정
		Font pwdFont = new Font("gulim", Font.BOLD, 15);
		Font pwdFont2 = new Font("gulim", Font.BOLD, 15);
		Font font = new Font("gulim", Font.BOLD, 16);
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

		//아이디
		JPanel userId = new JPanel();
		userId.setBackground(Color.white);
		userId.setBounds(80, 135, 460, 55);
		userId.setLayout(null);
		JLabel idLabel = new JLabel("아이디  ");
		idLabel.setBounds(0, 0, 70, 55);
		idLabel.setFont(font);
		JTextField idTxt = new JTextField(20);
		idTxt.setBounds(80, 10, 380, 35);
		idTxt.setFont(font);
		userId.add(idLabel);
		userId.add(idTxt);


		JButton btn2 = new JButton("중복검사 확인칸");
		btn2.setLocation(80, 195);

		btn2.setSize(230, 35); 

		btn2.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				//회원가입할 아이디가 사전에 등록된 회원의 아이디와 동일할 경우 true가 리턴 된다.
				if(md.overlapId(idTxt.getText()) == true)
				{
					JDialog dialog = new JDialog();

					dialog.setLayout(null);

					JLabel overlap = new JLabel("이미 존재하는 아이디입니다.");
					JButton overlapBtn = new JButton("확인");

					overlap.setBounds(60, 20, 250, 30);
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
				if(md.overlapId(idTxt.getText()) == false)
				{
					JDialog dialog = new JDialog();

					dialog.setLayout(null);

					JLabel overlap = new JLabel("사용 가능한 아이디입니다.");
					JButton overlapBtn = new JButton("확인");

					overlap.setBounds(60, 20, 250, 30);
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

				}
			}
		});

		

		//비밀번호
		JPanel userPwd = new JPanel();
		userPwd.setBackground(Color.white);
		userPwd.setBounds(80, 240, 460, 55);
		userPwd.setLayout(null);
		JLabel pwdLabel = new JLabel("비밀번호  ");
		pwdLabel.setBounds(0, 0, 80, 55);
		pwdLabel.setFont(pwdFont);
		JPasswordField pwdTxt = new JPasswordField(20);
		pwdTxt.setBounds(80, 10, 380, 35);
		userPwd.add(pwdLabel);
		userPwd.add(pwdTxt);

		//비밀번호 확인
		JPanel userPwd2 = new JPanel();
		userPwd2.setBackground(Color.white);
		userPwd2.setBounds(80, 300, 460, 55);
		userPwd2.setLayout(null);
		JLabel pwdLabel2 = new JLabel("확    인  ");
		pwdLabel2.setBounds(0, 0, 80, 55);
		pwdLabel2.setFont(pwdFont2);
		JPasswordField pwdTxt2 = new JPasswordField(20);
		pwdTxt2.setBounds(80, 10, 380, 35);
		userPwd2.add(pwdLabel2);
		userPwd2.add(pwdTxt2);

		//이름
		JPanel userName = new JPanel();
		userName.setBackground(Color.white);
		userName.setBounds(80, 365, 460, 55);
		userName.setLayout(null);
		JLabel nameLabel = new JLabel("이    름  ");
		nameLabel.setBounds(0, 0, 80, 55);
		nameLabel.setFont(pwdFont);
		JTextField nameTxt = new JTextField(16);
		nameTxt.setBounds(80, 10, 380, 35);
		nameTxt.setFont(font);
		userName.add(nameLabel);
		userName.add(nameTxt);

		//주민등록 번호
		JPanel userNum = new JPanel();
		userNum.setBackground(Color.white);
		userNum.setBounds(80, 430, 460, 55);
		userNum.setLayout(null);
		JLabel numLabel = new JLabel("주민등록");
		JLabel numLabel2 = new JLabel("번     호  ");
		numLabel.setBounds(0, 0, 80, 25);
		numLabel.setFont(new Font("gulim", Font.BOLD, 15));
		numLabel2.setBounds(0, 23, 80, 25);
		numLabel2.setFont(new Font("gulim", Font.BOLD, 15));
		JTextField numTxt = new JTextField(16);
		numTxt.setBounds(80, 10, 170, 35);
		numTxt.setFont(font);
		JLabel numLabel3 = new JLabel("-");
		numLabel3.setBounds(80+170, 0, 40, 55);
		numLabel3.setFont(new Font("gulim", 1, 55));
		JTextField numTxt2 = new JTextField(16);
		numTxt2.setBounds(80+210, 10, 170, 35);
		numTxt2.setFont(font);
		userNum.add(numLabel);
		userNum.add(numLabel2);
		userNum.add(numTxt);
		userNum.add(numLabel3);
		userNum.add(numTxt2);


		//휴대폰번호
		JPanel userPhone = new JPanel();
		userPhone.setBackground(Color.white);
		userPhone.setBounds(80, 495, 460, 55);
		userPhone.setLayout(null);
		JLabel phoneLabel = new JLabel("휴 대 폰");
		JLabel phoneLabel2 = new JLabel("번     호  ");
		phoneLabel.setBounds(0, 0, 80, 25);
		phoneLabel.setFont(new Font("gulim", Font.BOLD, 15));
		phoneLabel2.setBounds(0, 23, 80, 25);
		phoneLabel2.setFont(new Font("gulim", Font.BOLD, 15));
		JTextField phoneTxt = new JTextField(16);
		phoneTxt.setBounds(80, 10, 380, 35);
		phoneTxt.setFont(font);
		userPhone.add(phoneLabel);
		userPhone.add(phoneLabel2);
		userPhone.add(phoneTxt);


		//이메일주소
		JPanel userMail = new JPanel();
		userMail.setBackground(Color.white);
		userMail.setBounds(80, 570, 460, 55);
		userMail.setLayout(null);
		JLabel mailLabel = new JLabel("이 메 일");
		JLabel mailLabel2 = new JLabel("주     소  ");
		mailLabel.setBounds(0, 0, 80, 25);
		mailLabel.setFont(new Font("gulim", Font.BOLD, 15));
		mailLabel2.setBounds(0, 23, 80, 25);
		mailLabel2.setFont(new Font("gulim", Font.BOLD, 15));
		JTextField mailTxt = new JTextField(16);
		mailTxt.setBounds(80, 10, 380, 35);
		mailTxt.setFont(font);
		userMail.add(mailLabel);
		userMail.add(mailLabel2);
		userMail.add(mailTxt);

		JButton btn10 = new JButton("회원가입버튼");
		btn10.setLocation(65, 705);
		btn10.setSize(490, 65);
		btn10.addMouseListener(new MouseAdapter()
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
				
				String password2 = "";
				char[] pass2 = pwdTxt2.getPassword();
				
				for(int i=0; i<pass2.length; i++)
				{
					password2 += pass2[i];
				}

				System.out.println(password);
				System.out.println(password2);
				
				if(md.overlapId(idTxt.getText()))
				{
					System.out.println("아이디 중복이야!");
				}
				else if(!password.equals(password2))
				{
					System.out.println("비밀번호가 달라!");
				}
				else if(!(numTxt2.getText().charAt(0) >= '1' && numTxt2.getText().charAt(0) <= '4'))
				{
					System.out.println("1~4가 아니야!");
				}
				else
				{
					Member m = new Member(idTxt.getText(), password, nameTxt.getText(), (numTxt.getText() + "-" + numTxt2.getText()), numTxt2.getText().substring(0), phoneTxt.getText(), mailTxt.getText());
					md.signUp(m);

					jf.dispose();

				}
			}
		});
		JButton btn11 = new JButton("회원가입");
		btn11.setLocation(120, 45);
		btn11.setSize(130, 55); 

		//선레이아웃
		JButton btn12 = new JButton("");
		btn12.setLocation(20, 110);
		btn12.setSize(580, 5);

		JButton btn13 = new JButton("");
		btn13.setLocation(20, 570+20+55+20);
		btn13.setSize(580, 5);

		jp.add(btn);
		jp.add(userId);
		jp.add(btn2);
		jp.add(userPwd);
		jp.add(userPwd2);
		jp.add(userName);
		jp.add(userNum);
		jp.add(userPhone);
		jp.add(userMail);
		jp.add(btn10);
		jp.add(btn11);
		jp.add(btn12);
		jp.add(btn13);
		this.add(jp);
		this.setVisible(true);
	}
}
