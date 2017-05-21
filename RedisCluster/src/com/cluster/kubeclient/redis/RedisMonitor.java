package com.cluster.kubeclient.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisMonitor {
	
	public  Map getRedisInfo()  {
		//获取redis服务器信息
		Map m1 = new HashMap(); 
		Connection conn=new Connection();
		String info = conn.getRedisInfo();	
		String[] strs = info.split("\n");	
		if (strs != null && strs.length > 0) {
			for (int i = 0; i < strs.length; i++) {
				String s = strs[i];
				String[] str = s.split(":");
				if (str != null && str.length > 1) {
					m1.put(str[0],str[1]);
					System.out.println(str[0]+" "+str[1]);
				}
			}
		}
		return m1;
	}
	

}
