package com.virtusa.placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 public class confirm_pay extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String user = session.getAttribute("userName").toString();
		String amount = request.getParameter("htxtamount");
		HttpSession s = request.getSession();
		s.setAttribute("amt", amount);
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
			PreparedStatement pst = conn.prepareStatement("update payment_login set amount = ? where username = ?");
			pst.setString(1, amount);
			pst.setString(2, user);
			int res = pst.executeUpdate();
			if(res != 0)
			{
				RequestDispatcher reqdisp = request.getRequestDispatcher("confirm_payment.jsp");
				reqdisp.forward(request,response);
			}
			pst.close();
			conn.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}   	  	    
}