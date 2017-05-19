package com.cluster.server.pojo;

import java.util.List;

import com.cluster.server.model.RedisCluster;
import com.cluster.server.model.User;

public class TBRedisClusterDao {
	public SqlResponse insert(RedisCluster redisCluster){
		DBConstant constant=new DBConstant();
		String sql="insert into "+constant.REDISCLUSTER_TABLE+" (allocated_memory,used_memory,name,state,username)"
				+ "values('"+redisCluster.getAllocated_memory()+"','"+redisCluster.getUsed_memory()+"','"+redisCluster.getName()+"','"+redisCluster.getState()+"','"+redisCluster.getUserName()+"')";
		DBConnect con=new DBConnect();
		SqlResponse res=con.insertAndGetId(sql);
		return res;
		}
		
	public RedisCluster getRedisClusterById(int id) {
		DBConstant constant=new DBConstant();
		String sql="select * from "+constant.REDISCLUSTER_TABLE+" where id="+id;
		System.out.println(sql);
		DBConnect con=new DBConnect();
		List<RedisCluster> list=con.executeRedisCluster(sql);
		con.close();
		RedisCluster rediscluster=null;
		if(!list.isEmpty()){
			rediscluster=list.get(0);
		}
		return rediscluster;
		}
	
	public List<RedisCluster> getRedisclusterByUsername(String username) {
		DBConstant constant=new DBConstant();
		String sql="select * from "+constant.REDISCLUSTER_TABLE+" where username='"+username+"'";
		System.out.println(sql);
		DBConnect con=new DBConnect();
		List<RedisCluster> list=con.executeRedisCluster(sql);
		con.close();
		return list;
		}
}

