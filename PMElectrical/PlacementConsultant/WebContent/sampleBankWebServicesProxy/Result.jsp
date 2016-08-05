<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBankWebServicesProxyid" scope="session" class="_38._80._5._10.axis.services.new_banking.BankWebServicesProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBankWebServicesProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleBankWebServicesProxyid.getEndpoint();
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
        sampleBankWebServicesProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        _38._80._5._10.axis.services.new_banking.BankWebServices getBankWebServices10mtemp = sampleBankWebServicesProxyid.getBankWebServices();
if(getBankWebServices10mtemp == null){
%>
<%=getBankWebServices10mtemp %>
<%
}else{
        if(getBankWebServices10mtemp!= null){
        String tempreturnp11 = getBankWebServices10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String type_1id=  request.getParameter("type16");
            java.lang.String type_1idTemp = null;
        if(!type_1id.equals("")){
         type_1idTemp  = type_1id;
        }
        String number_2id=  request.getParameter("number18");
            java.lang.String number_2idTemp = null;
        if(!number_2id.equals("")){
         number_2idTemp  = number_2id;
        }
        String pin_3id=  request.getParameter("pin20");
        int pin_3idTemp  = Integer.parseInt(pin_3id);
        String date_4id=  request.getParameter("date22");
            java.lang.String date_4idTemp = null;
        if(!date_4id.equals("")){
         date_4idTemp  = date_4id;
        }
        String amount_5id=  request.getParameter("amount24");
        int amount_5idTemp  = Integer.parseInt(amount_5id);
        java.lang.String transaction13mtemp = sampleBankWebServicesProxyid.transaction(type_1idTemp,number_2idTemp,pin_3idTemp,date_4idTemp,amount_5idTemp);
if(transaction13mtemp == null){
%>
<%=transaction13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(transaction13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
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