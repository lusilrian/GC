package model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import model.vo.Member;

public class MemberDao
{
	private ArrayList<Member> list = new ArrayList<Member>();
	private Member loginMember;

	public MemberDao()
	{


		try
		{
			ObjectInputStream oir = new ObjectInputStream(new FileInputStream("member.dat"));
			int i = 0;
			while(true)
			{
				list.add((Member) oir.readObject());
				System.out.println(list.get(i));

				if(list.get(i).isAutoLoginCheck())
				{
					System.out.println("자동로그인dao");
					loginMember = list.get(i);
				}
				i++;
			}
		}
		catch (EOFException e)
		{
			System.out.println("회원 파일 로드 완료");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("회원 파일 없음");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}


	}
	//회원가입 시 아이디 중복 검사
	public boolean overlapId(String userId)
	{
		for(int i=0; i<list.size(); i++)
		{
			if(userId.equals(list.get(i).getUserId()))
			{
				//회원가입할 아이디가 사전에 등록된 회원의 아이디와 동일할 경우 true를 리턴 
				return true;
			}
		}
		return false;
	}
	//로그인시 비밀번호가 동일한지 검사
	public boolean overlapPwd(String userPwd)
	{
		for(int i=0; i<list.size(); i++)
		{
			if(userPwd.equals(list.get(i).getUserPwd()))
			{ 
				return true;
			}
		}
		return false;
	}

	public void signUp(Member m)
	{
		list.add(m);

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.dat")))
		{
			for(int i=0; i<list.size(); i++)
			{
				oos.writeObject(list.get(i));
			}
			oos.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public Member myAccount(String userId, String userPwd)
	{
		Member myAccount = null;

		for(int i=0; i<list.size(); i++)
		{
			if(userId.equals(list.get(i).getUserId()) == true && userPwd.equals(list.get(i).getUserPwd()) == true)
			{
				myAccount = list.get(i);
			}
		}		
		return myAccount;
	}

	public void modifyAccount(Member list)
	{

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.dat")))
		{
			for(int i=0; i<this.list.size(); i++)
			{
				if(list.getUserId().equals(this.list.get(i).getUserId()))
				{
					this.list.remove(i);
					this.list.add(list);
					oos.writeObject(this.list);
				}
			}
			oos.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void loginMember(String userId){
		for(int i=0; i<list.size(); i++)
		{
			if(userId.equals(list.get(i).getUserId()))
			{
				loginMember = list.get(i);
			}
		}
	}

	public Member getLoginMember(){
		return loginMember;
	}
	
	public void setLoginMember(Member loginMember) {
		this.loginMember = loginMember;
	}
	
	public ArrayList<Member> getList() {
		return list;
	}
	public void setList(ArrayList<Member> list) {
		this.list = list;
	}

	public void fileSave(){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.dat")))
		{

			for(int i=0; i<list.size(); i++)
			{
				oos.writeObject(list.get(i));
			}
			oos.flush();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}