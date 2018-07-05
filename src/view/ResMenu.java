package view;

import javax.swing.*;

public class ResMenu extends JPanel {
	private JPanel panel;
	public ResMenu(){
		JButton btn = new JButton("");
		btn.setLocation(20, 110);
		btn.setSize(580, 5);

		//뒤로가기 버튼
		JButton btn1 = new JButton("<");
		btn1.setLocation(45, 45);
		btn1.setSize(55, 55);  

		//메뉴이름
		JButton btn2 = new JButton("예매");
		btn2.setLocation(120, 45);
		btn2.setSize(130, 55);

		//영화, 극장, 날짜, 시간버튼
		JButton btn3 = new JButton("영화");
		btn3.setLocation(35, 130);
		btn3.setSize(125, 45); 
		JButton btn4 = new JButton("극장");
		btn4.setLocation(175, 130);
		btn4.setSize(125, 45); 
		JButton btn5 = new JButton("날짜");
		btn5.setLocation(315, 130);
		btn5.setSize(125, 45); 
		JButton btn6 = new JButton("시간");
		btn6.setLocation(455, 130);
		btn6.setSize(125, 45); 

		//영화, 극장, 날짜, 시간목록
		JButton btn7 = new JButton("선택한 영화 표시");
		btn7.setLocation(35, 180);
		btn7.setSize(125, 150); 
		JButton btn8 = new JButton("선택한 극장 표시");
		btn8.setLocation(175, 180);
		btn8.setSize(125, 150); 
		JButton btn9 = new JButton("선택한 날짜 표시");
		btn9.setLocation(315, 180);
		btn9.setSize(125, 150); 
		JButton btn10 = new JButton("선택한 시간 표시");
		btn10.setLocation(455, 180);
		btn10.setSize(125, 150); 

		//예매 초기화 버튼
		JButton btn11 = new JButton("예매 초기화");
		btn11.setLocation(55, 345);
		btn11.setSize(510, 45); 

		//상영 영화 목록
		JButton btn12 = new JButton("클릭시 각 항목 목록표기");
		btn12.setLocation(40, 405);
		btn12.setSize(540, 370); 
		
	}
}
