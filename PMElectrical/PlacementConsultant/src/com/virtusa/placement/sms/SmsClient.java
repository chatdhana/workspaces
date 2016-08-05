package com.virtusa.placement.sms;

import java.rmi.RemoteException;

public class SmsClient {
public static void  sendsms(String phno,String msg) throws Exception
{
	//sms.SendSMSLocator o= new sms.SendSMSLocator();
	//sms.SendSMSPortType ss=o.getSendSMSPort();
//	String s=ss.sendSMSToMany("subbuthemostcute@gmail.com","teenage" ,phno , "Ur Account is Successfully Created in JobsCorp");
	
	SendSMSPortTypeProxy s= new SendSMSPortTypeProxy();
	s.sendSMSToMany("subbuthemostcute@gmail.com","teenage" ,phno ,msg);
System.out.println(s+"   success");
}

}
