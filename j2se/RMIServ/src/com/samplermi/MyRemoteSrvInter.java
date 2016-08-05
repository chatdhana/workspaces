package com.samplermi;

import java.rmi.RemoteException;

public interface MyRemoteSrvInter extends java.rmi.Remote{

	String hello(String name) throws RemoteException;
}
