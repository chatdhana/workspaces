package mine.util;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<Student> studentSet = new HashSet<>();
		addStudents(studentSet);
		System.out.println(studentSet.size());
	}

	static void addStudents(Set<Student> studentSet) {

		for (int i = 0; i < 5; i++) {
			System.out.println(studentSet);
			studentSet.add(new Student("name-", "dept-"));

		}
	}
}

class Student {
	String name;
	String dept;

	public Student(String name, String dept) {
		this.name = name;
		this.dept = dept;

	}

	@Override
	public int hashCode() {

		return name.hashCode() + dept.hashCode() * 4;
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(((Student) obj).name) && dept.equals(((Student) obj).dept);
	}
}
