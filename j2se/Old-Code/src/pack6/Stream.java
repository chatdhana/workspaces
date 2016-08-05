package pack6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stream {

	
	public static void main(String[] args)
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	
	try
	{
		int i;
		while((i=bf.read())!=-1)
		System.out.print((char)i);
		
	}
	catch(IOException e)
	{
		System.out.println("E"+e);
	}
		

	}

}

