package com.cluster.server.handle;


import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.cluster.kubeclient.connect.JerseyRestfulClient;
import com.cluster.kubeclient.connect.Params;
import com.cluster.kubeclient.connect.ResourceType;
import com.cluster.kubeclient.connect.RestfulClient;
import com.cluster.kubeclient.handle.KubeHandle;
import com.cluster.kubeclient.handle.KubeUtil;
import com.cluster.kubeclient.redis.RedisMonitor;
import com.cluster.server.model.RedisCluster;

import com.cluster.server.model.RedisInformation;
import com.cluster.server.pojo.SqlResponse;
import com.cluster.server.pojo.TBRedisClusterDao;
import com.cluster.server.port.RedisInstancePort;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;


public class RedisInstanceHandle implements RedisInstancePort {
	@Context HttpServletRequest request; 
	
	@Override
	public RedisInformation getInstance()  {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/instances/getInstance");
		// TODO Auto-generated method stub
		RedisInformation redis=new RedisInformation();
        RedisMonitor redisMonitor=new RedisMonitor();
     
	    Map map=redisMonitor.getRedisInfo();
		
        redis.setConnection_blocker(map.get("connected_clients").toString());
        redis.setConnection_connected(/*map.get("blocked_clients").toString()*/"mpp");
        redis.setCpu("noe");
        redis.setFlow_in("none");
        redis.setFlow_out("none");
        redis.setHit_rate("none");
        redis.setKeys_delete("none");
        redis.setKeys_expired("none");
        redis.setKeys_setted_expired("none");
        redis.setKey_total("none");
        redis.setMemory_total(/*map.get("total_system_memory_human").toString()*/"noe");
        redis.setMemory_using(/*map.get("used_memory_rss_human").toString()*/"noj");
		return redis;
	}

	@Override
	public RedisInformation get() {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/instances/get");
		// TODO Auto-generated method stub
		RedisInformation redis=new RedisInformation();
        RedisMonitor redisMonitor=new RedisMonitor();
        Map map = redisMonitor.getRedisInfo();
		
        redis.setConnection_blocker(map.get("connected_clients").toString());
        redis.setConnection_connected(map.get("blocked_clients").toString());
        redis.setCpu("noe");
        redis.setFlow_in("none");
        redis.setFlow_out("none");
        redis.setHit_rate("none");
        redis.setKeys_delete("none");
        redis.setKeys_expired("none");
        redis.setKeys_setted_expired("none");
        redis.setKey_total("none");
        redis.setMemory_total(map.get("total_system_memory_human").toString());
        redis.setMemory_using(map.get("used_memory_rss_human").toString());
		return redis;
	}

	@Override
	public RedisCluster createCluster() {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/instances/createCluster");
		
		System.out.println(request.getSession().getAttribute("name"));
		String user_name=(String) request.getSession().getAttribute("name");
		/*
		 * insert the information to the table RedisClusterTable
		 */
		RedisCluster redisCluster=new RedisCluster();
		redisCluster.setAllocated_memory("1G");
		redisCluster.setName("redis¼¯Èº");
		redisCluster.setState(1);
		redisCluster.setUsed_memory("8K");
		redisCluster.setUserName(user_name);
		
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		SqlResponse sqlresponse=redisdao.insert(redisCluster);
		int clusterId=sqlresponse.getStateCode();
		
		redisCluster=null;
		RedisCluster redisClusterNew=redisdao.getRedisClusterById(clusterId);
		/*
		 * KubeHandle kubehandle=new KubeHandle();
		kubehandle.getRC();
		kubehandle.createSVC();*/
		return redisClusterNew;
	}

	@Override
	public RedisCluster deleteCluster(int id) {
		// TODO Auto-generated method stub
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		SqlResponse sqlresponse=redisdao.delete(id);
		System.out.println(sqlresponse.getMessage());
		return null;
	}

	@Override
	public RedisCluster modifyCluster() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<RedisCluster> GetClusterList() {
		// TODO Auto-generated method stub
		String userName=(String) request.getSession().getAttribute("name");
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		//RedisClusterList redisClusterList=new RedisClusterList();
		//redisClusterList.setRedisClusterList(redisdao.getRedisclusterByUsername(userName));
		List<RedisCluster> list=redisdao.getRedisclusterByUsername(userName);
		return list;
	}

}
