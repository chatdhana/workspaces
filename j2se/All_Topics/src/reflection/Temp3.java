package reflection;

import temp.Temp1;
import temp.Temp2;


public class Temp3 {
	public static void main(String[] args){
		Temp1  t = new Temp1();
		int x=30;
		System.out.println(Temp1.staticVar);
		System.out.println(t.instVar);
		t.instVar=30;
		Temp2.main(t);
		System.out.println(Temp1.staticVar);
		System.out.println(t.instVar);
	}

}
