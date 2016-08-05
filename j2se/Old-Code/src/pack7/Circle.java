package pack7;

public class Circle implements Shape{
	public  int r;
    public void getdata()
    {
    	consoleinput in=new consoleinput();
    	try
    	{
    		System.out.println("radius of circle");
    	r=in.readInt();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		
    	}
    }
public void area()
{	
 System.out.println("area is:"+pi*r*r);
}


}
