<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	box-sizing: border-box
}

/* Add padding to containers */
.container {
	padding-right: 400px;
	padding-left: 400px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
	<form action="saveReg" method="post">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<label><b>FirstName</b></label> <input type="text"
				placeholder="Enter your FirstName" name="firstName" required>
			<label><b>LastName</b></label> <input type="text"
				placeholder="Enter your LastName" name="lastname" required>
			<label><b>Email</b></label> <input type="text"
				placeholder="Enter your Email_Id" name="email" required> <label><b>Password</b></label>
			<input type="password" placeholder="Enter your Password"
				name="password" required>
			<hr>

			<p>
				By creating an account you agree to our <a href="#">Terms &
					Privacy</a>.
			</p>
			<input type="submit" class="registerbtn" value="Save">
		</div>

		<div class="container signin">
			<p>
				Already have an account? <a href="showDirectLoginPage">Sign in</a>.
			</p>
		</div>
	</form>
</body>
</html>