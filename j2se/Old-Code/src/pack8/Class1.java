package pack8;
public class Class1 {

	int id;
	String name;
	public static void main(String args[])
	{
		//Class1 c1=new Class1();
		//c1.new addr().disp();
	Class1.addr a= 	new addr();
	a.disp();
	
	//a.v();
	//Class1.addr.v();
	Class1 c1=new Class1();
	i o=c1.localmeth();
	o.disp();
	
	
	}
	static  class addr
	{
		int no;
		String st="xyz st.";
		String city;
		public void disp()
		{
			System.out.println("street:"+st);
		}
		public static void v()
		{
			System.out.println("static method");
		}
		
	}
	i localmeth()
	{ final int x1=10;
		class c implements i
		{ 
			public void disp()
			{ 
				System.out.println("local disp :"+x1+id);

			}
			
		}
		return new c();
		
	}
}

interface i
{ //int x;
	void disp();
}