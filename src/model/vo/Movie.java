package model.vo;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

public class Movie implements Serializable{
	private String name; //��ȭ�̸�
	private ImageIcon poster;//��ȭ ������
	private String str;//��ȭ �ٰŸ�
	private ImageIcon[] cut;//��ȭ ��ƿ��
	private int number; //���ż���;
	private String[] times = {"07:00","10:00","13:00","16:00","19:00","21:00","24:00"};
	private Theater[] theater = new Theater[times.length]; //�󿵰�
	public Movie(String name, ImageIcon poster, String str, ImageIcon[] cut) {
		super();
		this.name = name;
		Image originImg = poster.getImage(); 
		Image changedImg= originImg.getScaledInstance(180, 220, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		this.poster = Icon;
		this.str = str;
		this.cut = cut;
		for(int i = 0; i < theater.length; i++){
			theater[i] = new Theater(times[i]);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Theater[] getTheater() {
		return theater;
	}
	public void setTheater(Theater[] theater) {
		this.theater = theater;
	}
	
}
