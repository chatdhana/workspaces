package com.virtusa.placement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.virtusa.placement.controller.TestID;
import com.virtusa.placement.sms.SmsClient;

public class TestIDBiz {
public static TestID uniqueid(TestID tid) 
{
	
	Map session=ActionContext.getContext().getSession();
	String uname=session.get("userName").toString();
	Random rand=new Random();
	int num=Math.abs(rand.nextInt());
	System.out.println(num);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","ssampathkumar","sen");
	PreparedStatement pt=con.prepareStatement("insert into unique_test values(?,?)");
	pt.setString(1,uname);
	pt.setLong(2,num);
	pt.executeQuery();
	pt.close();
	con.close();
	
	SmsClient.sendsms(session.get("mobile").toString(),"Hi "+uname+", Ur TestID is "+num+" from JobsCorp.com");
	
	}catch (Exception e) {
		tid.setRetVal("error");
		e.printStackTrace();
	}
	tid.setRetVal("success");
	return tid;
	
}

}
