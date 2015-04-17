<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

</head>
<body>
	<p>
		<img src="/TradingPlatformWeb/StaticStuff/images/logo-TP.jpg"
			name="logo" width="200" height="120" id="logo" /> <img
			src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQL68-9Si8PuglgXQqGJGGgzTY2a0YZyDovqpFW13guGG8AsrGkrQ"
			name="phoneImage" width="28" height="24" align="right"
			id="phoneImage" />
	</p>

	
	Hello ${thisUser.firstName } ${thisUser.lastName }
	
	<c:forEach var="thisTrade" items="${sessionScope.thisTradeList }">

			<div class="container">
				<h2>Trades</h2>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse${thisTrade.tradeId }">Trade ID: ${thisTrade.TradeId }</a>
							</h4>
						</div>
						<div id="collapse${thisTrade.tradeId }" class="panel-collapse collapse in">
							<div class="panel-body">${thisTrade.sharePrice }</div>
							<div class="panel-body">${thisTrade.priceTotal }</div>
							<div class="panel-body">Shares Filled: ${thisTrade.shares }</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

</body>
</html>