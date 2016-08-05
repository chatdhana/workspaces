package mine.interfaces;

/**
 * Every field declaration in the body of an interface is implicitly public,
 * static, and final. It is permitted to redundantly specify any or all of these
 * modifiers for such fields.
 * 
 */
public interface FieldConstant {

	/* public static final */int x = 0; // implicitly declared as 'public static final'
	public static final int y = 0; // Explicitly (redundantly) declared as 'public static final'

	/*
	 * At run-time, interface fields that are initialized with constant
	 * expressions are initialized first. This also applies to static final
	 * fields in classes.
	 */
}
