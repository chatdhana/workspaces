<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
   
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Jobs Corp - for Total Recruitment Solutions ::</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="file://///10.5.80.121/PlacementProject/Template/Template/styles.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style3 {color: #9900CC}
.style4 {
 font-size: 24px;
 color: #0000CC;
}
.style6 {
 font-size: xx-large;
 color: #9933CC;
 font-family: "Lucida Calligraphy", "Lucida Handwriting", "Monotype Corsiva";
}
.style7 {
 font-size: 18px;
 color: #000000;
}
-->
</style>
</head>
<body>
<div id="main">
<!-- header begins -->
<div id="header">
    <div id="menu">
  <ul>
<li><a href="Home.jsp" title="Home" class="style3">Home</a></li>
<li><a href="Jobseeker.jsp" title="Job Seeker">Jobseeker</a></li>
<li><a href="Recruiter.jsp" title="Recruiter">Recruiter</a></li>
<li><a href="Profile.jsp" title="About Us">About Us</a></li>
<li><a href="Contact.jsp" title="Contact Us">Contact</a></li>

</ul>
 </div>
 
    <blockquote><span class="style4"><marquee direction="left">
    </marquee>
    </span>
      <blockquote class="style6">
        <p>&nbsp; </p>
       <p>&quot;JobsCorp.Com&quot;</p>
        <p><span class="style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We Make Ur Dreamz Possible.... </span></p>
      </blockquote>
    </blockquote>
</div>
<!-- header ends -->
<!-- content begins -->
<div id="global">
<div id="content">

 <div id="right">If you are already a member:
 
  <div id="login" class="boxed">
   <h2 class="title">Recruiter Login </h2>
   <div class="content2">
    <s:form id="form1" method="post" action="loginrecruiter">
     <fieldset>
     <legend>Login</legend>
     
     <s:textfield name="username" label="Username" />
<s:password name="password" label="Password" size="22"/>
<s:hidden name="type" label="type" value="seeker"/>
     
<s:submit name="login" value="Login"/>

     
     <p><a href="#"></a></p>
     </fieldset>
    </s:form>
   </div>
  </div>
  
<h4 style="color:navy;">
<s:property value="message1"/>
<s:property value="message"/>

<s:property value="message2"/>

<s:property value="name"/> 
</h4>
  
   </div>
 <div id="left">
  <h1 align="center">RECRUITER<br />
          <br />
          Welcome to Jobs Corp.com<br />
  </h1>
   <p>A registered recruiter at Jobs Corp, gets the following <br />
benefits:</p>
   <p>&nbsp;</p>
   <p>Post Jobs - Post your job requirements from time to time.</p>
   <p>&nbsp;</p>
   <p>Search Candidates - Search through our vast database and get desired candidates.</p>
   <p>&nbsp;</p>
   <p>Quick response -  Our Expert Team meticulously searches for the right candidates as 
      per your requirement and gives you quick response via </p>
   <p>email / 
     phone.<br />
     <br />
     <br />
   </p>
   <h1>So, Get started now&gt;&gt; <i><a style="color:navy;" href= "RecruiterForm.jsp">REGISTER!</a></i></h1><p>
   <br />
     </p>
   <p class="date">&nbsp;</p>
   </div>
</div>
<!-- content begins -->
</div>

<!-- footer begins -->
<div id="footer">
 <p>Copyright &copy; 2009. Design by <a href="#">Launch Pad 15 </a></p>
 <p> <a href="#">Privacy Policy</a></p>
</div>
<!-- footer ends -->
</body>
</html>

