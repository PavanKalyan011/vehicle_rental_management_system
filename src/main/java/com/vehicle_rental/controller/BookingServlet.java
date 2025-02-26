package com.vehicle_rental.controller;

import com.vehicle_rental.dao.BookingDAO;
import com.vehicle_rental.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/bookVehicle")
public class BookingServlet extends HttpServlet {

    private BookingDAO bookingDAO = new BookingDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");
        
        if (userId == null) {
            response.sendRedirect("login.jsp?error=Please login first.");
            return;
        }

        int vehicleId = Integer.parseInt(request.getParameter("vehicle_id"));
        double pricePerDay = Double.parseDouble(request.getParameter("price_per_day"));
        
        String startDateStr = request.getParameter("start_date");
        String endDateStr = request.getParameter("end_date");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            
            long diff = endDate.getTime() - startDate.getTime();
            int days = (int) (diff / (1000 * 60 * 60 * 24));
            double totalPrice = pricePerDay * days;

            Booking booking = new Booking(0, userId, vehicleId, startDate, endDate, totalPrice, "PENDING");
            boolean isBooked = bookingDAO.createBooking(booking);

            if (isBooked) {
                response.sendRedirect("user_dashboard.jsp?msg=Booking Successful");
            } else {
                response.sendRedirect("vehicle_list.jsp?error=Booking Failed");
            }

        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("vehicle_list.jsp?error=Invalid Date Format");
        }
    }
}
