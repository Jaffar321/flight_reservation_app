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
.loginbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.loginbtn:hover {
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
<title>Search Flights</title>
</head>
<body>

	<form action="findFlights" method="post">
		<div class="container">
			<h1>Search </h1>
			<hr>
			<label><b>From:</b></label> <input type="text"
				 name="from" required> 
			<label><b>to:</b></label>
			<input type="text"
				name="to" required>
				<label><b>Departure date</b></label>
			<input type="text"
				name="departure_date" required>
			<hr>

			<input type="submit" class="loginbtn" value="search">
	
		</div>

		
	</form>
	
</body>
</html>