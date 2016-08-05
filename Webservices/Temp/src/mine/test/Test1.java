package mine.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {

		Map<Class1, String> myColl = new HashMap<Class1, String>();

		Set<Class1> mySet = new HashSet<Class1>();

		Class1 strBldr = new Class1();

		System.out.println(strBldr.hashCode());
		strBldr.str = "ONE";
		strBldr.i = 1;
		// strBldr.append("1");
		myColl.put(strBldr, "ONE");
		mySet.add(strBldr);
		strBldr.str = "TWO";
		strBldr.i = 2;
		// strBldr.append("2");
		myColl.put(strBldr, "TWO");
		mySet.add(strBldr);
		strBldr.str = "THREE";
		strBldr.i = 3;
		// strBldr.append("3");
		myColl.put(strBldr, "THREE");
		mySet.add(strBldr);
		strBldr.str = "FOUR";
		strBldr.i = 4;
		// strBldr.append("4");
		mySet.add(strBldr);
		myColl.put(strBldr, "FOUR");
		System.out.println(myColl);
		System.out.println(mySet);
		System.out.println(strBldr.hashCode());
		System.out.println("identityHashCode:" + System.identityHashCode(strBldr));
	}

}

class Class1 {

	String str = null;
	int i = 0;

	@Override
	public int hashCode() {
		return this.i;
	}

}
