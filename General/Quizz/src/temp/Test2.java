package temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test2 implements Serializable{

	String str1 = null;
	String str2 = null;
	
	
	public static void main(String[] args) {
		print();
	}

	static native void print();
	synchronized  private void meth() {
		List list = new ArrayList<String>();
		
		synchronized(list) {
			list.add("");
			list.add(new Integer(10));	
		}
		
	}
	
	

}


class Out {
	static $Inn x = new $Inn();
	static void m(){
		System.out.println(x);
		$Inn.print();
	}
	private static class $Inn{
		static void print(){
			
		}
	}
}