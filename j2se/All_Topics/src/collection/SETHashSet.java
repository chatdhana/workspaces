package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 1) Interface: Set
 * 2) Thread Safe: No
 * 3) Can hold NULL?: Yes (but only one null is allowed)
 * 4) Order: Follows insertion order
 * 5) Duplicate: Not Allowed but it does not throw an exception 
 * 	  (bcoz the new duplicate element will overwrite old one)
 * 6) Method we use to add and read elements: add() & (can't use get(),use Iterator)
 */

public class SETHashSet {

	public static void main(String[] args) {
		Set<String> hSet = new HashSet<String>();
		hSet.add("str1");
		hSet.add(null);
		hSet.add("str2");
		hSet.add("str1"); // it doesn't throw an exception
		// it can hold null
		hSet.add(null); // it doesn't throw an exception
		// Traversing a set using iterator.
		for (Iterator<String> iterator = hSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}

}
