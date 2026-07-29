package com.demo.test;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		//step1 Register Driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
			Connection conn=DriverManager.getConnection(url,"root","root");
			if(conn!=null) {
				System.out.println("Connection done");
			}else {
				System.out.println("connection not done");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("connection not done");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}