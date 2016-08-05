package pack1;

public class Sup {
	int x=10;
	public static void main(String[] args)
	{
		
		Sub s=new Sub();
		s.disp();
		new Sub();

	}
	
	void disp()
	{
		System.out.println("dispSup::");
		
	}
	
	

}

class Sub extends Sup
{  
	void disp1()
	{
		System.out.println("dispSub::");
		
	}
	
	
}