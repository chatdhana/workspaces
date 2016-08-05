package pack7;

public class Rect implements Shape {

	int l,b;
	public void getdata()
    {
    	consoleinput in=new consoleinput();
    	try
    	{
    		System.out.println("enter b,l");
    	b=in.readInt();
    	l=in.readInt();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		
    	}
    }
	public void area()
	{
		
	System.out.println("area is:"+l*b);
	}

}