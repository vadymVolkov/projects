package com.volkov.repository;

import com.volkov.model.Locker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LockerStatus {


    public static List<Locker> getLockersFromLockerStatus() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, num, status, priority, cardnum, type from locker_status");
             ResultSet resultSet = ps.executeQuery();) {
            ArrayList<Locker> lockersAll = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int num = resultSet.getInt(2);
                String status = resultSet.getString(3);
                int priority = resultSet.getInt(4);
                int cardnum = resultSet.getInt(5);
                String type = resultSet.getString(6);
                lockersAll.add(new Locker(id, num, status, priority, type, cardnum));
            }
            return lockersAll;
        }
    }
    public static List<Locker> getLockersFromLockerStatusNormal() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, num, status, type from locker_status_normal");
             ResultSet resultSet = ps.executeQuery();) {
            ArrayList<Locker> lockersAll = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int num = resultSet.getInt(2);
                String status = resultSet.getString(3);
                String type = resultSet.getString(4);
                lockersAll.add(new Locker(id, num, status, type));
            }
            return lockersAll;
        }
    }
    public static String getLockerStatusById(int idNum) throws SQLException, ClassNotFoundException {
        String status;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT status FROM locker_status WHERE id = ?");) {
            ps.setInt(1, idNum);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            status = resultSet.getString(1);
        }

        return status;
    }
    public static void setStatusAndCardNumAndPriorityById (int idNum, String status, int cardNum, int priority) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE  locker_status SET status= ?, cardnum=?, priority=? WHERE id = ?");
        ) {
            ps.setString(1, status);
            ps.setInt(2, cardNum);
            ps.setInt(3, priority);
            ps.setInt(4, idNum);
            ps.executeUpdate();
        }
    }
    public static void setStatusAndPriorityByCardNum (String status,int priority, int cardNum) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE  locker_status SET status= ?, priority=? WHERE cardnum = ?");
        ) {
            ps.setString(1, status);
            ps.setInt(2, priority);
            ps.setInt(3, cardNum);
            ps.executeUpdate();
        }
        clearCardNumByCardNum(cardNum);
    }
    public static int getIdByCardNum (int cardNum) throws SQLException, ClassNotFoundException {
        int id;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id FROM locker_status WHERE cardnum = ?");) {
            ps.setInt(1, cardNum);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
        }

        return id;
    }
    public static void clearCardNumByCardNum (int cardNum) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE  locker_status SET cardnum= ? WHERE cardnum = ?");
        ) {
            ps.setInt(1, 0);
            ps.setInt(2, cardNum);
            ps.executeUpdate();
        }
    }
    public static void setStatusByIdInNormal (int idNum,String status) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE  locker_status_normal SET status= ? WHERE id = ?");
        ) {
            if (!status.equals("engaged")){
                status="empty";
            }
            ps.setString(1, status);
            ps.setInt(2, idNum);
            ps.executeUpdate();
        }
    }
    public static void setPriorityById (int idNum,int priority) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE  locker_status SET priority= ? WHERE id = ?");
        ) {
            ps.setInt(1, priority);
            ps.setInt(2, idNum);
            ps.executeUpdate();
        }
    }
    public static void setStatusById (int idNum,String status) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE  locker_status SET status= ? WHERE id = ?");
        ) {
            ps.setString(1, status);
            ps.setInt(2, idNum);
            ps.executeUpdate();
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
       //return DriverManager.getConnection("jdbc:mysql://localhost:3306/lockers", "root", "root");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lockers", "root", "375057");
    }
}
