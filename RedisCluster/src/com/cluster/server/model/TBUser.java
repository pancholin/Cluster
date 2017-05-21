package com.cluster.server.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User") 
public class TBUser {
	String username;  //用户名
	String password; //用户密码
	String email;  //创建时间
	
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}


