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
	 * 获取集群的监控信息
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
	 * 创建一个集群
	 */
	@POST
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public TBRedisCluster createCluster();
	
	/*
	 * 删除一个集群
	 */
	@DELETE
	@Path("/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public TBRedisCluster deleteCluster(@PathParam("id") int id);
	
	/*
	 * 修改一个集群信息
	 */
	@PUT
	
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response modifyCluster(ResRedisCluster resRedisCluster);
	
	/*
	 * 获取及群列表
	 */
	@GET
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public List<ResRedisCluster> GetClusterList();
}
