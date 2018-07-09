package model.vo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;import javax.swing.JOptionPane;

public class Movie implements Serializable{
	private String name; //영화이름
	private ImageIcon poster;//영화 포스터
	private String str;//영화 줄거리
	private ImageIcon[] cut;//영화 스틸컷
	private int number; //구매수량;
	private String[] days = new String[7];
	private String[][] theaterStr = {{"가산디지털","건대입구","신도림","청량리","홍대입구"},{"검단","부평","성남","수원","인천"}};
	private String[] times = {"07:00","10:00","13:00","16:00","19:00","21:00","24:00"};
	private ArrayList<Theater> theaters;
	
	private String time;
	private Theater theater;
	private boolean alarm = true;
	//상영 영화
	public Movie(String name, ImageIcon poster, String str, ImageIcon[] cut) {
		for(int i = 0; i < days.length; i++){
			Calendar d = new GregorianCalendar();
			if((d.get(Calendar.DATE)+i)<=d.getActualMaximum(Calendar.DATE)){
				System.out.println(d.get(Calendar.MONTH)+1);
				days[i] = "" + (d.get(Calendar.MONTH)+1) + "/" + (d.get(Calendar.DATE)+i);
			}else{
				days[i] = "" + (d.get(Calendar.MONTH)+2) + "/" + (d.get(Calendar.DATE)+i);
			}
			System.out.println(days[i]);
		}
		theaters = new ArrayList<Theater>();
		this.name = name;
		Image originImg = poster.getImage(); 
		Image changedImg= originImg.getScaledInstance(180, 220, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		this.poster = Icon;
		this.str = str;
		this.cut = cut;
		int a =0;
		for(int i = 0; i < theaterStr.length; i++){
			for(int j = 0; j < theaterStr[i].length; j++){
				for(int k = 0; k < 7; k++){
					for(int u = 0; u < times.length; u++){
						theaters.add(new Theater(times[u],theaterStr[i][j],days[k]));
						a++;
					}
				}
			}
		}
	}
	//예매 영화
	public Movie(String name, ImageIcon poster, String str, ImageIcon[] cut, String time, String day, String tname) {
		super();
		this.name = name;
		Image originImg = poster.getImage(); 
		Image changedImg= originImg.getScaledInstance(180, 220, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		this.poster = Icon;
		this.str = str;
		this.cut = cut;
		this.time = time;
		this.theater = new Theater(time,tname,day);
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

	public String[] getTimes() {
		return times;
	}

	public void setTimes(String[] times) {
		this.times = times;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	public String[][] getTheaterStr() {
		return theaterStr;
	}
	public void setTheaterStr(String[][] theaterStr) {
		this.theaterStr = theaterStr;
	}
	public ArrayList<Theater> getTheaters() {
		return theaters;
	}
	public ArrayList<Theater> getTheaters(String name, String day) {
		ArrayList<Theater> rtheaters = new ArrayList<Theater>();
		System.out.println(name);
		System.out.println(day);
		System.out.println(theaters.size());
		for(int i = 0; i < theaters.size();i++){
			if(theaters.get(i).getName().equals(name)){
				if(theaters.get(i).getDay().equals(day)){
					System.out.println(theaters.get(i).getTime());
					rtheaters.add(theaters.get(i));
				}
			}
		}
		return rtheaters;
	}
	public void setTheaters(ArrayList<Theater> theaters) {
		this.theaters = theaters;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", poster=" + poster + ", str=" + str + ", cut=" + Arrays.toString(cut)
		+ ", number=" + number + ", days=" + Arrays.toString(days) + ", theaterStr="
		+ Arrays.toString(theaterStr) + ", times=" + Arrays.toString(times) + ", theaters=" + theaters
		+ ", time=" + time + ", theater=" + theater + "]";
	}
	public boolean isAlarm() {
		return alarm;
	}
	public void setAlarm(int alarm) {
		this.alarm = false;
	}





}
