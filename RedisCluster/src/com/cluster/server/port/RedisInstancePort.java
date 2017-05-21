package com.cluster.server.port;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cluster.server.model.TBRedisCluster;

import com.cluster.server.model.RedisInformation;
import com.cluster.server.model.ResRedisCluster;
import com.cluster.server.model.Response;




@Path("/instances")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface RedisInstancePort {
	/*
	 * ��ȡ��Ⱥ�ļ����Ϣ
	 */
	@GET
	@Path("/{id}")
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
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public TBRedisCluster createCluster();
	
	/*
	 * ɾ��һ����Ⱥ
	 */
	@DELETE
	@Path("/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public TBRedisCluster deleteCluster(@PathParam("id") int id);
	
	/*
	 * �޸�һ����Ⱥ��Ϣ
	 */
	@PUT
	
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response modifyCluster(ResRedisCluster resRedisCluster);
	
	/*
	 * ��ȡ��Ⱥ�б�
	 */
	@GET
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public List<ResRedisCluster> GetClusterList();
}
