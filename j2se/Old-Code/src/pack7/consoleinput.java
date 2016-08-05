package pack7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class consoleinput {
	

	public String readString()throws Exception
	{

	                InputStreamReader in= new InputStreamReader(System.in);

	              BufferedReader bin= new BufferedReader(in);

	               String st=bin.readLine();
	                System.out.println("nnnnnn"+st);
	                return st;
	  
	}

                public int readInt()throws Exception

                {
                	Integer i=new Integer(readString());
                	i.intValue();
                	return  i;
                }

}
