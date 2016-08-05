package com.virtusa.placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class GetAmount extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String result = getAmount(username);
		out.write(result);
	}   	  	    
	
	protected String getAmount(String username)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String r = ""; 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
			PreparedStatement pst = conn.prepareStatement("select * from postjob where username = ? and paid is null ");
			pst.setString(1, username);
			ResultSet res = pst.executeQuery();
			while(res.next())
			{
				r = res.getString(1)+":"+res.getString(5)+":"+res.getString(10)+":"+formatter.format(res.getDate(12));
			}
			pst.close();
			conn.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
}