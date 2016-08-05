package mine.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvancedCollection {

	int i1;
	long l1;
	ArrayList<String> list;
	String x;
	String y;

	public AdvancedCollection() {
	}

	public AdvancedCollection(AdvancedCollection advColl) {
		this.x = advColl.x;
		this.y = advColl.y;
	}

	private void test() {
		AdvancedCollection advColl = new AdvancedCollection();
		advColl.x = "X";
		advColl.y = "Y";
	}

	public static void main(String[] args) {
		List<String> immutableSingletonList = Collections.singletonList("Immutable");

		System.out.println(immutableSingletonList);
		// immutableList.add("Addition");

		List<String> mutableList = new ArrayList<>();
		mutableList.add("1");
		mutableList.add("2");
		mutableList.add("3");

		List<String> immutableList = Collections.unmodifiableList(mutableList);
		System.out.println(immutableList);
		immutableList.add("4");
		mutableList.add("4");
		
		List<String> synchList = Collections.synchronizedList(mutableList);
		
	}
}
