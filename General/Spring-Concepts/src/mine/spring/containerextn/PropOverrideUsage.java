package mine.spring.containerextn;

public class PropOverrideUsage {

	private String property1 = null;
	private String property2 = null;

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
		System.out.println("PropOverrideUsage: property1=" + property1);
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
		System.out.println("PropOverrideUsage: property2=" + property2);
	}

}
