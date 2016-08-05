<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<%=request.getAttribute("id")%>
	<br />
	<label>dff ${requestScope['id']}</label>
	<br />
	<label>dff ${requestScope['id2'][0]}</label>
	<br />

	<br />
	<select id="country">
		<option selected="selected">---SELECT---</option>
		<c:forEach items="${requestScope['id2']}" var="arr">
			<option label="${arr}">${arr}</option>
		</c:forEach>
	</select>
</body>
</html>