package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/*
 * 1) HashTable s synchronized,and slower than HashMap.
 * 2) HashTable does not allow null as a key. i.e. You can put null as key in 
 * 	HashMap but not in HashTable.
 * 3) Iterator in the HashMap is fail-safe while the enumerator for the HashTable isn't
 * 
 * */
public class HashMapClass {

	
	public static void main(String[] args) {
		
		HashMap hm=new HashMap();
		hm.put(1, "dhana");
		hm.put(2, "dhana");
	
		System.out.println(hm.keySet());
	Collection co=hm.values();
	Iterator o=co.iterator();
		
	}

}