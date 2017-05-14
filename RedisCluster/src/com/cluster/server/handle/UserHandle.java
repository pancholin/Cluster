
package com.cluster.server.handle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cluster.server.model.User;
import com.cluster.server.port.UserPort;

import net.sf.json.JSONArray;

public class UserHandle implements UserPort{

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		user.setName("hefl");
		user.setEmail("fafafe");
		user.setPassword("name");
		return user;
	} 

	@Override
	public User getUserInformation(int id) {
		// TODO Auto-generated method stub
		
		
		User user=new User();
		user.setName("hefl");
		user.setEmail("fafafe");
		user.setPassword("name");
		return user;
	}

	
	


	
}

