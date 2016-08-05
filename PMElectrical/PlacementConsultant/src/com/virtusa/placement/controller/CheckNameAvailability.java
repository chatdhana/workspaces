
	package com.virtusa.placement.controller;

	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
	
import com.opensymphony.xwork2.ActionSupport;

	public class CheckNameAvailability extends ActionSupport {
		private static final long serialVersionUID = 1L;
private String username;
private int count=0;
private String userNameStatus;
		
CheckNameAvailability mecr;
		public String execute() throws Exception
		{	
				
        try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","ssampathkumar","sen");
				Statement st=con.createStatement();
				String userName=getUsername();
			
				
				ResultSet rs=st.executeQuery("select username from usernames");
			
			 while(rs.next())
				{
				  
				  if(userName.equalsIgnoreCase(rs.getString("username")))
					 	  count=1;
				      
			    }
			 if(count==1)
			 setUserNameStatus("This user name is not availbale. Please choose another name");
			 else
				 setUserNameStatus(" ");
			 
			 System.out.println(count);
			 
			 
		}
		catch(Exception e)
		{

			e.printStackTrace();	
		}
		return SUCCESS;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public String getUserNameStatus() {
			return userNameStatus;
		}
		public void setUserNameStatus(String userNameStatus) {
			this.userNameStatus = userNameStatus;
		}
	
	}


