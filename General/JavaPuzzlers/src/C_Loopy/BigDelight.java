package C_Loopy;

/**
 *  Avoid mixed-type comparisons, because they are inherently confusing.
 *  
 *  Use declared constants in place of "magic numbers.
 *
 */
class BigDelight {
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90)
                System.out.print("Joy!");
        }
    }
}
