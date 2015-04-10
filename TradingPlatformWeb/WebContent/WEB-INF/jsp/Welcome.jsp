<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Untitled Document</title>
<link rel="stylesheet" type="text/css"
	href="/TradingPlatformWeb/StaticStuff/css/HomeStyleSheet.css" />

</head>

<body>
	<p>
	<div id='mainImage'></div>
	
	
	<p>
		<img src="/TradingPlatformWeb/StaticStuff/images/logo-TP.jpg" name="logo"
			width="200" height="120" id="logo" /> <img
			src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQL68-9Si8PuglgXQqGJGGgzTY2a0YZyDovqpFW13guGG8AsrGkrQ"
			name="phoneImage" width="28" height="24" align="right"
			id="phoneImage" />
	<p>
	<div id='loginButtons'>
		<button type="button" id='loginButton' onclick="location.href='loginPage.html'" >Login</button>
		&nbsp&nbsp&nbsp
		<button type="button" id='registerButton' onclick="location.href='RegisterPage.html'">Register</button>
	</div>
	<div id="call">Call TP 800 800 8000</div>
	<p>
		<img src="/TradingPlatformWeb/StaticStuff/images/main.jpg" name="main"
			width="1200" height="580" id="main" />
	</p>
	
	<c:if test="${sessionScope.thisUser !=null }">
	Hello ${thisUser.firstName } ${thisUser.lastName }
	</c:if>
	
	<div id='navBar'>
		<ul>
			<li id='homemenu'>Home
				<ul id='homesub'>
				<li>Option 1</li>
				<li>Option 2</li>
				<li>Option 3</li>
					</ul></li>
			<li>Online Trading</li>
			<li>Online Brokerage</li>
			<li>Investment Products</li>
			<li>TP Services</li>
			<li>Contact Us</li>
		</ul>
	</div>
	<p>
		<img src="/TradingPlatformWeb/StaticStuff/images/round-images1.png"
			name="round1" width="152" height="152" id="round1" />
	<p>
	<div id='firstText'>
		<h1>View Requests</h1>
		<p>Invest your money, don't store it under your bed.</p>
		<form role="form" name="viewRequstForm" action="../../ViewRequest" method="post">
		<button type="button" id='learnMoreButton1'>View</button>
		</form>
	</div>
	<img src="/TradingPlatformWeb/StaticStuff/images/round-images3.png"
		name="round3" width="152" height="152" align="right" id="round3" />
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>
		<img src="/TradingPlatformWeb/StaticStuff/images/round-images2.png"
			name="round2" width="152" height="152" id="round2" /><img
			src="/TradingPlatformWeb/StaticStuff/images/round-images4.png"
			name="round4" width="152" height="152" align="right" id="round4" />
	</p>
	
	<hr id='line2' width="1200">
	<div id='secondText'>
		<h1>Make a Request</h1>
		Don't you want to be able to trade online? Well now you can, with the
		magic of TP.
		<a href="Request"><button type="button" id='learnMoreButton2' >Request</button>
		</a>
	</div>

	<div id='thirdText'>
		<h1>Online Brokerage</h1>
		Because who wants to pay a person to handle your money?
		<button type="button" id='learnMoreButton3'>Learn more</button>
	</div>
	<div id='fourthText'>
		<h1>TP Services</h1>
		The jokes write themselves.
		<button type="button" id='learnMoreButton4'>Learn more</button>
	</div>
	<div id='insideText'>
		<h1>&nbsp;</h1>
		<h1>&nbsp;</h1>
		<div id=insideWords'></div>
		<h1>&nbsp&nbsp&nbsp Why Choose TP?</h1>
		<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Manage your
			investments in your own time.</p>
		<button type="button" id='makeAccountButton' onclick="location.href='RegisterPage.html'">OPEN AN ACCOUNT</button>
		
	</div>
	<hr id='line3'>
	<div id='icons'>
		<img id='facebook'
			src="/TradingPlatformWeb/StaticStuff/images/facebookIcon.png" width="32"
			height="28"> <img id='facebook'
			src="/TradingPlatformWeb/StaticStuff/images/twitter.jpg" width="32"
			height="28"> <img id='facebook'
			src="/TradingPlatformWeb/StaticStuff/images/linkedin.jpg" width="32"
			height="28"> <img id='facebook'
			src="/TradingPlatformWeb/StaticStuff/images/google.png" width="32"
			height="28"> <img id='facebook'
			src="/TradingPlatformWeb/StaticStuff/images/youtube.png" width="32"
			height="28">
	</div>
	<div id='copyright'>© Louis.Yang@FDMGroup.com 2015</div>
</body>
</html>