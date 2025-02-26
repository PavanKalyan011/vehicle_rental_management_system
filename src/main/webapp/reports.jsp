<%@ page import="java.sql.*, com.vehicle_rental.util.DBConnection" %>
<html>
<head>
    <title>Reports</title>
</head>
<body>
    <h2>Booking Reports</h2>
    <table border="1">
        <tr>
            <th>Booking ID</th>
            <th>User ID</th>
            <th>Vehicle ID</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Total Price</th>
        </tr>

        <%
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM bookings";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("booking_id") %></td>
            <td><%= rs.getInt("user_id") %></td>
            <td><%= rs.getInt("vehicle_id") %></td>
            <td><%= rs.getDate("start_date") %></td>
            <td><%= rs.getDate("end_date") %></td>
            <td><%= rs.getDouble("total_price") %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
