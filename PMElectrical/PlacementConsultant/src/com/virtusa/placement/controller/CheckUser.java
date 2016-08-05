package com.virtusa.placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class CheckUser extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
 
	public CheckUser() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result = verifyUser(username,password);	
		out.print(result);
	}   
	
	private boolean verifyUser(String uname,String password)
	{
		boolean result = false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
			PreparedStatement pst = conn.prepareStatement("select * from usernames where username = ?");
			pst.setString(1, uname);
			ResultSet res = pst.executeQuery();
			while(res.next())
			{
				if(password.equalsIgnoreCase(res.getString(2)))
					result = true;			
				else 
					result = false;
			}
			pst.close();
			conn.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}