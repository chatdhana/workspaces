package annotation;

import java.util.Date;
import java.lang.annotation.*;

@AnnotationEx1(
		author="dhana",
		lastModified="12",
		currentVersion="1"
)

public class AnnotationExample{

	
	public static void main(String[] args) {
		
	}

	
}


class SuperClass
{
	@SuppressWarnings("deprecation")
	void disp()
	{
		new Date().getDate();
	}
}
class SubClass extends SuperClass
{
	
	/*Missing @Override annotation
	 * 
	 * The method disp() of type SubClass should be tagged with @Override since it actually overrides a superclass 
	 method
	 */
		
	//@Override
	
	void disp()
	{
	
	}
	
	
}

/* Annotation is used as super interface.
 * 
 * The annotation type Deprecated should not be used as a superinterface for Temp interface
 */
//interface Temp extends java.lang.Deprecated {
	
//}

