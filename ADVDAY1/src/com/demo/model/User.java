package com.demo.model;

public class User {
	private String uname;
	private String passwd;
	
	public User() {
		super();
	}
	public User(String uname, String passwd, String role) {
		super();
		this.uname = uname;
		this.passwd = passwd;
		
	}
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	@Override
	public String toString() {
		return "MyUser [uname=" + uname + ", passwd=" + passwd +  "]";
	}
  
}