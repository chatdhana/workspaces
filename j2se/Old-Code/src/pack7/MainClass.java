package pack7;
public class MainClass {

public static void main(String[] args)throws Exception {
	int  options=0;
	Shape s=null;
	System.out.println("enter the option");
	consoleinput in=new consoleinput();
    options=in.readInt();
	if(options==1)
	{
		s=new Circle();
		
		
	}
	else
		if (options==2)
	{
	s=new Rect();
			
			
	}
	s.getdata();
	s.area();
	}
}