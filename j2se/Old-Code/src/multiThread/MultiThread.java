package multiThread;

public class MultiThread extends Thread {
	public void run()
	{
		for(int i=0;i<10;i++)
		{
		System.out.println("MyThread");
		try{
			Thread.sleep(2000);
		}
				
		catch(Exception e)
		{
			
		}
		
	}

	}
}

	
	

