<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iteration Result</title>
</head>
<body>
Result:
<s:iterator value="list1" id="l1" status="l1S">

	<b><s:property id="l1Id" /></b>
	
	<s:if test="str11==str11">
	STR11</s:if>

	<s:iterator value="list2" status="l2S">

		<li><s:property id="l2" /></li>
		
	</s:iterator>

</s:iterator>
</body>
</html>