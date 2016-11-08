package com.volkov.servlet;

import com.volkov.repository.LockerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckStatusLocker", urlPatterns = "/check")
public class CheckStatusLocker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/check");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("lockers", LockerStatus.getLockersFromLockerStatus());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("lockertype","span");
        request.setAttribute("hidecardnum","");
        String action = "find";
        request.setAttribute("action", action);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
