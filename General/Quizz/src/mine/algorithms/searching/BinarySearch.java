package mine.algorithms.searching;

/**
 * 
 * A binary search or half-interval search algorithm (implements Divide and Conquer paradigm).
 * 
 * Finds the position of a specified value (the input "key") within a sorted array.
 * 
 * In each step, the algorithm compares the input key value with the key value of the middle element of the array.
 * 
 * If the keys match, then a matching element has been found so its index, or position, is returned.
 * 
 * Otherwise, if the sought key is less than the middle element's key, then the algorithm repeats its action on the sub-array to
 * the left of the middle element or, if the input key is greater, on the sub-array to the right.
 * 
 * If the remaining array to be searched is reduced to zero, then the key cannot be found in the array and a special "Not found"
 * indication is returned.
 * 
 * Worst case performance: O(log n)
 * 
 * Best case performance: O(1)
 * 
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArray = { 2, 7, 8, 10, 16, 19, 23, 27, 34, 37, 39 };
		for (int key : sortedArray) {
			System.out.print("Key:" + key);
			System.out.print("|" + binarySearchIteration(sortedArray, key));
			System.out.println("|" + binarySearchRecursion(sortedArray, key, 0, sortedArray.length - 1));
		}

	}

	/**
	 * Binary search using Divide and Conquer, iteratively.
	 * 
	 * @param sortedArray
	 * @param key
	 * @return
	 */
	static int binarySearchIteration(int[] sortedArray, int key) {
		int start = 0;
		int end = sortedArray.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			// System.out.print("#"+mid+"#");
			if (key == sortedArray[mid]) {
				return mid;
			} else if (key < sortedArray[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	/**
	 * Binary search using Divide and Conquer, recursively.
	 * 
	 * @param sortedArray
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	static int binarySearchRecursion(int[] sortedArray, int key, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			// System.out.print("#"+mid+"#");
			if (key == sortedArray[mid]) {
				return mid;
			} else if (key < sortedArray[mid]) {
				return binarySearchRecursion(sortedArray, key, start, mid - 1);
			} else {
				return binarySearchRecursion(sortedArray, key, mid + 1, end);
			}
		}
		return -1;
	}
}
