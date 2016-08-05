package mine.interfaces;

public class TestMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImplicitlyDeclaredMethodsSunInterface varName = new ImplicitlyDeclaredMethodsSunInterfaceClass();
		System.out.println(varName.toString());
	}

}


class ImplicitlyDeclaredMethodsSunInterfaceClass implements ImplicitlyDeclaredMethodsSunInterface {

	public int ownAbstractMethod() {
		return 0;
	}
	
}