package com.volkov.servlet;

import com.volkov.control.StatusChanger;
import com.volkov.repository.LockerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Clear", urlPatterns = "/clear")
public class Clear extends HttpServlet {
    int cardNum;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.getParameter("cardnumber").equals("")) {
            request.setCharacterEncoding("UTF-8");
            cardNum = Integer.parseInt(request.getParameter("cardnumber"));
        } else {
            cardNum=0;
            response.sendRedirect("/");
        }
        response.sendRedirect("/clear");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = 0;
        try {
            id = LockerStatus.getIdByCardNum(cardNum);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String status = "recomend";
        int priority = 1;
        try {
            LockerStatus.setStatusAndPriorityByCardNum(status,priority,cardNum);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        status = "empty";
        try {
            LockerStatus.setStatusByIdInNormal(id,status);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StatusChanger.optimizeAfterDelete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/");

    }
}
