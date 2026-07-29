package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Product;

public abstract class ProductImp  implements com.demo.dao.Product{
    static Connection conn;
    static {
    	conn=DBUtil.getMyConnection();
    }
	@Override
	public boolean saveProduct(Product p) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into product values(?,?,?,?,?)");
			pst.setInt(1, p.getPid());
			pst.setString(2, p.getPname());
			pst.setInt(3, p.getQty());
			pst.setDouble(4, p.getPrice());
			java.sql.Date sdt=java.sql.Date.valueOf(p.getMfgdate());
			pst.setDate(5, sdt);
			int n=pst.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List findAll() {
		try {
			PreparedStatement pst=conn.prepareStatement("select * from product");
			ResultSet rs=pst.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate());
				plist.add(p);
				
			}
			return plist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public boolean saveProduct(com.demo.dao.Product p) {
		// TODO Auto-generated method stub
		return false;
	}
}