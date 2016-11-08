package com.volkov;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcExample {
    public static void main(String[] args) {
        JdbcExample jdbcExample = new JdbcExample();
        try {
            Properties properties = jdbcExample.loadProperties();

            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));

            System.out.println("CONECTED");
            jdbcExample.transactionConection(connection);
            jdbcExample.printStudents(connection);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream("db.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void printStudents(Connection connection) throws SQLException {
        String sql = "select * from students";

        Statement statement = connection.createStatement();
        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();
        StringBuilder builder = new StringBuilder();
        while (resultSet.next()) {
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            int age = Integer.valueOf(resultSet.getString("age"));

            builder.append(fname + " " + lname + ", " + age+"\n");

        }
        System.out.println(builder);

    }

    public void addStudent (Connection connection) throws SQLException {
        String sql = "insert into students (fname, lname, age) value (?, ?, ?)";

        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,"Vasya");
        preparedStatement.setString(2,"Cruise");
        preparedStatement.setInt(3,19);

        preparedStatement.execute();
    }

    public void  transactionConection(Connection connection) throws SQLException {
        String sql1 = "insert into students (fname, lname, age) value ('John', 'Pop', 19)";
        String sql2 = "insert into students (fname, lname, age) value ('Kostya', 'Riba', 25)";

        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        try {
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            connection.commit();
        } catch ( Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

    }


}
