package overloading;

public class SupSubClass {

	
	public static void main(String[] args) {
	

Super sup=new Sub();
sup.print();



	}
	Super display()
	{
		return new Sub();
	}


}

class Super
{
	public Super() {
		System.out.println("from Super Cons");
	}

	void print()
	{
		System.out.println("from Super class");
	}
	
}

class Sub extends Super
{
	Sub() {
		System.out.println("from Sub cons");
	}
	void print()
	{
		System.out.println("from Sub class");
	}
}