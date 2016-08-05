package collection;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/* 1) Interface: Set
 * 2) Thread Safe: No
 * 3) Can hold NULL?: Yes (but only one null is allowed)
 * 4) Order: Follows insertion order
 * 5) Duplicate: Not Allowed but it does not throw an exception 
 * 	  (bcoz the new duplicate element will overwrite old one)
 * 6) Method we use to add and read elements: add() & (can't use get(),use Iterator)
 */

public class SETLinkedHashSet {
	public static void main(String[] args) {

		/*Set<Byte> lHSet=new LinkedHashSet<Byte>();
		lHSet.add(new Byte("12"));
		lHSet.add(new Byte("22"));
		lHSet.add(new Byte(null));
		lHSet.add(new Byte("08"));
		lHSet.add(new Byte("127"));
		lHSet.add(new Byte("127"));
		
		// Traversing a set using iterator.
		for (Iterator<Byte> iterator = lHSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}*/
		
		Set<String> lHSet=new LinkedHashSet<String>();
		lHSet.add("str1");
		lHSet.add("str2");
		lHSet.add("str3");
		lHSet.add(null);
		lHSet.add("str2");
		lHSet.add(null);
		lHSet.add("127");
		
		// Traversing a set using iterator.
		for (Iterator<String> iterator = lHSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}
