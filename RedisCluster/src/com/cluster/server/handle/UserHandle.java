
package com.cluster.server.handle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cluster.server.model.Response;
import com.cluster.server.model.User;
import com.cluster.server.pojo.SqlResponse;
import com.cluster.server.pojo.UserDao;
import com.cluster.server.port.UserPort;

import net.sf.json.JSONArray;

public class UserHandle implements UserPort{

	@Override
	public Response register(User user) {
		// TODO Auto-generated method stub
		UserDao userdao=new UserDao();
		SqlResponse sqlres=userdao.insert(user);
		Response res=new Response();
		if(sqlres.getStateCode()==200){
			res.setStatus(200);
			res.setMessage("注册成功");
		}else{
			res.setMessage("注册失败");
			res.setStatus(404);
		}
		return res;
	} 

	
	
	
	@Override
	public User getUserInformation(String id) {
		// TODO Auto-generated method stub
		
		
		User user=new User();
		user.setName("hefl");
		user.setEmail("fafafe");
		user.setPassword("name");
		return user;
	}




	@Override
	public Response login(User user) {
		UserDao userdao=new UserDao();
		User getuser=userdao.getUserByname(user.getName());
		Response res=new Response();
		if(getuser==null){
			res.setStatus(404);
			res.setMessage("用户名不存在");			
		}else{
			if(getuser.getPassword().equals(user.getPassword()))
		    {
				res.setStatus(200);
				res.setMessage(user.getName());
		    }else{
		    	res.setStatus(401);
		    	res.setMessage("密码错误");
		    }
			
		}
		return res;
	}

	
	


	
}

