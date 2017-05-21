package com.cluster.server.pojo;

import java.util.List;

import com.cluster.server.model.TBRedisCluster;
import com.cluster.server.model.TBUser;

public class TBRedisClusterDao {
	public SqlResponse insert(TBRedisCluster redisCluster){
		DBConstant constant=new DBConstant();
		String sql="insert into "+constant.REDISCLUSTER_TABLE+" (allocated_memory,used_memory,name,state,username)"
				+ "values('"+redisCluster.getAllocated_memory()+"','"+redisCluster.getUsed_memory()+"','"+redisCluster.getName()+"','"+redisCluster.getState()+"','"+redisCluster.getUserName()+"')";
		DBConnect con=new DBConnect();
		SqlResponse res=con.insertAndGetId(sql);
		return res;
		}
		
	public TBRedisCluster getRedisClusterById(int id) {
		DBConstant constant=new DBConstant();
		String sql="select * from "+constant.REDISCLUSTER_TABLE+" where id="+id;
		System.out.println(sql);
		DBConnect con=new DBConnect();
		List<TBRedisCluster> list=con.executeRedisCluster(sql);
		con.close();
		TBRedisCluster rediscluster=null;
		if(!list.isEmpty()){
			rediscluster=list.get(0);
		}
		return rediscluster;
		}
	
	public List<TBRedisCluster> getRedisclusterByUsername(String username) {
		DBConstant constant=new DBConstant();
		String sql="select * from "+constant.REDISCLUSTER_TABLE+" where username='"+username+"'";
		System.out.println(sql);
		DBConnect con=new DBConnect();
		List<TBRedisCluster> list=con.executeRedisCluster(sql);
		con.close();
		return list;
		}
	
	public SqlResponse delete(int id){
		DBConstant c=new DBConstant();
		DBConnect conn=new DBConnect();
		String sql="delete from "+c.REDISCLUSTER_TABLE+" where id="+id;
		return conn.delete(sql);
	}
	
	/*
	 * update the information of user and get the response
	 */
	public SqlResponse update(TBRedisCluster tbRedisCluster){
		DBConstant c=new DBConstant();
		DBConnect conn=new DBConnect();
		String sql="update "+c.REDISCLUSTER_TABLE+" set allocated_memory='"+tbRedisCluster.getAllocated_memory()+"', used_memory='"+tbRedisCluster.getUsed_memory()+"', name='"+tbRedisCluster.getName()+"', state="+tbRedisCluster.getState()+" where id= "+tbRedisCluster.getId();
		return conn.update(sql);
	}

}

