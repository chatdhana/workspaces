package mine.algorithms.javaapi;

import java.util.Comparator;

public class MobilePriceComparator implements Comparator<Mobile> {
	@Override
	public int compare(Mobile o1, Mobile o2) {
		return (int)(o1.price - o2.price);
	}

}
