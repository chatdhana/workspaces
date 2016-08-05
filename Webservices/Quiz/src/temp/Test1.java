package temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test1 implements Serializable {
	public static void main(String[] args) {
		
		System.out.println(Integer.parseInt("7FFFFFFF", 16));
		System.out.println(Integer.MAX_VALUE);
		Integer i = 10;
		System.out.println(i.hashCode());
		method2(i);
	}
	
	void method1() {
		Map<String,String> map = Collections.synchronizedMap(new HashMap<String,String>());
	}
	static void method2(Integer i){
		System.out.println(i.intValue());
	}
}
