package string_manipulation;

import java.util.Stack;
import java.util.StringTokenizer;

public class StringTokenizerEx {

	
	public static void main(String[] args) {
		String str="1:dhana;2:mani;3:ganesh;";
		StringTokenizer st=new StringTokenizer(str,";:");
		while(st.hasMoreTokens())
		{
			System.out.print("Number: "+st.countTokens());
			System.out.println(" Name: "+st.nextToken());
		
		}
		
	}

}
