package collection;

import java.util.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class LLClass {

	public static void main(String[] args) {
		
		LinkedList ll=new LinkedList();
		
		for(int i=0;i<5;i++)
			ll.add(new Integer(i));
			
		//ll.add(10,10);
			ListIterator io=ll.listIterator();
			//System.out.println("jhjjhhjhjjj");
			
			while(io.hasNext())
			{
				System.out.println(io.next());
				
			}
			while(io.hasPrevious())
			{
				System.out.println(io.previous());
				
			}
		
		
	}

}
