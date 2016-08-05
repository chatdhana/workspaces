package mine.spring.containerextn;

public class PropPaceholderUsage {

	private String prop1 = null;

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
		System.out.println("PropPaceholderUsage: prop1="+prop1);
	}

}
