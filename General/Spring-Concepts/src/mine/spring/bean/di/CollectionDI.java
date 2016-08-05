package mine.spring.bean.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionDI {
	private Properties userProperties;
	private List<Object> listOfObjs;
	private Set<Object> setOfObjs;
	private Map<Object, Object> mapOfObjs;
	private String[] stringArray;

	public Properties getUserProperties() {
		return userProperties;
	}

	public void setUserProperties(Properties userProperties) {
		this.userProperties = userProperties;
		System.out.println("userProperties:" + this.userProperties);
	}

	public List<Object> getListOfObjs() {
		return listOfObjs;
	}

	public void setListOfObjs(List<Object> listOfObjs) {
		this.listOfObjs = listOfObjs;
		System.out.println("listOfObjs:" + this.listOfObjs);
	}

	public Set<Object> getSetOfObjs() {
		return setOfObjs;
	}

	public void setSetOfObjs(Set<Object> setOfObjs) {
		this.setOfObjs = setOfObjs;
		System.out.println("setOfObjs:" + this.setOfObjs);
	}

	public Map<Object, Object> getMapOfObjs() {
		return mapOfObjs;
	}

	public void setMapOfObjs(Map<Object, Object> mapOfObjs) {
		this.mapOfObjs = mapOfObjs;
		System.out.println("mapOfObjs:" + this.mapOfObjs);
	}

	public String[] getStringArray() {
		return stringArray;
	}

	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
		System.out.println("stringArray:" + this.stringArray);
	}

}
