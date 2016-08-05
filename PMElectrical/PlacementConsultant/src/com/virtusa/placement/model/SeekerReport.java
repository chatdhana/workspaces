package com.virtusa.placement.model;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SeekerReport extends HttpServlet{
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException
			{
				ArrayList<String> ar=new ArrayList<String>();
		
	try
	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","ssampathkumar","sen");
			response.setContentType("text/html");	
			PrintWriter out = response.getWriter();
			PreparedStatement ps1=con.prepareStatement("SELECT COUNT(JOB_ID) FROM APPLYJOB WHERE USERNAME LIKE ?");
			ps1.setString(1,"dhanas");
			PreparedStatement ps = con.prepareStatement("SELECT COMPANY_NAME, DESIGNATION, SKILL, FUNCTIONAL_AREA FROM POSTJOB WHERE JOB_ID IN(SELECT JOB_ID FROM APPLYJOB WHERE USERNAME like ?)");
			ps.setString(1,"dhanas");				
			ResultSet rt=ps.executeQuery();
			ResultSet rt1=ps1.executeQuery();
			rt1.next();
			String a=rt1.getString(1);
		while(rt.next())
			{
				
				ar.add(rt.getString(1));
				
				ar.add(rt.getString(2));
				
				ar.add(rt.getString(3));
				
			ar.add(rt.getString(4));
				
				
			}
		RequestDispatcher d=getServletContext().getRequestDispatcher("/display.jsp");
		request.setAttribute("a",a);
		request.setAttribute("b",ar);
		d.include(request, response);
		con.close();
		
	   }
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
	}

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException
			{
		
			doPost(request,response);
			}
	
}
