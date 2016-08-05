package mine.src;

/**
 * 
 * Linear search or sequential search.
 * 
 * A method for finding a particular value in a list, that consists of checking every one of its elements, one at a time and in
 * sequence, until the desired one is found.
 * 
 * Linear search is the simplest search algorithm. For a list with n items, the best case is when the value is equal to the first
 * element of the list, in which case only one comparison is needed. The worst case is when the value is not in the list (or
 * occurs only once at the end of the list), in which case n comparisons are needed.
 * 
 * Linear searches don't require the collection to be sorted.
 * 
 * Worst case performance: O(n)
 * 
 * Best case performance: O(1)
 * 
 */
public class LinearOrSequentialSearch {

	public static void main(String[] args) {
		int[] sortedArray = { 2, 7, 8, 10, 16, 19, 23, 27, 34, 37, 39 };
		for (int key : sortedArray) {
			System.out.print("Key:" + key);
			System.out.println("|" + linearSearch(sortedArray, key));
		}
	}

	static int linearSearch(int[] unsortedArray, int key) {
		for (int i = 0; i < unsortedArray.length; i++) {
			if (key == unsortedArray[i]) {
				return i;
			}
		}
		return -1;
	}
}
