
package com.cluster.server.handle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import com.cluster.server.model.ResUserName;
import com.cluster.server.model.Response;
import com.cluster.server.model.TBUser;
import com.cluster.server.pojo.SqlResponse;
import com.cluster.server.pojo.TBUserDao;
import com.cluster.server.port.UserPort;

import net.sf.json.JSONArray;

public class UserHandle implements UserPort{
	@Context HttpServletRequest request; 
	@Context HttpServletResponse httpResponse;
	@Override
	public ResUserName register(TBUser user) {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/users/register");
		// TODO Auto-generated method stub
		TBUserDao userdao=new TBUserDao();
		SqlResponse sqlres=userdao.insert(user);
		Response res=new Response();
		ResUserName resUserName=new ResUserName();
		if(sqlres.getStateCode()==200){
			res.setStatus(200);
			res.setMessage("注册成功");
			httpResponse.setStatus(200);
			resUserName.setUsername(user.getName());
		}else{
			res.setMessage("注册失败");
			httpResponse.setStatus(201);
			res.setStatus(404);
		}
		return resUserName;
	} 

	
	
	
	@Override
	public TBUser getUserInformation(String email) {
		// TODO Auto-generated method stub
		
		System.out.println("http://localhost:8080/RedisCluster/restfulService/users/getUser/{email}");
		TBUserDao userdao=new TBUserDao();
		TBUser user=userdao.getUserByemail(email);
		return user;
	}




	@Override
	public ResUserName login(TBUser user) {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/users/login");
		TBUserDao userdao=new TBUserDao();
		TBUser getuser=userdao.getUserByemail(user.getEmail());
		Response res=new Response();
		ResUserName resUserName=new ResUserName();
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
				resUserName.setUsername(user.getName());
				httpResponse.setStatus(200);
		    }else{
		    	res.setStatus(401);
		    	res.setMessage("密码错误");
		    	httpResponse.setStatus(201);
		    }
			
		}
		return resUserName;
	}




	@Override
	public TBUser logout() {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(false);//防止创建Session  
		return null;
	}

	
	


	
}

