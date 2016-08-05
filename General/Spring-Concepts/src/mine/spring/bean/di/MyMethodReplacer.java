package mine.spring.bean.di;

import java.lang.reflect.Method;

import mine.spring.bean.SpringAppContextAware;

import org.springframework.beans.factory.support.MethodReplacer;

public class MyMethodReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		return SpringAppContextAware.getAppContext().getBean("prototypeBean");
	}

}
