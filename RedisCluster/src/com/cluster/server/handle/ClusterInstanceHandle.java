package com.cluster.server.handle;


import java.util.Map;

import com.cluster.kubeclient.redis.RedisMonitor;
import com.cluster.server.model.Redis;
import com.cluster.server.port.ClusterInstancePort;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;


public class ClusterInstanceHandle implements ClusterInstancePort {

	
	@Override
	public Redis getInstance()  {
		// TODO Auto-generated method stub
		Redis redis=new Redis();
        RedisMonitor redisMonitor=new RedisMonitor();
     
	    Map map=redisMonitor.getRedisInfo();
		
		
		/* JedisPoolConfig config = new JedisPoolConfig();
		  //修改最大连接数
		   config.setMaxTotal(20);
		 //声明一个线程池
		  JedisPool pool = new JedisPool(config,"120.24.72.117",6379);
		 
		 //获得jedis对象
		 Jedis jedis = pool.getResource();
		
		//Jedis jedis = new Jedis("120.24.72.117", 6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");*/
		
        redis.setConnection_blocker(/*map.get("connected_clients").toString()*/"noe");
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
	public Redis get() {
		// TODO Auto-generated method stub
		Redis redis=new Redis();
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

}
