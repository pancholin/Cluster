package com.cluster.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response") 
public class Response {
	
	private int status;
	String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
