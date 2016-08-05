package com.samplermi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MyRemoteSrv extends UnicastRemoteObject implements
		MyRemoteSrvInter {

	private static final long serialVersionUID = 1L;

	public MyRemoteSrv() throws RemoteException {
		super();
	}

	public static void main(String[] args) {

		try {
//			new MyRemoteSrv().settingProperties();
			// starting rmiregistry
//			new MyRemoteSrv().rmiRegistry();
			Registry registry=new MyRemoteSrv().rmiRegistry2();
			System.out.println("Registering and starting the service.");
			MyRemoteSrv myRemote = new MyRemoteSrv();
//			Registry registry=LocateRegistry.getRegistry();// No need to specify the default port 1099
//			Registry registry=LocateRegistry.getRegistry(1099);
//			Registry registry=LocateRegistry.getRegistry("172.25.205.32",1090);
			registry.rebind("MyRemoteSrv", myRemote);
			/*Naming.rebind("MyRemoteSrv", myRemote);*/
			System.out.println("Service startup successful...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public String hello(String name) throws RemoteException {
		Le_Customer.main_1();

		return "Hi " + name + ", Good " + new MyRemoteSrv().currentTime() + "!";
	}

	private String currentTime() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		int hour = new Integer(dateFormat.format(today));
		if (hour < 12) {
			return "morn";
		} else if (hour >= 12 && hour <= 16) {
			if (hour == 12)
				return "noon";
			else
				return "after noon";
		} else if (hour >= 12 && hour <= 23)
			return "evening";

		return "day";
	}

	// This will open command prompt and starts rmiregistry
	private void rmiRegistry() throws InterruptedException {
		try {
			System.out.println("Starting RMI Registry.");
			Runtime.getRuntime().exec("cmd /c start rmiregistry 1099");
			System.out.println("RMI Registry started...");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// This will open command prompt and starts rmiregistry
	private Registry rmiRegistry2() {
		Registry registry=null;
		try {
			System.out.println("Starting RMI Registry.");
			registry=LocateRegistry.createRegistry(1099);
			System.out.println("RMI Registry started...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return registry;
	}
	

	private void settingProperties() {
		Properties props = System.getProperties();
		if (props.getProperty("java.rmi.server.codebase") != null) {
			System.out.println("java.rmi.server.codebase: "
					+ props.getProperty("java.rmi.server.codebase"));
		} else {
			props.setProperty("java.rmi.server.codebase",
					"file://localhost/D:/BAOLiteWorkspace/RMISrv/bin/");
		}
	}
}
