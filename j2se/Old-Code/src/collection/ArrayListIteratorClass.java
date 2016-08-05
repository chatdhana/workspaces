package collection;
import java.util.*;

public class ArrayListIteratorClass {

	
	public void aList(){
		
	ArrayList a=new ArrayList();
	
	for(int i=0;i<5;i++)
	a.add(new Integer(i));
	
	ListIterator io=a.listIterator();
	
	while(io.hasNext())
{
		
		int i=io.nextIndex();
		Object o=io.next();
		if(i==3)
		{System.out.println("hdjkhgdk " + (Integer)o);
		
		io.remove();
		}
		
	
}

	
	while(io.hasPrevious())
	{
		
		System.out.println(io.previous());
			 
			 }
		
	}

	

	}


