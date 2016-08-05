package string_manipulation;

public class StringComparison {

	
	public static void main(String[] args) {
		
		
		String str1="dhana";
		String str2="dhana";		
		String str3=new String("dhana");
		String str4=new String("dhana");	
		System.out.println("third class");
		if(str1==str2)
		{
			System.out.println("str1==str2");
		}else{
			System.out.println("str1!=str2");
		}
		if(str1.equals(str2))
		{
			System.out.println("str1.equals(str2)");
		}else{
			System.out.println("!str1.equals(str2)");
		}
		if(str3==str4)
		{
			System.out.println("str3==str4");
		}else{
			System.out.println("str3!=str4");		
		}
		if(str3.equals(str4))
		{
			System.out.println("str3.equals(str4)");
		}else{
			System.out.println("!str3.equals(str4)");
		}
			
	}


}