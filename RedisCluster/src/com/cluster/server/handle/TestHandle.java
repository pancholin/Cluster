package com.cluster.server.handle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.cluster.server.model.User;
import com.cluster.server.port.TestPort;

public class TestHandle implements TestPort {

	@Context HttpServletRequest request;
    
    
	@Override
	public User create() {
		//获得HTTP的SESSION  
	    HttpSession session =request.getSession();  
	    //这只是一个统计变量  
	    String change =(String) session.getAttribute("email");  
	    
	    System.out.println(change);
	    session.removeAttribute("accout");
		//System.out.println(name);
		User user=new User();
		user.setName("hefl");
		user.setEmail(session.getId());
		user.setPassword("name");
		return user;
	}
	
	

}
