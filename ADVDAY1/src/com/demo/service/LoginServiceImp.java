package com.demo.service;

import com.demo.dao.Login;
import com.demo.dao.LoginImp;

public class LoginServiceImp implements LoginService{
	private Login ldao;

	public LoginServiceImp() {
		super();
		this.ldao = new LoginImp();
	}

	@Override
	public String validateUser(String uname, String passwd) {
		return ldao.authenticateUser(uname,passwd);
		
	}

	@Override
	public void closeMyConnection() {
		ldao.closeMyConnection();
		
	}

	
	

}