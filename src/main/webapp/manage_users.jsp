<%@ page import="java.sql.*, com.vehicle_rental.util.DBConnection" %>
<html>
<head>
    <title>Manage Users</title>
</head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role</th>
            <th>Action</th>
        </tr>

        <%
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("user_id") %></td>
            <td><%= rs.getString("username") %></td>
            <td><%= rs.getString("email") %></td>
            <td><%= rs.getString("role") %></td>
            <td>
                <a href="deleteUserServlet?user_id=<%= rs.getInt("user_id") %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
