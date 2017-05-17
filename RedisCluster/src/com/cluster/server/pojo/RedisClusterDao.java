package com.cluster.server.pojo;

import java.util.List;

import com.cluster.server.model.RedisCluster;
import com.cluster.server.model.User;

public class RedisClusterDao {
	public SqlResponse insert(RedisCluster redisCluster){
		Constant constant=new Constant();
		String sql="insert into "+constant.REDISCLUSTER_TABLE+" (memory_total,memory_using,name,state,username)"
				+ "values('"+redisCluster.getMemory_total()+"','"+redisCluster.getMemory_using()+"','"+redisCluster.getName()+"')";
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
