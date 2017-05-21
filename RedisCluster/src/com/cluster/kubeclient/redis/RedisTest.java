package com.cluster.kubeclient.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cluster.server.handle.RedisInstanceHandle;




public class RedisTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	 RedisInstanceHandle cluster=new RedisInstanceHandle();
	 
     System.out.println(cluster.getInstance().getConnection_blocker());
	 
		
		
		/*Connection conn=new Connection();
		System.out.println(conn.getRedisInfo());*/
			
	}
	
	 

}
