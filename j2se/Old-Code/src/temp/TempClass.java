package temp;

public class TempClass {

	

public static void main(String[] args) {

	String a="dh";//new String("dhana1");
	String b=new String("dhanA");
	String c=new String("dhana");
	if(c!=b)
	{
		System.out.println("gggggg");
	}
	if(b.equals(c))
	{
		System.out.println("gggggg");
	}
	
	
	//System.out.println((float)1/(float)2);
	C dhana= new C();
	dhana.init(18023);
	dhana.display();
	C ganesh= new C();
	ganesh.init(18024);
	
	
	}


}




class C
{int empid;
	void init(int y)
	{
		this.empid=y;
	}
	void display()
	{
		System.out.println(empid);
	}
}
