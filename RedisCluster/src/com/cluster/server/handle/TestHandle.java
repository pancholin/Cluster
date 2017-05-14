package com.cluster.server.handle;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

import com.cluster.server.model.User;
import com.cluster.server.port.TestPort;

public class TestHandle implements TestPort {

	@Override
	public User create(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName("hefl");
		user.setEmail("fafafe");
		user.setPassword("name");
		return user;
	}
	
	

}
