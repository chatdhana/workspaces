package mine.interfaces.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import mine.classes.EnumConstantsWithClassBody;

@AnnotationType(key = "key", marker = @Retention(RetentionPolicy.RUNTIME))
public @interface AnnotationType /*// extends Annotation 'implicitly' */ /* an annotation type declaration cann't be Generic */ {
	/** Annotation Type Element Declaration */
	String key(); // Implicitly 'public abstract'
	public abstract String value() default "DEFAULT Value"; // Explicitly 'public abstract'
	
	//Note: Defaults are applied dynamically at the time annotations are read; default values are not compiled into annotations.
	
	String[] authors() default {"DHANA","MANI"}; // ElementValueArrayInitializer
	// String[] approvers() default null; // Compile-time error; null is not a legal element value
	String[] approvers() default s;
	// String[][] multiDim(); // Multi-dimensional arrays not allowed
	Class<? extends String> exceptionType() default String.class;
	EnumConstantsWithClassBody enumElement() default EnumConstantsWithClassBody.X;
	
	Retention marker(); //public & abstract are permitted
	
	//AnnotationType myAnn(); 
	/* Compile-time error; Cyclic detected. It is a compile-time error if an annotation type declaration T contains an element
	of type T, either directly or indirectly.*/
	
	/** Constant Declaration */
	public static final int x = 0;
	String s = ""; // all field members are implicitly 'public static final' as interface's field members
	
	/** Class Declaration */
	class ClassType {

	}

	/** Interface Declaration */
	interface IFaceType {

	}

	/** Enum Declaration */
	enum EnumType {

	}

	/** Annotation Declaration */
	@interface Annotation {

	}
	
	/* An annotation type declaration inherits several members from java.lang.annotation.Annotation, including the implicitly declared methods
	corresponding to the instance methods in Object */
	
	
}


class AnnotationUsageClass {

}

