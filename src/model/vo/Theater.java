package model.vo;

import java.io.Serializable;

public class Theater implements Serializable {
	private String time;	//영화 상영 시간
	private int seat[][] = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
	
	public Theater(String time){
		this.time = time;
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


	public void setTime(String time) {
		this.time = time;
	}


	public int[][] getSeat() {
		return seat;
	}

	public void setSeat(int[][] seat) {
		this.seat = seat;
	}
	
}
