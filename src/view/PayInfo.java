package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.dao.MemberDao;

public class PayInfo extends JFrame {
	
	public PayInfo(MemberDao md, int sel) {
		this.setBounds(0, 0, 680, 680);
		String str = "";
		for(int i = 0; i <md.getLoginMember().getM1().size(); i++){
			str += md.getLoginMember().getM1().get(i);
		}
		System.out.println(str);
		JLabel j = new JLabel(str);
		j.setSize(680,680);
		
		this.add(j);
		this.setVisible(true);
		
		
	}

}
