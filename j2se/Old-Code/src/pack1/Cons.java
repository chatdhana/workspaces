package pack1;

public class Cons {

	
	int empid;
	int sal;
	public static void main(String[] args) {
	
	
		Cons c=new Cons();
		
		c.disp();
		
	new Cons(2.5,2);
	
	
	//c.disp();
	}
	Cons()
	{
		empid=12;sal=2000;
		System.out.println(" ....empid "+this.empid+"  sal**** " +this.sal);
	}
    Cons(int i)
		{ 
			System.out.println(" ....i "+i);
		}
    
	Cons(double x,int y)
	{	this(587);
	
		System.out.println(" ....x "+x+"  y " +y);
		
	}
	void disp()
	{ 
		System.out.println(" ....empid "+this.empid+"  sal " +this.sal);
	}
	
	}


