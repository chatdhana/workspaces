package ellipses;

/*Variable-Length Argument Lists. 
 * 
 *Variable-length argument lists are a new feature in J2SE 5.0. Programmers can 
 *create methods that receive an unspecified number of arguments. An argument 
 *type followed by an ellipsis (...) in a method's parameter list indicates that
 *the method receives a variable number of arguments of that particular type.
 *This use of the ellipsis can occur only once in a parameter list, and the 
 *ellipsis, together with its type, must be placed at the end of the parameterlist.
 *While programmers can use method overloading and array passing to accomplish much
 *of what is accomplished with "varargs," or variable-length argument lists, using 
 *an ellipsis in a method's parameter list is more concise.
 */

public class Ellipses {

	public static void main(String[] args) {

		// new Ellipses().disp(1,2,3,4,5,6,7,8);

		/*
		 * Illegal
		 * 
		 * Inexact type match for vararg arguments
		 * 
		 */
		// new Ellipses().display(null);
		// legal
		new Ellipses().display();

		// legal
		new Ellipses().display((Employee) null);

		Employee emp1 = new Employee("hari");
		Employee emp2 = new Employee("bond");

		// legal
		new Ellipses().display(emp1, emp2);

	}

	public void display(Employee... x) {
		for (Employee e : x)
			System.out.println(e.name);
	}
}

class Employee {

	String name;

	Employee(String name) {
		this.name = name;
	}
}