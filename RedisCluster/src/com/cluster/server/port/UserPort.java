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

@Path("/users")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface UserPort {
	
	
	/*
	 * 实现用户注册功能
	 * @return Response
	 */
	@POST
	@Path("/register")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response register(User user);
	
	/*
	 * 实现用户登录功能
	 * @return Response
	 */
	@POST
	@Path("/login")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response login(User user);
	
	/*
	 * 实现通过用户名获取用户信息的功能
	 * @return Response
	 */
	@GET
	@Path("/getUser/{name}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public User getUserInformation(@PathParam("name") String name);
}
