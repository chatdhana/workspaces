package mine.exception;

import java.io.FileNotFoundException;
import java.io.IOException;


public class TryCatch {

	public static void main(String[] args) {
		new TryCatch().method();
	}
	class E1 extends Exception {
	}

	class E2 extends E1 {
	}

	class E3 extends E2 {
	}
	
	void method() {
		
		// Transitive Type (E3 <: E2 <: E1) Exception handler
		try {
			
			throw new E3();
		} catch (E2 e) {
		} catch (E1 e) { // Warning: Specific exceptions are thrown and they are handled by previous catch block.
		}
		
		// Catching Type and SubTypes.
		try {
			throw new FileNotFoundException(); // Statically Throwing Exception
		} catch (IOException ioe) {
		}
		
		try {
			m();
		} catch (FileNotFoundException fnfe) {
		} catch (IOException ioe) {
		} catch (Throwable t) {
		}
		
		// Unchecked Exception
		try {
			throw new RuntimeException();
		} catch(Throwable e){ // Catches RuntimeException.
		} finally {
		}
		
		// Unchecked Exception		
		try {
			throw new RuntimeException(); // Error at Runtime
		} catch(Error e){ // Catching RuntimeException at compile-time though Error is not superclass. But fails to catch RuntimeException at runtime.
		} finally {
		}
		
		// Unchecked Exception
		try {
			throw new RuntimeException(); // No need to catch Unchecked Exception, but subsequent statements become as unreachable.
		}  finally {
		}
	}

	static void m() throws IOException {
		throw new FileNotFoundException();
	}
}
