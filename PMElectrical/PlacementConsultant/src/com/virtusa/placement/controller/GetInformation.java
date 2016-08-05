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

/**
 * Servlet implementation class for Servlet: GetInformation
 *
 */
 public class GetInformation extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
	
   String a1 ="";	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	protected String getDetailsUser(String username)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
			PreparedStatement pst = conn.prepareStatement("select * from recruiter_personal where username = ?");
			pst.setString(1, username);
			ResultSet res = pst.executeQuery();
			while(res.next())
			{
				a1 = res.getString(2)+":"+res.getString(7)+":"+res.getString(6)+":"+res.getString(3);
				
			}
			pst.close();
			conn.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return a1;
	}

	/*public static void main(String[] args)
	{
		String username = "fgh";
		System.out.println("hi this is main in servlet");
		GetInformation g = new GetInformation();
		String s = g.getDetailsUser(username);
		System.out.println(s);
	}*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String s = getDetailsUser(username);
		out.write(s);
	}   	  	    
}