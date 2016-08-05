package com.virtusa.placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RecruiterReport extends HttpServlet{
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException
			{
		
				String companyName="Not Available";
				String jobCount="Not Available";
				ArrayList<String> details=new ArrayList<String>(); 
			
				try
				{
					
	HttpSession session=request.getSession(true);
	String userName=session.getAttribute("userName").toString();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","ssampathkumar","sen");
	response.setContentType("text/html");	
	
	PreparedStatement ps1=con.prepareStatement("SELECT COMPANY_NAME FROM POSTJOB WHERE USERNAME like ?");
	ps1.setString(1,userName);
	PreparedStatement ps = con.prepareStatement("SELECT COUNT(JOB_ID) FROM POSTJOB WHERE USERNAME like ?");
	ps.setString(1,userName);	
	PreparedStatement ps2=con.prepareStatement("SELECT DESIGNATION, SKILL, FUNCTIONAL_AREA, POSTED_DATE FROM POSTJOB WHERE USERNAME like ?");
	ps2.setString(1, userName);
	ResultSet rt=ps.executeQuery();
	ResultSet rt1=ps1.executeQuery();
	ResultSet rt2=ps2.executeQuery();
	while(rt.next())
		jobCount=rt.getString(1);
	while(rt1.next())
		companyName=rt1.getString(1);
	

RequestDispatcher d=getServletContext().getRequestDispatcher("/RecruiterReport.jsp");

request.setAttribute("cname",companyName);
request.setAttribute("jcount", jobCount);
request.setAttribute("details",rt2);
d.include(request, response);
con.close();

}
catch(Exception e)
{
e.printStackTrace();
}

}
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
			{
		doPost(request,response);
			}
	

}

