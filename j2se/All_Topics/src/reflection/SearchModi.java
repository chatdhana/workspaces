package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SearchModi {

	public static void printModifiers(String nam) {

		try {
			Class c = Class.forName(nam);
			int x = c.getModifiers();
			System.out.println("x=" + x);
			System.out.println("modifiers of " + c.getName() + "class are");

			if (Modifier.isPublic(x)) {
				System.out.println("public");
			}
			if (Modifier.isAbstract(x)) {
				System.out.println("Abstarct");
			}
			if (Modifier.isFinal(x)) {
				System.out.println("final");
			}
		}// try
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// method end

	static void getAttributes(String className) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InstantiationException {

		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		Field[] fields = cls.getDeclaredFields();
		// Test test = new Test();
		String[] strArr = { "11278", "dhana", "S" };
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
			fields[i].set(obj, strArr[i]);
		}

		Test test = (Test) obj;
		System.out.println(test.id + ":" + test.name + ":" + test.type);

	}

	public static void main(String args[]) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InstantiationException {
		// printModifiers(args[0]);

		getAttributes("reflection.Test");
	}// main

}// class
