package model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.Member;

public class MemberDao
{
	private ArrayList<Member> list = new ArrayList<Member>();

	public MemberDao()
	{
		try
		{
			ObjectInputStream oir = new ObjectInputStream(new FileInputStream("member.dat"));
			
			while(true)
			{
				list.add((Member) oir.readObject());
			}
		}
		catch (EOFException e)
		{
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
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
	public ArrayList<Member> myAccount(String userId, String userPwd)
	{
		ArrayList<Member> myAccount = new ArrayList<Member>();
		
		for(int i=0; i<list.size(); i++)
		{
			if(userId.equals(list.get(i).getUserId()) == true && userPwd.equals(list.get(i).getUserPwd()) == true)
			{
				myAccount.add(list.get(i));
			}
		}		
		return myAccount;
	}
	public void modifyAccount(ArrayList<Member> list)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.dat")))
		{
			for(int i=0; i<this.list.size(); i++)
			{
				if(list.get(0).getUserId().equals(this.list.get(i).getUserId()))
				{
					oos.writeObject(list.get(0));
				}
			}
			oos.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}