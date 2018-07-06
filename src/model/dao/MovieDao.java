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
import model.vo.Movie;

public class MovieDao {
	private ArrayList<Movie> list = new ArrayList<Movie>();

	public MovieDao()
	{
		try
		{
			ObjectInputStream oir = new ObjectInputStream(new FileInputStream("movie.dat"));
			int i = 0;
			while(true)
			{
				list.add((Movie) oir.readObject());
				System.out.println(list.get(i++).getName());
			}
		}
		catch (EOFException e)
		{
			System.out.println("영화 파일 로드 완료");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("영화 파일 없음");
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
	
	public void movieInsert(Movie m)
	{
		list.add(m);

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat")))
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
	
	public ArrayList<Movie> getMovieList(){
		return list;
	}
	
}
