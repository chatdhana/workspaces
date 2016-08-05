<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%@ taglib prefix="s" uri="/struts-tags" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<s:head theme="ajax" /> 
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Seeker Profile</title>
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
<li><a href="Home.jsp" title="Home" class="style3">Home</a></li>
<li><a href="Jobseeker.jsp" title="Job Seeker">Jobseeker</a></li>
<li><a href="Recruiter.jsp" title="Recruiter">Recruiter</a></li>
<li><a href="Profile.jsp" title="About Us">About Us</a></li>
<li><a href="Contact.jsp" title="Contact Us">Contact</a></li>
<li><a href="SiteMap.jsp" title="Site Map">SiteMap</a></li>
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
Seeker Profile</span>
</h2>

</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div id="center">
<s:form action="seekerprofile" name="seekerprofileform" method="post" enctype="multipart/form-data">

<s:textfield name="username"  label="Username" maxlength="50" size="20" disabled="true"/>
<s:textfield name="experience" label="Experience" maxlength="50" size="20"/> 
<s:textfield name="minsal" label="Minimum Salary" maxlength="50" size="20"/> 
<s:textfield name="maxsal" label="Maximum Salary" maxlength="10" size="20"/> 

 
 <s:select list="{'-Select-',
'Accounts / Finance / Tax / CS / Audit',
'Agent',
'Architecture / Interior Design',
'Banking / Insurance',
'Content / Journalism',
'Corporate Planning / Consulting',

'IT Software',
'IT- Hardware / Telecom / Technical Staff / Support',
'ITES / BPO / KPO / Customer Service / Operations',
'Legal',
'Marketing / Advertising / MR / PR',
'Packaging',
'Pharma / Biotech / Healthcare / Medical / R and D',
'Production / Maintenance / Quality',
'Purchase / Logistics / Supply Chain',

'Ticketing / Travel / Airlines',
'Top Management',
'TV / Films / Production',
'Web / Graphic Design / Visualiser',
'-NA-'}" name="farea" label="Functional Area"/>

<s:select list="{'-Select-',
'Accounts / Finance / Tax / CS / Audit',
'Agent',
'Architecture / Interior Design',
'Banking / Insurance',
'Content / Journalism',
'Corporate Planning / Consulting',
'IT Software',
'Production / Maintenance / Quality',
'Purchase / Logistics / Supply Chain',
'Sales / BD',
'Secretary / Front Office / Data Entry',
'Self Employed / Consultants',
'Site Engineering / Project Management',
'Teaching / Education',
'Ticketing / Travel / Airlines',
'Top Management',
'TV / Films / Production',
'Web / Graphic Design / Visualiser',
'-NA-'}" name="industry" label="Industry"/>

<s:textfield name="keyskill1" label="KeySkill1"  size="20"/> 
<s:textfield name="keyskill2" label="KeySkill2"  size="20"/> 
<s:textfield name="keyskill3" label="KeySkill3"  size="20"/> 
<s:textfield name="res_obj" label="Resume Objective"  size="20"/> 
<s:textfield name="twelfth" label="XII Percentage"  size="20"/> 
<s:textfield name="tenth" label="X Percentage"  size="20"/> 
<s:select name="ug" label="UG" list="{'-Select-','B.A','B.Arch','BCA','B.B.A','B.Com',
'B.Ed','BDS','BHM','B.Pharma','B.Sc','B.Tech/B.E.','LLB','MBBS','Diploma','BVSC','-NA-'}"/>

<s:textfield name="ug_stream" label="UG Stream"  size="20"/> 
<s:select name="pg" label="Post Graduation" list="{'-Select-','CA','CS','ICWA','M.A','M.Arch','M.Com',
'M.Ed','M.Pharma','M.Sc','M.Tech','MBA/PGDM','MCA','MS','PG Diploma','MVSC','MCM','-NA-'}"/>
<s:textfield name="pg_stream" label="PG Stream"  size="20"/> 
<s:select name="doctorate" label="Doctorate" list="{'-Select-',
'Ph.D/Doctorate',
'MPHIL',
'-NA-'}"/>
<s:textfield name="field_phd" label="Field_Phd"  size="20"/> 
<s:textfield name="university" label="University"  size="20"/> 
 
<s:file name="upload_resume" value="browse" label="Upload Resume"  /> 
<!--
<table><tr><td>(or) </td></tr></table>
<s:textarea name="paste_resume" label="Paste Resume" rows="5" cols="48"></s:textarea>  -->
<s:submit name="submit" value="Register"/>
</s:form>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>


<p>&nbsp;</p>
</div>
<!-- content begins -->
<!-- footer begins -->
<div id="footer">

<p>Copyright &copy; 2009. Design by Jobs Corp.com, All rights Reserved.</p>
 <p> Privacy Policy</p>.

</div>
</div>
</div>
<!-- footer ends -->
</body>
</html>


 
