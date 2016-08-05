<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="ajax" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="file://///10.5.80.121/PlacementProject/Template/Template/styles.css" rel="stylesheet" type="text/css" />

<title>Site Map</title>
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
<li><a href="Home.jsp" title="" class="style3">Home</a></li>
<li><a href="Jobseeker.jsp" title="">Jobseeker</a></li>
<li><a href="Recruiter.jsp" title="">Recruiter</a></li>
<li><a href="Profile.jsp" title="">About Us</a></li>
<li><a href="Contact.jsp" title="">Contact</a></li>
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
Site Map</span>
</h2>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="center">


<s:tree theme="ajax" id="root" label="Home">
	
	<s:treenode theme="ajax" id="child1"  label="<b>Job Seeker Login</b>" >
      	<s:treenode theme="ajax" id="1subchild1" label="Update Profile">
        <s:treenode theme="ajax" id="1subchild2" label="Change Password"/>
        </s:treenode>
        <s:treenode theme="ajax" id="1subchild3" label="Search Job">
          	<s:treenode theme="ajax" id="1subchild31" label="Apply for Job" />
        </s:treenode> 
        <s:treenode theme="ajax" id="1subchild4" label="Seeker Report" />
        <s:treenode theme="ajax" id="1subchild5" label="Logout"/>
	</s:treenode>
    <s:treenode theme="ajax" id="child2" label="<b>Recruiter Login</b>" >
      	<s:treenode theme="ajax" id="2subchild1" label="Update Profile">
      	<s:treenode theme="ajax" id="2subchild2" label="Change Password"/>
      	</s:treenode>
      	<s:treenode theme="ajax" id="2subchild3" label="Post Job"/>
      	<s:treenode theme="ajax" id="2subchild4" label="Payment"/>
      	<s:treenode theme="ajax" id="2subchild5" label="Recruiter Report" />
      	<s:treenode theme="ajax" id="2subchild6" label="Logout"/>
    </s:treenode>
    <s:treenode theme="ajax" id="child8" label="<b>Admin</b>" >
    	<s:treenode theme="ajax" id="8subchild1" label="Seeker Details"/>
    	<s:treenode theme="ajax" id="8subchild2" label="Recruiter Details"/>
    	<s:treenode theme="ajax" id="8subchild3" label="Logout"/>
    </s:treenode>
    <s:treenode theme="ajax" id="child3" label="<b>Submit Resume</b>"/>
    <s:treenode theme="ajax" id="child4" label="<b>New Recruiter</b>"/>
    <s:treenode theme="ajax" id="child5" label="<b>About Us</b>"/>
    <s:treenode theme="ajax" id="child6" label="<b>Contact Us</b>"/>
    <s:treenode theme="ajax" id="child7" label="<b>Site Map</b>"/>
</s:tree>

<p>&nbsp;</p>
<p>&nbsp;</p>
<a href="google.html">Google Map</a>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
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