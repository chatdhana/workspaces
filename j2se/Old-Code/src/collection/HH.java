package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;

public class HH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashSet a =new LinkedHashSet(); 
		a.add(new Integer(1));
		a.add(new String("hhh"));
		a.add(new Integer(12));
		
		a.add(new Integer(15));
		a.add(new Integer(17));
		Iterator aa =a.iterator();
		
		while(aa.hasNext()){
			System.out.println(aa.next());
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
