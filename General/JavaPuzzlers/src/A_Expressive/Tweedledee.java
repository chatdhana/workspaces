package A_Expressive;

public class Tweedledee {
    public static void main(String[] args) {
        // Put your declarations for x and i here
    	// int i=0,x=0;
    	
    	// Puzzle solution not working.
    	Object x = "x";
    	String i = "i";
        x = x + i;  // Must be LEGAL
        x += i;     // Must be ILLEGAL
    }
}
