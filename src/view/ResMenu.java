package view;

import javax.swing.*;

public class ResMenu extends JPanel {
	private JPanel panel;
	public ResMenu(){
		JButton btn = new JButton("");
		btn.setLocation(20, 110);
		btn.setSize(580, 5);

		//�ڷΰ��� ��ư
		JButton btn1 = new JButton("<");
		btn1.setLocation(45, 45);
		btn1.setSize(55, 55);  

		//�޴��̸�
		JButton btn2 = new JButton("����");
		btn2.setLocation(120, 45);
		btn2.setSize(130, 55);

		//��ȭ, ����, ��¥, �ð���ư
		JButton btn3 = new JButton("��ȭ");
		btn3.setLocation(35, 130);
		btn3.setSize(125, 45); 
		JButton btn4 = new JButton("����");
		btn4.setLocation(175, 130);
		btn4.setSize(125, 45); 
		JButton btn5 = new JButton("��¥");
		btn5.setLocation(315, 130);
		btn5.setSize(125, 45); 
		JButton btn6 = new JButton("�ð�");
		btn6.setLocation(455, 130);
		btn6.setSize(125, 45); 

		//��ȭ, ����, ��¥, �ð����
		JButton btn7 = new JButton("������ ��ȭ ǥ��");
		btn7.setLocation(35, 180);
		btn7.setSize(125, 150); 
		JButton btn8 = new JButton("������ ���� ǥ��");
		btn8.setLocation(175, 180);
		btn8.setSize(125, 150); 
		JButton btn9 = new JButton("������ ��¥ ǥ��");
		btn9.setLocation(315, 180);
		btn9.setSize(125, 150); 
		JButton btn10 = new JButton("������ �ð� ǥ��");
		btn10.setLocation(455, 180);
		btn10.setSize(125, 150); 

		//���� �ʱ�ȭ ��ư
		JButton btn11 = new JButton("���� �ʱ�ȭ");
		btn11.setLocation(55, 345);
		btn11.setSize(510, 45); 

		//�� ��ȭ ���
		JButton btn12 = new JButton("Ŭ���� �� �׸� ���ǥ��");
		btn12.setLocation(40, 405);
		btn12.setSize(540, 370); 
		
	}
}
