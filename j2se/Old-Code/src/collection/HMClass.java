package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HMClass {

	
	public static void main(String[] args) {
		
		HashMap hm=new HashMap();
		for(int i=0;i<5;i++)
		hm.put(new Integer(i), new String("dhana"+i));
	
		System.out.println(hm);
		Set s=hm.keySet();
		System.out.println(s);
	Collection s1=hm.values();
		System.out.println(s1);
	//	while(io.hasNext())
		//{
		//	System.out.println(io.next());
		//}
		
		

	}

}
