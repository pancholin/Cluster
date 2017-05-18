package com.cluster.server.port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cluster.server.model.RedisCluster;
import com.cluster.server.model.RedisInformation;




@Path("/instances")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface ClusterInstancePort {
	/*
	 * ��ȡ��Ⱥ�ļ����Ϣ
	 */
	@GET
	@Path("/getInstance")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({"application/xml","application/json"})
	public RedisInformation getInstance() ;
	
	
	@GET
	@Path("/get")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public RedisInformation get();
	
	
	/*
	 * ����һ����Ⱥ
	 */
	@POST
	@Path("/createCluster")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public RedisCluster createCluster();
	
	/*
	 * ɾ��һ����Ⱥ
	 */
	@POST
	@Path("/deleteCluster")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public RedisCluster deleteCluster();
	
	/*
	 * �޸�һ����Ⱥ��Ϣ
	 */
	@PUT
	@Path("/modifyCluster")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public RedisCluster modifyCluster();
	
	/*
	 * ��ȡ��Ⱥ�б�
	 */
	@GET
	@Path("/getClusterList")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public RedisCluster GetClusterList();
}
