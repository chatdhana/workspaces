package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* 1) Interface: List
 * 2) Thread Safe: No
 * 3) Can hold NULL?: Yes
 * 4) Order: Follows insertion order
 * 5) Duplicate: Allowed
 * 6) Method we use to add and read elements: add() & get()
 */
public class LISTLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> lList=new LinkedList<String>();
		lList.add("str0");
		lList.add(1,"str1");
		// Allows duplicates
		lList.add("str0");
		// Allows null element
		lList.add(null);
		// Traversing a list using iterator.
		for (Iterator<String> iterator = lList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

			
	}

}
