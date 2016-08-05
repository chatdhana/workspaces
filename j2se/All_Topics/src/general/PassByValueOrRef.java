package general;

public class PassByValueOrRef {
//	static Person person1 = new Person();
//	static Person person2 = new Person();

	public static void main(String[] args) {
		 Person person1 = new Person();
		System.out.println(person1);
		person1.id = 10;
		person1.name = "Dhana";
		System.out.println("person.id:" + person1.id);
		System.out.println("person.name:" + person1.name);
		new PassByValueOrRef().changeParam(person1);
		System.out.println("person.id:" + person1.id);
		System.out.println("person.name:" + person1.name);
		 Person person2 = new Person();
		System.out.println(person2);
		person2.id = 12;
		person2.name = "Krish";
		new PassByValueOrRef().exchangeObject(person1, person2);
		System.out.println("person.id:" + person1.id);
		System.out.println("person.name:" + person1.name);
		System.out.println("person.id:" + person2.id);
		System.out.println("person.name:" + person2.name);
	}

	private void changeParam(Person person) {
		person.id = 11;
		person.name = "Mani";
	}

	private void exchangeObject(Person person1, Person person2) {
		Person temp = person1;
		person1 = person2;
		person2 = temp;
		// person1.id = 13;
		// person1.name = "Ashok";
		// person2.id = 14;
		// person2.name = "Bala";
	}

}

class Person {
	int id;
	String name;
}
