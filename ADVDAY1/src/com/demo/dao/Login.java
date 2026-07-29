package com.demo.dao;

import com.demo.model.Product;

public interface Login {

	String authenticateUser(String uname, String passwd);

	void closeMyConnection();

	

}