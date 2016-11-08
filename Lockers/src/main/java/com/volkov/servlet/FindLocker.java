package com.volkov.servlet;

import com.volkov.repository.LockerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindLocker", urlPatterns = "/findlocker")
public class FindLocker extends HttpServlet {
    int cardNum;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!request.getParameter("cardnumber").equals("")) {
            request.setCharacterEncoding("UTF-8");
            cardNum = Integer.parseInt(request.getParameter("cardnumber"));
            response.sendRedirect("/findlocker");
        } else {
            cardNum=0;
            response.sendRedirect("/");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("lockers", LockerStatus.getLockersFromLockerStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("lockertype","a");
        String action = "find";
        request.setAttribute("action", action);
        request.setAttribute("cardnum", cardNum);
        request.setAttribute("hidecardnum","hidden");
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
