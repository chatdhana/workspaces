package mine.interfaces;

import java.io.FileNotFoundException;

import javax.naming.NamingException;

public interface MethodOverriding {
	Object getNumber() throws ClassNotFoundException, NamingException;
}

interface MethodOverridingSub1 extends MethodOverriding {
	Number getNumber() throws ClassNotFoundException; // Allowed; throws clause: exact match
//	Number getNumber(); // Allowed; thows clause: ignored
//	Number getNumber() throws FileNotFoundException; // Compile-time error; throws clause not substitutable
//	Number getNumber() throws ClassNotFoundException, FileNotFoundException;
}

interface MethodOverridingSub2 extends MethodOverriding {
	Double getNumber() throws ClassNotFoundException;
}

interface MethodOverridingDeepSub1 extends MethodOverridingSub1,
		MethodOverridingSub2 {
	// Number getNumber() throws ClassNotFoundException; // Compile-time error; incompatible return type
	 Double getNumber() throws ClassNotFoundException;
}


// Inherit several methods with override-equivalent signature.
// Overriding methods' RETURN TYPE should be substitutable while having throws clause with different types does not cause error.

interface MethodOverriding1 {
	Double getNumber() throws ClassNotFoundException;
}

interface MethodOverriding2 {
	Double getNumber() throws NamingException;
}

/* One of the inherited methods must be return-type-substitutable for every
other inherited method; otherwise, a compile-time error occurs. (The throws
clauses do not cause errors in this case.)*/
interface MethodOverridingSub3 extends MethodOverriding1, MethodOverriding2 {
}

class MethodOverridingClass implements MethodOverridingSub3 {
	public Double getNumber() {
		return null;
	}
}
