package com.cluster.server.handle;


import java.util.Map;

import com.cluster.kubeclient.connect.JerseyRestfulClient;
import com.cluster.kubeclient.connect.Params;
import com.cluster.kubeclient.connect.ResourceType;
import com.cluster.kubeclient.connect.RestfulClient;
import com.cluster.kubeclient.handle.KubeHandle;
import com.cluster.kubeclient.handle.KubeUtil;
import com.cluster.kubeclient.redis.RedisMonitor;
import com.cluster.server.model.RedisCluster;
import com.cluster.server.model.RedisInformation;
import com.cluster.server.port.ClusterInstancePort;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;


public class ClusterInstanceHandle implements ClusterInstancePort {

	
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
		RedisCluster redisCluster=new RedisCluster();
		KubeHandle kubehandle=new KubeHandle();
		kubehandle.getRC();
		kubehandle.createSVC();
		
		return redisCluster;
	}

}
