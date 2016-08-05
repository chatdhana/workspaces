package mine.spring.bean.di;

import mine.spring.bean.SpringAppContextAware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PrototypeBeanInjectionAppCtxAware implements ApplicationContextAware {
	private int intField;
	private float floatField;
	private String stringField;
	private Object objField;
	private int[] intArray;
	private Object[] objArray;
	private PrototypeBean prototypeBean;

	private ApplicationContext appCtx;

	public void usageMethod() {
		System.out.println("Gets brand new instance of PrototypeBean on every request." + createPrototypeBean());
	}

	protected PrototypeBean createPrototypeBean() {
		return (PrototypeBean) SpringAppContextAware.getAppContext().getBean("prototypeBean");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.appCtx = arg0;
	}

	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}

	public float getFloatField() {
		return floatField;
	}

	public void setFloatField(float floatField) {
		this.floatField = floatField;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public Object getObjField() {
		return objField;
	}

	public void setObjField(Object objField) {
		this.objField = objField;
	}

	public int[] getIntArray() {
		return intArray;
	}

	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}

	public Object[] getObjArray() {
		return objArray;
	}

	public void setObjArray(Object[] objArray) {
		this.objArray = objArray;
	}

	public ApplicationContext getAppCtx() {
		return appCtx;
	}

	public void setAppCtx(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	public PrototypeBean getPrototypeBean() {
		return prototypeBean;
	}

	public void setPrototypeBean(PrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
	}

}
