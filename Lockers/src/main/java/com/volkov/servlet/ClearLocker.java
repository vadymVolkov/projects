package com.volkov.servlet;

import com.volkov.repository.LockerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ClearLocker", urlPatterns ="/clearlocker")
public class ClearLocker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cardNum = request.getParameter("cardnumber");
        response.sendRedirect("/clearlocker");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("lockers", LockerStatus.getLockersFromLockerStatus());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String action = "clear";
        request.setAttribute("action", action);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
