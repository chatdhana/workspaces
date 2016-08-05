<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.Date,java.text.* ,java.util.Iterator,java.util.ArrayList,com.virtusa.placement.pojo.*,com.virtusa.placement.controller.*;"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%@ taglib prefix="s" uri="/struts-tags" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<s:head theme="ajax" /> 
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Jobs Available</title>
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
<li><a href="SeekerLogin.jsp" title="Home" class="style3">Home</a></li>
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
<h1 align="center">
<span class="style22">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Jobs Available For You</span>
</h1>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="center">



<%String userName=session.getAttribute("userName").toString(); 

session.setAttribute("userName",userName);

%>

<h2 style="color:buttonshadow" > Hi <%=userName %> </h2>

<br/>
<br/>

<br/>
<br/>
<s:if test="errorReport!=null">
<h5 style="color:yellow">* <s:property value="errorReport"/></h5>
</s:if>
<%! int rowCount=0;  %>
	
	<%

	
	SearchJobSeek sjobj=new SearchJobSeek();
	ArrayList jobsList=(ArrayList)sjobj.selectedList();

try
{
	
	DateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
	DateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");



		for(Iterator it=jobsList.iterator();it.hasNext();)
		{	    rowCount++;
				PostJob s=(PostJob)it.next();
 			 	
  
 	 %>
	
	
	
<s:form name='form<%=s.getJobId()%>' action='applyJob' ><table>
 <tr><td valign="top"> <%= s.getJobId() %>&nbsp;&nbsp; </td><td> <div style='color:infotext'><b><u><%=s.getDesig() %></u> </b>( <%= s.getMinExp()%> - <%=s.getMaxExp()%>  yr) Experienced in <%= s.getSkill().toUpperCase() %> </div> <br><%=s.getCompanyName()%>,  <%=s.getLocation()%>. <br><i><%=s.getJobDesc()%></i><br> Posted Date: <%=formatter2.format( formatter1.parse(s.getPostedDate().substring(0,10)))%><br><br><p align="justify" ><s:submit  value='Apply for this job' tooltip="Register  this job"></s:submit></p><br><br></td></tr>
 <s:hidden name='jobIdT' value='<%= String.valueOf(s.getJobId()) %>'></s:hidden>
 <s:hidden name='seekerIdT' value='<%=userName %>'></s:hidden>
 </table> </s:form>
 
 
<% 
	}


	
	if(rowCount==0)
	{
		%>
		<h2 style="color:navy;">Please search again with different choice </h2>
		<%
		
	}
	
	rowCount=0;
	
}catch(Exception e)
{
	//out.println(e);
	//e.printStackTrace();
	
%>

<h2 style="color:navy;">Error in page....</h2>
<%
}
%>



<p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
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

