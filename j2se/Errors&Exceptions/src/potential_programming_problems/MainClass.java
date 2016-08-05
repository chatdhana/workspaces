package potential_programming_problems;


public class MainClass  {
	static int $=1;
	int x;
	byte v_byte=+127;
	short v_short=32767;
	int v_int =v_short*v_short;
	boolean flag=v_byte<v_short;
	
	
	
	public static void main(String[] args) {
		System.out.println($);
		new MainClass().temp();
		
	}
	
	void temp() {
		System.out.println(v_byte);
		System.out.println(flag);
	}

}

