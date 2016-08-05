package mine.general;

import mine.exception.*;
import mine.polymorphism.*;
import bag.*;

public class InitOrder {
	public InitOrder() {
		System.out.println("Constructor");
	}

	static String staticVar1 = retStr("staticVar1");
	String instanceVar1 = retStr("instanceVar1");
	
	static {
		System.out.println("Static Init");
	}

	{
		System.out.println("Instance Init");
	}

	static String staticVar2 = retStr("staticVar2");
	String instanceVar2 = retStr("instanceVar2");
	
	private static String retStr(String arg){
		System.out.println(arg);
		return "StringValue";
	}
	public static void main(String[] args) {
		System.out.println("Main");
		InitOrder qtn = new InitOrder();
		ProtectedAccess b=new ProtectedAccess();
		Bag bag = null;
		for (;;) {
			try {
				Thread.sleep(1000);

				SubClass subClass = new SubClass();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

/**
 * @author dhana
 * 
 */
class SuperClass {
	static {
		System.out.println("Static Init Super");
	}
	{
		System.out.println("Instance Init Super");
	}

	public SuperClass() {
		System.out.println("Cunstructor Super");
	}
}

class SubClass extends mine.general.SuperClass {
	Shadowing shadowing;
	ARM arm;
	static {
		System.out.println("Static Init Sub");
	}
	{
		System.out.println("Instance Init Sub");
	}

	public SubClass() {
		System.out.println("Cunstructor Sub");
	}

}
