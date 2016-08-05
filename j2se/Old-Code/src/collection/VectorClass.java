package collection;

import java.util.Vector;

public class VectorClass {

	
	public static void main(String[] args) {
		
		Thread t1=new Thread();
		Thread t2=new Thread();
		t1.start();
		t2.start();
		
	}
	void run()
	{
		Vector vo=new Vector();
		for(int i=0;i<5;i++)
		vo.add(new Integer(i));
	
		for(int i=0;i<5;i++)
			System.out.println(vo.get(i));
		
	}

}

