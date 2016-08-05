package mine.interfaces.annotation;

/**
 * Annotation with Single-Element
 */
@SingleElementAnnotation("Single Element With Name 'value'")
public @interface SingleElementAnnotation {
	String value();
	// By convention, the name of the sole element in a single-element annotation type is 'value'.
}


//@SingleElementAnnotation2("Single Element With Name 'nonValue'") // Error; The attribute 'value' is undefined.
@interface SingleElementAnnotation2 {
	String nonValue();
}

@SingleElementAnnotation3("Value for value attribute")
@interface SingleElementAnnotation3 {
	String value();

	String nonValue() default "NonValue";

	String other() default "Other";
}