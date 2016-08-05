package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


public class SerializationExample {
	
	public static void main(String[] args) {
		
		new Serialize();
		Timer.staticField=10;
//		new DeSerialization();
	
	
	}
}

//Serializable class
class Timer implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Date time;
	static int staticField=6;
	int instanceField=1222221;

	public Timer() {
		time=Calendar.getInstance().getTime();
	}

	public Date getTime() {
		return time;
	}

}

//To inflate
class DeSerialization 
{
	public DeSerialization() {
		System.out.println("Performing Deserialization.....");
	try{
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Documents and Settings\\dgovindan\\Desktop\\object.txt"));
		Timer timer=(Timer)in.readObject();
		System.out.println(timer.getTime());
	
		System.out.println(timer.staticField);
		in.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}

//To Serialize
class Serialize
{
	public Serialize() {
		
		try {
			
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\Documents and Settings\\dgovindan\\Desktop\\object.txt"));
		out.writeObject(new Timer());
		out.close();
		System.out.println("Serilization successful");
		}catch (Exception e) {
		e.printStackTrace();
		
		}
	}
}
