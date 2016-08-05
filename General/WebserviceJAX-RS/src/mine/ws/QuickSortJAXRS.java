package mine.ws;

import java.util.Arrays;

public class QuickSortJAXRS {

	public int[] doQuickSort(int[] inArray) {
		int[] sortedArray = quickSort(inArray);
		return sortedArray;
	}
	
	private int[] quickSort(int[] array) {
		int len = array.length;

		if (len <= 1) {
			return array;
		}

		int[] smaller = new int[len];
		int[] equal = new int[len];
		int[] larger = new int[len];
		int smallerIndex = 0;
		int equalIndex = 0;
		int largerIndex = 0;
		int pivot = findPivot(array);
		for (int i = 0; i < len; i++) {
			if (array[i] < pivot) {
				smaller[smallerIndex++] = array[i];
			} else if (array[i] == pivot) {
				equal[equalIndex++] = array[i];
			} else {
				larger[largerIndex++] = array[i];
			}
		}
		return concat(quickSort(Arrays.copyOf(smaller, smallerIndex)), Arrays.copyOf(equal, equalIndex),
				quickSort(Arrays.copyOf(larger, largerIndex)));
	}

	private static int[] concat(int[] smaller, int[] equal, int[] larger) {
		int[] result = new int[smaller.length + equal.length + larger.length];
		int resultIndex = 0;
		for (int i = 0; i < smaller.length; i++) {
			result[resultIndex++] = smaller[i];
		}
		for (int i = 0; i < equal.length; i++) {
			result[resultIndex++] = equal[i];
		}
		for (int i = 0; i < larger.length; i++) {
			result[resultIndex++] = larger[i];
		}

		return result;
	}

	private static int findPivot(int[] array) {
		return array[array.length/2];
	}
}
