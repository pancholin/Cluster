package com.cluster.server.pojo;

import java.util.List;

import com.cluster.server.model.User;

public class TBUserDao {
	
	public SqlResponse insert(User user){
	DBConstant c=new DBConstant();
	String sql="insert into "+c.USER_TABLE+" (name,password,email)"
			+ "values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
	DBConnect con=new DBConnect();
	SqlResponse res=con.insert(sql);
	return res;
	}
	
	public User getUserByemail(String email) {
		DBConstant constant=new DBConstant();
		String sql="select * from "+constant.USER_TABLE+" where email='"+email+"'";
		System.out.println(sql);
		DBConnect con=new DBConnect();
		List<User> list=con.executeUser(sql);
		con.close();
		User user=null;
		if(!list.isEmpty()){
			user=list.get(0);
		    }
		return user;
		}


}
