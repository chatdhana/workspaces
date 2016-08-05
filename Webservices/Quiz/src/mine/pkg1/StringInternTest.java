package mine.pkg1;

import java.util.ArrayList;
import java.util.List;

import mine.pkg2.StringInternClass2;

public class StringInternTest {

	public static void main(String[] args) {
		checkPermGenSize();
	}

	static void checkForEqualinty() {
		System.out.println("C1:" + (StringInternClass1.str1 == StringInternClass2.str1));
	}

	static void checkPermGenSize() {
		List<String> internalizedStrList = new ArrayList<String>();
		long i = 0;
		while (true) {
			internalizedStrList.add(("InternalizedString" + i++).intern());
			try {
				if (i % 1000 == 0)
					Thread.sleep(500);
				if(i%10000 ==0)
					internalizedStrList.clear();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
