
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Seeker Profile</title>
</head>
<body>
<s:form action="viewseekerprofile" name="viewseekerprofile" >

<s:textfield name="username"  label="Username" maxlength="50" size="20"/>
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

<s:textfield name="keyskill1" label="KeySkill1" maxlength="10" size="20"/> 
<s:textfield name="keyskill2" label="KeySkill2" maxlength="10" size="20"/> 
<s:textfield name="keyskill3" label="KeySkill3" maxlength="10" size="20"/> 
<s:textfield name="res_obj" label="Resume Objective" maxlength="10" size="20"/> 
<s:textfield name="twelfth" label="XII Percentage" maxlength="10" size="20"/> 
<s:textfield name="tenth" label="X Percentage" maxlength="10" size="20"/> 
<s:select name="ug" label="UG" list="{'-Select-','B.A','B.Arch','BCA','B.B.A','B.Com',
'B.Ed','BDS','BHM','B.Pharma','B.Sc','B.Tech/B.E.','LLB','MBBS','Diploma','BVSC','-NA-'}"/>

<s:textfield name="ug_stream" label="UG Stream" maxlength="10" size="20"/> 
<s:select name="pg" label="Post Graduation" list="{'-Select-','CA','CS','ICWA','M.A','M.Arch','M.Com',
'M.Ed','M.Pharma','M.Sc','M.Tech','MBA/PGDM','MCA','MS','PG Diploma','MVSC','MCM','-NA-'}"/>
<s:textfield name="pg_stream" label="PG Stream" maxlength="10" size="20"/> 
<s:select name="doctorate" label="Doctorate" list="{'-Select-',
'Ph.D/Doctorate',
'MPHIL',
'-NA-'}"/>
<s:textfield name="field_phd" label="Field_Phd" maxlength="10" size="20"/> 
<s:textfield name="university" label="University" maxlength="10" size="20"/> 


</s:form>

</body>
</html>