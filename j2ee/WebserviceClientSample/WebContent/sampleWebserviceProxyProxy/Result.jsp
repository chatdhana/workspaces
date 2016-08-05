<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleWebserviceProxyProxyid" scope="session" class="mine.ws.proxy.WebserviceProxyProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleWebserviceProxyProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleWebserviceProxyProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleWebserviceProxyProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        mine.ws.proxy.WebserviceProxy getWebserviceProxy10mtemp = sampleWebserviceProxyProxyid.getWebserviceProxy();
if(getWebserviceProxy10mtemp == null){
%>
<%=getWebserviceProxy10mtemp %>
<%
}else{
        if(getWebserviceProxy10mtemp!= null){
        String tempreturnp11 = getWebserviceProxy10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        %>
        <jsp:useBean id="mine1ws1entity1DataEntity_1id" scope="session" class="mine.ws.entity.DataEntity" />
        <%
        sampleWebserviceProxyProxyid.redirectWebserviceCall(mine1ws1entity1DataEntity_1id);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>