<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="bookVehicle" method="post">
    <input type="hidden" name="vehicle_id" value="<%= request.getParameter("vehicle_id") %>">
    <input type="hidden" name="price_per_day" value="<%= request.getParameter("price_per_day") %>">
    
    <label>Start Date:</label>
    <input type="date" name="start_date" required><br>
    
    <label>End Date:</label>
    <input type="date" name="end_date" required><br>

    <button type="submit">Book Now</button>
</form>

</body>
</html>