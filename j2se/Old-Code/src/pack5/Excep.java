package pack5;

public class Excep {

	static int i=11;
	public static void main(String[] args) {
		try
		{
			if(i>10)
			throw new MyExcep("cool");
		}
		catch(MyExcep me)
		{
			System.out.println("Error:"+me);
		}
		
	}

}






class MyExcep extends Exception
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public MyExcep()
	//{
	//	super();
	//}
	public MyExcep(String s)
	{ 
		super(s);
		
	}
		
	//public String toString()
	//{
		
		//return "The given value is greater than the specified "+x;
		
		
	//}
}