package pack5;

public abstract class Abst {

	
	public static void main(String[] args) {
		
		//child c=
			new child().v();
		//c.v();
	
	}
	abstract void v();
}
class child extends Abst
{ 
	void v()
	{
	System.out.println("child");
	}
	
}