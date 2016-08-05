package collection;
import java.util.*;
import java.util.HashSet;
import java.util.Iterator;




public class HSetClass {

	
	public static void main(String[] args) {
		Set hs=new HashSet();
		for(int i=0;i<5;i++)
		hs.add(new Integer(i));
		System.out.println(hs);
		Iterator io=hs.iterator();
		while(io.hasNext())
		{
			System.out.println(io.next());
		}
		
		

	}

}
