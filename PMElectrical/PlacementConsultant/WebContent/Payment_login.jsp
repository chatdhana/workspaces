<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>Payment</title>

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


<script type='text/javascript'>

var comp_name = document.forms[0].companyname.value;
var comp_phone = document.forms[0].phone.value;
var person_name = document.getElementById('personname').value;
var comp_desig = document.forms[0].designation.value;
var comp_email = document.forms[0].c_email.value;
var person_mob = document.forms[0].mobile.value;
var comp_address = document.forms[0].address.value;
var submit_form = false;

function validate()
{
	{
		company_result = validate_compname();
		if(company_result == true)
			submit_form = true;
		else
			submit_form = false;
	}
	
	{	
		phone_result = validate_phone();
		if(phone_result == true)
			submit_form = true;
		else
			submit_form = false;
	}
	
	{
		person_result = validate_personname();
		if(person_result == true)
			submit_form = true;
		else
			submit_form = false;	
	}
	
	{
		desig_result = validate_desig();
		if(desig_result == true)
			submit_form = true;
		else
			submit_form = false;	
	}
	
	{
		email_result = validate_email();
		if(email_result == true)
			submit_form = true;
		else
			submit_form = false;	
	}

	{
		mobile_result = validate_mobile();
		if(mobile_result == true)
			submit_form = true;
		else
			submit_form = false;	
	}
	
	if(submit_form==true)
	{
		document.forms[0].submit();
		return true;
	} 		
	else
	{
		document.getElementById('personname').value = "";
		document.forms[0].designation.value = "";
		document.forms[0].mobile.value = "+91";
		alert("Fill in the form again");
		return false;
	}
}


function validate_compname()
{	
	var comp_name = document.forms[0].companyname.value;
	if(comp_name.length>0)
	{
		return true;
	}
	else
	{
		return false;
	}
}	


function validate_phone()
{
	var comp_phone = document.forms[0].phone.value;
	if(comp_phone.length>0)
	{
		if(comp_phone.search(/^\d{3,4}\d{6,8}$/)!=-1)		
		{
			return true;
		}
		else
		{
			return false;	
		}
	}
}	
		
			
function validate_personname()
{	
	var person_name = document.getElementById('personname').value;
	var regexp = /[a-zA-Z]/;
	var regexp1 = /[0-9]/;	
	if(regexp.test(person_name)&&!regexp1.test(person_name))  	
	{
		return true;
	}
	else
	{
		return false;
	}
}	
		
		
function validate_desig()
{
	var comp_desig = document.forms[0].designation.value;
	var regexp2 = /[a-zA-Z\.]{2,}/;	
	if(regexp2.test(comp_desig))
	{
		return true;
	}
	else
	{
		return false;			
	}
}


	
function validate_email()
{
	var comp_email = document.forms[0].c_email.value;
	var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/ ;
   	var illegalChars= /[\(\)\<\>\,\;\:\\\[\]]/;
	if(comp_email != "")
	{
		if(emailFilter.test(comp_email))
		{
			if(!comp_email.match(illegalChars))
			{
				return true;
			}
		}
	}
	else
	{
		return false;
	}
}


function validate_mobile()
{
	var person_mob = document.forms[0].mobile.value;
	var mob_regexp = /^\+91[9][0-9]{9}/;
	if(mob_regexp.test(person_mob))
	{
		return true;
	}
	else
	{
		return false;
	}
}		

</script>

</head>

<body >


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
	var url = "http://10.5.80.57:8080/PlacementConsultant/GetInformation?username=" +escape(username);
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
			if(e=='')
			{
				alert("no data");
			}
			else
			{
				var result = e.split(":");
				document.forms[0].companyname.value = result[0];
				document.forms[0].hcompanyname.value = result[0];
				document.forms[0].companyname.disabled = true;
				document.forms[0].phone.value = result[1];
				document.forms[0].hphone.value = result[1];
				document.forms[0].phone.disabled = true;
				document.forms[0].address.value = result[2];
				document.forms[0].haddress.value = result[2];
				document.forms[0].address.disabled = true;	
				document.forms[0].c_email.value = result[3];
				document.forms[0].hc_email.value = result[3];
				document.forms[0].c_email.disabled = true;				
			}		
		}
	}
}				
</script>



 <form action = "Payment_servlet" method = "post">
 <div>
<input type = "hidden" name="hcompanyname" id="hcompanyname"/>
<input type = "hidden" name="hphone" id="hphone"/>
<input type = "hidden" name="haddress" id="haddress"/>
<input type = "hidden" name="hc_email" id="hc_email"/> 


Welcome &nbsp;<%= session.getAttribute("userName") %>
</div>

<div id = "divDetails" >
<table align = "center">
	
	<tr>
		<td>Company Name</td>
		<td>:</td>
		<td><input type="text" name="companyname" id="companyname"/></td>		
	</tr>
	
	<tr>
		<td>Phone</td>
		<td>:</td>
		<td><input type="text" name="phone" id="phone"/></td>
	</tr>
	
	<tr>
		<td>Company E-mail</td>
		<td>:</td>
		<td><input type="text" name="c_email" id="c_email"/></td>
	</tr>
	
	<tr>
		<td>Person in-charge</td>
		<td>:</td>
		<td><input type="text" name="personname" id="personname"/></td>
		<td><label id="lname"></label></td>
	</tr>

	<tr>
		<td>Designation</td>
		<td>:</td>
		<td><input type="text" name="designation" id="designation"/></td>
	</tr>
	
	<tr>
		<td>Mobile Number</td>
		<td>:</td>
		<td><input type="text" name="mobile" id="mobile" value = "+91" maxlength = "13"/></td>
	</tr>
	
	<tr>
		<td>Address</td>
		<td>:</td>
		<td><textarea name = "address" id="address" rows="3" cols="15"></textarea></td>
	</tr>
	
	<tr align="center">	
		<td align="center">
		<input type="button" value="Submit" onclick = "return validate()"/>
		</td>
	</tr>
	
</table>
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
