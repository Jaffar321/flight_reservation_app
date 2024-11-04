<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
.styled-table {
    
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
</style>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
</head>
<body>
<h2>Flight Search Results</h2>
<h3>List of Flights</h3>
<table border=1 class="styled-table">
<tr>
<th>Airlines</th>
<th>Departure City</th>
<th>Arrival City</th>
<th>Departure Time</th>
<th>Select Flight</th>
</tr>
    <c:forEach items="${findFlight }" var="findFlight">
    <tr>
    <td>${findFlight.operatingAirlines }</td>
    <td>${findFlight.departureCity }</td>
    <td>${findFlight.arrivalCity }</td>
    <td>${findFlight.estimatedDepartureTime }</td>
        <td align="center"><a href="showCompleteReservation?flightId=${findFlight.id }">Select</a></td>
    
    </tr>
    </c:forEach>
</table>

</body>
</html>