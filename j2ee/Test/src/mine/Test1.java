package mine;

import java.util.Observable;


class Test1 {
	private static native void registerNatives1();
	
	static {
		registerNatives1();
	}
	public static void main(String[] args) {
		int x = 1, y = 1;
		if (x == y) {
			
			System.out.println("XX");
		}
		registerNatives1();
	}

}


