<%@ page import="java.sql.*, com.vehicle_rental.util.DBConnection" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Welcome, Admin</h2>
    <a href="manage_users.jsp">Manage Users</a> |
    <a href="manage_vehicles.jsp">Manage Vehicles</a> |
    <a href="manage_bookings.jsp">Manage Bookings</a> |
    <a href="logout.jsp">Logout</a>
    
    <form action="addVehicle" method="post">
    <input type="text" name="model" placeholder="Model" required><br>
    <input type="text" name="brand" placeholder="Brand" required><br>
    <input type="number" name="price_per_day" placeholder="Price per day" required><br>
    <select name="availability">
        <option value="true">Available</option>
        <option value="false">Not Available</option>
    </select><br>
    <button type="submit">Add Vehicle</button>
</form>
</body>
</html>


