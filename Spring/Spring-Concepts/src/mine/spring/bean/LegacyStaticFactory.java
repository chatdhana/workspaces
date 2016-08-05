package mine.spring.bean;

import java.util.HashMap;
import java.util.Map;

public class LegacyStaticFactory {

	private static volatile Map<String, AssetProduct> sharedObj = new HashMap<String, AssetProduct>();

	public static AssetProduct getProduct() {
		return getProduct("C");
	}

	public static AssetProduct getProduct(String type) {
		type = type == null ? "C" : type;
		if (!sharedObj.containsKey(type)) {
			if ("C".equals(type)) {
				sharedObj.put(type, new Card());
			} else {
				sharedObj.put(type, new Loan());
			}
		}
		System.out.println("Returning " + type + " from LegacyStaticFactory");
		return sharedObj.get(type);
	}

}
