package mine.general;

import java.util.*;

public class Shadowing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Class1(true).x();
	}

}


interface IFace1 {
	String x = "x";
}

interface IFace2 {
	Integer x = 1;
}

class Class1 implements IFace1, IFace2 {
	Boolean x = true;
	public Class1(Boolean x) {
		this.x = x; // Accessing shadowed instance field 'x' by using this keyword.
	}
	void x() {
		int x =10;
		
		/* Field Declaration Shadowing */
		System.out.println("x(local):" + x);
		
		// Accessing shadowed field using this keyword or qualified name.
		System.out.println("x(this):" + this.x);
		System.out.println("x(IFace1):" + IFace1.x);
		System.out.println("x(IFace2):" + IFace2.x);
		
		/* Type Declaration Shadowing */
		List<String> shadowList =  new ArrayList();		
		shadowList.add("Element");
	}
}



class ArrayList implements List<String> {

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(String e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public String get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public String set(int index, String element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, String element) {
		// TODO Auto-generated method stub
		
	}

	public String remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<String> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}