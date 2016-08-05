package mine.spring.bean.scope;

import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class MyThreadScope implements Scope {

	private static ThreadLocal<Map<String, Object>> threadScope = new ThreadLocal<Map<String, Object>>();

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map<String, Object> scope = threadScope.get();
		Object obj = scope.get(name);
		if (obj == null) {
			obj = objectFactory.getObject();
			scope.put(name, obj);
		}
		return obj;
	}

	@Override
	public Object remove(String name) {
		Map<String, Object> scope = threadScope.get();
		return scope.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {

	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return Thread.currentThread().getName();
	}

}
