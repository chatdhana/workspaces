package collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MAPTreeMap {


	/* 1) Interface: SortedMap
	 * 2) Thread Safe: No
	 * 3) Can hold NULL?: Yes (key can also be null)
	 * 4) Order: Sorted (Natural order).
	 * 5) Duplicate: Unique keys. 
	 * 6) Method we use to add and read elements: put() & get()(we can't use Iterator directly
	 * but can use Entry interface to traverse Map through Iterator).
	 */
	public static void main(String[] args) {
	
		Map<Integer, String> tMap=new TreeMap<Integer, String>();
		tMap.put(5, "val1");
		tMap.put(3, "val2");
		tMap.put(7, "val3");
		tMap.put(1, "val4");
		tMap.put(3, null);
		
		Set<Entry<Integer,String>> s=tMap.entrySet();
		for (Iterator<Entry<Integer, String>> iterator=s.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
			
		}
		
		

	}

}
