package threadPack2;

public class StackClass {

	
		public static void main(String[] args) {  	
		push pu=new push();
		Thread p1=new Thread(pu);
		pop po=new pop();
		Thread p2=new Thread(po);
		p1.setName("Push");
		p2.setName("Pop");
		p1.start();
		
		Thread.currentThread().setDaemon(true);
		StackImp so=new StackImp();
		
		if(so.isEmpty())
		{
			try{
				p2.wait();
			}
			catch(Exception e)
			{
				
			}
			
			}
			else{
				if(((p2.getState().equals("WAITING"))))
						{
					p2.start();
						}
				else
					p2.notify();
				
				
			
			}
		if(so.isFull())
		{
			
		}
		
		/*
		(new Thread("Pusher") {
		public void run() {
		for(;;) {
		System.out.println("Pushed: " +
		stack.push(new Integer(i)));
		i++;
		}
		}
		}).start();
		
		
		
		
		(new Thread("Popper") { 
		public void run() {
		for(;;) {
		System.out.println("Popped: " + stack.pop());
		}
		}
		}).start();
		*/
		System.out.println("Exit from main().");
		}
		}



class push extends Thread
{			int i=1;
	 		final StackImp stack = new StackImp(20); 
	 
			public void run() {
			for(;;) {
			System.out.println("Pushed: " +
			stack.push(new Integer(i)));
			i++;
			}
			}
			
}

class pop extends Thread
{int i=1;
	final StackImp stack = new StackImp(20); 
	 public void run() {
			for(;;) {
			System.out.println("Popped: " + stack.pop());
			}
			}
}

	

 class StackImp{ 
	public Object[] stackArray;
	public int topOfStack;
	
	public StackImp() {
		
		}
		
	public StackImp(int capacity) {
	stackArray = new Object[capacity];
	topOfStack = -1;
	}
	
	
	public boolean push(Object element) { 
	
	if (isFull()) 
		{
		
		return false;
		
		}
	++topOfStack;
	try { Thread.sleep(1000); } catch (Exception ex) { } 
	stackArray[topOfStack] = element;
	return true;
	}
	
	
	
	synchronized public Object pop() {
	
	if (isEmpty())
		{
		return null;
		}
	
	Object obj = stackArray[topOfStack];
	stackArray[topOfStack] = null;
	try { Thread.sleep(1000); } catch (Exception ex) { } 
	topOfStack--;
	return obj;
	}
	
	
	public boolean isEmpty() { 
		return topOfStack < 0;
		}
	
	
	public boolean isFull() {
		return topOfStack >= stackArray.length - 1; 
		}
	}
 
 