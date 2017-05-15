package com.cluster.kubeclient.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Call {
	
	private JedisPool callInterface;  
    
    public Call() {  
    }  
      
    public void setCallFunc(JedisPool callInterface) {  
        this.callInterface = callInterface;  
    }  
      
    public String call() {  
        
          Jedis jedis = callInterface.getResource();
		  String info=jedis.info();
		  return info;
    }  

}
