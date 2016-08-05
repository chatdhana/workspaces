package mine.spring.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CombinedLifecyclemechanisms implements InitializingBean, DisposableBean {
	private int intField;
	private String stringField;
	private Object objField;

	@PostConstruct
	public void postConstruct() {
		System.out.println("CombinedLifecyclemechanisms called postConstruct().");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.intField = 1;
		this.stringField = "via afterPropertiesSet()";
		this.objField = null;
		System.out.println("CombinedLifecyclemechanisms called afterPropertiesSet()");
	}
	
	public void initMethod() {
		this.intField = 1;
		this.stringField = "via init-method";
		this.objField = null;
		System.out.println("CombinedLifecyclemechanisms called init-method");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("CombinedLifecyclemechanisms called preDestroy().");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("CombinedLifecyclemechanisms called DisposableBean's destroy().");
	}

	public void destroyMethod() {
		System.out.println("CombinedLifecyclemechanisms called destroy-method.");
	}
}
