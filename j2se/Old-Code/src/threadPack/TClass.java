package threadPack;

public class TClass extends Thread{

	
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			
			
			
			
			new TClass(){
				public void run()
				{ 
				for(int i=0;i<1;i++)
					{
					System.out.println("Child of Disp");
					try{
						Thread.sleep(1000);			
					}
					catch(Exception e)
					{
						
					}
					
				}
				}
			}.start();
			
			
			
			
			
			
			
		disp();
		try{
			Thread.sleep(1000);			
		}
		catch(Exception e)
		{
			
		}
		}		
	}
	public void disp()
	{
		System.out.println("Disp");
	}
}
