package pack2;



public class Ellipses {

		
	public static void main(String[] args) {

		//new Ellipses().disp(1,2,3,4,5,6,7,8);
		
		
		/* Illegal
		 * 
		 * Inexact type match for vararg arguments
		 * 
		 */
	//	new Ellipses().display(null);
	
		
		//legal
		new Ellipses().display();
		
		
		//legal
		new Ellipses().display((Employee)null);
		
		Employee emp1=new Employee("hari");
		Employee emp2=new Employee("bond");
		
		//legal
		new Ellipses().display(emp1,emp2);
		
	}

	
	
	public void display(Employee... x) {
		for(Employee e:x)
		System.out.println(e.name);
	}
}

class Employee
{
	
	String name;
	
	Employee(String name)
	{
	this.name=name;
	}
}