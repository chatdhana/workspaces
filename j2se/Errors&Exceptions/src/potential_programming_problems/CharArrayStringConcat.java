package potential_programming_problems;

//Using a char array in string concatenation
public class CharArrayStringConcat {
	
	public static void main(String[] args) {
		new CharArrayStringConcat().charArrayTest();
	}
	char[] ch=new char[10];
	void charArrayTest() {
		ch[0]='j';
/*		
 * Following statement will throw 
 * "Using a char array in string concatenation"
 * or "Must explicitly convert the char[] to a String" message. 
*/
		String str="hello"+ch;
		System.out.println(str);
	}
}
