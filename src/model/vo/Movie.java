package model.vo;

import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;

public class Movie {
	private String name; //영화이름
	private Date time;	//영화 상영 시간
	private ImageIcon poster;//영화 포스터
	private String str;//영화 줄거리
	private ImageIcon[] cut;//영화 스틸컷
	private int number = 1; //영화 구매 수량
	public Movie(String name, Date time, ImageIcon poster, String str, ImageIcon[] cut, int number) {
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
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
