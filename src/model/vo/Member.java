package model.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable{
	private String userId;
	private String userPwd;
	private String name;
	private char gender;
	private String birthDay;
	private String phoneNumber;
	private String email;
	private ArrayList<Movie> m1;//���ſ�ȭ ����
	private ArrayList<Movie> m2;//���� ��ȭ ����
	private ArrayList<Store> s1;//����� ���ų���
	private ArrayList<Store> s2;//���� ����� ����
	public Member(String userId, String userPwd, String name, String birthDay, String num, String phoneNumber,
			String email) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.gender = (num.charAt(0) == '1') ? '��' : '��';
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Movie> getM1() {
		return m1;
	}
	public void setM1(ArrayList<Movie> m1) {
		this.m1 = m1;
	}
	public ArrayList<Movie> getM2() {
		return m2;
	}
	public void setM2(ArrayList<Movie> m2) {
		this.m2 = m2;
	}
	public ArrayList<Store> getS1() {
		return s1;
	}
	public void setS1(ArrayList<Store> s1) {
		this.s1 = s1;
	}
	public ArrayList<Store> getS2() {
		return s2;
	}
	public void setS2(ArrayList<Store> s2) {
		this.s2 = s2;
	}

	@Override
	public String toString() {
		return userId + "," + userPwd + "," + name + "," + gender
				+ "," + birthDay + "," + phoneNumber + "," + email + "," + m1
				+ "," + m2 + "," + s1 + "," + s2;
	}
	
	
}
