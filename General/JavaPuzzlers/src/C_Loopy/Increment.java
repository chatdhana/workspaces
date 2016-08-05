package C_Loopy;

/**
 * Do not assign to the same variable more than once in a single expression. 
 *
 */
public class Increment {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++)
            j = j++;
        
        System.out.println(j);
    }
}
