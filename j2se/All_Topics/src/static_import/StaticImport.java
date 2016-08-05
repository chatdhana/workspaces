package static_import;

//The static import must be a static field or static member type.
/*When an import is static, all the accessible methods and variables of 
 *the class can be used without prefixing the class name.*/ 
import static java.lang.Math.*;

public class StaticImport {

	
	public static void main(String[] args) {
		System.out.println(PI);
		System.out.println(cos(0));

	}

}
