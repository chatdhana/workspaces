package mine.execution;

public class SimpleClassLoader {

	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	}
}


class MyClassLoader extends ClassLoader {
	
}

