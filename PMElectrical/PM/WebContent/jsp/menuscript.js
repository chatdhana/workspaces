/*** SET BUTTON'S FOLDER HERE ***/
var buttonFolder = "http://localhost:8080/PM/jsp/buttons/";

/*** SET BUTTONS' FILENAMES HERE ***/
upSources = new Array("button1up.png","button2up.png","button3up.png","button4up.png","button5up.png","button6up.png","button7up.png","button8up.png");

overSources = new Array("button1over.png","button2over.png","button3over.png","button4over.png","button5over.png","button6over.png","button7over.png","button8over.png");


//*** NO MORE SETTINGS BEYOND THIS POINT ***//
totalButtons = upSources.length;



//*** MAIN BUTTONS FUNCTIONS ***//
// PRELOAD MAIN MENU BUTTON IMAGES
function preload() {
	for ( x=0; x<totalButtons; x++ ) {
		buttonUp = new Image();
		buttonUp.src = buttonFolder + upSources[x];
		buttonOver = new Image();
		buttonOver.src = buttonFolder + overSources[x];
	}
}

// SET MOUSEOVER BUTTON
function setOverImg(But) {
	document.getElementById('button' + But).src = buttonFolder + overSources[But-1];
}

// SET MOUSEOUT BUTTON
function setOutImg(But) {
	document.getElementById('button' + But).src = buttonFolder + upSources[But-1];
}


//preload();



//Login

function hideElement(name) {
document.getElementById(name).style.visibility="hidden";

}

function showElement(name) {
document.getElementById('login').style.visibility="visible";
}

var oldInnerHTML = new String();

function disLoginOrRegisterPane() {
var userName=document.getElementById('userName').value;
oldInnerHTML=document.getElementById('login1').innerHTML;
var inHTML="<div class='content2'>Registered User? <a	href='javascript:disLoginPane();' onmouseout='setOutImg(1);' onmouseover='setOverImg(1);' ><img src='buttons/button1up.png' alt='Registered User? Click on me!'	border='0' id='button1' vspace='1' hspace='1'/></a><br/> New User? <a href='#' onmouseout='setOutImg(\"2\");' onmouseover='setOverImg(\"2\");' ><img	src='buttons/button2up.png' alt='New User? Click on me!' border='0'	id='button2' vspace='1' hspace='1' /></a></div>";
if(!userName) {
document.getElementById('userName').value='';
document.getElementById('login').innerHTML =inHTML;

} else {
disLoginPane();
}

}

function disLoginPane() {
var inHtml="<div class='content2'>User Name: <input id='userName' type='text'	alt='User Name' /> <br />Password: <input id='pwd' type='password' alt='Password'><br />&nbsp;&nbsp;<a href='home.jsp' onmouseout='setOutImg(1);' onmouseover='setOverImg(1);' ><img src='buttons/button1up.png' alt='Registered User? Click on me!'	border='0' id='button1' vspace='1' hspace='1'/></a></div>";
document.getElementById('login').innerHTML =oldInnerHTML;
document.getElementById('userName').focus();
document.getElementById('userName').select();
}

preload();
