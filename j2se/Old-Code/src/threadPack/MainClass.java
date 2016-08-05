package threadPack;

public class MainClass 
{

	
	public static void main(String[] args) 
	{
		System.out.println("Main Starts here");
		
		TClass tc=new TClass();
		tc.setDaemon(false);
		tc.start();
		
		System.out.println("**8**");
	
			new TClass(){
			public void run()
			{ 
			for(int i=0;i<5;i++)
				{
				System.out.println("At annonymous class");
				try{
					Thread.sleep(1000);			
				}
				catch(Exception e)
				{
					
				}
				
			}
			}
		}.start();
		System.out.println("Ends here");
	
	}

}
