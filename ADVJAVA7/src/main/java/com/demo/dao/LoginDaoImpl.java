package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.MyUser;

public class LoginDaoImpl implements LoginDao {
static Connection conn;
static {
	conn = DBUtils.getMyConnection();
}
@Override
public MyUser authenticateUser(String uname, String pswd) {
	try {
		PreparedStatement pst = conn.prepareStatement("select * from test where uname=? and passwd = ?");
		pst.setString(1, uname);
		pst.setString(2, pswd);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			MyUser u = new MyUser(rs.getString(1), rs.getString(2), rs.getString(3));
			return u;
		}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
}
