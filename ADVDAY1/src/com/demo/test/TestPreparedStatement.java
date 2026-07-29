package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestPreparedStatement
{

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
            Connection conn = DriverManager.getConnection(url, "root", "root");

            int id = 1;
            String name = "pen";
            int qty = 50;
            double price = 60;
            LocalDate ldt = LocalDate.now();

            // ERROR TRIGGER: We only list 4 columns, but we pass 5 question marks!
            String brokenSql = "INSERT INTO product1 (pid, name, qty, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst1 = conn.prepareStatement(brokenSql);
            
            pst1.setInt(1, id);
            pst1.setString(2, name);
            pst1.setInt(3, qty);
            pst1.setDouble(4, price);
            pst1.setDate(5, java.sql.Date.valueOf(ldt));

            // This line will crash and throw the java.sql.SQLException
            int n = pst1.executeUpdate(); 
            
            if (n > 0) {
                System.out.println("insertion done");
            }

            pst1.close();
            conn.close();

        } catch (SQLException e) {
            // This will catch and print your exact column count mismatch error
            e.printStackTrace(); 
        }
    }
}
