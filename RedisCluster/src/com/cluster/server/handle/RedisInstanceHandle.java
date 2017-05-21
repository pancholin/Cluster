package com.cluster.server.handle;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.json.JSONObject;

import com.cluster.kubeclient.connect.JerseyRestfulClient;
import com.cluster.kubeclient.connect.Params;
import com.cluster.kubeclient.connect.ResourceType;
import com.cluster.kubeclient.connect.RestfulClient;
import com.cluster.kubeclient.handle.KubeHandle;
import com.cluster.kubeclient.handle.KubeUtil;
import com.cluster.kubeclient.redis.RedisHandle;
import com.cluster.kubeclient.redis.RedisMonitor;
import com.cluster.server.model.TBRedisCluster;

import com.cluster.server.model.RedisInformation;
import com.cluster.server.model.ResRedisCluster;
import com.cluster.server.model.Response;
import com.cluster.server.model.TBClusterLink;
import com.cluster.server.pojo.SqlResponse;
import com.cluster.server.pojo.TBClusterLinkDao;
import com.cluster.server.pojo.TBRedisClusterDao;
import com.cluster.server.port.RedisInstancePort;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;


public class RedisInstanceHandle implements RedisInstancePort {
	@Context HttpServletRequest httpRequest; 
	@Context HttpServletResponse httpResponse;
	@Override
	public RedisInformation getInstance()  {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/instances/getInstance");
		// TODO Auto-generated method stub
		RedisHandle redisHandle=new RedisHandle();
		RedisInformation redis=redisHandle.getBasicInfo();      
		return redis;
	}

	@Override
	public RedisInformation get() {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/instances/get");
		// TODO Auto-generated method stub
		RedisInformation redis=new RedisInformation();
        RedisHandle redisHandle=new RedisHandle();
        redis=redisHandle.getBasicInfo();
        
		
        
		return redis;
	}

	@Override
	public TBRedisCluster createCluster() {
		System.out.println("http://localhost:8080/RedisCluster/restfulService/instances/createCluster");
		
		System.out.println(httpRequest.getSession().getAttribute("name"));
		String userName=(String) httpRequest.getSession().getAttribute("name");
		/*
		 * 将集群基本信息插入RedisClusterTable
		 */
		TBRedisCluster redisCluster=new TBRedisCluster();
		redisCluster.setAllocated_memory("5.4G");
		redisCluster.setName("redis集群");
		redisCluster.setState(1);
		redisCluster.setUsed_memory("8K");
		redisCluster.setUserName(userName);
		
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		SqlResponse sqlresponse=redisdao.insert(redisCluster);
		int clusterId=sqlresponse.getStateCode();
		
		redisCluster=null;
		TBRedisCluster redisClusterNew=redisdao.getRedisClusterById(clusterId);
		
		/*
		 * 创建redis集群，默认创建3个redis
		 */
		KubeUtil kubeUtil=new KubeUtil();
		KubeHandle kubehandle=new KubeHandle();
		JSONObject json=new JSONObject();
		/*for(int i=0;i<3;i++){
			String name=kubeUtil.getName(userName, clusterId, i);
			kubehandle.createRC(name);
			kubehandle.createSVC(name);
			json.put(name, kubehandle.getNodePort(name));
		}*/
		
		/*
		 * 将集群端口信息及redis数量插入到TBClusterLink中
		 */
		TBClusterLink tbClusterLink=new TBClusterLink();
		tbClusterLink.setLink(json.toString());
		tbClusterLink.setNumber(3);
		tbClusterLink.setClusterId(clusterId);
		
		TBClusterLinkDao clusterLinkDao=new TBClusterLinkDao();
		clusterLinkDao.insert(tbClusterLink);
		
		/*
		 * 进TBRedisCluster转化为ResRedisCluster
		 */
				
		return redisClusterNew;
	}

	@Override
	public TBRedisCluster deleteCluster(int id) {
		// TODO Auto-generated method stub
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		SqlResponse sqlresponse=redisdao.delete(id);
		System.out.println(sqlresponse.getMessage());
		return null;
	}

	@Override
	public Response modifyCluster(ResRedisCluster resRedisCluster) {
		
		//将resRedisCluster转化为TBRedisCluster
		String userName=(String) httpRequest.getSession().getAttribute("name");
		TBRedisCluster tbRedisCluster=new TBRedisCluster();
		
		tbRedisCluster.setAllocated_memory(resRedisCluster.getAllocated_memory());
		tbRedisCluster.setCreated_time(resRedisCluster.getCreated_time());
		tbRedisCluster.setUsed_memory(resRedisCluster.getUsed_memory());
		tbRedisCluster.setName(resRedisCluster.getName());
		tbRedisCluster.setState(resRedisCluster.getState());
		tbRedisCluster.setId(resRedisCluster.getId());
		tbRedisCluster.setUserName(userName);
		
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		SqlResponse sqlResponse=redisdao.update(tbRedisCluster);
	    System.out.println(sqlResponse.getMessage());  
		if(sqlResponse.getStateCode()==200)
			httpResponse.setStatus(200);
		else
			httpResponse.setStatus(201);
		
		return null;
	}

	
	@Override
	public List<ResRedisCluster> GetClusterList() {
		// TODO Auto-generated method stub
		
		//通过name从数据库中获取Cluster List
		String userName=(String) httpRequest.getSession().getAttribute("name");
		TBRedisClusterDao redisdao=new TBRedisClusterDao();
		
		//将DBRedisCluster List转化为 ResRedisCluster List  
		List<TBRedisCluster> list=redisdao.getRedisclusterByUsername(userName);
		List<ResRedisCluster> resList = new ArrayList<ResRedisCluster>();
		for(int i=0;i<list.size();i++){
			ResRedisCluster redis=new ResRedisCluster();
			redis.setAllocated_memory(list.get(i).getAllocated_memory());
			redis.setCreated_time(list.get(i).getCreated_time());
			redis.setId(list.get(i).getId());
			redis.setName(list.get(i).getName());
			redis.setUsed_memory(list.get(i).getUsed_memory());
			redis.setState(list.get(i).getState());
			resList.add(redis);	
		}
		
		return resList;
	}

}
