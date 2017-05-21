package com.cluster.kubeclient.redis;

import java.sql.DriverManager;
import java.sql.SQLException;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import redis.clients.jedis.exceptions.JedisConnectionException;



public class Connection {
	/*
	 * 获取redis连接池
	 */
	public JedisPool getPool(String url,int port) {
        JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(100);
		config.setMaxIdle(20);
		config.setMaxWait(1000l);	
		JedisPool pool = new JedisPool(config,url,port);
	  return pool;
	}

     	     
	/*
	 * get info
	 */
	public String getRedisInfo()  {	    
        Jedis jedis =new Jedis("120.24.72.117",6379);
        String info=jedis.info(); 
        jedis.disconnect();
		return info;				
	}
	
	public Long getDbSize(){ 
        Jedis jedis =new Jedis("120.24.72.117",6379);
        Long l=jedis.dbSize();
       jedis.disconnect(); 		
		return l;
	}

}
