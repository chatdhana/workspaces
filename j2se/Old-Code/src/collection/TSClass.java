package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TSClass  {

	
	
	public static void main(String[] args) {
		
		Set hs=new TreeSet();
		//List hs=new ArrayList();
		//hs.add(3);
		
		//for(int i=1;i<5;i++)
		//hs.add(new Integer(i));
		//hs.add(uc);
		hs.add(1);
		hs.add("dhana");
		
		Iterator io=hs.iterator();
		while(io.hasNext())
		{
			
			System.out.println(io.next());
		}
		
}
	
}
