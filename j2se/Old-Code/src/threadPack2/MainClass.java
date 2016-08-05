package threadPack2;

public class MainClass {

	
	public static void main(String[] args) {
		RTClass rtc=new RTClass();
		Thread t1=new Thread(rtc);
		Thread t2=new Thread(rtc);
		Thread t3=new Thread(rtc);
		
		
		t1.setName("T1");
		//t1.setPriority(10);
		
		t1.start();
		
		t2.setName("T2");
		
		t2.start();
		
		t3.setName("T3");
		
		t3.start();
	}

}
