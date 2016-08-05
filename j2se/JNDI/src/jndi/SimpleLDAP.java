package jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class SimpleLDAP {

	public static void main(String[] args) {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://virtusa.com:389/o=virtusa");

		try {
			// Create the initial directory context
		    DirContext ctx = new InitialDirContext(env);
			    
		    // Ask for all attributes of the object 
		    Attributes attrs = ctx.getAttributes("s=Govindan, g=Dhananjayan");

		    // Find the surname attribute ("sn") and print it
		    System.out.println("sn: " + attrs.get("s").get());

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
