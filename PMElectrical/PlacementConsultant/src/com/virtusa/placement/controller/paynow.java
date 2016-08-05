package com.virtusa.placement.controller;

import com.virtusa.placement.controller.BankWebServices;
import _38._80._5._10.axis.services.new_banking.*;
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

public class paynow extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String type = request.getParameter("htype");
		String number = request.getParameter("cardnumber");
		String date = request.getParameter("hdate");
		String pin = request.getParameter("securepin");
		String amt = request.getParameter("amt");
		int pin_no = Integer.parseInt(pin);
		int amount = Integer.parseInt(amt);
		HttpSession ss = request.getSession();
		String result="";
		try
		{
		BankWebServicesServiceLocator serv = new BankWebServicesServiceLocator();
		_38._80._5._10.axis.services.new_banking.BankWebServices bank = serv.getnew_banking();
		result = bank.transaction(type, number, pin_no, date, amount);
		}
		catch(Exception e)
		{
			result = result;
		}
		/*BankWebServices b = new BankWebServices();
		String result = b.transaction(type, number, pin_no, date, amount);*/
		if(result.equalsIgnoreCase("Transaction Completed"))
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
				PreparedStatement pst12 = conn.prepareStatement("update payment_login set paid = 'y' where username = ?");
				pst12.setString(1, username);
				int res = pst12.executeUpdate();
				PreparedStatement pst13 = conn.prepareStatement("update postjob set paid = 'y' where username = ?");
				pst13.setString(1, username);
				int res1 = pst13.executeUpdate();
				System.out.println(res);
				pst12.close();
				pst13.close();
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
		if(result.equalsIgnoreCase("Transaction Completed"))		
		{
			RequestDispatcher reqdisp = request.getRequestDispatcher("Transaction_Success.jsp");
			reqdisp.forward(request,response);
		}
		else
		{			
			ss.setAttribute("error", result);
			RequestDispatcher reqdisp = request.getRequestDispatcher("FailedTransaction.jsp");
			reqdisp.forward(request,response);
		}
		
	}
}