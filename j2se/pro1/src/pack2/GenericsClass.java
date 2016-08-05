package pack2;


import java.util.ArrayList;
import java.util.List;

public class GenericsClass {

	
	public static void main(String[] args) {
		//Usage of Raw Type
		ArrayList a=new ArrayList();
		//Unchecked Generic Type Operation
		a.add("string value");
		
		System.out.println("hi...");
	}
	
	/*Generic type parameter declared with a final type bound.
	 * Here Child is the final class, could not be extended.
	 */
	void print (List<? extends Child> l)
	{
		System.out.println("hi");
	}
	

}

final class Child{
	
}
