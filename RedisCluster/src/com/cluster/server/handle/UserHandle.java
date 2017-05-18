
package com.cluster.server.handle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import com.cluster.server.model.Response;
import com.cluster.server.model.User;
import com.cluster.server.pojo.SqlResponse;
import com.cluster.server.pojo.TBUserDao;
import com.cluster.server.port.UserPort;

import net.sf.json.JSONArray;

public class UserHandle implements UserPort{
	@Context HttpServletRequest request; 
	
	@Override
	public Response register(User user) {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/users/register");
		// TODO Auto-generated method stub
		TBUserDao userdao=new TBUserDao();
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
	public User getUserInformation(String email) {
		// TODO Auto-generated method stub
		
		System.out.println("http://localhost:8080/RedisCluster/restfulService/users/getUser/{email}");
		TBUserDao userdao=new TBUserDao();
		User user=userdao.getUserByemail(email);
		return user;
	}




	@Override
	public Response login(User user) {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/users/login");
		TBUserDao userdao=new TBUserDao();
		User getuser=userdao.getUserByemail(user.getEmail());
		Response res=new Response();
		if(getuser==null){
			res.setStatus(404);
			res.setMessage("用户名不存在");			
		}else{
			if(getuser.getPassword().equals(user.getPassword()))
		    {
				res.setStatus(200);
				res.setMessage(user.getName());
				HttpSession session=request.getSession();
				session.setAttribute("name",user.getName());
				session.setAttribute("password",user.getPassword());
		    }else{
		    	res.setStatus(401);
		    	res.setMessage("密码错误");
		    }
			
		}
		return res;
	}




	@Override
	public User logout() {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(false);//防止创建Session  
		return null;
	}

	
	


	
}

