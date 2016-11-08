package com.volkov.servlet;

import com.volkov.repository.LockerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Locker", urlPatterns = "/")
public class Locker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("lockers", LockerStatus.getLockersFromLockerStatusNormal());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("lockertype","span");
        request.setAttribute("hidecardnum","hidden");
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
