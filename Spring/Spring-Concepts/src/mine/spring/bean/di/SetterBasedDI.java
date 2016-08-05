package mine.spring.bean.di;

public class SetterBasedDI {
	private DICollBeanA depBeanA;
	private DICollBeanB depBeanB;

	public DICollBeanA getDepBeanA() {
		return depBeanA;
	}

	public void setDepBeanA(DICollBeanA depBeanA) {
		this.depBeanA = depBeanA;
	}

	public DICollBeanB getDepBeanB() {
		return depBeanB;
	}

	public void setDepBeanB(DICollBeanB depBeanB) {
		this.depBeanB = depBeanB;
	}

}
