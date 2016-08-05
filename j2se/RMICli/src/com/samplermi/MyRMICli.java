package com.samplermi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

public class MyRMICli {

	public static void main(String[] args) {
//		new MyRMICli().settingProperties();
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			Registry registry = LocateRegistry.getRegistry("127.0.0.1");
			MyRemoteSrvInter remote = (MyRemoteSrvInter) registry
					.lookup("MyRemoteSrv");
			System.out.println("From Server: " + remote.hello("Dhana"));
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	// Not required in all the time.
	private void settingProperties() {
		Properties props = System.getProperties();
		if (props.getProperty("java.security.policy") != null) {
			System.out.println("java.security.policy: "
					+ props.getProperty("java.security.policy"));
		} else {
			props.setProperty("java.security.policy",
					"C:/Documents and Settings/dgovindan/client.policy");
		}

		if (props.getProperty("java.rmi.server.codebase") != null) {
			System.out.println("java.rmi.server.codebase: "
					+ props.getProperty("java.rmi.server.codebase"));
		} else {
			props.setProperty("java.rmi.server.codebase",
					"file://localhost/D:/BAOLiteWorkspace/RMICli/bin/");
		}
	}

}
