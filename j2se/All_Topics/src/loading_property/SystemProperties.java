package loading_property;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class SystemProperties {

	
	public static void main(String[] args) {
		Properties property=System.getProperties();
		Set<Entry<Object,Object>> s=property.entrySet();
		
		for (Iterator<Entry<Object, Object>> iterator=s.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}

}
