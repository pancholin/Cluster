package com.cluster.kubeclient.redis;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

public class Connection {
	public static void main(String [] args){
		   
	     System.out.println(getRedisInfo());
	
	}
	public void connection(){
		 //Connecting to Redis server on localhost 
		 Jedis jedis = new Jedis("120.24.72.117"); 
	      System.out.println("Connection to server sucessfully"); 
	      jedis.set("runoobkey", "Redis tutorial");
	      // 获取存储的数据并输出
	      System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
	      
	      //check whether server is running or not 
	     System.out.println("Server is running: "+jedis.ping()); 
	}
	public static String getRedisInfo() {
		Jedis jedis = new Jedis("120.24.72.117");
		try {
			
			Client client = jedis.getClient();
			client.info();
			String info = client.getBulkReply();
			return info;
		} finally {
			// 返还到连接池
			jedis.close();
		}
	}
	
	

}
