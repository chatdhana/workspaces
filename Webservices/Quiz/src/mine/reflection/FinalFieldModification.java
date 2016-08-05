package mine.reflection;

import java.lang.reflect.Field;

public class FinalFieldModification {

	private final String str1;

	FinalFieldModification() {
		str1 = retStr();
	}

	String retStr() {
		return "str1";
	}

	void check() {
		System.out.println(returnFinalField(this, this));
	}

	String returnFinalField(FinalFieldModification obj1, FinalFieldModification obj2) {
		System.out.println("str1:" + obj1.str1);
		changeValueReflection(obj1);
		System.out.println("str1:" + obj2.str1);
		return obj2.str1;
	}

	void changeValueReflection(FinalFieldModification obj1) {
		try {
			Class<? extends FinalFieldModification> clazz = obj1.getClass();
			Field fieldStr = null;
			for (Field field : clazz.getDeclaredFields()) {
				if (field.getName().equals("str1")) {
					fieldStr = field;
				}
			}
			fieldStr.setAccessible(true);
			fieldStr.set(obj1, "str2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FinalFieldModification().check();
	}

}
