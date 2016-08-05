package jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//Java Naming and Directory Interface
//This program finds the file on a path in local file system.
public class SimpleJNDI {

	
	public static void main(String[] args) {
	
		Hashtable<String,String> env = new Hashtable<String,String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.fscontext.RefFSContextFactory");
		try {
			Context ctx = new InitialContext(env);
			 Object obj = ctx.lookup("C:/Documents and Settings/dgovindan/Desktop/accoundt.txt");
			 System.out.println(" Object found is ::::  "+obj.toString());
		} catch (NamingException e) {
			e.printStackTrace();
		}

		

	}

}
