package threadPack2;

public class RTClass implements Runnable {
int x=10;
	synchronized public void run()
	{
		for(int i=0;i<3;i++)
		{
			String s=Thread.currentThread().getName();
			int p=Thread.currentThread().getPriority();
		System.out.println("my thread:"+s);
		x++;
		System.out.println("x:"+x);
		System.out.println("Priority:"+p);
		/*try{
			Thread.sleep(1000);			
		}
		catch(Exception e)
		{
			
		}*/
	}
	}
}


