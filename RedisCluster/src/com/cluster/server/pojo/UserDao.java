package com.cluster.server.pojo;

import java.util.ArrayList;
import java.util.List;

import com.cluster.server.model.User;

public class UserDao {
	
	public SqlResponse insert(User user){
	Constant c=new Constant();
	String sql="insert into "+c.USER_TABLE+" (name,password,email)"
			+ "values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
	MysqlConn con=new MysqlConn();
	SqlResponse res=con.insert(sql);
	return res;
	}
	
	public User getUserByname(String name) {
		Constant constant=new Constant();
		String sql="select * from "+constant.USER_TABLE+" where name='"+name+"'";
		System.out.println(sql);
		MysqlConn con=new MysqlConn();
		List<User> list=con.executeUser(sql);
		con.close();
		User user=null;
		if(!list.isEmpty()){
			user=list.get(0);
		    }
		return user;
		}


}
