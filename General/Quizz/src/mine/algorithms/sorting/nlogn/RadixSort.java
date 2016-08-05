package mine.algorithms.sorting.nlogn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Radix Sort
 * 
 * A non-comparative integer sorting algorithm.
 * 
 * Sorting involves examining of digits of the key separately, starting with 1s, 10s, 100s,.. (if LSD approach) or Ns, N-1s,
 * N-2s,.. (if MSD approach).
 * 
 * Disassembles a key into digits and arranges the data item according to the value of the digits.
 * 
 * Classification: Least Significant Digit (LSD) and Most Significant Digit (MSD)
 * 
 * Radix: means the base of the system of numbers (e.g. 2 is the radix of the binary system).
 * 
 * Steps (for LSD):
 * 
 * 1) Divide data items into 10 groups/buckets, according to the value of their Place Value (1s, 10s, 100s,..) digits.
 * 
 * 2) Reassemble buckets of keys into an array, starting with 0's bucket, 1's bucket,.., 9's bucket in order.
 * 
 * 3) Multiply the current Place Value by 10.
 * 
 * 4) Repeat steps: 1,2, and 3 ; continue till max key's number of digits.
 * 
 * 
 * No.of Copies: O(2*N) --> O(N) , where N is number of keys.
 * 
 * No.of Comparisons: NIL
 * 
 * Worst Case: O(N * log N)
 * 
 * 
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] array = { 987, 543, 213, 456, 789, 765, 432, 34, 788, 210, 300, 456, 98760, 54321, 100, 10, 1 };
		System.out.println("Unsorted Array:" + Arrays.toString(array));
//		int[] sortedArrayusingLSD = radixSortLSD(array);
//		System.out.println("Sorted Array (Radix LSD):" + Arrays.toString(sortedArrayusingLSD));
//		
		int[] sortedArrayusingMSD = radixSortMSD(array);
		System.out.println("Sorted Array (Radix MSD):" + Arrays.toString(sortedArrayusingMSD));
//		System.out.println(getNthDigitMSD(4321, 4));
//		System.out.println(getNthDigitMSD(54321, 3));
//		System.out.println(getNthDigitMSD(54321, 2));
//		System.out.println(getNthDigitMSD(54321, 1));
//		System.out.println(getNthDigitMSD(54321, 0));
		
	}

	public static int[] radixSortLSD(int[] array) {
		int len = array.length;
		int maxDigits = getMaxDigits(array);
		int digitPos = 0;
		List<List<Integer>> buckets = new ArrayList<>();
		for(int i=0; i<10;i++){
			buckets.add(new ArrayList<Integer>());
		}
		
		while (digitPos < maxDigits) {
			// 1) Divide data items into 10 groups/buckets, according to the value of their Place Value (1s, 10s, 100s,..) digits.
			for (int i = 0; i < len; i++) {
				buckets.get(getNthDigitLSD(array[i], digitPos)).add(array[i]);
			}
			
			// 2) Reassemble buckets of keys into an array, starting with 0's bucket, 1's bucket,.., 9's bucket in order.
			array = reassembleBuckets(buckets,len);
			
			digitPos++;
		}
		return array;
	}
	
	public static int[] radixSortMSD(int[] array) {
		int len = array.length;
		int maxDigits = getMaxDigits(array);
		int digitPos = maxDigits-1;
		List<List<Integer>> buckets = new ArrayList<>();
		for(int i=0; i<10;i++){
			buckets.add(new ArrayList<Integer>());
		}
		
		while (digitPos > 0) {
			// 1) Divide data items into 10 groups/buckets, according to the value of their Place Value (Ns, N-1s,.. 100s, 10s, 1s) digits.
			for (int i = 0; i < len; i++) {
				System.out.println("digitPos:"+digitPos+"|i:"+i+"|"+array[i]);
				buckets.get(getNthDigitLSD(array[i], digitPos)).add(array[i]);
			}
			
			// 2) Reassemble buckets of keys into an array, starting with 0's bucket, 1's bucket,.., 9's bucket in order.
			array = reassembleBuckets(buckets,len);
			
			digitPos--;
		}
		return array;
	}
	

	private static int getMaxDigits(int[] array) {
		int maxValue = 0;
		int maxDigits = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		
		//((int)Math.log10(Math.abs(maxValue)))+1;
		
		while (maxValue > 0) {
			maxValue /= 10;
			maxDigits++;
		}
		return maxDigits;
	}

	private static int getNthDigitLSD(int number, int pos) {
		while (pos-- > 0) {
			number /= 10;
		}
		return number % 10;
	}

	private static int getNthDigitMSD(int number, int pos) {
		int tempNumber = number;
		int noOfDigits=0;
		int modDivisor=10;
		
		while (number > 0) {
			number /= 10;
			noOfDigits++;
		}
		
		if(pos<noOfDigits-1){
			modDivisor = (int)Math.pow(10, noOfDigits-pos);
		}
		
		while(noOfDigits++ < pos){
			tempNumber *= 10;
		}
		
		while (pos-- > 0) {
			tempNumber /= 10;
		}
		return getNthDigitLSD(tempNumber%modDivisor,0);
	}
	
	private static int[] reassembleBuckets(List<List<Integer>> buckets, int len) {
		int[] array = new int[len];
		int index = 0;
		for (List<Integer> bucket : buckets) {
			for (Integer key : bucket) {
				array[index++] = key;
			}
			bucket.clear();
		}
		
		return array;
	}

}
