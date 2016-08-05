package pack1;

import java.util.Locale;

public class LocaleClass {

	
	public static void main(String[] args) {
		Locale l=new Locale("tm");
		Locale[] l1=l.getAvailableLocales();
		for(Object o: l1)
		{
			System.out.println(o.toString());
		}

	}

}
