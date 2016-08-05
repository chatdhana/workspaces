package temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import bag.Bag;

public class Test1 implements Serializable {
	public static void main(String[] args) {
	
		String str = "1 | 2 |    |4|5";
		String tokens[]=str.split("\\|");
		StringBuffer finalvalue = new StringBuffer();
		
		for(String token : tokens )
		{
			finalvalue.append(token);
		}
		System.out.println(finalvalue);
		//System.out.println(str.split("\\|"));
		//System.out.println(Arrays.toString(str.split("\\|")));
		
	
	}
}
