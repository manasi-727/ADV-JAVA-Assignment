package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class TestCallableStatement 
{
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
					int num=20;
					CallableStatement cst=conn.prepareCall("{call getcnt(?,?)}");
					cst.setInt(1,1);
					cst.registerOutParameter(2, Types.INTEGER);
					cst.execute();
					System.out.println("count in dept"+num+"----> "+cst.getInt(2));
					conn.close();
				} catch (SQLException e) {
					System.out.println("connection not done");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

	}

}