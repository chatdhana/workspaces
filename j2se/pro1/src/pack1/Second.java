package pack1;

public class Second {
	public Second()
	{
	
	}
		
	public static void main(String[] args) {
		new Second().temp();

	}
void temp(){
	
}
}

class Child extends Second
{

	
	void disp()
	{
	new Child();	
	}
}

interface Int1
{
	public void temp();
	
}
interface Int2
{
	public void temp();
}

interface Int3
{
	public void temp();
}
 abstract class AbsClass implements Int1,Int2,Int3
{
	int i;

	
}