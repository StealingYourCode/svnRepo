<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/TradingPlatformWeb/StaticStuff/css/loginRegisterStyleSheet.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<p>
	<p>
	<div id='mainImage'></div>
	<p>
		<img src="/TradingPlatformWeb/StaticStuff/images/logo-TP.jpg" name="logo"
			width="200" height="120" id="logo" onclick="location.href='HomePage.html'" /> <img
			src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQL68-9Si8PuglgXQqGJGGgzTY2a0YZyDovqpFW13guGG8AsrGkrQ"
			name="phoneImage" width="28" height="24" align="right"
			id="phoneImage" />
	<p>
	<div id='loginButtons'>
		<button type="button" id='loginButton'>Login</button>
		&nbsp&nbsp&nbsp
		<button type="button" id='registerButton' onclick="location.href='RegisterPage.html'">Register</button>
	</div>
	<div id="call">Call TP 800 800 8000</div>
	<div class="container">
		<h2>Login</h2>
		<div class="border">
			<form role="form" name="LoginForm" action="../../Login" method="post">
				<div class="form-group"  >

					<input type="text" class="form-control" id="username" name="Username"
						placeholder="Username">
				</div>
				<div class="form-group">

					<input type="password" class="form-control" id="password" name="Password"
						placeholder="Password">
				</div>
				<div class="checkbox">
					<label><input type="checkbox"> Remember me</label>
				</div>
				<button type="submit" class="btn btn-default" id='submitButton'>Login</button>
				<div id='blueText'><p>Forgot your password?</p>
				<p>Register</p>
				</div>
			</form>
		</div>
	</div>

	<hr id='line2'>
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