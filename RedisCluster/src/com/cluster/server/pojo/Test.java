package com.cluster.server.pojo;

import com.cluster.server.model.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Constant c=new Constant();
		User user=new User();
		user.setName("linpanxue");
		user.setEmail("2941676061@qq.com");
		user.setPassword("123456");
		String sql="insert into "+c.USER_TABLE+" (name,password,email)"
				+ "values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
		MysqlConn con=new MysqlConn();
		SqlResponse res=con.insert(sql);
		System.out.println(res.getStateCode());*/
		UserDao userdao =new UserDao();
		User user=new User();
		user=userdao.getUserByname("linpanxue");
	}

}
