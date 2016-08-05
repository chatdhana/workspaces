<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>

<!-- 


 -->
<html>
<head>
<title>Home | Login</title>
<link href="http://localhost:8080/PM/css/styleIndex.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
<!--
.style3 {
	color: #9900CC
}

.style4 {
	font-size: 24px;
	color: #0000CC;
}

.style6 {
	font-size: xx-large;
	color: #9933CC;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
}

.style7 {
	font-size: 18px;
	color: #000000;
}

.style8 {
	font-size: xx-large;
	color: navy;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
}

.style10 {
	font-size: 13px;
	color: #333333;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
}

.error {
	font-size: 13px;
	color: red;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
}
-->
</style>
</head>
<body onload="javascript:disLoginOrRegisterPane();">
<div id="main"><!-- header begins -->
<div id="header">
<div id="menu"><br />
<br />
<br />
<br />
<span class="style8"><b>Thirumalai Chemicals Limited</b></span> <br />
<span class="style10">One of the leading manufacturers of
Industrial and Speciality Chemicals for a range of global end users.</span>
<ul>
</ul>
</div>

<blockquote><span class="style4"> <marquee
	direction="left"> </marquee> <!--  <img	src=".././image/tcl.jpg" />-->
</span>
<blockquote class="style6">

<p>&quot;Electrical Maintenance&quot;</p>
<p>&nbsp;</p>
<p><span class="style7" style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<p>&nbsp;</p>
<b>Preventive Maintenance Schedule</b></span></p>
</blockquote>
</blockquote>
</div>
<!-- header ends --> <!-- content begins -->
<div id="global">
<div id="content">
<div id="right"><!--Login Box Starts Here -->
<div id="login" class="boxed">
<div id='login1' class='content2'><s:form id='loginForm'
	action='/jsp/auth.action' method="post">

	<s:actionmessage id="actMsg" cssStyle="error" />
	<span style="color: red"><s:actionerror id="actErr"
		cssClass="error" /></span>
	<s:textfield id="userName" name="userName" label="UserName"></s:textfield>
	<s:password id="pwd" name="pwd" label="Password"></s:password>
	<s:submit id="button1" name="loginBtn" formId="loginForm" type="image"
		src="/PM/css/buttons/button1up.png" onmouseout='setOutImg(1);'
		onmouseover='setOverImg(1);'></s:submit>
</s:form></div>
</div>
<!--Login Box Starts Here --></div>
<div id="left">
<h1 align="center"><br />
<br />
Welcome to Preventive Maintenance Site<br />
</h1>
<p>Welcome!</p>
<p>TCL welcomes you to its electrical maintenance intranet site.<br />
</p>
</div>
</div>
<!-- content begins --></div>
</div>
<!-- footer begins -->
<div id="footer">
<p style="text-align: center;">Copyright &copy; 2010.Thirumalai
Chemicals Ltd., All rights Reserved.</p>
</div>
<!-- footer ends -->
</body>
</html>
