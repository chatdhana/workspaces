<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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

<script type = 'text/javascript'>

var request = null;
 request = new ActiveXObject("Microsoft.XMLHTTP");
 if(request == null)
 	alert("Error creating Object");

function validate()
{
	var uname = document.getElementById("username").value;
	var pword = document.getElementById("password").value;
	var url = "http://10.5.80.57:8080/PlacementConsultant/CheckUser?username=" +escape(uname);
	request.open("POST", url, true); 
	request.onreadystatechange = checkpwd;
	request.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	request.send("username="+escape(uname) +"&password="+ escape(pword));
}
	
function checkpwd()
{ 	
 	if(request.readystate == 4)
 	{
 		if(request.status == 200)
 		{
 			var c = request.responseText;
 			if(c == 'true')
 			{
 				document.forms[0].submit(); 						
			}
			else
			{
				document.getElementById("login").innerHTML = 'Password Incorrect*';
			}
 		}
 	}
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



<form action = "Payment_login.jsp">
<div>
<br></br><br>
</br></div>
<div>
Welcome <label id="user"><%= session.getAttribute("userName")%>,</label>
<input type = "hidden" name = "username" id = "username" value="<%= session.getAttribute("userName")%>">

</input>
<br/>
<br/>
Finish the payment to Confirm your Job Post...
<br/>
<br/>
</div>
<div>

<table>
	
	<tr>
	<td>Password</td>
	<td>:</td>
	<td><input type = "password" name = "password" id = "password"></input><div id = "login">Enter the Password here!!!
	</div></td>	
	</tr>
	
	<tr align="center">
	<td><br></br><input type = "button" value = "Submit" onclick = "return validate()"></input>
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
