package collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SETTreeSet {

	/* 1) Interface: SortedSet Implements Set
	 * 2) Thread Safe: No
	 * 3) Can hold NULL?: Yes (but only one null is allowed)
	 * 4) Order: Sorted(Natural ordering)
	 * 5) Duplicate: Not Allowed but it does not throw an exception 
	 * 	  (bcoz the new duplicate element will overwrite old one)
	 * 6) Method we use to add and read elements: add() & (can't use get(),use Iterator)
	 */
	
	public static void main(String[] args) {
	 
		Set<String> tSet=new TreeSet<String>();
		tSet.add("str1");
		tSet.add("str2");
		tSet.add("str1");
		tSet.add("str");
		tSet.add(null); // This will throw an exception at runtime
		
		// Traversing a set using iterator.
		for (Iterator<String> iterator = tSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

		
		
		
		/*Set<Date> tSet=new TreeSet<Date>();
		tSet.add(new Date());
		tSet.add(new Date());
		tSet.add(null);
		
		// Traversing a set using iterator.
		for (Iterator<Date> iterator = tSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
*/
	}

}
