package dynamic_method_dispatch;

public class DynamicDispatch {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//Assigning a reference of an object of type class B to a variable of type class A.
		A ab = new B();
		a.f(ab);
		a.g(b);
		b.f(ab);
		b.g(a);
		b.h(ab);
		ab.f(a);
	//	ab.h(a);
		ab.f(ab);

	}

}

class A {
	A() {
//		System.out.println("A.A()");
	}

	public void f(A a) {
		System.out.println("A.f(A)");
	}

	public void f(B b) {
		System.out.println("A.f(B)");
	}

	public void g(A a) {
		System.out.println("A.g(A)");
	}
}

class B extends A {
	B() {
//		System.out.println("B.B()");
	}

	public void f(A a) {
		System.out.println("B.f(A)");
	}

	public void f(B b) {
		System.out.println("B.f(B)");
	}

	public void g(B b) {
		System.out.println("B.g(B)");
	}

	public static void h(A a) {
		System.out.println("B.h(A)");
	}
}

