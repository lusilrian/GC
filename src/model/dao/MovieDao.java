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
import model.vo.Movie;
import model.vo.Theater;

public class MovieDao {
	private ArrayList<Movie> list = new ArrayList<Movie>();

	public MovieDao()
	{	

		try
		{
			ArrayList<Theater> theaters;
			Calendar d = new GregorianCalendar();
			for(int i = 0; i < list.size(); i++){
				theaters = list.get(i).getTheaters();
				for(int j = 0; j < 5; j++){
					for(int k = 0; k < 5; k++){
						for(int l = 0; l < theaters.size(); l++){
							System.out.println("------------------------------------------------------------------------------------");
							System.out.println(theaters.get(l).getDay());
							System.out.println((d.get(Calendar.MONTH)+1) + "/" + (d.get(Calendar.DATE)-1));
							System.out.println(theaters.get(l).getDay().equals((d.get(Calendar.MONTH)+1) + "/" + (d.get(Calendar.DATE)-1)));
							System.out.println("------------------------------------------------------------------------------------");
							
							if(theaters.get(l).getDay().equals((d.get(Calendar.MONTH)+1) + "/" + (d.get(Calendar.DATE)-1))){
								System.out.println(d.get(Calendar.DATE)-1);
								System.out.println(d.get(Calendar.DATE)+7);
								Theater t = (Theater) theaters.get(l).clone();
								t.setDay((d.get(Calendar.MONTH)+1) + "/" + (d.get(Calendar.DATE)+7));
								theaters.add(t);
								theaters.remove(l);

							}
						}
					}
				}
			}
			ObjectInputStream oir = new ObjectInputStream(new FileInputStream("movie.dat"));
			int i = 0;
			while(true)
			{
				list.add((Movie) oir.readObject());
				for(int j = 0; j < list.get(i).getTheaters().size(); j++){
					System.out.println(list.get(i).getTheaters().get(j));
				}
				i++;
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
		} /*catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
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

	public void fileSave(){
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
}
