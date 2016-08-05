package pack3;

public class Overr {

	{
		System.out.println("Instance Initialise Block");
	}
	
	public static void main(String[] args)
	{ 
		
		
		Sub s=new Sub();
		s.display();
		Sub s2=new Sub();
		s2.display();
		
	}

}


 class Sup
 {
	 static{
		 System.out.println("static base");
		} 
	 {
		 System.out.println("Instance base");
		}
	 
	 int i=10;
	 void display()
	 {
		 System.out.println("disp:SUP:");
	 }
 }
 
 
 
 class Sub extends Sup
 {  static{
	 System.out.println("static deri");
	} 
{
	 System.out.println("Instance d");
	}
	  void display()
	 {
		 System.out.println("disp:SUB:"+i);
		 
	 }
 }
 
    