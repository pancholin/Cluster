package com.cluster.server.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User") 
public class TBUser {
	String username;  //�û���
	String password; //�û�����
	String email;  //����ʱ��
	
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


