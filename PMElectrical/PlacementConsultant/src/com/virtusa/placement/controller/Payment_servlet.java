package com.virtusa.placement.controller;

import java.io.IOException;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 public class Payment_servlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   String user,pname, comp_email, comp_phone, person_desig, comp_name, person_mob, address;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}  	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		user = session.getAttribute("userName").toString();
		comp_name = request.getParameter("hcompanyname");
		comp_phone = request.getParameter("hphone");
		comp_email = request.getParameter("hc_email");
		pname = request.getParameter("personname");
		person_desig = request.getParameter("designation");
		person_mob = request.getParameter("mobile");
		address = request.getParameter("haddress");

		try{
		response.setContentType("text/html");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
		PreparedStatement pst = conn.prepareStatement("insert into payment_login values(?,?,?,?,?,?,?,?,0,payid.nextval,'no')");
		pst.setString(1, user);
		pst.setString(2,comp_name);
		pst.setString(3,comp_phone);
		pst.setString(4,pname);
		pst.setString(5,person_desig);
		pst.setString(6,comp_email);
		pst.setString(7,person_mob);
		pst.setString(8,address);
		int result = pst.executeUpdate();
		if(result != 0){
			RequestDispatcher reqdisp = request.getRequestDispatcher("TariffDetails.jsp");
			reqdisp.forward(request,response);
		}
		else
		{
			
		}
		
		//out.println("hi"+"\n"+pname+"\n"+comp_email+"\n"+comp_phone+"\n"+comp_desig+"\n"+comp_name+"\n"+person_mob+"\n"+comp_address+"\n"+cityval+"\n"+stateval+"\n"+countryval);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}   	  	    
}