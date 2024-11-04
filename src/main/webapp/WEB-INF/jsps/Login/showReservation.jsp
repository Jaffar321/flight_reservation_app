<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container {
	
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 90%;
	padding: 10px;
	margin: 4px 0 22px 0;
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
.savebtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.savebtn:hover {
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
.split {
	height: 100%;
	width: 50%;
	position: fixed;
	z-index: 1;
	top: 0;
	overflow-x: hidden;
	padding-top: 18px;
}

.left {
	left: 0;
	background-color: #04AA6D;
}

.right {
	right: 0;
	background-color: red;
}

/* If you want the content centered horizontally and vertically */
.centered {
	position: absolute;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
}
table, th, {

  border: 1px solid white;
  
}
.td{
color:white;
}
</style>
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body>
	<div class="split left">
		<div class="centered td">
			<h3>Flight Details</h3>
			<table border=1>
				<tr>

					<td style="color:white;">Flight Number</td>
					<td>${flight.flightNumber }</td>
				</tr>
				<tr>
					<td>Operating Airlines</td>
					<td>${flight.operatingAirlines }</td>
				</tr>
				<tr>
					<td>Departure City</td>
					<td>${flight.departureCity }</td>
				</tr>
				<tr>
					<td>Arrival City</td>
					<td>${flight.arrivalCity }</td>
				</tr>
				<tr>
					<td>Departure Date</td>
					<td>${flight.dateOfDeparture}</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="split right">
		<div >
			<h3>Enter Passenger details</h3>
			<form action="confirmReservation" method="post">
				<div class="container"><table>
				<tr><td>
					<label><b>First Name</b></label> </td><td><input type="text"
						placeholder="Enter your FirstName" name="firstName" required></td></tr>
					<tr><td><label><b>Last Name</b></label></td><td> <input type="text"
						placeholder="Enter your LastName" name="lastName" required></td></tr>
						<tr><td><label><b>Middle Name</b></label> </td><td><input type="text"
						placeholder="Enter your MiddleName" name="middleName" required></td></tr>
					<tr><td><label><b>Email_Id</b></label></td><td> <input type="text"
						placeholder="Enter your Email_Id" name="email" required></td></tr>
						<tr> <td><label><b>Phone</b></label></td>
					<td><input type="text" placeholder="Enter your Mobile Number"
						name="phone" required></td></tr>
						<tr><td><label><b>Name On the Card</b></label></td><td> <input type="text"
						placeholder="Enter your Name Printed on Card" name="nameOfTheCard" required></td></tr>
						<tr><td><label><b>Card Number</b></label></td><td> <input type="text"
						placeholder="Enter your Card Number" name="cardNumber" required></td></tr>
						<tr><td><label><b>CVV Number</b></label></td><td> <input type="text"
						placeholder="Enter your CVV Number" name="cvv" required></td></tr>
						<tr><td><label><b>Expiry Date</b></label></td><td> <input type="text"
						placeholder="Enter Expire date of card" name="expiryDate" required></td></tr>
						
						<tr><td colspan=2><input type="hidden" name="flightId" value="${flight.id }"/></td></tr>
					<hr>
<tr>
					<td colspan=2><input type="submit" class="savebtn" value="Complete Reservation"></td></tr></table>
				</div>

				<div class="container signin"></div>
			</form>
		</div>
	</div>

</body>
</html>