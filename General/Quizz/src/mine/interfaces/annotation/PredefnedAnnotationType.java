package mine.interfaces.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Target(ElementType.PACKAGE)
public @interface PredefnedAnnotationType {

}

/**
 *	<p>* <b>Target</b> : The meta-annotation Target indicates the kinds of program element to which an annotation type is applicable.</p>
 *	
 *	<p>* If a Target meta-annotation is <b>not present</b> on an annotation type declaration, the declared type may be used on <b> any program element</b>.</p>
 *	
 *	<p>* It is a <b>compile-time error</b> if a given <b>enum constant appears more than once</b> in an annotation whose corresponding type is java.lang.annotation.Target</p>
 */
@java.lang.annotation.Target({ ElementType.LOCAL_VARIABLE, ElementType.FIELD})
/*@Target({ ElementType.ANNOTATION_TYPE, ElementType.PACKAGE, ElementType.TYPE,
		ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER,
		ElementType.FIELD, ElementType.LOCAL_VARIABLE })*/
@interface MyTarget {
	String varName();

	class InnerClass {
		@MyTarget(varName = "instanceField")
		int instanceField;
		
		// @TargetUse // The annotation @TargetUse is disallowed for this location
		void method() {
			@SuppressWarnings("unused")
			@MyTarget(varName = "localVarX")
			int localVarX = 0;
		}
	}
}

/** <p>* <b>Retention: </b> meta-annotation, Indicates how long annotations with the annotated type are to be retained.</p>
 *  <p>* If no Retention annotation is present on an annotation type declaration, the retention policy <b>defaults to RetentionPolicy.CLASS</b>.</p> 
 *	<p> 1) SOURCE - Annotations Discarded from class file. </p>
 * 	<p>	2) CLASS - Annotations Recorded in the class file by the compiler but need not be retained by the VM.</p>
 *	<p>	3) RUNTIME - In Addition to CLASS, the reflection libraries of the Java SE platform must make Declared Annotations available at run-time. </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyRetention {

}

/**
 * <p> * <b>Inherited: </b> meta-annotation, Indicates that an annotation type is automatically inherited. </p>
 * <p> * It causes annotations to be inherited from super classes; No effect if used to annotate anything other than a class.</p>
 */
@Inherited
@interface MyInherited {
	@MyInherited
	class SuperClass {
	}
	class SubClass extends SuperClass {
	}
	class DeepSubClass extends SubClass {
	}
}


/**
 *	<p> * Override - marker-annotation, Indicates that a method declaration is intended to override a method declaration in a supertype.</p>
 *	<p> * The annotation type Override supports early detection of subtle problems (e.g.: overloading instead of overriding).
 */
class MyOverride {

	// @Override // Error
	public boolean equals(MyOverride myObj) {
		return true;
	}

	@Override
	public boolean equals(Object myObj) {
		return true;
	}


	 @Override
	public Object clone() throws CloneNotSupportedException{
		 return null;
	 }
	
	interface IFace {
		@Override
		boolean equals(Object myObj);

		// @Override// Error
		public Object clone() throws CloneNotSupportedException;
	}
}



/**
 * <p> * @SuppressWarnings - Indicates that the named compiler warnings should be suppressed in the annotated element (and in all 
 program elements contained in the annotated element) </p>
 *  <p> * Disables a warning which a programmer considers it as an inappropriate warning.</p>
 *  <p> * It has local effects because it only suppresses unchecked warning pertaining to the declaration of a method. </p>
 * 
 */
class MySuppressWarnings {
	
	void method1(){
		@SuppressWarnings("unused")
		int unusedlocalvar = 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	void method2(){
		List list = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arraylist = (ArrayList<Integer>) list;
	}
	
}


/**
 * <p> * Deprecated - Use it to annotate a program element/unit that programmers are discouraged to use bcoz
 * 		 which is dangerous to use or better alternate exists.
 * <p> * Use of the @Deprecated annotation on a local variable declaration or on a parameter declaration has no effect.</p>
 *
 */
@Deprecated
class MyDeprecated {
	@Deprecated
	void method1(){
		
	}
	
	void method2(){
		// Warning Ignored : The use is within an entity that is itself annotated with the annotation @Deprecated
		method1();
		Thread.currentThread().destroy();
	}
}

class NonDeprecatedUnit {
	@Deprecated
	void method1(){
			
	}
	
	// Warning Ignored : The use is within an entity that is annotated to suppress the warning with the annotation @SuppressWarnings("deprecation");
	@SuppressWarnings("deprecation")
	void method2(){
		Thread.currentThread().destroy();
	}
	
	void method3(){
		// Warning Ignored : The use and declaration are both within the same outermost class.
		method1();
	}
}




/**
 * <p> * SafeVarargs - prevents a Java compiler from reporting unchecked warnings for the declaration or invocation
 * 	 		of a variable arity method or constructor with non-reifiable elements (parameters).</p>
 * <p> * It has non-local effects, bcoz suppresses unchecked warnings at method invocation expressions.</p> 
 * <p> * @SuppressWarnings("unchecked") annotation has local effects because it only suppresses unchecked warnings
 *  	pertaining to the declaration of a method. </p>
 * 
*/
class MySafevarargs {

	/**
		The SafeVarargs annotation has non-local effects because it suppresses unchecked
		warnings at method invocation expressions in addition to an unchecked warning
		pertaining to the declaration of the variable arity method itself. In contrast,
		the @SuppressWarnings("unchecked") annotation has local effects because it only
		suppresses unchecked warnings pertaining to the declaration of a method.

		It is a compile-time error if a fixed arity method or constructor declaration is
		annotated with the SafeVarargs annotation.
		
		
		It is a compile-time error if a variable arity method declaration that is neither
		static nor final is annotated with the SafeVarargs annotation.
	*/
	@SafeVarargs
	final <T> List<T> varArityMethod(T type, T... varArityElements) {
		List<T> list = new ArrayList<T>();
		addAll(new ArrayList<T>(), varArityElements);
		return list;

	}
	
	final <T> void varArgUsage(T type, T element) {
		List<T> list = varArityMethod(type, element); // Suppressed Type Safety warnings with an annotation (@SafeVarargs) at varArityMethod().
		System.out.println(list);
	}
	
	public static <T> boolean addAll(Collection<? super T> c,@SuppressWarnings("unchecked") T... elements) {
        boolean result = false;
        for (T element : elements)
            result |= c.add(element);
        return result;
    }
	
}

/**
 * Documented: meta-annotation, indicates that annotations with a type are to be
 * documented by javadoc and similar tools by default.
 * 
 */
@Documented
@MarkerAnnotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyDocumented {
	
}