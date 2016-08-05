<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Confirm your Payment</title>

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
<script language="JavaScript" src = "creditcard_validation.js"></script>

<script type="text/javascript">
function call_ccvalidation()
{
	var name = document.getElementById("cardname");
	var cname = name.options[name.selectedIndex].text;
	var cnumber = document.getElementById("cardnumber").value;
	javascript:validate_creditcard(cname,cnumber);
}

function getDate()
{
	var m = document.getElementById('month').value;
	var y =document.getElementById('year').value;
	document.getElementById('hdate').value=m+"-"+y;
}

function paycard()
{
	var ctype = document.getElementById('cardname').value;
	document.getElementById('htype').value = ctype;
	document.forms[0].submit();
	return true;
}

function exit()
{
	document.forms[0].reset();
	document.forms[0].action = "";
	document.forms[0].submit();
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

<li><a href="#" title="" class="style3">Home</a></li>

<li><a href="#" title="">Job Seeker </a></li>

<li><a href="#" title="">Recruiter</a></li>

<li><a href="#" title="">About Us </a></li>

<li><a href="#" title="">Contact</a></li>

<h1>&nbsp;</h1>

</ul>

</div>

<div id="main">

<!-- header begins -->

<!-- header ends -->

<!-- content begins -->

<div id="global">

<div id="content">



<form action = "paynow" method = "post">
<div><% java.util.Date date = new java.util.Date();%>
   <%= date %> </div>
   <br><br>
<div align="center"><label>Type of your Credit Card&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;</label>
	 <select name = "cardname" id = "cardname">
	 		<option value = "">--Select a Card Type--</option>
	 		<option value = "Visa">Visa</option>
	 		<option value = "MasterCard">MasterCard</option>
	 		<option value = "DinersClub">DinersClub</option>
	 		<option value = "CarteBlanche">CarteBlanche</option>
	 		<option value = "AmEx">AmEx</option>
	 		<option value = "Discover">Discover</option>
	 		<option value = "JCB">JCB</option>
	 		<option value = "enRoute">enRoute</option>
	 		<option value = "Solo">Solo</option>
	 		<option value = "Switch">Switch</option>
	 		<option value = "Maestro">Maestro</option>
	 		<option value = "VisaElectron">VisaElectron</option>
	 </select>
</div><br>

<div align = "center"><label>Credit Card Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>:&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "cardnumber" id = "cardnumber" onblur = "call_ccvalidation()">
</div>
<br>
<div align = "center"><label>Enter the security code&nbsp;&nbsp;&nbsp;&nbsp;</label>:&nbsp;&nbsp;&nbsp;&nbsp;<input type = "password" name = "securepin" id = "securepin" size = "3" maxlength="3">
</div>
<br>
<div id = "expiry" align = "center"><label>Expiry Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>:&nbsp;&nbsp;&nbsp;&nbsp;
<select name = "month">
<option value = "jan">01</option>
<option value = "feb">02</option>
<option value = "mar">03</option>
<option value = "apr">04</option>
<option value = "may">05</option>
<option value = "jun">06</option>
<option value = "jul">07</option>
<option value = "aug">08</option>
<option value = "sep">09</option>
<option value = "oct">10</option>
<option value = "nov">11</option>
<option value = "dec">12</option>
</select>&nbsp;&nbsp;
<select name = "year" onblur="getDate()">
<option value = "2009">09</option>
<option value = "2010">10</option>
<option value = "2011">11</option>
<option value = "2012">12</option>
<option value = "2013">13</option>
<option value = "2014">14</option>
<option value = "2015">15</option>
<option value = "2016">16</option>
<option value = "2017">17</option>
<option value = "2018">18</option>
<option value = "2019">19</option>
<option value = "2020">20</option>
<option value = "2021">21</option>
<option value = "2022">22</option>
<option value = "2023">23</option>
<option value = "2024">24</option>
<option value = "2025">25</option>
<option value = "2026">26</option>
</select>
</div>
<br>
<div align="center">
<table>
<tr>
<td><input type = "button" name = "pay" id  = "pay" disabled value= "Pay Now" onclick = "return paycard()"></td>
<td><input type = "button" value= "Cancel" onclick = " return exit()"></td>
</tr>
</table>
</div>
<input type = "hidden" name = "hdate" id = "hdate">
<input type = "hidden" name = "htype" id = "htype">
<input type = "hidden" name = "amt" id = "amt" value = "<%= session.getAttribute("amt")%>">
<input type = "hidden" name = "username" id = "username" value = "<%= session.getAttribute("userName")%>">
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