package com.vehicle_rental.controller;

import com.vehicle_rental.dao.VehicleDAO;
import com.vehicle_rental.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addVehicle")
public class VehicleServlet extends HttpServlet {

    private VehicleDAO vehicleDAO = new VehicleDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        double pricePerDay = Double.parseDouble(request.getParameter("price_per_day"));
        boolean availability = Boolean.parseBoolean(request.getParameter("availability"));

        Vehicle vehicle = new Vehicle(0, model, brand, pricePerDay, availability);
        boolean isAdded = vehicleDAO.addVehicle(vehicle);

        if (isAdded) {
            response.sendRedirect("admin_dashboard.jsp?msg=Vehicle Added");
        } else {
            response.sendRedirect("admin_dashboard.jsp?error=Failed to add vehicle");
        }
    }
}
