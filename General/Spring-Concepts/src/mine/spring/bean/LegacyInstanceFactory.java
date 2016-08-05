package mine.spring.bean;

import java.util.HashMap;
import java.util.Map;

public class LegacyInstanceFactory {
	private static volatile Map<String, AssetProduct> sharedObj = new HashMap<String, AssetProduct>();

	public AssetProduct getProduct() {
		return getProduct("C");
	}

	public AssetProduct getProduct(String type) {
		type = type == null ? "C" : type;
		if (!sharedObj.containsKey(type)) {
			if ("C".equals(type)) {
				sharedObj.put(type, new Card());
			} else {
				sharedObj.put(type, new Loan());
			}
		}
		System.out.println("Returning " + type + " from LegacyInstanceFactory");
		return sharedObj.get(type);
	}
}
