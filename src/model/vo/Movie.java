package model.vo;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

public class Movie implements Serializable{
	private String name; //��ȭ�̸�
	private String[] time;	//��ȭ �� �ð�
	private ImageIcon poster;//��ȭ ������
	private String str;//��ȭ �ٰŸ�
	private ImageIcon[] cut;//��ȭ ��ƿ��
	private int number = 1; //��ȭ ���� ����
	public Movie(String name, String[] time, ImageIcon poster, String str, ImageIcon[] cut, int number) {
		super();
		this.name = name;
		this.time = time;
		Image originImg = poster.getImage(); 
		Image changedImg= originImg.getScaledInstance(180, 220, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		this.poster = Icon;
		this.str = str;
		this.cut = cut;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getTime() {
		return time;
	}
	public void setTime(String[] time) {
		this.time = time;
	}
	public ImageIcon getPoster() {
		return poster;
	}
	public void setPoster(ImageIcon poster) {
		this.poster = poster;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public ImageIcon[] getCut() {
		return cut;
	}
	public void setCut(ImageIcon[] cut) {
		this.cut = cut;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
