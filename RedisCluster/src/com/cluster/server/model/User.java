package com.cluster.server.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User") 
public class User {
	String name;  //�û���
	String password; //�û�����
	String email;  //����ʱ��
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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


