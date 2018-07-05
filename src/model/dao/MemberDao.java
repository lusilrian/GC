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
			System.out.println("���� �ε� �Ϸ�");
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
	//ȸ������ �� ���̵� �ߺ� �˻�
	public boolean overlapId(String userId)
	{
		for(int i=0; i<list.size(); i++)
		{
			if(userId.equals(list.get(i).getUserId()))
			{
				//ȸ�������� ���̵� ������ ��ϵ� ȸ���� ���̵�� ������ ��� true�� ���� 
				return true;
			}
		}
		return false;
	}
	//�α��ν� ��й�ȣ�� �������� �˻�
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
}