package com.virtusa.placement.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class VerifyRecruiterLogin extends ActionSupport
{
	{
		
	}
	private static final long serialVersionUID = 1L;
	private int count=0;
	private int validity=0;
	private String password;
	public String username;
	public static final String MESSAGE2 = "Its our login page........";
	
  public static final String MESSAGE1 = "Ur Password Information Incorrect......";
	
  public static final String MESSAGE = "Ur User Id Information Incorrect......";

  private String message;
  
	
   
	
	        public String getPassword() {
	        	return password;
	        }
	        public void setPassword(String password) {
	        	this.password = password;
	        }
			public String getUsername() {
				return username;
			}
public void setUsername(String username) {
	this.username = username;
}
			public void setMessage(String message)
	    	{
	    		this.message = message;
	    	}
	        public String getMessage() 
	    	{
	    	    return message;
	        }
	
	public String execute() throws Exception 
	{
		Map session=ActionContext.getContext().getSession();
		session.put("userName", getUsername().toLowerCase());
    	username=getUsername();
	    password=getPassword();
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","ssampathkumar","sen");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
		Statement st2=con.createStatement();
		ResultSet rs =st.executeQuery("select username from usernames where type='R'");
		while(rs.next())
		{
			String str2=rs.getString("username");
			if(username.equalsIgnoreCase(str2))
				count++;
			
		}
		
		ResultSet rs1 =st.executeQuery("select password from usernames where username='"+username+"'");
			while(rs1.next())
			{
				
				String str1=rs1.getString("password");
			
				
				if(password.equals(str1)&&count!=0)
					
					{  
					
					validity++;
					}
						
					
				else 
				{
					setMessage(MESSAGE1);
				}
				
			}
			if(count==0)
			{
				setMessage(MESSAGE);

			}
			
			st.close();
			
					
			
	   if(validity!=0)
	   {
		  
		   
		   ResultSet rs2=st2.executeQuery("select mobile from seeker_personal where username='"+getUsername()+"'");
		   
		   if(rs2.next())
			   session.put("mobile",rs2.getString(1));
		   setMessage(MESSAGE2);
		   con.close();
	       return SUCCESS;
	   }
	   else
		   return ERROR;
	  
	}
	
}