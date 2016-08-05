<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="ajax" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="file://///10.5.80.121/PlacementProject/Template/Template/styles.css" rel="stylesheet" type="text/css" />

<title>Post Job</title>
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
Post Job</span>
</h2>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="center">



<%
String userName=session.getAttribute("userName").toString();
session.setAttribute("userName",userName);
%>



	


<s:form id="postJobHomeFom1" action="postJob" >
<h2 align="left" style=" color:buttonshadow" > Hi <%=userName %> </h2>
<br/>
<br/>
<s:hidden name="userName" value='<%=userName %>'></s:hidden>
<s:textfield name="desigT" label="Designation (e.g: consultant)" required="true"></s:textfield>
<s:textfield name="skillT" label="Skill (e.g:java,c)" required="true"></s:textfield>
<s:textfield name="locationT"  label="Location (e.g:chennai)" required="true"></s:textfield>
<s:select name=" funAreaT" list="funArea"  label="Functional Area" headerValue="-- Select Functional Area --" headerKey="-1" required="true"></s:select>
<s:select name="salaryT" list="Salary" headerValue="-- Select Salary--" headerKey="-1" onchange="dojo.event.topic.publish('maxSalTopic');return false;" label="Salary (p.m)in Rupees" required="true"></s:select>
<s:select  name="minExpT" list="minExp" headerValue="-- Select Min Experience --" headerKey="-1"  label="Minimum Experience(in year)" onchange="dojo.event.topic.publish('maxExpTopic');return false;" required="true"></s:select>

<s:form>
<s:url id="maxExpURL" action="maxExpChooserRec"></s:url>
<s:div href="%{maxExpURL}" name="maxExpT" showLoadingText="false" listenTopics="maxExpTopic" theme="ajax" formId="postJobHomeFom1"></s:div>
<s:textarea name="descriptionT" cols="50" rows="7" label="Description of job" ></s:textarea>
<s:submit  value="Post Job"></s:submit>
<s:reset ></s:reset>
</s:form>


</s:form>
<h2 style="color:red;">* -Required fields</h2>







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