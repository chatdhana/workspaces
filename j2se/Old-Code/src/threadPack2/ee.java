package threadPack2;

public class ee {

	
	public static void main(String[] args) throws Exception{
		
     eve a =new eve();
     odd b=new odd();
    
     
     odd.o=a;
     a.start();
     
     b.start();
     
		
		
		
		
		
		
		
	}

}
class eve extends Thread
{
	public void run(){
		
		
				for(int i=0;i<100;i++){
				
		if((i%2)==0){
			System.out.println(i+" even");
			
			
				if(i>=10){
					synchronized(this){
						
						notify();
					}
				}
			
		}
		try{
		//Thread.sleep(10);
		}
		catch(Exception e)
		{
			
		}
	}
				
				
				
		}
	}





class odd extends Thread{
	static eve o;
	public void run()
	{
		synchronized(o)
		{
			
			try
			{
			o.wait();
			}
			catch(InterruptedException ie)
			{
				
			}
			
		for(int i=0;i<100;i++){
			if((i%2)!=0){
				System.out.println(i+" Odd");
				}
	try{
		Thread.sleep(10);
		}
		catch(Exception ex)
		{
			
		}
		}
		
}
		
}
	
}





















