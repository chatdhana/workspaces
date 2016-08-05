package mine.spring.bean.di;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import mine.spring.bean.BeanA;

public class AutowiringCollection {
	private BeanA[] stringArray;
	private List<BeanA> listCollection;
	private Map<String, BeanA> mapCollection;

	public AutowiringCollection() {
		System.out.println("Autowiring collection/array by byType mode:");
	}

	public AutowiringCollection(BeanA[] stringArray, List<BeanA> listCollection, Map<String, BeanA> mapCollection) {
		this.stringArray = stringArray;
		this.listCollection = listCollection;
		this.mapCollection = mapCollection;
		System.out.println("Autowiring collection/array by constructor mode:");
		System.out.println("this.stringArray:" + Arrays.toString(this.stringArray));
		System.out.println("this.listCollection:" + this.listCollection);
		System.out.println("this.mapCollection:" + this.mapCollection);
	}

	public BeanA[] getStringArray() {
		return stringArray;
	}

	public void setStringArray(BeanA[] stringArray) {
		this.stringArray = stringArray;
		System.out.println("this.stringArray:" + Arrays.toString(this.stringArray));
	}

	public List<BeanA> getListCollection() {
		return listCollection;
	}

	public void setListCollection(List<BeanA> listCollection) {
		this.listCollection = listCollection;
		System.out.println("this.listCollection:" + this.listCollection);
	}

	public Map<String, BeanA> getMapCollection() {
		return mapCollection;
	}

	public void setMapCollection(Map<String, BeanA> mapCollection) {
		this.mapCollection = mapCollection;
		System.out.println("this.mapCollection:" + this.mapCollection);
	}

}
