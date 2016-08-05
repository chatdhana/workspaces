package collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MAPHashTable {

	/* 1) Interface: Map
	 * 2) Thread Safe: Yes, synchronized.
	 * 3) Can hold NULL?: No
	 * 4) Order: No Order.
	 * 5) Duplicate: Unique keys. 
	 * 6) Method we use to add and read elements: put() & get()(we can't use Iterator directly
	 * but can use Entry interface to traverse Map through Iterator).
	 */

	public static void main(String[] args) {

		Map<Integer, String> hTable = new Hashtable<Integer, String>();
		hTable.put(2, "val1");
		hTable.put(1, "val2");
		hTable.put(2, "val3");
		hTable.put(3, "val3");
//		hTable.put(1,null);// null not allowed
		Set s = hTable.entrySet();
		for (Iterator iterator=s.iterator() ;iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}

}
