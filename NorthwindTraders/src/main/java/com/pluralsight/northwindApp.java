package com.pluralsight;

import java.sql.*;

public class northwindApp {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "Yearup2025!!");

            String query = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String products = results.getString("productName");
                System.out.println(products);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
