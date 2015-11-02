$( document ).ready(function() {
	console.log("app ready");
});

function validate(){
	var name = $("#name").val();
	var email = $("#email").val();
	var phone = $("#phone").val();
	var phoneRegex = /^([0-9\(\)\/\+ \-]*)$/;
	if (name==""){
		alert("Please enter your name");
		return false;
	} else if(!validateEmail(email)) {
		alert("Please enter valid email address");
		return false;
	} else if(phone=="") {
		alert("Please provide your phone number");
		return false;
	} else if(phone!="" && (!phoneRegex.test(phone))) {
		alert("Please enter valid phone number");
		return false;
	}
}

function validateEmail(email) {
	if(email == "") {
		return false;
	}
	atPos = email.indexOf("@");
	dotPos = email.lastIndexOf(".");
   
	if (atPos < 1 || ( dotPos - atPos < 2 )) {
		return false;
	}
	
	return true;
}