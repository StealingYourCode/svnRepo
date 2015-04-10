/**
 * 
 */
function checkPasswordMatch() {

	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("passwordConfirm").value;
	var errorText = "";

	if (password != confirmPassword) {
	
	errorText += "Passwords do not match <br>";
	document.getElementById("errorMessage").innerHTML = errorText;
//	alert("Passwords do not match");
	return false;
	
	}
	
	else
		return true;

// if (errorText != "") {
// document.getElementById("errorMessage").innerHTML = errorText;
// return false;
// }

}

function checkFormNotEmpty(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var errorText="";
	
	if(username=="" || password==""){
		errorText+= "Enter a username and password";
		document.getElementById("errorMessage").innerHTML = errorText;
		return false;
	}
	
	else 
		return true;
}

function goToRequestPage(){
	window.location="/WEB-INF/jsp/Request.jsp";
	
		
}