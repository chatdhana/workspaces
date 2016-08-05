package mine.spring.bean.di;

public class Autowiring {
	private AutowireCollBeanA autowireCollBeanA;
	private AutowireCollBeanB autowireCollBeanB;
	private String mode;

	public Autowiring() {
	}
	public Autowiring(AutowireCollBeanA autowireCollBeanA, AutowireCollBeanB autowireCollBeanB, String mode) {
		this.autowireCollBeanA = autowireCollBeanA;
		this.autowireCollBeanB = autowireCollBeanB;
		this.mode = mode;
		System.out.println("Autowire mode:" + this.mode);
		System.out.println("this.autowireCollBeanA:"+this.autowireCollBeanA);
		System.out.println("this.autowireCollBeanB:"+this.autowireCollBeanB);
		
	}

	public AutowireCollBeanA getAutowireCollBeanA() {
		return autowireCollBeanA;
	}

	public void setAutowireCollBeanA(AutowireCollBeanA autowireCollBeanA) {
		this.autowireCollBeanA = autowireCollBeanA;
		System.out.println("this.autowireCollBeanA:"+this.autowireCollBeanA);
	}

	public AutowireCollBeanB getAutowireCollBeanB() {
		return autowireCollBeanB;
	}

	public void setAutowireCollBeanB(AutowireCollBeanB autowireCollBeanB) {
		this.autowireCollBeanB = autowireCollBeanB;
		System.out.println("this.autowireCollBeanB:"+this.autowireCollBeanB);
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
		System.out.println("Autowire mode:" + this.mode);
	}

}
