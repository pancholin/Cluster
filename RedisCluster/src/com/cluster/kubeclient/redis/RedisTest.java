package com.cluster.kubeclient.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cluster.server.handle.ClusterInstanceHandle;


import redis.clients.jedis.exceptions.JedisAskDataException;

public class RedisTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	 ClusterInstanceHandle cluster=new ClusterInstanceHandle();
	 try {
		System.out.println(cluster.getInstance().getConnection_blocker());
	} catch (JedisAskDataException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		 /*Config config = new Config();  
	     config.setConnectionPoolSize(10);  
	     config.addAddress("127.0.0.1:6379");  
	     Redisson redisson = Redisson.create(config);  
	     System.out.println("reids连接成功...");  
		*/
		
			
	}
	
	 

}
