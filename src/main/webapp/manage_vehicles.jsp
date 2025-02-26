<%@ page import="java.sql.*, com.vehicle_rental.util.DBConnection" %>
<html>
<head>
    <title>Manage Vehicles</title>
</head>
<body>
    <h2>Vehicle List</h2>
    <a href="add_vehicle.jsp">Add New Vehicle</a>
    <table border="1">
        <tr>
            <th>Vehicle ID</th>
            <th>Model</th>
            <th>Brand</th>
            <th>Price Per Day</th>
            <th>Action</th>
        </tr>

        <%
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM vehicles";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("vehicle_id") %></td>
            <td><%= rs.getString("model") %></td>
            <td><%= rs.getString("brand") %></td>
            <td><%= rs.getDouble("price_per_day") %></td>
            <td>
                <a href="edit_vehicle.jsp?vehicle_id=<%= rs.getInt("vehicle_id") %>">Edit</a> |
                <a href="deleteVehicleServlet?vehicle_id=<%= rs.getInt("vehicle_id") %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
