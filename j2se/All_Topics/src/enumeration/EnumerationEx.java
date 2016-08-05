package enumeration;

import java.util.Enumeration;
import java.util.Vector;

/*
 * public interface Enumeration.
 1) An object that implements the Enumeration interface generates a series of 
 elements, one at a time. Successive calls to the nextElement method return 
 successive elements of the series. 

 2) Methods are provided to enumerate through the elements of a vector, the keys
 of a hashtable, and the values in a hashtable. Enumerations are also used to
 specify the input streams to a SequenceInputStream. 

 NOTE: The functionality of this interface is duplicated by the Iterator 
 interface. In addition, Iterator adds an optional remove operation, and has 
 shorter method names. New implementations should consider using Iterator in 
 preference to Enumeration. 

 * 
 * */

public class EnumerationEx {

	static Vector<String> v;
	public static void main(String[] args) {
		new EnumerationEx().add();
		new EnumerationEx().display();
	}

	void add()
	{
		v=new Vector<String>();
		v.add("dhana1");
		v.add("dhana2");
		v.add("dhana3");
				
	}
	void display() {
				
		for (Enumeration<String> e=v.elements();e.hasMoreElements();) {
			System.out.println(e.nextElement());
			
			
		}
	}


}
