package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dao.MovieDao;
import model.vo.Movie;

public class MovieInsert extends JFrame{
	private MovieDao md = new MovieDao();
	JFileChooser fc;
	ImageIcon poster;
	Movie m;
	/*	private String name; //��ȭ�̸�
	private String[] time;	//��ȭ �� �ð�
	private ImageIcon poster;//��ȭ ������
	private String str;//��ȭ �ٰŸ�
	private ImageIcon[] cut;//��ȭ ��ƿ��
	private int number = 1; //��ȭ ���� ����

	 */	public MovieInsert(){
		 this.setTitle("��ȭ ����");
		 this.setBounds(0, 0, 640, 860);
		 this.setLayout(null);
		 fc = new JFileChooser();

		 fc.setMultiSelectionEnabled(false);
		 JPanel panel = new JPanel();
		 panel.setBounds(0, 0, 640, 860);
		 panel.setLayout(null);

		 JLabel namel = new JLabel("��ȭ �̸�");
		 namel.setBounds(20,20, 50, 30);

		 JTextField name = new JTextField();
		 name.setBounds(80,20, 640-80, 30);

		 JLabel strl = new JLabel("��ȭ �ٰŸ�");
		 strl.setBounds(20,50, 50, 30);

		 JTextArea str = new JTextArea();
		 str.setBounds(80,50, 640-80, 200);


		 String[] time = {"07:00","10:00","13:00","16:00","19:00","21:00","24:00"};
		 ImageIcon mc[] = {new ImageIcon("images/cat.PNG"),new ImageIcon("images/dog.PNG"),new ImageIcon("images/tiger.PNG"),new ImageIcon("images/cat.PNG")};
		 JLabel posterl = new JLabel("������");
		 posterl.setBounds(20,260, 50, 30);

		 JButton posterb = new JButton("����");
		 posterb.setBounds(80,260, 50, 30);
		 posterb.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == posterb) {
					 if (fc.showOpenDialog(posterb) == JFileChooser.APPROVE_OPTION) {

						 System.out.println(fc.getSelectedFile().toString());

						 String fname = fc.getSelectedFile().toString();

						 ImageIcon icon = new ImageIcon(fname);

						 Image temp = icon.getImage();

						 Image img = new ImageIcon(fname).getImage();


						 int a=img.getWidth(null);

						 int b=img.getHeight(null);


						 Image newImg = temp.getScaledInstance(a, b, java.awt.Image.SCALE_SMOOTH); 

						 poster = new ImageIcon(newImg);

					 }
				 }
			 }
		 });
		 
		 JButton sel = new JButton("Ȯ��");
		 sel.setBounds(80,300, 50, 30);
		 sel.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == sel) {
					 m = new Movie(name.getText(),time,poster,str.getText(),mc,0);
					 md.movieInsert(m);
					 name.setText("");
					 str.setText("");
					 poster = null;
				 }
			 }
		 });
		 
		 
		 panel.add(namel);
		 panel.add(name);
		 panel.add(strl);
		 panel.add(str);
		 panel.add(posterl);
		 panel.add(posterb);
		 panel.add(sel);
		 
		 this.add(panel);
		 this.setVisible(true);
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


	 }
}
