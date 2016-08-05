package com.virtusa.placement.controller;


import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


 

public class Contact extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

static final long serialVersionUID = 1L;


public Contact() 

{

super();

} 



protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

{


}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

{

response.setContentType("text/html");

PrintWriter out=response.getWriter(); 

String email=request.getParameter("email"); 

String name=request.getParameter("name");

String phone=request.getParameter("phone");

String query=request.getParameter("query");

String message=request.getParameter("message");

out.write("<HTML><HEAD><TITLE>Display Comments</TITLE></HEAD><BODY bgcolor='lightblue'><form action='ContactUs' method='post'>");

out.write("<br><br><h1>Thanks for your valuable comments...</h1>");

out.write("<br><br>EMAIL:" +email);

out.write("<br><br>NAME:" +name);

out.write("<br><br>PHONE:" +phone);

out.write("<br><br>QUERY:" +query); 

out.write("<br><br>MESSAGE:" +message); 

// out.write("\n<center><input type='submit'/></center></form></BODY>\n</HTML>");

// out.close();


try

{

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","ssampathkumar","sen");

PreparedStatement pst=con.prepareStatement("insert into comments(email,name,phone,query,message) values(?,?,?,?,?)");

pst.setString(1,email);

pst.setString(2,name);

pst.setString(3,phone);

pst.setString(4,query);

pst.setString(5,message);


int a=pst.executeUpdate();

System.out.println(a);

pst.close();

con.close();

}

catch(Exception e)

{

e.printStackTrace();

}

finally

{

out.close();

} 

} 

}
