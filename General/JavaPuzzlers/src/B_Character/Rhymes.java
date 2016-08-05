package B_Character;

import java.util.*;

/**
 * 1) Watch out for fencepost errors.
 * 
 * 2) Don't fall through from one nonempty case to another.
 * 
 * 3) Use familiar idioms and APIs whenever possible. If you must use unfamiliar APIs, read the documentation carefully.
 *
 */
public class Rhymes {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        StringBuffer word = null;
        switch(rnd.nextInt(2)) {
            case 1:  word = new StringBuffer('P');
            case 2:  word = new StringBuffer('G');
            default: word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }
}
