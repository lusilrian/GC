package model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Theater implements Serializable {
	private String time;	//��ȭ �� �ð�
	private String name; //��ȭ���̸�
	private String day; //��ȭ ��¥
	private int seat[][] = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
	
	
	public Theater(String time, String name, String day){
		this.time = time;
		this.name = name;
		this.day = day;
	}


	public String getTime() {
		String str = "";
		int o = 0;
		for(int i = 0; i < seat.length; i++){
			for(int j = 0; j < seat[i].length; j++){
				if(seat[i][j] == 1){
					o++;
				}	
			}
		}
		str = time + "(" + o + "/" + (seat.length * seat[0].length) + ")";
		return str;
	}
	
	public String getTime2() {
		
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int[][] getSeat() {
		return seat;
	}

	public void setSeat(int[][] seat) {
		this.seat = seat;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}


	@Override
	public String toString() {
		return "Theater [time=" + time + ", name=" + name + ", day=" + day + ", seat=" + Arrays.toString(seat) + "]";
	}
	
}
