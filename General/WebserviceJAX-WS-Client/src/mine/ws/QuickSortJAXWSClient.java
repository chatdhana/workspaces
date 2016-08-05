package mine.ws;

import java.util.Arrays;
import java.util.Random;

public class QuickSortJAXWSClient {

	public static void main(String[] args) {
		try {
			QuickSortJAXWS serv = new QuickSortJAXWSServiceLocator().getQuickSortJAXWS();
			int[] unsortedArray = new int[100];
			for (int i = 0; i < 100; i++) {
				unsortedArray[i] = new Random().nextInt(1000);
			}
			System.out.println("UnSortedArray:" + Arrays.toString(unsortedArray));
			int[] sortedArray = serv.doQuickSort(unsortedArray);
			System.out.println("SortedArray:" + Arrays.toString(sortedArray));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
