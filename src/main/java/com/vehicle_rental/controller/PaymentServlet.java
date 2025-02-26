package com.vehicle_rental.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/processPayment")
public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("booking_id"));
        String paymentMethod = request.getParameter("payment_method");

        if ("online".equals(paymentMethod)) {
            response.sendRedirect("payment_gateway.jsp?booking_id=" + bookingId);
        } else {
            response.sendRedirect("user_dashboard.jsp?msg=Payment Successful");
        }
    }
}
