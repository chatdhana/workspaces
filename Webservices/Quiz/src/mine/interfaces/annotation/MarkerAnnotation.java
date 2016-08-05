package mine.interfaces.annotation;

/**
 * Marker Annotation - 
 * An annotation with no elements is called Marker Annotation. 
 *  
 * Sometimes short-hand form of annotation with elements is also called Marker Annotation,
 * as long as all the elements have default values.
 */
public @interface MarkerAnnotation {

	// Annotation type has zero element -- Marker Annotation
}


/**
 * Normal annotation can also be act as Marker Annotation, if all the elements have default values.
 *
 */
@NormalAnnotation 
@interface NormalAnnotation {

	// Annotation with elements have default values -- can act as Marker Annotation
	String element1() default "E1";
	String element2() default "E2";
}