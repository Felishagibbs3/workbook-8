package com.pluralsight;

import java.sql.*;

public class northwindApp {

    public static void main(String[] args) {
        String username = "root";
        String password = "Yearup2025!!";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);


            PreparedStatement statement = connection.prepareStatement("SELECT productID, productName, UnitPrice, Unitsinstock FROM products");
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int id = results.getInt("ProductID");
                String name = results.getString("ProductName");
                double price = results.getDouble("UnitPrice");
                int stock = results.getInt("UnitsInStock");

                System.out.println("Product ID: " + id);
                System.out.println("Product Name: " + name);
                System.out.println("Unit Price: " + price);
                System.out.println("Units in Stock: " + stock);
                System.out.println("------------------------------------");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

//continue working on the NorthwindTraders in the previous exercise.
//Modify your code to display all Products in the Northwind database. The list
//must include: - product id - product name - unit price - units in stock
