package collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;


public class MAPLinkedHashMap {

	/* 1) Interface: Map
	 * 2) Thread Safe: No
	 * 3) Can hold NULL?: Yes (key can also be null)
	 * 4) Order: Insertion order.
	 * 5) Duplicate: Unique keys. 
	 * 6) Method we use to add and read elements: put() & get()(we can't use Iterator directly
	 * but can use Entry interface to traverse Map through Iterator).
	 */
	public static void main(String[] args) {
		
		Map<Integer, String> lHMap=new LinkedHashMap<Integer, String>();
		lHMap.put(3, "val1");
		lHMap.put(1, "val2");
		lHMap.put(5, null);
		lHMap.put(2, "val3");
		
		System.out.println(lHMap.get(1));
		System.out.println(lHMap.get(2));
		Set<Entry<Integer,String>> s=lHMap.entrySet();
		for(Iterator<Entry<Integer, String>> iterator=s.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}

}
