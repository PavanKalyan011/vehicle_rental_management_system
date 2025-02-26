package com.vehicle_rental.controller;

import com.vehicle_rental.util.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteVehicleServlet")
public class DeleteVehicleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("vehicle_id"));
        String query = "DELETE FROM vehicles WHERE vehicle_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, vehicleId);
            pstmt.executeUpdate();
            response.sendRedirect("manage_vehicles.jsp?msg=Vehicle Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("manage_vehicles.jsp?error=Failed to delete vehicle");
        }
    }
}
