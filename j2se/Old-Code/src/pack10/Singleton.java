package pack10;

public class Singleton {

	
	public static void main(String[] args) 
	
	{ 
		
		MySingleton mso=MySingleton.readIns();
	}

	
}

class MySingleton
{  
	public static MySingleton ms=new MySingleton();
	 
	
	
	public static  MySingleton readIns()
	{
	return ms;
	}
}