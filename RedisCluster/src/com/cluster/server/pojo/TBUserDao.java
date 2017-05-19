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

	/*
	 * delete the user and get the response
	 */
	public SqlResponse delete(int user_id){
		DBConstant c=new DBConstant();
		DBConnect conn=new DBConnect();
		String sql="delete from "+c.USER_TABLE+" where user_id="+user_id;
		return conn.delete(sql);
	}

	
	/*
	 * update the information of user and get the response
	 */
	public SqlResponse update(User user){
		DBConstant c=new DBConstant();
		DBConnect conn=new DBConnect();
		String sql="update "+c.USER_TABLE+" set email='"+user.getEmail()+"', password='"+user.getPassword()+"' where name="+user.getName();
		return conn.update(sql);
	}

}
