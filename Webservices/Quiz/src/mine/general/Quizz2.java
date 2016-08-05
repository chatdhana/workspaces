package mine.general;

public class Quizz2 extends Quizz2Sub {
	String x ="Quizz2";
	public static void main(String[] args) {
		Quizz2 quizz2 = new Quizz2();
		quizz2.caller();
	}
	
	void caller(){
		this.m();
		super.m();
		((Quizz2Sub)this).m();
		System.out.println(this.x);
		System.out.println(super.x);
		System.out.println(((Quizz2Sup)this).x);
	}
	
	void m(){
		System.out.println("Quizz2");
	}
	

}


class Quizz2Sup {
	String x ="Quizz2Sup";
	void m(){
		System.out.println("Quizz2Sup");
	}
}

class Quizz2Sub extends Quizz2Sup {
	String x ="Quizz2Sub";
	void m(){
		System.out.println("Quizz2Sub");
	}
}
