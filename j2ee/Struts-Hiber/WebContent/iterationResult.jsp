<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iteration Result</title>
<script type="text/javascript">
var req = false;
   function makeRequest(url, parameters) {
      req = false;
     
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
       alert(window.XMLHttpRequest);
         req = new XMLHttpRequest();
         if (req.overrideMimeType) {
         	// set type accordingly to anticipated content type
            //req.overrideMimeType('text/xml');
            req.overrideMimeType('text/html');
         }
      } else if (window.ActiveXObject) { // IE
      alert(window.ActiveXObject);
         try {
            req = new ActiveXObject("Msxml2.XMLHTTP");
         } catch (e) {
            try {
               req = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
         }
      }
      if (!req) {
         alert('Cannot create XMLHTTP instance');
         return false;
      }
      req.onreadystatechange = alertContents;
      req.open('GET', url + parameters, true);
      req.send(null);
   }

   function alertContents() {
      if (req.readyState == 4) {
         if (req.status == 200) {
            result = req.responseText;
            document.getElementById('invalidRecTabe').innerHTML = result;            
         }
      }
   }

function loadInvalidRecTable(){
makeRequest("<%= request.getContextPath()%>/iterationTest.action","");
}
</script>
</head>
<body onload="loadInvalidRecTable()">

<div id="invalidRecTabe"></div>
Result::
<s:iterator value="list1" id="l1" status="l1S">

	<b><s:property id="l1Id" /></b>
	<!-- 
	<s:if test="str11==str11">
	STR11</s:if>

	<s:iterator value="list2" status="l2S">

		<li><s:property id="l2" /></li>
		
	</s:iterator>
 -->
</s:iterator>

</body>
</html>