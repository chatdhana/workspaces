<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="header.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>TCL - Home</title>
<style type="text/css" media="all">
<!--
.style3 {
	color: #009933
}

.style5 {
	font-size: 16px;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
	color: #0000FF;
}

.style10 {
	color: #990099;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
	font-size: x-large;
}

.style12 {
	font-size: x-large;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
	color: #0000FF;
}

.style13 {
	font-size: x-large;
	color: #993399;
}

.style15 {
	color: #0000FF;
	font-size: x-large;
}

.style17 {
	color: #9933CC
}

.style19 {
	color: navy;
	font: bold;
}

.style20 {
	font-size: 16px;
	color: #0000FF;
}

.style21 {
	font-size: 14px;
	color: #333333;
	font-family: "Lucida Calligraphy", "Lucida Handwriting",
		"Monotype Corsiva";
}

.style22 {
	font-size: 14px;
	color: red;
}
-->
</style>
</head>
<body class="styleBody">

<table width="100%" border="0" cellspacing="0" cellpadding="0" >


	<tr class="styleImg01">
		<td nowrap="yes">&nbsp;&nbsp;<span class="style10">&nbsp;
		<span class="style19"><b>Thirumalai Chemicals Limited</b> </span></span> <span><br />

		<span class="style21"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; One of
		the leading manufacturers of Industrial and Speciality Chemicals for a
		range of global end users.</span></span> &nbsp;&nbsp;<span class="style10"><center>Preventive
		Maintenance Schedule</center></span></td>

	</tr>
	<tr class="styleImg02">
		<td nowrap="yes"><span style=" font:bold;color: navy;">Welcome &nbsp;
		<s:property value="#session.userName" />!</span> 
		
		<s:if
			test="#session.loggedIn!='true'">
			<jsp:forward page="/jsp/pageExpired.jsp"></jsp:forward>
		</s:if></td>
	</tr>
	<tr class="styleImg01">
		<td nowrap="yes"><a href="/PM/jsp/home.action" title="Go to home page">Home</a>
		<a href="#" title="Show Reports">Reports</a> <a href="#"
			title="Show master reports">MasterReports</a> <a href="#"
			title="Show Site Map">SiteMap</a> <a href="logout.action"
			title="End up session">Logout</a></td>

	</tr>
	<tr>
		<td>
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

		</td>

	</tr>



	<tfoot>
		<tr class="styleImg01">
			<td nowrap="yes"><center><span>Copyright &copy;
			2010.Thirumalai Chemicals Ltd., All rights Reserved.</span> </center></td>

		</tr>

	</tfoot>
</table>
</body>

</html>

