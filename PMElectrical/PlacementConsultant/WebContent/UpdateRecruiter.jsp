<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%@ taglib prefix="s" uri="/struts-tags" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<s:head theme="ajax" /> 
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Update Recruiter</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="file://///10.5.80.121/PlacementProject/Template/Template/styles.css" rel="stylesheet" type="text/css" />


<style type="text/css">
<!--
.style3 {color: #009933}
.style5 {
font-size: 16px;
font-family: "Lucida Calligraphy", "Lucida Handwriting", "Monotype Corsiva";
color: #0000FF;

}
.style10 {
color: #990099;
font-family: "Lucida Calligraphy", "Lucida Handwriting", "Monotype Corsiva";
font-size: x-large;
}
.style12 {font-size: x-large; font-family: "Lucida Calligraphy", "Lucida Handwriting", "Monotype Corsiva"; color: #0000FF; }


.style13 {
font-size: x-large;
color: #993399;
}
.style15 {color: #0000FF; font-size: x-large;}
.style17 {color: #9933CC}
.style19 {color: #9933cc}
.style20 {
font-size: 16px;
color: #0000FF;
}
.style21 {font-size: 14px; color: #333333;}
.style22{font-size: 14px; color:red;}
-->

</style>
</head>
<body>
<div id="menu">
<br /><br />
&nbsp;&nbsp;<span class="style10">&nbsp; <span class="style19">JobsCorp.Com</span></span>


<span class="style5 style13 style19"><span class="style17 style20"> &nbsp;</span></span><span class="style5 style13"><span class="style15">&nbsp; </span></span><span class="style12">&nbsp;</span><span class="style5"><br />


&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<span class="style21">We Make Ur Dreamz Posssible...... </span></span>

<ul>
<li><a href="RecruiterLogin.jsp" title="Home" class="style3">Home</a></li>
<li><a href="Jobseeker.jsp" title="Job Seeker">Jobseeker</a></li>
<li><a href="Recruiter.jsp" title="Recruiter">Recruiter</a></li>
<li><a href="Profile.jsp" title="About Us">About Us</a></li>
<li><a href="Contact.jsp" title="Contact Us">Contact</a></li>
<li><a href="SiteMap.jsp" title="Site Map">SiteMap</a></li>
<li><a href="logout.jsp" title="Logout">Logout</a></li>
</ul>
</div>
<div id="main">
<!-- header begins -->
<!-- header ends -->
<!-- content begins -->
<div id="global">
<div id="content">


<div id="left">
<h2 align="center">
<span class="style22">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Update Profile</span>
</h2>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="center">
                
                
<s:form action="updatedrecruiterdata" name="form1"> 
<%

String userName=session.getAttribute("userName").toString();
%>
<h2 align="left" style="color:buttonshadow" > Hi <%=userName %> </h2>

<tr><td bgcolor="#EEF1D1"><b>
<s:label> <font face="Verdana" size="2" color="#003775">  Company Details </font></s:label>
</b>
</td></tr>
 
<s:textfield name="company_name" label="Company Name"  size="30"/> 

<s:textfield name="contactperson_name" label="ContactPerson"  size="30"/> 
<s:textfield name="contactperson_empid" label="ContactPerson's Empid"  size="30"/> 
     
<s:textarea name="contactaddress" label="Complete Address" cols="24" rows="5"/> 
<s:textfield name="city" label="City"  size="30"/> 
<s:textfield name="phone" label="Contact No."  size="30"/> 
<s:textfield name="mobile" label="Mobile No."  size="30"/> 
<s:textfield name="email" label="Email Address"  size="30"/> 
  <s:select list="{'Accounting-tax/consulting',
                   'Advertising/PR',
                   'Agriculture',
                   'Architecture/Interior Design',
                   'Automobiles',
                   
                   'Healthcare',
                   'Hotel/Travel/Tourism',
                   'Insurance',
                   'IT-Hardware/Networking',
                   'IT-Software',
                   'Manufacturing/Industrial',
                   'Petroleum/Oil and Gas/Power',
                   'Printing/Packaging',
                   'Real Estate',
				   'Telecom',
                   'Web Services'}" name="industry" label="Industry"/>
                   
                   
                
  <br/>
  <br/>
  
  
  <s:submit value="Update"/> 
   
</s:form>
<h3 style="color:navy;"> <a href="ChangePassword.jsp">Change Password?</a></h3>  
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</div>
</div>
</div>
<!-- content begins -->
<!-- footer begins -->
<div id="footer">

<p>Copyright &copy; 2009. Design by Jobs Corp.com, All rights Reserved.</p>
 <p> Privacy Policy</p>.

</div>

<!-- footer ends -->
</body>
</html>

