<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/CurrencyConverter/StaticStuff/css/CurrencyConverter.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="border">
	
		<c:if test="${applicationScope.thisNameList !=null }">
			<form role="form" name="ConvertForm" action="/Converter" method="post">

			<div class="form-group">

				<!--  <label for="sel1">Choose currency to convert from:</label> <select
					class="form-control" id="selectFrom" name="convertFrom">
				<c:forEach var="thisName" items="${applicationScope.thisNameList }">
				<option>${ thisName}</option>
				</c:forEach>
					-->
				</select>
			</div>

			<div class="form-group">

				<label for="sel1">Choose currency to convert to:</label> <select
					class="form-control" id="selectTo" name="convertTo">
					
					
				</select>
			</div>

			<div class="form-group">
				<label for="sel1">Enter the amount:</label> <input
					type="Convert From" class="form-control" id="fromInput"
					placeholder="Convert From" name="fromInput">

			</div>

			<p></p>

			<div class='submitButton'>
				<button type="submit" class="btn btn-default" id='submitButton1'>Convert</button>
			</div>
		</form>
		</c:if>
	</div>

</body>
</html>