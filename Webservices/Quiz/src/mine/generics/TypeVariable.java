package mine.generics;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class TypeVariableSuperClass implements TypeVariableIface, Remote, Serializable {

	private static final long serialVersionUID = 1L;

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public String next() {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove() {
		// TODO Auto-generated method stub

	}

}

class TypeVariableSubClass extends TypeVariableSuperClass {

	private static final long serialVersionUID = 1L;

}

class TypeVariableSubClass2 extends TypeVariableSubClass {

	private static final long serialVersionUID = 1L;

}

interface TypeVariableIface extends Iterator<String> {

}

class TypeVariable<TV, TV2 extends TypeVariableIface & Iterator<String> & Serializable> {
	TV typeVarible;

	public <X> TypeVariable(TV typeVarible, Collection<? extends Set<?>> a,
			List<? super TypeVariableSubClass2> b, X x) {
		this.typeVarible = typeVarible;
	}

	public TV getTypeVarible() {
		return typeVarible;
	}

	public void setTypeVarible(TV typeVarible) {
		this.typeVarible = typeVarible;
	}

	public <S> void display(S s){
		System.out.println(s.getClass());
		if(s instanceof String){
			System.out.println(s.toString());
		}
	}
	public static void main(String[] args) {
		TypeVariable<String, TypeVariableSuperClass> tv = new<String> TypeVariable<String, TypeVariableSuperClass>(
				"GenericClassString", new ArrayList<HashSet<String>>(),
				new ArrayList<TypeVariableIface>(), "GenericConstructorString");
		System.out.println(tv.getTypeVarible());
		tv.setTypeVarible("xxxxx");
		tv.<String>display("GenericMethodString");
		Object obj = new int[100];
		List l = new ArrayList<Number>();
		List<String> ls = l;
		
		
	}

}