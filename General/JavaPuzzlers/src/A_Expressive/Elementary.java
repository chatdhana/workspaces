package A_Expressive;

/**
 * Always use a capital el (L) (type suffix) in long literals, never a lower case el (l). D for double, F for float. 
 *
 */
public class Elementary {
    public static void main(String[] args) {
        // Bad way
    	System.out.println(12345 + 5432l);
    	
    	// Good way
    	System.out.println(12345 + 5432L);
    	
    }
}
