<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>Tariff Details</title>

<meta name="keywords" content="" />

<meta name="description" content="" />

<link href="file://///10.5.80.121/PlacementProject/Template/Template/styles.css" rel="stylesheet" type="text/css" />

<style type="text/css">


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


</style>

<script type="text/javascript">
function CheckCalculate()
{
	var num = document.getElementById("vacant").value;
	var regexp1 = /[0-9]{1,5}/;
	if(regexp1.test(num))
	{
		Calculate();
	}
	else
	{
		alert("Please enter the vacancy details");
		Total.innerHTML = '';
	}	
}

function Calculate()
{
	var commission = 0.05;
	var sal = document.getElementById("salary").value;
	var num = document.getElementById("vacant").value;
	Total.innerHTML = 'Amount to be paid&nbsp;:&nbsp;<input type = "text" name = "txtamount" id = "txtamount">';
	var cal = sal*commission*num;
	document.getElementById("txtamount").value = cal;
	document.getElementById("htxtamount").value = cal;
	document.getElementById("txtamount").disabled = true;
}

function isEnabled()
{
	if(document.theForm.checkEnabler.checked)
		document.theForm.submit();
	else
		alert("Please Check the Terms and Conditions");
}

</script>

</head>

<body>

<div id="menu">

<br /><br />

&nbsp;&nbsp;<span class="style10">&nbsp; <span class="style19">JobsCorp.Com</span></span>

<span class="style5 style13 style19"><span class="style17 style20"> &nbsp;</span></span><span class="style5 style13"><span class="style15">&nbsp; </span></span><span class="style12">&nbsp;</span><span class="style5"><br />

&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<span class="style21">We Make Ur Dreamz Posssible...... </span></span>

<ul>
<li><a href="SeekerLogin.jsp" title="Home" class="style3">Home</a></li>
<li><a href="Jobseeker.jsp" title="Job Seeker">Jobseeker</a></li>
<li><a href="Recruiter.jsp" title="Recruiter">Recruiter</a></li>
<li><a href="Profile.jsp" title="About Us">About Us</a></li>
<li><a href="Contact.jsp" title="Contact Us">Contact</a></li>
<li><a href="SiteMap.jsp" title="Site Map">SiteMap</a></li>
<li><a href="logout.jsp" title="Logout">Logout</a></li>
</ul>

</div>

<div id="main">

<!-- header begins -->

<!-- header ends -->

<!-- content begins -->

<div id="global">

<div id="content">


<input type = "hidden" name = "username" id = "username" value="<%= session.getAttribute("userName")%>"/>
<script type='text/javascript'>


var request = null;
 request = new ActiveXObject("Microsoft.XMLHTTP");
 if(request == null)
 	alert("Error creating Object");
 	

	var username = document.getElementById("username").value;
	var url = "http://10.5.80.57:8080/PlacementConsultant/GetAmount?username=" +escape(username);
	request.open("POST", url, true); 
	request.onreadystatechange = pushDetails;
	request.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	request.send("username="+escape(username));
				
function pushDetails()
{
	if(request.readystate == 4)
	{
		if(request.status == 200)
		{
			var e = request.responseText;
			var result = e.split(":");
			document.forms[0].jobid.value = result[0];
			document.forms[0].job_type.value = result[1]; 
			document.forms[0].salary.value = result[2];
			document.forms[0].pdate.value = result[3];
			document.forms[0].jobid.disabled = "true";
			document.forms[0].job_type.disabled = "true";
			document.forms[0].salary.disabled = "true";
			document.forms[0].pdate.disabled = "true";
		}
	}
}				
</script>

 <label>Hi <%= session.getAttribute("userName") %></label>
<form name = "theForm" action="confirm_pay" method="post">
<div>
<input type = "hidden" name = "htxtamount" id = "htxtamount"/>
</div>
<table align = "center" width="100%" cellpadding="0" cellspacing="0">

	<tr>
	<td>
	Your Order Preview:<br/><br/>
	</td>
	</tr>
	
	<tr>
		<td>Job ID</td>
		<td>:</td>
		<td><input type="text" name="jobid" id="jobid"/></td>
	</tr>
	
	<tr>
		<td>Job Type</td>
		<td>:</td>
		<td><input type="text" name="job_type" id="job_type"/></td>
	</tr>
	
	<tr>
		<td>Quoted Salary</td>
		<td>:</td>
		<td><input type="text" name="salary" id="salary"/></td>
	</tr>
	
	<tr>
		<td>Posted Date</td>
		<td>:</td>
		<td><input type="text" name="pdate" id="pdate"/></td>
	</tr>
	
	<tr>
		<td>No. of vacancies to be filled through us</td>
		<td>:</td>
		<td><input type="text" name="vacant" id="vacant" maxlength = "5"/><input type = "button" value = "Calculate Amount" onclick = "CheckCalculate()"/></td>
	</tr>
		
</table>

<table>
	<tr>
		<td><div id = "Total"></div></td>
	</tr>
</table>


<div>
<input type="checkbox" name="checkEnabler" value="checkbox"/><a href = "TermsConditions.jsp">I have read the Terms and Conditions</a><br/>
<br/><br/>
<input type = "button" name = "next" value = "Pay Now" onclick = "isEnabled()"/>
<input type = "button" name = "cancel" value = "Cancel" onclick = ""/>

</div>


</form>






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





</div>

<!-- content begins -->

</div>

</div>

<!-- footer begins -->


<div id="footer">

<p>Copyright &copy; 2009. Design by Launch Pad 15 </p>

<p> <a href="#">JobCorps.com</a></p>

</div>

<!-- footer ends -->


</body>

</html>
