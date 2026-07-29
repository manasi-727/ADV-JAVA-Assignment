package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestStatement {

    public static void main(String[] args) {
        try {
            // step 1 register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // step 2 create connection
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            
            // step 3 create a statement
            Statement st = conn.createStatement();
            
            // step 4 execute the statement
            ResultSet rs = st.executeQuery("select * from product");
            
            // step 5 navigate through resultset
            while(rs.next()) {
                System.out.println("Id : " + rs.getInt(1));
                System.out.println("Name : " + rs.getString(2));
                System.out.println("Qty : " + rs.getInt(3));
                System.out.println("price : " + rs.getDouble(4));
                
                // to covert java sql date into LocalDate
                java.sql.Date dt = rs.getDate(5);
                if (dt != null) {
                    LocalDate ldt = dt.toLocalDate();
                    System.out.println("MfgDate : " + ldt.toString());
                }
                System.out.println("---------------------------");
            }
            
            // to insert data
            int id = 1;
            String name = "pen";
            int qty = 50;
            double price = 60;
            LocalDate dt = LocalDate.now();
            
            // FIXED LINE: Added the missing closing parenthesis ')' at the end of the query string
            String query = "insert into product values(" + id + ",'" + name + "'," + qty + "," + price + ",'" + dt.toString() + "')";
            System.out.println(query);
            
            int n = st.executeUpdate(query);
            if (n > 0) {
                System.out.println("Insertion successful!");
            }
            
            // Close resources
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
