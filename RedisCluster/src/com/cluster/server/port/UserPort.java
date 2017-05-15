package com.cluster.server.port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cluster.server.model.Response;
import com.cluster.server.model.User;

@Path("/Users")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface UserPort {
	
	
	/*
	 * 实现用户注册功能
	 */
	@POST
	@Path("/register")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response register(User user);
	
	@POST
	@Path("/login")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response login(User user);
	
	
	@GET
	@Path("/user/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public User getUserInformation(@PathParam("id") String id);
}
