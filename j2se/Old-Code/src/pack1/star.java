package pack1; 
public class star {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		

	//star s1=new star();
	//s1.disp();
		dis d=new dis();
		d.disp();
	}
	
	
		
	
		
	}


class dis
{
 void disp()
	{
		int a=6;
		for(int i=1;i<=a;i++)
		{
			for(int s=i;s<=a;s++)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print(" "+i);
			}
			System.out.println("");
		}
	}
}


