package collection;

import java.util.*;

public class ArrayListClass {
	
	
	public void arr() {
		
		ArrayList a=new ArrayList();
		t to=new t();
		
		Object o=null;
		int ar[]=new int[12];
		int x=0;
	
		for (int i=0;i<9;i++)
		{
		 a.add(new Integer(i));
		 
		}
		a.add(new Integer(5));
		a.add(new String("dhana"));

		a.add(to);
	
		
		for (int i=0;i<11;i++)
		{
			o=a.get(i);
		
			if(o instanceof Integer)
			{ 
				ar[x++]=(Integer)a.get(i);
				System.out.println(a.get(i));
			}
		}
		for (int i=0;i<=x;i++)
		{
			System.out.println(ar[i]);
		}
		
		for (int i=0;i<11;i++)
		{
			o=a.get(i);
		
			if( o instanceof String)
			{
				
				System.out.println(a.get(i));
			}
		}
		
		System.out.println(a.get(11));
		
		
		((t)a.get(11)).v();
		
		
		
	}
	
}


class t
{
	void v()
	{
		System.out.println("dhananjayan");
	}
}