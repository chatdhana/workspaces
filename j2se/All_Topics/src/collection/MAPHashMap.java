package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


/* 1) Interface: Map
 * 2) Thread Safe: No
 * 3) Can hold NULL?: Yes (key can also be null)
 * 4) Order: No Order.
 * 5) Duplicate: Unique keys. 
 * 6) Method we use to add and read elements: put() & get()(we can't use Iterator directly
 * but can use Entry interface to traverse Map through Iterator).
 */

public class MAPHashMap {

	
	public static void main(String[] args) {
	
		Map<Integer, String> hMap=new HashMap<Integer, String>();
		hMap.put(1,"dhana");
		hMap.put(1,"dhan");
		hMap.put(1,null);
		hMap.put(2,null);
		System.out.println("Map1.......");
		System.out.println(hMap.get(1));
		System.out.println(hMap.get(2));
		System.out.println(hMap.entrySet()); 
		System.out.println(hMap.keySet());
		System.out.println(hMap.values());
		System.out.println(hMap.isEmpty());
		
		Set<Entry<Integer,String>> s=hMap.entrySet();
		System.out.println("Traversing Map using Entry interface through Iterator.");
		for (Iterator<Entry<Integer,String>> iterator=s.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
			
		}
		
		
		
		
		Map<String, String> hMap2=new HashMap<String, String>();
		hMap2.put("a","dhana");
		hMap2.put("b","dhana");
		hMap2.put("a","dhana a");
		hMap2.put(null,"dhan null");
		hMap2.put(null,null);
		
		
		System.out.println("Map2.......");
		System.out.println(hMap2.get("a"));
		System.out.println(hMap2.get(null));
		
		
		
		
	}

}
