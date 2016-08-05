<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request body reader</title>
<script type="text/javascript">
	function triggerReq() {
		var xmlDataReq = document.getElementById('xmlDataReq');
		var xmlDataRes = document.getElementById('xmlDataRes');
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4 && req.status == 200) {
				xmlDataRes.value = req.responseText;
			}
		};
		req.open("POST", "ReqBodyReader", true);
		req.send(xmlDataReq.value);
	}
</script>
</head>
<body>
	<form id="formId" action="ReqBodyReader" method="get" enctype="application/x-www-form-urlencoded">
		
		<table width="100%">
			<thead align="center">
				<tr>
					<td><label for="xmlDataReq">Request</label></td>
					<td><label for="xmlDataRes">Response</label></td>
				</tr>
			</thead>
			<tbody align="center">
				<tr>
					<td><textarea id="xmlDataReq" rows="30" cols="80" ></textarea></td>
					<td><textarea id="xmlDataRes" rows="30" cols="80" readonly></textarea></td>
				</tr>
			</tbody>
		</table>

		<br /> 
		<div align="center">
		<input id="hiddenIp1" type="text" value="Trigger Request" align="middle"/>
		<input id="hiddenIp2" type="text" value="Trigger Request" align="middle"/>
		
		<input id="triggerBtn" type="button" onclick="triggerReq();"
			value="Trigger Request" align="middle"/>
		<input id="submitBtn" type="submit" value="Submit" align="middle"/>
		</div>
	</form>
</body>
</html>