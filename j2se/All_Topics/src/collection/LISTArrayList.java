package collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* 1) Interface: List
 * 2) Thread Safe: No
 * 3) Can hold NULL?: Yes
 * 4) Order: Follows insertion order
 * 5) Duplicate: Allowed
 * 6) Method we use to add and read elements: add() & get()
 * 
 */
public class LISTArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		// Adding elements into ArrayList
		list.add("str0");
		list.add(1, "str1");
		//Allows Duplicate elements
		/*Shifts the element currently at that position (if any) and any subsequent elements to 
		 *the right (adds one to their indices).
		 */
		list.add(1, "str1"); 
		// It can hold null values
		list.add(null);

		// Displaying the elements of a list(without using iterator).
		System.out.println(list.get(0));
		System.out.println(list.get(1));

		// Displaying the elements of a list using enhanced for loop.
		for (String element : list) {
			System.out.println(element);
		}

		// Traversing a list using iterator.
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
			// iterator.remove();
		}

		// Traversing a list using ListIterator.
		ListIterator<String> iterator = list.listIterator();
		for (; iterator.hasNext();) {
			System.out.println(iterator.next());
			iterator.set("string"+(iterator.nextIndex()-1));
			// iterator.remove();
		}
		iterator.add("string2");
		// NULL element is allowed
		iterator.add(null);
		for (; iterator.hasPrevious();) {
			System.out.println(iterator.previous());
			// iterator.remove();
		}

		// Lists comparison
		List<String> l1=new ArrayList<String>();
		l1.add("s1");
		l1.add("s2");
		l1.add("s3");
		l1.add("s4");
		List<String> l2=new ArrayList<String>();
//		l2.addAll(l1);
		l2=l1.subList(0,4);
		l2.add("s5");
		System.out.println(l1.equals(l2));
		System.out.println(l2.equals(l1));
		
		System.out.println(l1);
		System.out.println(l2);

	}

}
