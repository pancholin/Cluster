package com.cluster.kubeclient.redis;

import java.sql.DriverManager;
import java.sql.SQLException;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisAskDataException;



public class Connection {
	public Jedis getConnection() {
		Jedis jedis=null;
		jedis= new Jedis("120.24.72.117", 6379);
		  System.out.println("Connection to server sucessfully");
		
	  return jedis;
	}
 
     	     
	/*
	 * get info
	 */

	@SuppressWarnings("finally")
	public String getRedisInfo()  {
		Jedis jedis= getConnection(); 
		String info=null;
		//Jedis jedis = null;
			try{
				  //jedis= new Jedis("120.24.72.117", 6379);
				  System.out.println("Connection to server sucessfully");
				  Client client=jedis.getClient();
				  info = jedis.info();
			
			}catch (JedisAskDataException e) {
			    System.out.println("¡¨Ω”“Ï≥£");
			}finally{
				return info;
			}			
					
	}
	
	

}
