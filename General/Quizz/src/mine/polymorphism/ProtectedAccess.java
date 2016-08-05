package mine.polymorphism;

import pack1.ProtectedAccessSuperClass;

public class ProtectedAccess extends ProtectedAccessSuperClass {
	int temp;

	void accessSuper(ProtectedAccessSuperClass superClass) {
		// temp = superClass.x; // Can't access default package access member x.
		// temp = superClass.y; // Can't access protected member y, it is not
		// involved in the implementation of ProtectedAccessSuperClass.
		this.z = superClass.z;

		/*
		 * A protected constructor can be accessed by a class instance creation
		 * expression only from within the package in which it is defined.
		 */
		// ProtectedAccessSuperClass protSuperInstance = new ProtectedAccessSuperClass();
		super.y = this.y; // Can access protected member using this. it is involved in the implementation of ProtectedAccessSuperClass.
	}

	public ProtectedAccess() {
		super();
	}
}
