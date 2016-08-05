package general;

public class NullPointerAccess {

	 
	public static void main(String[] args) {
	Emp e=new Emp();
		
	if(e!=null)
	{
		if(e==null)
		{
			e=null;	
		}
	}
	//Potential null pointer exception
//e.disp();
}
}

class Emp {

	void disp()
	{
		
	}
}