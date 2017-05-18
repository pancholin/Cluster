package com.cluster.kubeclient.redis;

import java.sql.DriverManager;
import java.sql.SQLException;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import redis.clients.jedis.exceptions.JedisConnectionException;



public class Connection {
	public JedisPool getPool(String url) {
        JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(100);
		config.setMaxIdle(20);
		config.setMaxWait(1000l);	
		JedisPool pool = new JedisPool(config,url,6379);
	  return pool;
	}

     	     
	/*
	 * get info
	 */
	public String getRedisInfo()  {
		
		/*boolean borrowOrOprSuccess = true;
		String info=null;
		JedisPool pool=getPool("120.24.72.117");
		Jedis jedis=null;
		try {
		  
		} 
		catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				pool.returnBrokenResource(jedis);
 
		} 
		finally {
			if (borrowOrOprSuccess)
				pool.returnResource(jedis);
		}*/
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(100);
		config.setMaxIdle(20);
		config.setMaxWait(1000l);	
		Call caller = new Call();  
        caller.setCallFunc(new JedisPool(config,"120.24.72.117",6379));  
        String info=caller.call(); 
        
		return info;				
	}
	
	

}
