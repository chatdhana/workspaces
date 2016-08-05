package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* 
 * 1) Interface: List
 * 2) Thread Safe: Yes
 * 3) Can hold NULL?: Yes
 * 4) Order: Follows insertion order
 * 5) Duplicate: Allowed
 * 6) Method we use to add and read elements: add() & get()
 * 
 */
public class LISTVector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	List<Integer> vect=new Vector<Integer>();
	vect.add(5);
	vect.add(0);
	vect .add(1);
	// Duplicates allowed
	//	vect.add(1);
	vect.add(1,3);
	// It can hold null element
	vect.add(null);
	// Traversing a vector using iterator.
	for (Iterator<Integer> iterator = vect.iterator(); iterator.hasNext();) {
		System.out.println(iterator.next());
	}

	}

}
